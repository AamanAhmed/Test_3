package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView empname,empdept,empsalary;
    Button savebtn,viewbtn;
    Db db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empname = (TextView) findViewById(R.id.name);
        empdept = (TextView) findViewById(R.id.dept);
        empsalary = (TextView) findViewById(R.id.salary);
        savebtn = (Button) findViewById(R.id.save);
        viewbtn = (Button) findViewById(R.id.view);
        db = new Db(MainActivity.this);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = empname.getText().toString();
                String dept = empdept.getText().toString();
                int salary = Integer.parseInt(empsalary.getText().toString());

                if (salary < 25000) {
                    Toast.makeText(MainActivity.this, "Salary must be 25000", Toast.LENGTH_SHORT).show();
                } else if (salary > 75000) {
                    Toast.makeText(MainActivity.this, "Salary must be under 75000", Toast.LENGTH_SHORT).show();
                }  else {
                    boolean success = db.insertrecord(name, dept, salary);
                    if (success == true) {
                        Toast.makeText(MainActivity.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,view.class);
                startActivity(i);
            }
        });
        }

    }

