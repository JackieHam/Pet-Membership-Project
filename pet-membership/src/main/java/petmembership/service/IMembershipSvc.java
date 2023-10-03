package petmembership.service;

import petmembership.common.ResultVo;
import petmembership.entity.Membership;

import java.util.List;

public interface IMembershipSvc {
    ResultVo getMember(Integer id);

    ResultVo addMember(Membership member);

    ResultVo updateMember(Membership member);

    ResultVo deleteMember(Integer id);

    ResultVo getMember(String name);

    ResultVo deleteMember(String name);
}
