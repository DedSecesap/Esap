package com.example.apple.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder>{
    List<ClubModel> children;
    Context context;

    public ClubAdapter(List<ClubModel> child, Context context)
    {
        this.children=child;
        this.context=context;
    }

    @NonNull
    @Override
    public ClubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new ClubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(children.get(i));
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.recyclable_item_academic;
    }


    @Override
    public int getItemCount() {
        return children.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.NameCode);
        }

        void bindData(final ClubModel child){
            Name.setText(child.getName());
            Name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,ClubActivity.class);
                    intent.putExtra("Name",child.getName());
                    intent.putExtra("Council",child.getCouncil());
                    context.startActivity(intent);
                }
            });

        }

    }
}

