package com.example.davidtran.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.davidtran.mvpdemo.R;
import com.example.davidtran.mvpdemo.model.entity.Demo;
import com.example.davidtran.mvpdemo.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mMainPresenter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPresenter();

        Button btnLoad = (Button) findViewById(R.id.btn_load_data);
        mListView = (ListView) findViewById(R.id.list_view);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.loadData();
            }
        });
    }

    private void initPresenter(){
        mMainPresenter = new MainPresenter(this);
    }

    @Override
    public void displayMain(List<Demo> listDemo) {
        mListView.setAdapter(new ArrayAdapter<Demo>
                (this,android.R.layout.simple_list_item_1,listDemo));
    }
}
