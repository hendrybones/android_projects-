package com.example.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter{
    private ArrayList<City> cities;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView name;
        public final TextView description;
        public final ImageView image;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
            image = view.findViewById(R.id.image);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        City city=cities.get(position);

        holder.name.setText(city.getName());
        holder.description.setText(city.getName());
        Picasso.get().load(city.getImageURL()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        if(cities !=null){
            return cities.size();
        }else {

        }
        return 0;
    }
    public CityAdapter(ArrayList<City> cities) {
        this.cities = cities;
    }
}
