package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>  {
    private ArrayList<Weather> weatherArrayList = new ArrayList<>();

    @NonNull
    @Override
    public WeatherAdapter.WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        return new WeatherAdapter.WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        int result = 0;
        if(this.weatherArrayList != null){
            result = this.weatherArrayList.size();
        }
        return result;
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder{

        public WeatherViewHolder(@NonNull final View itemView){
            super(itemView);
        }

        public void bind(){
        }
    }
}
