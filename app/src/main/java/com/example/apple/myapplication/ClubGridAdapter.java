package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClubGridAdapter extends RecyclerView.Adapter<ClubGridAdapter.ViewHolder>{
        List<ClubGridModel> clubsToday;

public ClubGridAdapter(List<ClubGridModel> classes)
        {
        this.clubsToday=classes;
        }

@NonNull
@Override
public ClubGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(i,viewGroup,false);

        return new ClubGridAdapter.ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder,int i){
        viewHolder.bindData(clubsToday.get(i));
        }

@Override
public int getItemViewType(final int position){
        return R.layout.club_cardview;
        }


@Override
public int getItemCount(){
        return clubsToday.size();
        }

class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView Name;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        Name = itemView.findViewById(R.id.tvTypeName);
        imageView=itemView.findViewById(R.id.img_roomType);


    }

    void bindData(ClubGridModel classT) {
        Name.setText(classT.getTextClub());


    }

}
}

