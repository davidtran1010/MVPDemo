package com.example.davidtran.mvpdemo.model;

import android.content.Context;
import android.util.Log;

import com.example.davidtran.mvpdemo.model.Utils.DBManager;
import com.example.davidtran.mvpdemo.model.entity.Student;

import java.util.ArrayList;

/**
 * Created by davidtran on 7/24/17.
 */

public class UserInterator {
 private LoadStudentListener mListener;
    private DBManager mDBManager;

    public UserInterator(LoadStudentListener listener,Context context) {
        mListener = listener;
        mDBManager = new DBManager(context);
    }


   /* public void createListData(){
        List<Student> mStudentList =  new ArrayList<>();
        for (int i=0;i<10;i++){
            mStudentList.add(new Student("I am developer"));
        }
        mListener.onLoadStudentSuccess(mStudentList);
    }*/

   public void getStudentList(){
       ArrayList<Student> mStudentArrayList = new ArrayList<>();
       try{
           mStudentArrayList = mDBManager.getStudentList();
       }
       catch (Exception e){
           Log.d("An","Failed to get Db");
       }

       if(mStudentArrayList !=null) {
           mListener.onLoadStudentSuccess(mStudentArrayList);
       }
       else{
           mListener.onLoadStudentFailure("Nothing to load or fail to load");
       }
   }
    public void createStudentData(Student student){
        mDBManager.saveStudentToDB(student);

    }
    public void updateStudentData(Student student){
        mDBManager.updateStudentToDB(student);
    }
    public void deleteStudentData(String mssv){
        mDBManager.deleteStudentFromDB(mssv);
    }

}