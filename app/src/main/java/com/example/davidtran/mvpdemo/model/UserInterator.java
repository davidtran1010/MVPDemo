package com.example.davidtran.mvpdemo.model;

import com.example.davidtran.mvpdemo.model.entity.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidtran on 7/24/17.
 */

public class UserInterator {
 private LoadDemoListener mListener;

    public UserInterator(LoadDemoListener listener) {
        mListener = listener;
    }

    public void createListData(){
        List<Demo> mDemoList =  new ArrayList<>();
        for (int i=0;i<10;i++){
            mDemoList.add(new Demo("I am developer"));
        }
        mListener.onLoadDemoSucess(mDemoList);
    }
}