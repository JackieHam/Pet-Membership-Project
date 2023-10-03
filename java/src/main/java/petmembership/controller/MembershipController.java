package petmembership.controller;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import petmembership.common.BusCodeEnum;
import petmembership.common.ResultVo;
import petmembership.entity.Membership;
import petmembership.service.IMembershipSvc;

@RestController
@RequestMapping("/member")

public class MembershipController {
    @Autowired
    private IMembershipSvc membershipSvc;

    @GetMapping("/querymember")
    public ResultVo getMemberById(@RequestParam Integer id) {
        return membershipSvc.getMember(id);
    }

    @GetMapping("/querymembername")
    public ResultVo getMemberByName(@RequestParam String name) {
        if (StringUtils.isEmpty(name)) {
            return new ResultVo(BusCodeEnum.MANDATORY_FIELD.getCode(), BusCodeEnum.MANDATORY_FIELD.getMsg(), null);
        } else {
            return membershipSvc.getMember(name);
        }
    }

    @PostMapping("/insertmember")
    public ResultVo addMember(@RequestBody Membership member) {
        if (StringUtils.isEmpty(member.getName())) {
            return new ResultVo(BusCodeEnum.MANDATORY_FIELD.getCode(), BusCodeEnum.MANDATORY_FIELD.getMsg(), null);
        }
        return membershipSvc.addMember(member);
    }



    @PostMapping("/updatemember")
    public ResultVo upMember(@RequestBody Membership member) {
        if (member == null) {
            return new ResultVo(BusCodeEnum.MANDATORY_FIELD.getCode(), BusCodeEnum.MANDATORY_FIELD.getMsg(), null);
        } else {
            return membershipSvc.updateMember(member);
        }
    }


    @GetMapping("/deletemember")
    public ResultVo delMember(@RequestParam Integer id) {
        if (membershipSvc.getMember(id) == null) {
            return new ResultVo(BusCodeEnum.NONE_FOUND.getCode(), BusCodeEnum.NONE_FOUND.getMsg(), null);
        } else {
            return membershipSvc.deleteMember(id);
        }
    }

    @GetMapping("/deletemembername")
    public ResultVo delMember(@RequestParam String name) {
        if (StringUtils.isEmpty(name)) {
            return new ResultVo(BusCodeEnum.MANDATORY_FIELD.getCode(), BusCodeEnum.MANDATORY_FIELD.getMsg(), null);
        } else {
            return membershipSvc.deleteMember(name);
        }
    }
}
