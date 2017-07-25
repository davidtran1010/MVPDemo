package com.example.davidtran.mvpdemo.model;

import com.example.davidtran.mvpdemo.model.entity.Student;

import java.util.List;

/**
 * Created by davidtran on 7/24/17.
 */

public interface LoadStudentListener {
    void onLoadStudentSuccess(List<Student> studentList);
    void onLoadStudentFailure(String message);
}
