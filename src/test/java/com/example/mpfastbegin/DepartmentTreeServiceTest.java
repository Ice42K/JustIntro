package com.example.mpfastbegin;

import com.example.mpfastbegin.model.Department;
import com.example.mpfastbegin.mapper.service.DepartmentTreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class DepartmentTreeServiceTest {
    @Autowired
    DepartmentTreeService departmentTreeService;

    @Test
    public void TestGetDepartmentTree(){
        List<Department> result =  departmentTreeService.getDepartmentTree();
        System.out.println("\n"+result+"\n");

    }

    @Test
    public void TestAddTreeNode(){
        String departmentName = "技术支持部";
        Integer parentId = 2;
        departmentTreeService.addTreeNode(departmentName,parentId);
    }

    @Test
    public void TestUpdateDepartmentName(){
        Integer departmentId = 1;
        String name = "总经理办";
        departmentTreeService.updateDepartmentName(departmentId,name);
    }

    @Test
    public void TestDeleteDepartment(){
        Integer departmentId = 13;
        departmentTreeService.deleteDepartment(departmentId);
    }

    @Test
    public void UpdateDepartmentTreeShape(){
        Integer departmentId = 4;
        Integer parentId = 1;
        departmentTreeService.updateDepartmentTreeShape(departmentId,parentId);
    }


}
