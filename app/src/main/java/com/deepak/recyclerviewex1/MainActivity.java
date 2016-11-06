package com.deepak.recyclerviewex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editTextName, editTextDesig;
    Button button;

    MyRecyclerAdapter myRecyclerAdapter;
    ArrayList<Employee> mEmployeeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Views
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        editTextName = (EditText) findViewById(R.id.editText1);
        editTextDesig = (EditText) findViewById(R.id.editText2);

        mEmployeeArrayList = new ArrayList<>();
        myRecyclerAdapter = new MyRecyclerAdapter(this, mEmployeeArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);//To display in linear fashion we use LinearLayoutManager

        recyclerView.setAdapter(myRecyclerAdapter);
    }

    public void submit(View view) {
        Employee employee = new Employee(editTextName.getText().toString(),editTextDesig.getText().toString());
        mEmployeeArrayList.add(employee);

        myRecyclerAdapter.notifyItemInserted(mEmployeeArrayList.size()-1);
        myRecyclerAdapter.notifyItemRangeChanged(mEmployeeArrayList.size()-1, mEmployeeArrayList.size());
    }
}