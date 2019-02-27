package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.ViewHolder>{
    List<TodayModel> classesToday;

    public TodayAdapter(List<TodayModel> classes)
    {
        this.classesToday=classes;
    }

    @NonNull
    @Override
    public TodayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new TodayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(classesToday.get(i));
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.today_recy_item;
    }


    @Override
    public int getItemCount() {
        return classesToday.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name;
        TextView Time;
        TextView Code;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.Name23);
            Time=itemView.findViewById(R.id.timi);
            Code=itemView.findViewById(R.id.codee);

        }

        void bindData(TodayModel classT){
            Name.setText(classT.getHall());
            Time.setText(classT.getTime());
            Code.setText(classT.getCode());
        }

    }
}
