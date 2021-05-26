package com.lenovo.dao;

import com.lenovo.domain.Student;
import com.lenovo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao{

    @Override
    public List<Student> SelectStudent() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.lenovo.dao.StudentDao.SelectStudent";
        //执行sql语句，使用sqlSession类的方法
        List<Student> students = sqlSession.selectList(sqlId);
        //关闭
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.lenovo.dao.StudentDao.insertStudent";
        //执行sql语句，使用sqlSession类的方法
        int insert = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        //关闭
        sqlSession.close();
        return insert;
    }
}
