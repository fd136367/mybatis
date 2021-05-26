package com.lenovo;


import com.lenovo.dao.StudentDao;
import com.lenovo.domain.Student;
import com.lenovo.utils.MyBatisUtils;
import com.lenovo.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
    public void testSelectMultiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectMulitParam("关羽", 20);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testSelectMultiObject(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        QueryParam param = new QueryParam();
        param.setParamName("张三");
        param.setParamAge(28);
        List<Student> students = mapper.selectMultiObject(param);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }


}
