package com.example.service;


import com.example.pojo.Emp;
import com.example.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService
{
    public abstract PageBean page(Integer page, Integer pageSize,String name,
                                    Integer gender, LocalDate begin,LocalDate end);

    public abstract void delete(List<Integer> ids);

    public abstract void insert(Emp emp);

    public abstract Emp getId(Integer id);

    public abstract void update(Emp emp);

    Emp login(Emp emp);

}
