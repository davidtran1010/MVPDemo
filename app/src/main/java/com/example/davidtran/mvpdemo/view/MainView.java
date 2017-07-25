package com.example.davidtran.mvpdemo.view;

import com.example.davidtran.mvpdemo.model.entity.Student;

import java.util.List;

/**
 * Created by davidtran on 7/24/17.
 */

public interface MainView {
    void displayMain(List<Student> listStudent);
    void displayLoadInfo(String message);

}

