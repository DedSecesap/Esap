package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.ViewHolder>{
    List<AnnouncementModel> clubsToday;

    public AnnouncementAdapter(List<AnnouncementModel> classes)
    {
        this.clubsToday=classes;
    }

    @NonNull
    @Override
    public AnnouncementAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(i,viewGroup,false);

        return new AnnouncementAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementAdapter.ViewHolder viewHolder, int i){
        viewHolder.bindData(clubsToday.get(i));
    }

    @Override
    public int getItemViewType(final int position){
        return R.layout.announcement_view;
    }


    @Override
    public int getItemCount(){
        return clubsToday.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView text1,text2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.proftext1);
            text2 = itemView.findViewById(R.id.proftext2);
            imageView=itemView.findViewById(R.id.messengerImageView);


        }

        void bindData(AnnouncementModel classT) {
            text1.setText(classT.getTitle());
            text2.setText(classT.getMessage());

        }

    }
}
