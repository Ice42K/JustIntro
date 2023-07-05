package com.example.mpfastbegin.utils;

import com.example.mpfastbegin.model.Department;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class RecursionSorter {

    public static List<Department> streamToTree(@NotNull List<Department> treeList, int parentId) {
        return treeList.stream()
                .filter(parent -> parent.getParentId().equals(parentId))
                .map(child -> {
                    child.setChild(streamToTree(treeList,child.getDepartmentId()));
                    return child;
                }).collect(Collectors.toList());
    }
}
