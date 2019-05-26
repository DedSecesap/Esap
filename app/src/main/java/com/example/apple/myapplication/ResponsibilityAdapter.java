package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ResponsibilityAdapter extends RecyclerView.Adapter<ResponsibilityAdapter.ViewHolder>{
        List<ResponsibilityModel> children;

public ResponsibilityAdapter(List<ResponsibilityModel> child)
        {
        this.children=child;
        }

@NonNull
@Override
public ResponsibilityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new ResponsibilityAdapter.ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(children.get(i));
        }

@Override
public int getItemViewType(final int position) {
        return R.layout.responsibilityitem;
        }


@Override
public int getItemCount() {
        return children.size();
        }

class ViewHolder extends RecyclerView.ViewHolder{
    TextView Name;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        Name=itemView.findViewById(R.id.nameeee);
    }

    void bindData(ResponsibilityModel child){
        Name.setText(child.getName());

    }

}
}