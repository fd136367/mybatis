package com.lenovo;


import com.github.pagehelper.PageHelper;
import com.lenovo.dao.StudentDao;
import com.lenovo.domain.Student;
import com.lenovo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AppTest
{

    @Test
    public void selectStudentIf(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        //student.setName("李四");
        student.setAge(20);
        //调用dao的方法，执行数据库操作
        List<Student> student1 =mapper.selectStudentIf(student);
        student1.forEach(student2 -> System.out.println(student2));
    }


    @Test
    public void selectStudentWhere(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        //调用dao的方法，执行数据库操作
        List<Student> student1 =mapper.selectStudentWhere(student);
        student1.forEach(student2 -> System.out.println(student2));
    }

    @Test
    public void selectForEach(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1003);
        list.add(1002);
        //调用dao的方法，执行数据库操作
        List<Student> students = mapper.selectForEach(list);
        students.forEach(student2 -> System.out.println(student2));
    }

    @Test
    public void selectForEachTwo(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setId(1002);
        list.add(student);

        student =  new Student();
        student.setId(1003);
        list.add(student);
        //调用dao的方法，执行数据库操作
        List<Student> students = mapper.selectForEachTwo(list);
        students.forEach(student2 -> System.out.println(student2));
    }

    @Test
    public void selectAll(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper方法，分页
        //pageNum:第几页数据，从1开始
        //pageSize：一页中有多少行数据
        PageHelper.startPage(1,3);
        List<Student> students = mapper.selectAll();
        students.forEach(student2 -> System.out.println(student2));
    }
}