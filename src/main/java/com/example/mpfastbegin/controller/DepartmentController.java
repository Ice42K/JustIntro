package com.example.mpfastbegin.controller;

import com.example.mpfastbegin.model.Department;
import com.example.mpfastbegin.mapper.service.DepartmentTreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api
@RestController
@RequestMapping("tree")
public class DepartmentController {

    @Autowired
    DepartmentTreeService departmentTreeService;
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "添加部门")
    @PostMapping("addDepartment")
    public void addDepartment(@ApiParam(name="departmentName",value="部门名称",required=true) String departmentName,
                              @ApiParam(name="parentID",value="父节点ID",required=true) Integer parentID){
        departmentTreeService.addTreeNode(departmentName,parentID);
    }

    @ApiOperation(value = "返回树形")
    @GetMapping("getTree")
    public List<Department> getTree(){
        return departmentTreeService.getDepartmentTree();
    }

    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("更改部门名称")
    @PutMapping("updateDepartmentName")
    public void updateDepartmentName(@ApiParam(name="DepartmentID",value="部门ID",required=true) Integer departmentID,
                                     @ApiParam(name="DepartmentName",value="部门新名称",required=true) String departmentName){
        departmentTreeService.updateDepartmentName(departmentID,departmentName);
    }

    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "删除部门")
    @PutMapping("deleteDepartment")
    public void deleteDepartment (@ApiParam(name="DepartmentId",value="部门ID",required=true) Integer departmentId){
        departmentTreeService.deleteDepartment(departmentId);
    }

    @ApiOperation("更改部门树形状")
    @PutMapping("updateDepartmentTreeShape")
    public void updateDepartmentTreeShape(@ApiParam(name="DepartmentId",value="部门ID",required=true) Integer departmentId,
                                          @ApiParam(name="parentId",value="父节点ID",required=true) Integer parentId){
        departmentTreeService.updateDepartmentTreeShape(departmentId,parentId);
    }
}

