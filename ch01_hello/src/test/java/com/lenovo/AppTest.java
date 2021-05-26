package com.lenovo;

import static org.junit.Assert.assertTrue;

import com.lenovo.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AppTest 
{

    @Test
   public void insert() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始（target/classes）
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream stream = Resources.getResourceAsStream(config);
        //3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory build = builder.build(stream);
        //5.[重要] 获取SqlSessionFactory中获取SqlSession   true自动开启自动提交事务
        SqlSession sqlSession = build.openSession(true);
        //6.[重要]指定要执行的sql语句的标识。sql映射文件中的namespace+"."+标签的id值
        String sqlId = "com.lenovo.dao.StudentDao" + "." + "insertStudent";
        Student stu = new Student();
        stu.setId(1003);
        stu.setName("张飞");
        stu.setEmail("zhangfei@163.com");
        stu.setAge(28);
        //7.执行sql语句，通过sqlId找到语句
        int num = sqlSession.insert(sqlId, stu);
        //8.输出结果
        System.out.println("执行之后影响的行数是"+num);
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
