package com.lenovo;


import com.lenovo.dao.StudentDao;
import com.lenovo.domain.MyStudent;
import com.lenovo.domain.Student;
import com.lenovo.utils.MyBatisUtils;
import com.lenovo.vo.QueryParam;
import com.lenovo.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class AppTest
{

    @Test
    public void testSelectStudent(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        Student student1 = mapper.selectStudentById(1003);
        System.out.println(student1);
    }
    @Test
    public void testSelectStudentReturnViewStudent() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        ViewStudent viewStudent = mapper.selectStudentReturnViewStudent(1003);
        System.out.println(viewStudent);
    }

    @Test
    public void testCountStudent() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        int i = mapper.countStudent();
        System.out.println("学生的数量" + i);
    }

    //返回Map
    @Test
    public void testSelectMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = mapper.selectMapById(1001);
        System.out.println(map);
    }

    @Test
    public void testSelectResultMap(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        List<Student> student1 =  mapper.selectAllStudents();
        student1.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectMyStudent(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        List<MyStudent> student1 =  mapper.selectMyStudent();
        student1.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectDiffColProperty(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        List<MyStudent> student1 =  mapper.selectDiffColProperty();
        student1.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectLikeOne(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        //准备好like的内容
        String name = "%李%";
        List<Student> student1 =  mapper.selectLikeOne(name);
        student1.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectLikeTwo(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        //准备好like的内容
        String name = "李";
        List<Student> student1 =  mapper.selectLikeTwo(name);
        student1.forEach(student -> System.out.println(student));
    }


}