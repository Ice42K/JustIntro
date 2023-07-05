package com.example.mpfastbegin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("department")
@Data
public class Department {
    @TableId(type = IdType.AUTO)
    private Integer departmentId;
    private String departmentName;
    private Integer parentId;
    @TableField(exist = false)
    private List<Department> child;
    private Integer logicalDelete;

    public Department(Integer departmentId, String departmentName, Integer parentId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.parentId = parentId;
    }

    public Department copy(){
        return new Department(this.departmentId, this.departmentName, this.parentId);
    }
}
