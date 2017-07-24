package com.example.davidtran.mvpdemo.presenter;

import com.example.davidtran.mvpdemo.model.LoadDemoListener;
import com.example.davidtran.mvpdemo.model.UserInterator;
import com.example.davidtran.mvpdemo.model.entity.Demo;
import com.example.davidtran.mvpdemo.view.MainView;

import java.util.List;

/**
 * Created by davidtran on 7/24/17.
 */

public class MainPresenter implements LoadDemoListener {
    private UserInterator mainInterator;
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        mainInterator = new UserInterator(this);
    }

    public void loadData(){
        mainInterator.createListData();
    }
    @Override
    public void onLoadDemoSucess(List<Demo> demoList) {
            mainView.displayMain(demoList);
    }

    @Override
    public void onLoadDemoFailure(String message) {

    }
}
