package com.example.davidtran.mvpdemo.model;

import com.example.davidtran.mvpdemo.model.entity.Demo;

import java.util.List;

/**
 * Created by davidtran on 7/24/17.
 */

public interface LoadDemoListener {
    void onLoadDemoSucess(List<Demo> demoList);
    void onLoadDemoFailure(String message);
}
