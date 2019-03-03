package com.example.apple.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    List<EventModel> eventModels;

    public EventAdapter(List<EventModel> classes)
    {
        this.eventModels =classes;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);

        return new EventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindData(eventModels.get(i));
    }

    @Override
    public int getItemViewType(final int position) {
        return R.layout.event_recy_item;
    }


    @Override
    public int getItemCount() {
        return eventModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView Name;
        TextView Text;
        TextView Club;
        TextView Contact;
        TextView Venue;
        TextView Time;
        int dwars;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.textView3);
            Text=itemView.findViewById(R.id.textView4);
            Club=itemView.findViewById(R.id.textView6);
            Contact=itemView.findViewById(R.id.textView7);
            Venue=itemView.findViewById(R.id.textView8);
            Time=itemView.findViewById(R.id.textView9);
            imageView=itemView.findViewById(R.id.imageView2);


        }

        void bindData(EventModel classT){
            Name.setText(classT.getEventName());
            Text.setText(classT.getEventText());
            Club.setText(classT.getEventClub());
            Contact.setText(classT.getEventContact());
            Venue.setText(classT.getEventVenue());
            Time.setText(classT.getEventTime());
            imageView.setImageResource(dwars);


        }

    }
}
