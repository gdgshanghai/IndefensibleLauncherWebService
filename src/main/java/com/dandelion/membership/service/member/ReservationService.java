package com.dandelion.membership.service.member;

import com.dandelion.membership.constant.Constant;
import com.dandelion.membership.dao.data.MembershipMapper;
import com.dandelion.membership.dao.model.CalendarEvent;
import com.dandelion.membership.dao.model.Reservation;
import com.dandelion.membership.exception.MembershipException;
import com.dandelion.membership.exception.WebserviceErrors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ReservationService {
    private static final Logger logger = Logger.getLogger("ReservationService");
    @Autowired
    private MembershipMapper membershipMapper;


    @Transactional(rollbackFor = Exception.class)
    public boolean reservationSubmit(Long memberId, Date start, Date end) throws ParseException, MembershipException {
        logger.log(Level.INFO, "Service reservationSubmit");
        Reservation tempReservation = new Reservation();
        tempReservation.setMemberidfk(memberId);
        tempReservation.setStart(start);
        tempReservation.setEnd(end);
        logger.log(Level.INFO, "beforesetStatus");
        tempReservation.setStatus("申請中");
        logger.log(Level.INFO, "aftersetStatus");
        tempReservation.setCreateddate(new Date());
        tempReservation.setModifieddate(new Date());
        logger.log(Level.INFO, "before Reservation r = membershipMapper.selectReservationByMemberIdAndDate(memberId, start, end);");
        List<Reservation> r = membershipMapper.selectReservationByMemberIdAndDate(memberId, start, end);
        logger.log(Level.INFO, "after Reservation r = membershipMapper.selectReservationByMemberIdAndDate(memberId, start, end);");
        if (r.size() != 0) {
            logger.log(Level.INFO, "(r !=null");
            return false;
        }
        membershipMapper.insertReservation(tempReservation);

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String dd = format.format(start);
        Date startDay = format.parse(dd);
        dd = format.format(end);
        Date endDay = new Date(format.parse(dd).getTime() + Constant.DAY_TIME);

        List<Reservation> reservations = membershipMapper.selectReservationByDate(startDay, endDay);
        int reservationSize = reservations.size();
        logger.info(String.valueOf(reservationSize));
        if (reservationSize > 0) {
            List<CalendarEvent> events = membershipMapper.selectCalendarEventByStartAndEnd(startDay, endDay);
            if (events.size() == 0) {
                throw new MembershipException(WebserviceErrors.CALENDAREVENT_NOT_EXIST, WebserviceErrors.CALENDAREVENT_NOT_EXIST_MESSAGE);
            }
            CalendarEvent calendarEvent = events.get(0);
            if (reservationSize <= 2) {
                calendarEvent.setTitle("half full");
                calendarEvent.setCssclass("event-warning");
                membershipMapper.updateCalendarEvent(calendarEvent);
            }
            if (reservationSize > 2) {
                calendarEvent.setTitle("full");
                calendarEvent.setCssclass("event-important");
                calendarEvent.setUrl("###");
                membershipMapper.updateCalendarEvent(calendarEvent);
            }
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public String selectEvent(Long from, Long to) throws JSONException {

        Float days = Float.valueOf((to - from) / Constant.DAY_TIME);
        logger.info("query days : " + String.valueOf(days));

        List<CalendarEvent> calendarEvents = membershipMapper
                .selectCalendarEventByStartAndEnd(new Date(from), new Date(to));
        if (days > 7 && days <= 31) {
            boolean b = false;
            if (calendarEvents != null) {
                if (calendarEvents.size() >= days) {
                    b = true;
                }
            }
            if (!b) {
                for (int i = 0; i < days; i++) {
                    CalendarEvent tempCalendarEvent = new CalendarEvent();
                    Long startTime = from + i * Constant.DAY_TIME;
                    Long endTime = from + (i + 1) * Constant.DAY_TIME
                            - Constant.Hour_TIME;
                    tempCalendarEvent.setTitle("Empty");
                    tempCalendarEvent.setCssclass("event-success");
                    tempCalendarEvent
                            .setUrl("../Reservation/Reserve?startTime="
                                    + startTime + "&endTime=" + endTime);
                    tempCalendarEvent.setStart(new Date(startTime));
                    tempCalendarEvent.setEnd(new Date(endTime));
                    tempCalendarEvent.setCreateddate(new Date());
                    tempCalendarEvent.setModifieddate(new Date());
                    membershipMapper.insertCalendarEvent(tempCalendarEvent);

                    logger.info(new Date(startTime).toLocaleString());
                }

                calendarEvents = membershipMapper
                        .selectCalendarEventByStartAndEnd(new Date(from),
                                new Date(to));
            }
        }

        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        for (CalendarEvent calendarEvent : calendarEvents) {
            JSONObject json = new JSONObject();
            Long startTime = calendarEvent.getStart().getTime();
            Long endTime = calendarEvent.getEnd().getTime();
            json.put("id", calendarEvent.getId());
            json.put("title", calendarEvent.getTitle());
            json.put("url", calendarEvent.getUrl());
            json.put("class", calendarEvent.getCssclass());
            json.put("start", startTime);
            json.put("end", endTime);
            array.put(json);
        }
        result.put("success", 1);
        result.put("result", array);

        return result.toString();
    }

    public List<Reservation> selectReservation() {
        List<Reservation> list = membershipMapper.selectReservationByStatusIsApplying();
        return list;
    }

    public void approval(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            membershipMapper.updateReservation(reservation);
        }
    }
}
