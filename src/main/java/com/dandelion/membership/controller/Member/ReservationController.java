package com.dandelion.membership.controller.member;

import com.dandelion.membership.dao.model.Reservation;
import com.dandelion.membership.dao.model.ReservationForm;
import com.dandelion.membership.exception.MembershipException;
import com.dandelion.membership.service.member.ReservationService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "Reservation")
public class ReservationController {
    private static final Logger logger = Logger.getLogger("ReservationController");
    private static List<Reservation> reservations = new ArrayList<Reservation>();
    @Autowired
    private ReservationService reservationService;

    public static void main(String[] args) throws ParseException {
        System.out.println(new Date(1383235200000L));
        float a = 1.000f;
        System.out.println(1 == a);
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String dd = format.format(d);
        d = format.parse(dd);
        System.out.println(d);
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "Show", method = RequestMethod.GET)
    public String show() {
        return "calendar";
    }

    @RequestMapping(value = "Reserve", method = RequestMethod.GET)
    public String reserve(WebRequest webRequest) throws JSONException {
        return "reserve";
    }

    @RequestMapping(value = "Query", method = RequestMethod.GET)
    public ModelAndView selectEvent(WebRequest webRequest) throws JSONException {
        Long from = Long.valueOf(webRequest.getParameter("from"));
        Long to = Long.valueOf(webRequest.getParameter("to"));
        String result = reservationService.selectEvent(from, to);
        return new ModelAndView("json", "j", result.toString());
    }

    @RequestMapping(value = "Submit", method = RequestMethod.POST)
    public String ReservationSubmit(WebRequest request) throws ParseException, MembershipException {
        logger.log(Level.INFO, "Coming");
        Long memberId = Long.valueOf(request.getParameter("memberId"));
        String reservation = request.getParameter("reservation");
        String[] strings = reservation.split("-");
        strings[0].trim();
        strings[1].trim();
        logger.log(Level.INFO, strings.toString());
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        logger.log(Level.INFO, "SimpleDateFormat");
        Date startDate = format.parse(strings[0]);
        Date startEnd = format.parse(strings[1]);
        logger.log(Level.INFO, startEnd.toString());
        boolean b = reservationService.reservationSubmit(memberId, startDate, startEnd);
        if (!b) {
            logger.log(Level.INFO, "return error");
            return "error";
        }
        return "home";
    }

    @RequestMapping(value = "Select")
    public ModelAndView selectApplicant() {
        reservations = reservationService.selectReservation();
        ReservationForm reservationForm = new ReservationForm();
        reservationForm.setReservations(reservations);
        return new ModelAndView("reserveApproval", "reservationForm", reservationForm);
    }

    @RequestMapping(value = "Save")
    public ModelAndView approval(@ModelAttribute("reservationForm") ReservationForm reservationForm) {
        if (reservationForm == null) {
            logger.info("NULL");
            return new ModelAndView("reserveApproval");
        }
        List<Reservation> reservations = reservationForm.getReservations();
        ReservationController.reservations = reservations;
        if (null != reservations && reservations.size() > 0) {
            reservationService.approval(reservations);
        }

        return new ModelAndView("reserveApproval");
    }
}
