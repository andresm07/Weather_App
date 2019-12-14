package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {
    private ArrayList<City> cities = new ArrayList<>();
    private OnCityClicked listener;

    public void setListener(OnCityClicked listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.CityViewHolder holder, int position) {
        holder.bind(this.cities.get(position).getName(), this.cities.get(position).getCountryName(), this.cities.get(position).getWeather(), this.listener);
    }

    @Override
    public int getItemCount() {
        int result = 0;
        if(this.cities != null){
            result = this.cities.size();
        }
        return result;
    }

    class CityViewHolder extends RecyclerView.ViewHolder{
        private EditText cityName;
        private EditText countryName;
        private EditText weatherType;
        private ImageButton shareButton;
        private ImageButton likeButton;

        public CityViewHolder(@NonNull final View itemView){
            super(itemView);
            this.cityName = itemView.findViewById(R.id.editTextCity);
            this.countryName = itemView.findViewById(R.id.editTextCountry);
            this.weatherType = itemView.findViewById(R.id.editTextWeather);
            this.shareButton = itemView.findViewById(R.id.imageButtonShare);
            this.likeButton = itemView.findViewById(R.id.imageButtonLike);
        }

        public void bind(final String cityName, final String countryName, final String weather, OnCityClicked onCityClicker){
            this.cityName.setText(cityName);
            this.countryName.setText(countryName);
            this.weatherType.setText(weather);

        }
    }
}
