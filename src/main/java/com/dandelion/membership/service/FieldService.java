package com.dandelion.membership.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dandelion.membership.constant.Constant;
import com.dandelion.membership.dao.data.MembershipMapper;
import com.dandelion.membership.dao.model.CalendarEvent;
import com.dandelion.membership.dao.model.Field;
import com.dandelion.membership.exception.MembershipException;
import com.dandelion.membership.exception.WebserviceErrors;

@Service
public class FieldService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
	@Autowired
	private MembershipMapper membershipMapper;
	
	
	@Transactional(rollbackFor = Exception.class)
	public boolean fieldSubmit(Long fieldId, Date start, Date end) throws ParseException, MembershipException {
		Field field = new Field();
		field.setId(fieldId);
		field.setStart(start);
		field.setEnd(end);
		field.setStatus("");
		field.setCreateddate(new Date());
		field.setModifieddate(new Date());
		
		int i = membershipMapper.updateField(field);
		if(0 == i) {
			return false;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String dd = format.format(start);
		Date startDay = format.parse(dd);
		dd = format.format(end);
		Date endDay = new Date(format.parse(dd).getTime() + Constant.DAY_TIME);
		
		List<CalendarEvent> events = membershipMapper.selectCalendarEventByStartAndEnd(startDay, endDay);
		if( events.size() == 0 ) {
			throw new MembershipException(WebserviceErrors.CALENDAREVENT_NOT_EXIST, WebserviceErrors.CALENDAREVENT_NOT_EXIST_MESSAGE);
		}
		for (CalendarEvent calendarEvent : events) {
			calendarEvent.setTitle("cleaning time");
			calendarEvent.setCssclass("event-special");
			membershipMapper.updateCalendarEvent(calendarEvent);
		}
		return true;
	}
	
	public void insert(){
		for (int i = 0; i < 10; i++) {
			Field tempField = new Field();
			tempField.setId(Long.valueOf(i + 1));
			tempField.setStatus("");
			tempField.setCreateddate(new Date());
			tempField.setModifieddate(new Date());
			tempField.setStart(new Date());
			tempField.setEnd(new Date());
			membershipMapper.insertField(tempField);
		}
	}


}
