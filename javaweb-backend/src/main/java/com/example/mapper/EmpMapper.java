package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//    // 查询总记录
//    @Select("select count(*) from  emp")
//    public Long count();
//
//    // 分页查询，
//    @Select("SELECT * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

//    @Select("select * from emp")

    //条件查询
    public abstract List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    // 批量删除
    public abstract void delete(List<Integer> ids);

    // 新增数据
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public abstract void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    public abstract Emp getId(Integer id);

    public abstract void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
     Emp getUsernameAndPassword(Emp emp);

    //根据部门ID删除部门下的员工数据
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
