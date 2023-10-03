//package petmembership.service.impl;
//
//
//import com.alibaba.fastjson.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import petmembership.entity.Dept;
//import petmembership.service.IDeptService;
//
//import javax.annotation.security.RunAs;
//import java.sql.SQLOutput;
//import java.util.Date;
//
//@SpringBootTest
//public class DeptServiceImplTest {
//
//    @Autowired
//    private IDeptService iDeptService;
//
//    @Test
//    public void addDept() {
//
//        Dept dept = new Dept();
//        dept.setCreateDate(new Date());
//        dept.setUpdateDate(new Date());
//        dept.setDepName("D3");
//        dept.setDepCode("01");
//        dept.setDepDes("tets");
//        iDeptService.addDept(dept);
//    }
//    @Test
//    public void upDeptById() {
//
//       Dept dept = iDeptService.selectDeptById(2L);
//        dept.setUpdateDate(new Date());
//        dept.setDepName("dept_01");
//        dept.setId(2L);
//        iDeptService.upDeptById(dept);
//    }
//
//
//    @Test
//    public void upDept() {
//        Dept dept = new Dept();
//        dept.setDepCode("01");
//        dept.setUpdateDate(new Date());
//        dept.setDepDes("批量条件更新");
//        iDeptService.upDept(dept);
//    }
//
//    @Test
//    public void queryDept() {
//
//        Dept dept = new Dept();
////        dept.setDepName("t");
//        System.out.println(JSONObject.toJSONString(iDeptService.selectDept(dept)));
//    }
//
//    @Test
//    public void delDeptById() {
//        iDeptService.delDeptById(2L);
//
//
//    }
//}