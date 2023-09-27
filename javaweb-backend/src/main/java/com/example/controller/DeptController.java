package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j//记录日志
@RestController
// 完整请求路径由类上的@RequestMapping的value属性和方法上的@RequestMapping的value属性
@RequestMapping("/depts")
public class DeptController
{
    @Autowired
    private DeptService deptService;

    // 查询全部部门数据
    // @RequestMapping(value = "/depts",method = RequestMethod.GET)// 指定请求方式为GET
    // 下行写法为上行的简写
    @GetMapping// 指定请求方式为GET
    public Result list()
    {
        log.info("查询全部部门数据");
        // 调用service方法
        List<Dept> deptList =  deptService.list();
        return Result.success(deptList);
    }


    // 删除部门数据
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        log.info("根据id删除部门:{}", id);
        // 调用service删除部门
        deptService.delete(id);
        return Result.success();
    }

    // 添加部门数据
    @PostMapping
    public Result insert(@RequestBody Dept dept)
    {
        log.info("新增部门:{}", dept);
        // 调用service新增部门
        deptService.insert(dept);
        return Result.success();
    }

    // 编辑界面回显数据
    @GetMapping("/{id}")
    public Result getId(@PathVariable Integer id)
    {
        log.info("根据ID查询数据: {}", id);
        Dept dept = deptService.getId(id);
        return Result.success(dept);
    }


    // 更新部门数据
    // 前端出现请求方法为Post，与开发文档中要求的Put方法不一致，该功能暂未实现
    @PutMapping
    public Result update(@RequestBody Dept dept)
    {
        log.info("更新部门:{}", dept);
        deptService.update(dept);
        return Result.success();
    }

}
