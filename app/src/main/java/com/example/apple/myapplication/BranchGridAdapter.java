package com.example.apple.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BranchGridAdapter  extends RecyclerView.Adapter<BranchGridAdapter.ViewHolder>{
    List<BranchGridModel> clubsToday;
    Context context;

    public BranchGridAdapter(List<BranchGridModel> classes,Context context)
    {
        this.clubsToday=classes;
        this.context=context;
    }

    @NonNull
    @Override
    public BranchGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(i,viewGroup,false);

        return new BranchGridAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchGridAdapter.ViewHolder viewHolder, int i){
        viewHolder.bindData(clubsToday.get(i));
    }

    @Override
    public int getItemViewType(final int position){
        return R.layout.branch_cardview;
    }


    @Override
    public int getItemCount(){
        return clubsToday.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView Name;
        TextView Tagline;
        TextView Designation;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.student_name);
            Tagline = itemView.findViewById(R.id.tag_line);
            Designation = itemView.findViewById(R.id.designation_text);
            imageView=itemView.findViewById(R.id.student_image);


        }

        void bindData(final BranchGridModel classT) {
            Name.setText(classT.getName());
            Tagline.setText(classT.getTagline());
            Designation.setText(classT.getDesignation());
            Name.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,ProfileActivity.class);
                    intent.putExtra("name",classT.getName());
                    intent.putExtra("data",classT.getData());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });



        }

    }
}
