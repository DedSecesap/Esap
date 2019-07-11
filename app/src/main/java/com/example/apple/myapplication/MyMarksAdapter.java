package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class MyMarksAdapter extends RecyclerView.Adapter<MyMarksAdapter.ViewHolder> {

    List<MyMarksModel> models;

    public MyMarksAdapter(List<MyMarksModel> child)
    {
        this.models=child;
    }


    @NonNull
    @Override
    public MyMarksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new MyMarksAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMarksAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(models.get(i));
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.marks_listview;
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView code,marks;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.course_name);
            code=itemView.findViewById(R.id.course_code);
            marks=itemView.findViewById(R.id.marks);




        }

        void bindData(MyMarksModel child){
            name.setText(child.getName());
            code.setText(child.getCode());
            marks.setText(child.getMarks());
        }

    }
}