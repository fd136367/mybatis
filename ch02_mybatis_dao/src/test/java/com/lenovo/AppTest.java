package com.lenovo;


import com.lenovo.dao.StudentDao;
import com.lenovo.dao.StudentDaoImpl;
import com.lenovo.domain.Student;
import org.junit.Test;

import java.util.List;

public class AppTest
{

    @Test
    public void testSelectStudent(){
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.SelectStudent();
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student stu = new Student();
        stu.setId(1004);
        stu.setName("刘备");
        stu.setEmail("lb@google.com");
        stu.setAge(50);
        int i = dao.insertStudent(stu);
        System.out.println("添加对象的数量"+i);
    }
}
