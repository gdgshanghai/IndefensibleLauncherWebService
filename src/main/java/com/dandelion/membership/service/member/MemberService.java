package com.dandelion.membership.service.member;

import com.dandelion.membership.dao.data.MembershipMapper;
import com.dandelion.membership.dao.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MembershipMapper membershipMapper;

    public List<Applicant> selectMember() {
        List<Applicant> list = membershipMapper.selectMembers();
        return list;
    }

}
