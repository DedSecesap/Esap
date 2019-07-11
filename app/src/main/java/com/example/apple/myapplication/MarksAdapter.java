package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class MarksAdapter extends RecyclerView.Adapter<MarksAdapter.ViewHolder> {

    List<MarksModel> models;

    public MarksAdapter(List<MarksModel> child)
    {
        this.models=child;
    }


    @NonNull
    @Override
    public MarksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new MarksAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarksAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(models.get(i));
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.marks_d_proflist;
    }


    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView number;
        TextView grade,lower,upper,avg;
        CheckBox checkBox;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.text1);
            grade=itemView.findViewById(R.id.grades_name);
            lower=itemView.findViewById(R.id.lower_limit);
            upper=itemView.findViewById(R.id.upper_limit);
            avg=itemView.findViewById(R.id.avg_students);
            checkBox=itemView.findViewById(R.id.grade_check);



        }

        void bindData(MarksModel child){
            number.setText(child.getNo());
            grade.setText(child.getGrade());
            lower.setText(child.getLL());
            upper.setText(child.getUL());
            avg.setText(child.getAvg());
            checkBox.setChecked(child.getChecked());

        }

    }
}
