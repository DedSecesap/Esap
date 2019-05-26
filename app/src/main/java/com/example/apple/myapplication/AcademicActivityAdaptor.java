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

public class AcademicActivityAdaptor extends RecyclerView.Adapter<AcademicActivityAdaptor.ViewHolder>{
        List<AcademicActivityModel> children;
        Context context;

public AcademicActivityAdaptor(List<AcademicActivityModel> child, Context context)
        {
        this.children=child;
        this.context =context;
        }

@NonNull
@Override
public AcademicActivityAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new AcademicActivityAdaptor.ViewHolder(view);
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

    void bindData(final AcademicActivityModel child){
        Name.setText(child.getName());
        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(child.getType().contains("profe"))
                {
                    Intent intent=new Intent(context,ProfessorActivity.class);
                    intent.putExtra("data",child.getDetails());
                    intent.putExtra("name",child.getName());
                    context.startActivity(intent);
                }
                else if(child.getType().contains("courses"))
                {
                    Intent intent=new Intent(context,CourseInfoActivity.class);
                    intent.putExtra("data",child.getDetails());
                    intent.putExtra("name",child.getName());
                    context.startActivity(intent);
                }
                else if(child.getType().contains("students"))
                {
                    Intent intent=new Intent(context,ProfileActivity.class);
                    intent.putExtra("data",child.getDetails());
                    intent.putExtra("name",child.getName());
                    intent.putExtra("from","Recycler");
                    context.startActivity(intent);
                }
            }
        });

    }

}
}

