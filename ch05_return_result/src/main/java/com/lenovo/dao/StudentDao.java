package com.lenovo.dao;

import com.lenovo.domain.MyStudent;
import com.lenovo.domain.Student;
import com.lenovo.vo.QueryParam;
import com.lenovo.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(Integer id);

    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudent();

    //定义方法返回Map
    Map<Object,Object> selectMapById(Integer id);

    //使用resultMap定义映射关系
    List<Student> selectAllStudents();

    //MyStudent的查询
    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffColProperty();

    //第一种模糊查询,在java代码指定like内容
    List<Student> selectLikeOne(String name);
    //name就是李值，在mapper中拼接 like "%" 李 "%"
    List<Student> selectLikeTwo(String name);

}
