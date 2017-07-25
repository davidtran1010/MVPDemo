package com.example.davidtran.mvpdemo.model.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.davidtran.mvpdemo.model.entity.Student;

import java.util.ArrayList;


/**
 * Created by davidtran on 6/7/17.
 */


public class DBManager extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "StudentManager.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS Students" + " (" +
                    "MSSV INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "HoTen TEXT," +
                    "NgaySinh Text," +
                    "CMND Text,"+
                    "Khoa INTEGER," +
                    "Nganh Text)" ;



    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS Tasks";

    public DBManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public boolean saveStudentToDB(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        try {
            /*"MSSV INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "HoTen TEXT," +
                    "NgaySinh Text," +
                    "CMND Text,"+
                    "Khoa INTEGER," +
                    "Nganh Text)" ;*/
           
            contentValues.put("HoTen", student.getFName());
            contentValues.put("NgaySinh", student.getBDate());
            contentValues.put("CMND",student.getIDNumber());
            contentValues.put("Khoa", student.getAcaYear());
            contentValues.put("Nganh",student.getMajor());

            db.insert("Students",null,contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteStudentFromDB(String mssv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();

        db.delete("Students","MSSV =" + mssv,null);
        return true;
    }
    public boolean updateStudentToDB(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();

        contentValues.put("HoTen", student.getFName());
        contentValues.put("NgaySinh", student.getBDate());
        contentValues.put("CMND",student.getIDNumber());
        contentValues.put("Khoa", student.getAcaYear());
        contentValues.put("Nganh",student.getMajor());

        db.update("Students",contentValues,"MSSV = ?",new String[] {student.getID()});
        return true;
    }

   /*public ArrayList<Task> FilterTasks(int id){
       int index = 0;
       ArrayList<Task> studentList = new ArrayList<Task>();

       SQLiteDatabase db = this.getReadableDatabase();
       Cursor res = db.rawQuery("Select * from Tasks where ID = "+id,null);
       res.moveToFirst();

       while(res.isAfterLast()==false){
           boolean status = res.getInt(6) >0;
           studentList.add(new Task(res.getInt(0),res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),status));
       }
       return studentList;
   }*/
    public ArrayList<Student> getStudentList(){
        int index = 0;
        ArrayList<Student> studentList = new ArrayList<Student>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * from Students",null);
        res.moveToFirst();

        while(res.isAfterLast()==false){

            String MSSV = res.getString(0);
            String HoTen = res.getString(1);
            String NSinh = res.getString(2);
            String CMND = res.getString(3);
            int Khoa = Integer.parseInt(res.getString(4));
            String Nganh = res.getString(5);

            Student mStudent = new Student(MSSV,HoTen,NSinh,CMND,Khoa,Nganh);
            studentList.add(mStudent
            );
            Log.i("My log: students:",""+index++);
            res.moveToNext();
        }
        Log.i("My log: Student list:","");
        for (Student t:studentList
             ) {
            Log.i("My log:","name:"+t.getFName());
        }

        return studentList;
    }



}

