package com.example.apple.myapplication;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ProfCardAdapter extends RecyclerView.Adapter<ProfCardAdapter.ViewHolder>{
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    DatabaseReference reference=firebaseDatabase.getReference();

    List<AcademicActivityModel> children;
    Context context;
    public ProfCardAdapter(List<AcademicActivityModel> child, Context context)
    {
        this.children=child;
        this.context =context;
    }

    @NonNull
    @Override
    public ProfCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new ProfCardAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(children.get(i));

    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.profcardlayout;
    }


    @Override
    public int getItemCount() {
        return children.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
            TextView mName;
        TextView mDesignation;
        ImageView imageView;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName=itemView.findViewById(R.id.name);
            mDesignation= itemView.findViewById(R.id.designation_text);
            imageView = itemView.findViewById(R.id.imgcar);
//            imageView.setImageResource(R.drawable.users);


        }

        void bindData(AcademicActivityModel child){
            mName.setText(child.getName());
            String data=child.getDetails();
            String designation;
            String imageurl;
            if(data.indexOf('=',data.lastIndexOf("Designation")+2)!=-1)
            {
                designation=data.substring(data.indexOf('=',data.lastIndexOf("Designation"))+1,data.indexOf(",",data.lastIndexOf("Designation")));
            }
            else
            {
                designation=data.substring(data.indexOf('=',data.lastIndexOf("Designation"))+1,data.indexOf('}'));
            }
            mDesignation.setText(designation);
            if(data.indexOf('=',data.lastIndexOf("Image")+2)!=-1)
            {
                imageurl=data.substring(data.indexOf('=',data.lastIndexOf("Image"))+1,data.indexOf(",",data.lastIndexOf("Image")));
            }
            else
            {
                imageurl=data.substring(data.indexOf('=',data.lastIndexOf("Image"))+1,data.indexOf('}'));
            }

            Glide.with(context)
                    .load(imageurl)
                    .into(imageView);




        }

    }

}
