package com.dandelion.membership.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dandelion.membership.dao.data.MembershipMapper;
import com.dandelion.membership.dao.model.Applicant;

@Service
public class MemberService {
	@Autowired
	private MembershipMapper membershipMapper;
	
	public List<Applicant> selectMember() {
		List<Applicant> list = membershipMapper.selectMembers();
		return list;
	}
	
}
