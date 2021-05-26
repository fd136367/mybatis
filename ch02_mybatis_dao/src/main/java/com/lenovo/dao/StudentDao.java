package com.lenovo.dao;

import com.lenovo.domain.Student;

import java.util.List;

public interface StudentDao {

    List<Student> SelectStudent();

    public int insertStudent(Student student);
}
