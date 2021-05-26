package com.lenovo.dao;

import com.lenovo.domain.Student;

import java.util.List;

public interface StudentDao {

    //动态sql，使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    //where的使用
    List<Student> selectStudentWhere(Student student);

    //forEach的使用1
    List<Student> selectForEach(List<Integer> idlist);

    //forEach的使用2
    List<Student> selectForEachTwo(List<Student> stulist);

    //使用PageHelper分页数据
    List<Student> selectAll();

}
