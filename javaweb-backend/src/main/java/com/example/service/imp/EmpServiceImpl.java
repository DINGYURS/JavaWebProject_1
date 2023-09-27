package com.example.service.imp;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService
{
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize,String name,
//                            Integer gender, LocalDate begin,LocalDate end)
//    {
//        // 获取总记录数
//        Long count = empMapper.count();
//
//        // 获取分页查询结果列表
//        Integer start = (page-1)*pageSize;
//        List<Emp> emplist = empMapper.page(start, pageSize);
//
//
//        // 封装PageBean对象并返回
////        PageBean pageBean = new PageBean(count, emplist);
////        return pageBean;
//        return new PageBean(count, emplist);
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize,String name,
                            Integer gender, LocalDate begin,LocalDate end)
    {
        // 设置分页参数(使用PageHelper插件)
        PageHelper.startPage(page, pageSize);

        // 执行查询
        List<Emp> emplist = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) emplist;

        // 返回结果
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids)
    {
        empMapper.delete(ids);
    }

    @Override
    public void insert(Emp emp)
    {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getId(Integer id)
    {
        return empMapper.getId(id);
    }

    @Override
    public void update(Emp emp)
    {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp)
    {
        return empMapper.getUsernameAndPassword(emp);
    }
}
