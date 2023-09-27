package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController
{
    @Autowired
    private EmpService empService;

    // 分页查询
    @GetMapping
    // @RequestParam 可设置参数的默认值
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String name, Integer gender,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end)
    {
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        // 调用service分页查询
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    // 批量删除
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids)
    {
        log.info("批量删除, ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    // 添加数据
    @PostMapping
    // @RequestBody 用于将前端发送请求的JSON数据封装至实体类中
    public Result insert(@RequestBody Emp emp)
    {
        log.info("新增数据,{}", emp);
        empService.insert(emp);
        return Result.success();
    }

    // 编辑界面显示数据
    @GetMapping("/{id}")
    public Result getId(@PathVariable Integer id)
    {
        log.info("根据ID查询数据：{}", id);
        Emp emp = empService.getId(id);
        return Result.success(emp);
    }

    // 修改数据
    @PutMapping
    public Result update(@RequestBody Emp emp)
    {
        log.info("更新数据：{}", emp);
        empService.update(emp);
        return Result.success();
    }
}
