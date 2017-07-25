package com.example.davidtran.mvpdemo.presenter;

import android.content.Context;
import android.util.Log;

import com.example.davidtran.mvpdemo.model.LoadStudentListener;
import com.example.davidtran.mvpdemo.model.UserInterator;
import com.example.davidtran.mvpdemo.model.entity.Student;
import com.example.davidtran.mvpdemo.view.MainView;

import java.util.List;

/**
 * Created by davidtran on 7/24/17.
 */

public class MainPresenter implements LoadStudentListener {
    private UserInterator mainInterator;
    private MainView mainView;

    public MainPresenter(MainView mainView, Context context) {
        this.mainView = mainView;
        mainInterator = new UserInterator(this,context);
    }
    public void createData(Student student){
        mainInterator.createStudentData(student);
    }
    public void updateData(Student student){
        mainInterator.updateStudentData(student);
    }
    public void deleteData(String mssv){
        mainInterator.deleteStudentData(mssv);
    }


    public void loadData(){
        mainInterator.getStudentList();
    }
    @Override
    public void onLoadStudentSuccess(List<Student> studentList) {
            mainView.displayMain(studentList);
    }

    @Override
    public void onLoadStudentFailure(String message) {
        mainView.displayLoadInfo(message);
    }
}
