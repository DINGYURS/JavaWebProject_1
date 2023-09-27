package com.example.service;


import com.example.pojo.Dept;

import java.util.List;

// 部门管理
public interface DeptService
{
    // 查询全部部门数据
    public abstract List<Dept> list();


    // 删除部门信息
    public abstract void delete(Integer id);

    // 新增部门数据
    public abstract void insert(Dept dept);

    // 回显数据
    public abstract Dept getId(Integer id);

    // 更新部门数据
    public abstract void update(Dept dept);

}
