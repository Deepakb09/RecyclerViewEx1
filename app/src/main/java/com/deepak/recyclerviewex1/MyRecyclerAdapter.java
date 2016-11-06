package com.deepak.recyclerviewex1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Deepak on 06-Nov-16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private ArrayList<Employee> mData;
    private LayoutInflater mLayoutInflater;

    public MyRecyclerAdapter(Context context, ArrayList<Employee> data) {
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//This method is used to inflate the view

        View view = mLayoutInflater.inflate(R.layout.list_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);//Passing view to constructor - itemView in the MyViewHolder class created below

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {//This method is used to populate values into views

        holder.setData(position, mData.get(position));//This is to set the data
        holder.setListeners();

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        int mPosition;
        Employee currentEmployee;

        TextView textViewName, textViewDesig;
        ImageButton imageButtonDelete;

        public MyViewHolder(View itemView) {//itemView contains list_row.xml passed above
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textView1);
            textViewDesig = (TextView) itemView.findViewById(R.id.textView2);
            imageButtonDelete = (ImageButton) itemView.findViewById(R.id.imageButton1);
        }

        public void setData(int position, Employee employee) {

            mPosition = position;
            currentEmployee = employee;

            textViewName.setText(employee.getName());
            textViewDesig.setText(employee.getDesig());

        }

        public void setListeners() {
            imageButtonDelete.setOnClickListener(MyViewHolder.this);//This can be implemented after initializing also
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.imageButton1){

                mData.remove(currentEmployee);

                notifyItemRemoved(mPosition);
                notifyItemRangeChanged(mPosition, mData.size());
            }
        }
    }
}