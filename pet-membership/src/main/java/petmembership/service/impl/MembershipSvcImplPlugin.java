package petmembership.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petmembership.common.BusCodeEnum;
import petmembership.common.ResultVo;
import petmembership.entity.Membership;
import petmembership.mapper.MembershipMapperPlugin;
import petmembership.service.IMembershipSvc;
import javax.xml.transform.Result;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class MembershipSvcImplPlugin implements IMembershipSvc {
    @Autowired
    private MembershipMapperPlugin membershipMapperPlugin;

    @Override
    public ResultVo getMember(Integer id) {
        if (id <= 0) {
            return new ResultVo(BusCodeEnum.INVALID_INPUT.getCode(), BusCodeEnum.INVALID_INPUT.getMsg(), id);
        } else {
            Membership membership = membershipMapperPlugin.selectById(id);
            if (membership == null) {
                return new ResultVo(BusCodeEnum.NONE_FOUND.getCode(), BusCodeEnum.NONE_FOUND.getMsg(), null);
            } else {
                return new ResultVo(BusCodeEnum.SUCCESS.getCode(), BusCodeEnum.SUCCESS.getMsg(), membership);
            }
        }
    }

    @Override
    public ResultVo getMember(String inputName) {
        QueryWrapper<Membership> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", inputName);
        queryWrapper.select("id", "name", "gender", "age", "phone_number", "balance", "member_level", "registration_date");
        List<Membership> memberships = membershipMapperPlugin.selectList(queryWrapper);
        if (memberships.size() == 0) {
            return new ResultVo(BusCodeEnum.NONE_FOUND.getCode(), BusCodeEnum.NONE_FOUND.getMsg(), null);
        } else {
            return new ResultVo(BusCodeEnum.SUCCESS.getCode(), BusCodeEnum.SUCCESS.getMsg(), memberships);
        }
    }

    @Override
    public ResultVo addMember(Membership member) {
        if (membershipMapperPlugin.selectById(member.getId()) != null) {
            return new ResultVo(BusCodeEnum.DUPLICATION_OF_DATA.getCode(), BusCodeEnum.DUPLICATION_OF_DATA.getMsg(), null);
        }
        if (member.getRegistrationDate() != null) {
            Date registrationDate = member.getRegistrationDate();
            LocalDate localRegistrationDate = registrationDate.toLocalDate();
            LocalDate today = LocalDate.now();
            if (today.isBefore(localRegistrationDate)) {
                return new ResultVo(BusCodeEnum.INVALID_INPUT.getCode(), BusCodeEnum.INVALID_INPUT.getMsg(), registrationDate);
            }
        }
        if (member.getAge() != null) {
            Integer inputAge = member.getAge();
            if (!inputAge.toString().matches("120|(1[0-1]\\d)|([1-9]?\\d)")) {
                return new ResultVo(BusCodeEnum.INVALID_INPUT.getCode(), BusCodeEnum.INVALID_INPUT.getMsg(), inputAge);
            }
        }
        membershipMapperPlugin.insert(member);
        int id = member.getId();
        return new ResultVo(BusCodeEnum.SUCCESS.getCode(), BusCodeEnum.SUCCESS.getMsg(), id);
    }

    @Override
    public ResultVo updateMember(Membership member) {
        if (membershipMapperPlugin.selectById(member.getId()) == null) {
            return new ResultVo(BusCodeEnum.NONE_FOUND.getCode(), BusCodeEnum.NONE_FOUND.getMsg(), null);
        }
        if (member.getRegistrationDate() != null) {
            Date registrationDate = member.getRegistrationDate();
            LocalDate registrationLocalDate = registrationDate.toLocalDate();
            LocalDate today = LocalDate.now();
            if (today.isBefore(registrationLocalDate)) {
                return new ResultVo(BusCodeEnum.INVALID_INPUT.getCode(), BusCodeEnum.INVALID_INPUT.getMsg(), registrationDate);
            }
        }
        if (member.getAge() != null) {
            Integer inputAge = member.getAge();
            if (!inputAge.toString().matches("120|(1[0-1]\\d)|([1-9]?\\d)")) {
                return new ResultVo(BusCodeEnum.INVALID_INPUT.getCode(), BusCodeEnum.INVALID_INPUT.getMsg(), inputAge);
            }
        }
        membershipMapperPlugin.updateById(member);
        return new ResultVo(BusCodeEnum.SUCCESS.getCode(), BusCodeEnum.SUCCESS.getMsg(), member.getId());
    }

    @Override
    public ResultVo deleteMember(Integer id) {
        if (membershipMapperPlugin.selectById(id) == null) {
            return new ResultVo(BusCodeEnum.NONE_FOUND.getCode(), BusCodeEnum.NONE_FOUND.getMsg(), null);
        } else {
            membershipMapperPlugin.deleteById(id);
            return new ResultVo(BusCodeEnum.SUCCESS.getCode(), BusCodeEnum.SUCCESS.getMsg(), id);
        }
    }

    @Override
    public ResultVo deleteMember(String inputName) {
        QueryWrapper<Membership> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", inputName);
        List<Membership> memberships = membershipMapperPlugin.selectList(queryWrapper);
        int size = memberships.size();
        if (size == 0) {
            return new ResultVo(BusCodeEnum.NONE_FOUND.getCode(), BusCodeEnum.NONE_FOUND.getMsg(), inputName);
        } else {
            queryWrapper.eq("name", inputName);
            membershipMapperPlugin.delete(queryWrapper);
            return new ResultVo(BusCodeEnum.SUCCESS.getCode(), BusCodeEnum.SUCCESS.getMsg(), size);
        }
    }
}
