package com.example.davidtran.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.davidtran.mvpdemo.R;
import com.example.davidtran.mvpdemo.model.entity.Student;
import com.example.davidtran.mvpdemo.presenter.MainPresenter;
import com.example.davidtran.mvpdemo.view.Adapters.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mMainPresenter;
    private StudentAdapter mStudentAdapter;
private List<Student> mStudentList = new ArrayList<>();
    @BindView(R.id.list_view) ListView mListView;
    @BindView(R.id.btn_create_data) Button btnCreate;
    @BindView(R.id.btn_update_data) Button btnUpdate;
    @BindView(R.id.btn_delete_data) Button btnDelete;

    @BindView(R.id.inputID)
    EditText inputID;
    @BindView(R.id.inputName)
    EditText inputName;
    @BindView(R.id.inputBDate)
    EditText inputBDate;
    @BindView(R.id.inputIDNumber)
    EditText inputIDNumber;
    @BindView(R.id.inputAcaYear)
    EditText inputAcaYear;
    @BindView(R.id.inputMajor)
    EditText inputMajor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPresenter();

        mMainPresenter.loadData();
        setupListener();

    }

    private void setupListener(){
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mMainPresenter.createData(convertViewtoStudent());
                mMainPresenter.loadData();
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                inputID.setText(mStudentList.get(position).getID());
                inputName.setText(mStudentList.get(position).getFName());
                inputBDate.setText(mStudentList.get(position).getBDate());
                inputIDNumber.setText(mStudentList.get(position).getIDNumber());
                String acaYear = String.valueOf(mStudentList.get(position).getAcaYear());
                inputAcaYear.setText(acaYear);
                inputMajor.setText(mStudentList.get(position).getMajor());

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.updateData(convertViewtoStudent());
                mMainPresenter.loadData();

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = "";
                id = inputID.getText().toString();
                mMainPresenter.deleteData(id);
                mMainPresenter.loadData();
            }
        });
    }
    private Student convertViewtoStudent(){
        String ID = inputID.getText().toString();
        String Name = inputName.getText().toString();
        String BDate = inputBDate.getText().toString();
        String IDNumber = inputIDNumber.getText().toString();
        int AcaYear = Integer.parseInt(inputAcaYear.getText().toString());
        String Major = inputMajor.getText().toString();

        Student mStudent = new Student(ID,Name,BDate,IDNumber,AcaYear,Major);
        return  mStudent;
    }
    private void initPresenter(){
        mMainPresenter = new MainPresenter(this,getApplicationContext());
    }

    @Override
    public void displayMain(List<Student> listStudent) {
        mStudentList = listStudent;
        mStudentAdapter = new StudentAdapter(listStudent,getApplicationContext());
        mListView.setAdapter(mStudentAdapter);
    }

    @Override
    public void displayLoadInfo(String message) {
        Toast.makeText(this,"Nothing to load",Toast.LENGTH_SHORT);
    }
}
