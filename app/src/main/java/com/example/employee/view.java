package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class view extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        list = (ListView) findViewById(R.id.mylist);
        Db db = new Db(this);
        ArrayList<HashMap<String,String>> datarecvd = db.fetchdata();
        ListAdapter adapter = new SimpleAdapter(this,datarecvd,R.layout.customlayout,new String[]{"Name","Dept","Salary"},new int[]{R.id.editname,R.id.editdept,R.id.editsalary});
        list.setAdapter(adapter);
    }
}