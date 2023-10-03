//package petmembership.service.impl;
//
//import lombok.Data;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import petmembership.entity.Membership;
//import petmembership.mapper.MembershipMapper;
//import petmembership.service.IMembershipSvc;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Service
//public class MembershipSvcImpl implements IMembershipSvc {
//
//    @Autowired
//    private MembershipMapper membershipMapper;
//
//
//    @Override
//    public Membership getMember(Integer id) {
//        return membershipMapper.queryMemberById(id);
//    }
//
//    @Override
//    public List<Membership> getMember(String name) {
//        return membershipMapper.queryMemberByName(name);
//    }
//
//    @Override
//    public Integer addMember(Membership member) {
//        //.....校验逻辑
//        if (getMember(member.getId()) == null) {
//            membershipMapper.insertMember(member);
//            return member.getId();
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public Integer updateMember(Membership member) {
//        if (getMember(member.getId()) != null) {
//            membershipMapper.updateMember(member);
//            return member.getId();
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public Integer deleteMember(Integer id) {
//        if (getMember(id) != null) {
//            return membershipMapper.delMember(id);
//        } else {
//            return 0;
//        }
//    }
//
//    @Override
//    public Integer deleteMember(String name) {
//        if (getMember(name) != null) {
//            return membershipMapper.delMemberByName(name);
//        } else {
//            return 0;
//        }
//    }
//}
