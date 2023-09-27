package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper
{

    //查询全部部门数据
    @Select("select id, name, create_time, update_time from dept")
    public abstract List<Dept> list();


    // 删除部门数据
    @Delete("delete from dept where id = #{id};")
    public abstract void delete(Integer id);

    // 新增部门数据
    @Insert("insert into dept (name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime});")
    public abstract void insert(Dept dept);

    // 更新部门数据
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id};")
    public abstract void update(Dept dept);

    // 回显数据
    @Select("select * from dept where id = #{id}")
    public abstract Dept getId(Integer id);
}
