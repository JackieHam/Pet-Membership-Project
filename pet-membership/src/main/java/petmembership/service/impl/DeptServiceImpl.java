//package petmembership.service.impl;
//
//import com.alibaba.druid.util.StringUtils;
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import org.apache.ibatis.annotations.Update;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import petmembership.entity.Dept;
//import petmembership.mapper.DeptMapper;
//import petmembership.service.IDeptService;
//
//import java.sql.Wrapper;
//import java.util.List;
//
//@Service
//public class DeptServiceImpl implements IDeptService {
//
//
//    @Autowired
//    private DeptMapper deptMapper;
//
//
//    @Override
//    public Dept selectDeptById(Long id) {
//        return  deptMapper.selectById(id);
//    }
//
//    @Override
//    public List<Dept> selectDept(Dept dept) {
////        QueryWrapper<Dept> queryWrapper = new QueryWrapper<Dept>();
////        if (!StringUtils.isEmpty(dept.getDepName())) {
////            queryWrapper.like("dep_name", dept.getDepName());
////        }
////        queryWrapper.select("dep_name","dep_code");
//
//        LambdaQueryWrapper<Dept> wrapper = Wrappers.lambdaQuery();
//        if (!StringUtils.isEmpty(dept.getDepName())) {
//            wrapper.like(Dept::getDepName, dept.getDepName());
//        }
//        wrapper.select(Dept::getDepName, Dept::getDepCode);
//        return deptMapper.selectList(wrapper);
//    }
//
//
//
//
//    @Override
//    public int addDept(Dept dept) {
//        deptMapper.insert(dept);
//        return 0;
//    }
//
//    @Override
//    public int upDeptById(Dept dept) {
//        deptMapper.updateById(dept);
//        return 0;
//    }
//
//    @Override
//    public int upDept(Dept dept) {
//        UpdateWrapper wrapper = new UpdateWrapper<Dept>();
//        if (!StringUtils.isEmpty(dept.getDepCode())) {
//            wrapper.eq("dep_code", dept.getDepCode());
//        }
//        deptMapper.update(dept, wrapper);
//        return 0;
//    }
//
//    @Override
//    public int delDeptById(Long id) {
//        return deptMapper.deleteById(id);
//    }
//}
