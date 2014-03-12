package com.dandelion.membership.dao.data;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.dandelion.membership.dao.model.Applicant;
import com.dandelion.membership.dao.model.CalendarEvent;
import com.dandelion.membership.dao.model.Field;
import com.dandelion.membership.dao.model.Reservation;

public interface MembershipMapper {

	public int insertApplicant(Applicant applicant);
	
	public int updateApplicant(Applicant applicant);
	
	@Select(value="Select * from tb_applicant t where t.ismember = 0")
	@ResultMap("BaseApplicantResultMap")
	public List<Applicant> selectApplicant();
	
	@Select(value="Select * from tb_applicant t where t.ismember = 1")
	@ResultMap("BaseApplicantResultMap")
	public List<Applicant> selectMembers();
	
	@Select(value="SELECT * FROM tb_applicant t where t.applicantName = #{name} and t.ismember = 1 ;")
	@ResultMap("BaseApplicantResultMap")
	public List<Applicant> selectMemberByName(String name);
	
	@Select(value="SELECT * FROM tb_applicant t where t.applicantName = #{0} and t.referrername = #{1}")
	@ResultMap("BaseApplicantResultMap")
	public List<Applicant> selectMemberByNameandReferrername(String name, String referrername);
	
	@Select(value="SELECT * FROM tb_applicant t where t.applicantEmail = #{0}")
	@ResultMap("BaseApplicantResultMap")
	public List<Applicant> selectMemberByEmail(String email);
	
	@Select(value="select * from tb_event t where t.start >= #{0} and t.end <= #{1}")
	@ResultMap("BaseCalendarEventResultMap")
	public List<CalendarEvent> selectCalendarEventByStartAndEnd(Date start, Date end);
	
	public int insertCalendarEvent(CalendarEvent calendarEvent);
	
	@Select(value="SELECT * FROM tb_reservation t where t.start <=  #{1} and t.end >= #{2} and t.memberidfk = #{0} limit 1")
	@ResultMap("BaseReservationResultMap")
	public List<Reservation> selectReservationByMemberIdAndDate(Long memberId, Date start, Date end);
	
	@Select(value="SELECT * FROM tb_reservation t where t.start >= #{0} and t.end <= #{1} ")
	@ResultMap("BaseReservationResultMap")
	public List<Reservation> selectReservationByDate(Date start, Date end);
	
	public int insertReservation(Reservation reservation);
	
	public int updateCalendarEvent(CalendarEvent calendarEvent);
	
	public int updateField(Field field);
	
	public int insertField(Field field);
	
	@Select(value="select * from tb_reservation t where t.status = '申請中';")
	@ResultMap("BaseReservationResultMap")
	public List<Reservation> selectReservationByStatusIsApplying();
	
	public int updateReservation(Reservation reservation);
}
