package com.example.mpfastbegin.mapper.service;

import com.example.mpfastbegin.model.Department;

import java.util.List;

public interface DepartmentTreeService {

    public List<Department> getDepartmentTree();

    public void addTreeNode(String departmentName,Integer parentId);

    public void updateDepartmentName(Integer departmentId, String name);

    public void deleteDepartment(Integer department);
    public void updateDepartmentTreeShape(Integer department, Integer parentId);
}
