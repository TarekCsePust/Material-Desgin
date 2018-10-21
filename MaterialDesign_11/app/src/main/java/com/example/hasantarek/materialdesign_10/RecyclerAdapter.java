package com.example.hasantarek.materialdesign_10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 9/27/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<Moviedataprovider> arrayList = new ArrayList<Moviedataprovider>();
    Context context;
    MainActivity mainActivity;
    public RecyclerAdapter(ArrayList<Moviedataprovider> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context = context;
        this.mainActivity =(MainActivity) context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        RecyclerViewHolder  recyclerViewHolder = new RecyclerViewHolder(view,this.mainActivity);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Moviedataprovider moviedataprovider = arrayList.get(position);
        holder.imageView.setImageResource(moviedataprovider.getImage());
        holder.movie.setText(moviedataprovider.getMovie_name());
        holder.actor.setText(moviedataprovider.getActor());
        holder.email.setText(moviedataprovider.getEmail());
        if(!mainActivity.is_action_mode)
        {
            holder.checkBox.setVisibility(View.GONE);
        }
        else
        {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imageView;
        TextView movie,actor,email;
        CardView cardView;
        CheckBox checkBox;
        MainActivity mainActivity;
        public RecyclerViewHolder(View itemView,MainActivity mainActivity) {
            super(itemView);

            cardView = (CardView)itemView.findViewById(R.id.card_id);
            this.mainActivity = mainActivity;
            checkBox = (CheckBox)itemView.findViewById(R.id.check_list_id);
            imageView = (ImageView)itemView.findViewById(R.id.image_id);
            movie = (TextView)itemView.findViewById(R.id.name_id);
            actor = (TextView)itemView.findViewById(R.id.actor_id);
            email = (TextView)itemView.findViewById(R.id.email_id);
            cardView.setOnLongClickListener(mainActivity);
            checkBox.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mainActivity.preparselection(v,getAdapterPosition());
        }
    }

    public void  updateAdapter(ArrayList<Moviedataprovider> list)
    {
        for(Moviedataprovider moviedataprovider : list)
        {
            arrayList.remove(moviedataprovider);
        }
        notifyDataSetChanged();
    }
}