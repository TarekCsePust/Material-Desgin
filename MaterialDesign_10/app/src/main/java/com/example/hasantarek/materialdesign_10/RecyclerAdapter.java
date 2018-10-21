package com.example.hasantarek.materialdesign_10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hasan Tarek on 9/27/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<Moviedataprovider> arrayList = new ArrayList<Moviedataprovider>();
    Context context;
    public RecyclerAdapter(ArrayList<Moviedataprovider> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        RecyclerViewHolder  recyclerViewHolder = new RecyclerViewHolder(view,this.context,this.arrayList);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Moviedataprovider moviedataprovider = arrayList.get(position);
        holder.imageView.setImageResource(moviedataprovider.getImage());
        holder.movie.setText(moviedataprovider.getMovie_name());
        holder.actor.setText(moviedataprovider.getActor());
        holder.email.setText(moviedataprovider.getEmail());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imageView;
        TextView movie,actor,email;
        ArrayList <Moviedataprovider>List = new ArrayList<Moviedataprovider>();
        Context ctx;
        public RecyclerViewHolder(View itemView,Context ctx,ArrayList<Moviedataprovider> arrayList) {
            super(itemView);
            this.List = arrayList;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            imageView = (ImageView)itemView.findViewById(R.id.image_id);
            movie = (TextView)itemView.findViewById(R.id.name_id);
            actor = (TextView)itemView.findViewById(R.id.actor_id);
            email = (TextView)itemView.findViewById(R.id.email_id);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            Moviedataprovider moviedataprovider = this.List.get(position);
            Intent intent = new Intent(ctx,Moviedetails.class);
            intent.putExtra("image",moviedataprovider.getImage());
            intent.putExtra("mov_name",moviedataprovider.getMovie_name());
            intent.putExtra("actor_name",moviedataprovider.getActor());
            intent.putExtra("email_add",moviedataprovider.getEmail());
            this.ctx.startActivity(intent);

        }
    }
}