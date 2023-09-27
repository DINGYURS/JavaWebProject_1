package com.example.service.imp;

import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService
{
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;


    @Override
    public List<Dept> list()
    {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id)
    {
        deptMapper.delete(id);// 根据ID删除部门数据

        empMapper.deleteByDeptId(id);// 根据部门ID删除该部门下的员工数据
    }

    @Override
    public void insert(Dept dept)
    {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public void update(Dept dept)
    {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }

    @Override
    public Dept getId(Integer id)
    {
        return deptMapper.getId(id);
    }
}
