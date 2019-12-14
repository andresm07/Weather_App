package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder>{
    private ArrayList<City> cities = new ArrayList<>();
    private OnCityClicked listener;

    public void setListener(OnCityClicked listener){
        this.listener = listener;
    }

    public void setCityList (ArrayList<City> cities) {
        this.cities = cities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_list_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityAdapter.CityViewHolder holder, int position) {
        holder.bind(this.cities.get(position), this.listener);
    }

    @Override
    public int getItemCount() {
        int result = 0;
        if(this.cities != null && this.cities.size() > 0){
            result = this.cities.size();
        }
        return result;
    }

    class CityViewHolder extends RecyclerView.ViewHolder{
        private TextView cityName;
        private TextView countryName;
        private TextView weatherType;
        private ImageButton shareButton;
        private ImageButton likeButton;

        public CityViewHolder(@NonNull final View itemView){
            super(itemView);
            this.cityName = itemView.findViewById(R.id.textViewCityName);
            this.countryName = itemView.findViewById(R.id.textViewCountryName);
            this.weatherType = itemView.findViewById(R.id.textViewWeather);
            //this.shareButton = itemView.findViewById(R.id.imageButtonShare);
            //this.likeButton = itemView.findViewById(R.id.imageButtonLike);
        }

        public void bind(City city, OnCityClicked onCityClicker){
            this.cityName.setText(city.getName());
            this.countryName.setText(city.getCountryName());
            this.weatherType.setText(city.getWeather());
        }
    }
}
