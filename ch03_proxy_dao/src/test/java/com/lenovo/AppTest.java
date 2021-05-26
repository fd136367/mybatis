package com.lenovo;


import com.lenovo.dao.StudentDao;
import com.lenovo.domain.Student;
import com.lenovo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class AppTest
{

    @Test
    public void testSelectStudent(){
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getSession(dao接口)
         * getMapper能获取dao接口对于的实现类对象
         */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库操作
        List<Student> students = mapper.SelectStudent();
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student stu = new Student();
        stu.setId(1005);
        stu.setName("关羽");
        stu.setEmail("gy@google.com");
        stu.setAge(50);
        int i = mapper.insertStudent(stu);
        sqlSession.commit();
        System.out.println("添加对象的数量"+i);
    }
}
