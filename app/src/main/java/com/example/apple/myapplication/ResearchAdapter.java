package com.example.apple.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ResearchAdapter extends RecyclerView.Adapter<ResearchAdapter.ViewHolder> {
    List<ResearchModel> researchModels;
    Context context;

    public ResearchAdapter(List<ResearchModel> classes)
    {
        this.researchModels=classes;
    }

    @NonNull
    @Override
    public ResearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new ResearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResearchAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(researchModels.get(i));
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.data_recycler_item;
    }


    @Override
    public int getItemCount() {
        return researchModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView subtext;
        TextView history;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleText);
            subtext=itemView.findViewById(R.id.supportInfoText);
            history=itemView.findViewById(R.id.description);

        }

        void bindData(ResearchModel classT){
            title.setText(classT.getProjectName());
            subtext.setText("Mentored by "+ classT.getProjectMentor());
            history.setText(classT.getProjectBreif());
        }

    }
}
