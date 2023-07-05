package com.example.mpfastbegin.mapper.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mpfastbegin.model.Department;
import com.example.mpfastbegin.mapper.DepartmentMapper;
import com.example.mpfastbegin.mapper.service.DepartmentTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static com.example.mpfastbegin.utils.RecursionSorter.streamToTree;

@Service
public class DepartmentTreeServiceImpl implements DepartmentTreeService {
    private static final int DefaultRootID = 0;
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepartmentTree() {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("logical_delete",0);
        List<Department> departmentList = departmentMapper.selectList(queryWrapper);
        departmentList = streamToTree(departmentList,DefaultRootID);
        return departmentList;
    }

    @Override
    public void addTreeNode(String departmentName,Integer parentId) {
        Department department = new Department(null,departmentName,parentId);
        departmentMapper.insert(department);
    }

    @Override
    public void updateDepartmentName(Integer departmentId, String name) {
        Department departmentNameUpdater =  departmentMapper.selectById(departmentId);
        departmentNameUpdater.setDepartmentName(name);
        departmentMapper.updateById(departmentNameUpdater);
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        Department departmentNameDeleter =  departmentMapper.selectById(departmentId);
        departmentNameDeleter.setLogicalDelete(1);
        departmentMapper.updateById(departmentNameDeleter);
    }

    @Override
    public void updateDepartmentTreeShape(Integer departmentId, Integer parentId) {
        Department departmentParentIdUpdater = departmentMapper.selectById(departmentId);
        departmentParentIdUpdater.setParentId(parentId);
        departmentMapper.updateById(departmentParentIdUpdater);
    }
}
