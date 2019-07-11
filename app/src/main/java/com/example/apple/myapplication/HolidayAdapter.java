package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.ViewHolder> {

    List<HolidayModel> holidays;
    List<HolidayModel> finalModels;

    public HolidayAdapter(List<HolidayModel> child)
    {
        this.holidays=child;
        finalModels=new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            for (HolidayModel hm : holidays) {
                Log.e("TAG", "Sort krne aaya apun");
                if (hm.getDate().contains("/"))
                    if (Integer.parseInt(hm.getDate().substring(hm.getDate().indexOf('/') + 1)) == i)
                        finalModels.add(hm);
            }

        }


    }


    @NonNull
    @Override
    public HolidayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new HolidayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(finalModels.get(i));
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.holiday_table_row;
    }


    @Override
    public int getItemCount() {
        return finalModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView dateview;
        TextView occasion;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateview=itemView.findViewById(R.id.date);
            occasion=itemView.findViewById(R.id.occasion);
        }

        void bindData(HolidayModel child){
            dateview.setText(""+ child.getDate()+"");
            occasion.setText("" + child.getOccasion()+ "");

        }

    }
}




