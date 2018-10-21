package com.example.hasantarek.materialdesign_8;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hasan Tarek on 9/26/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerviewHolder> {

    String []country_names,capital_name;

    public RecyclerAdapter(String[] country_names, String[] capital_name) {
        this.country_names = country_names;
        this.capital_name = capital_name;
    }

    @Override
    public RecyclerviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_layout,parent,false);
        RecyclerviewHolder recyclerviewHolder = new RecyclerviewHolder(view);
        return recyclerviewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerviewHolder holder, int position) {

        holder.country.setText(country_names[position]);
        holder.capital.setText(capital_name[position]);

    }

    @Override
    public int getItemCount() {
        return country_names.length;
    }

    public static class RecyclerviewHolder extends RecyclerView.ViewHolder
    {

        TextView country,capital;
        public RecyclerviewHolder(View itemView) {
            super(itemView);
            country = (TextView)itemView.findViewById(R.id.country_id);
            capital = (TextView)itemView.findViewById(R.id.capital_id);
        }
    }
}