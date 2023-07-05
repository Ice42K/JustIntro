package com.example.mpfastbegin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpfastbegin.model.Department;
import com.example.mpfastbegin.mapper.DepartmentMapper;
import com.example.mpfastbegin.utils.RecursionSorter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentMapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void testSelect() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("logical_delete",0);
        List<Department> departmentList = departmentMapper.selectList(queryWrapper);
        System.out.println(departmentList);
        System.out.println(RecursionSorter.streamToTree(departmentList,0));
    }
}
