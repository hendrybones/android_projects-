package com.example.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView cities;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        private ArrayList<City> initCities() {
            ArrayList<City> list = new ArrayList<>();

            list.add(new City("Cinque Terre", "The coastline, the five villages in Italy.", "https://bit.ly/CBImageCinque"));
            list.add(new City("Paris", "Paris is the capital city of France", "https://bit.ly/CBImageParis"));
            list.add(new City("Rio de Janeiro", "Rio has been one of Brazil's most popular destinations.", "https://bit.ly/CBImageRio"));
            list.add(new City("Sydney", "Sydney is the state capital of New South Wales.", "https://bit.ly/CBImageSydney"));

            return list;

        }
    }
}
