package com.dandelion.membership.service.member;

import com.dandelion.membership.dao.data.MembershipMapper;
import com.dandelion.membership.dao.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApprovalService {
    @Autowired
    private MembershipMapper membershipMapper;

    public static void main(String[] args) {
        long d = new Date().getTime();
        d = d + 1000L * 60 * 60 * 24 * 365 * 2;
        Date x = new Date(d);
        System.out.println(x);
    }

    public List<Applicant> selectApplicant() {
        List<Applicant> list = membershipMapper.selectApplicant();
        for (Applicant applicant : list) {
            String referrerName = applicant.getReferrername();
            List<Applicant> referrerMember = membershipMapper.selectMemberByName(referrerName);
            if (referrerMember.size() == 0) {
                continue;
            }
            long d = new Date().getTime();
            long value = d - referrerMember.get(0).getApplydate().getTime();
            long twoYear = 1000L * 60 * 60 * 24 * 365 * 2;
            if (value > twoYear) {
                applicant.setIsreferrertrue(true);
            }
        }
        return list;
    }

    public void approval(List<Applicant> applicants) {
        for (Applicant applicant : applicants) {
            if ("accept".equals(applicant.getStatus())) {
                applicant.setIsmember(true);
            }
            applicant.setModifieddate(new Date());
            membershipMapper.updateApplicant(applicant);
        }
    }
}
