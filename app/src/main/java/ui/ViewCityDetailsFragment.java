package ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proyectofinal.R;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import models.City;
import models.Weather;
import viewmodels.CityWeatherViewModel;

public class ViewCityDetailsFragment extends Fragment {

    private TextView cityNameTextView;
    private TextView climateDescriptionTextView;
    private TextView temperatureTextView;

    private ImageButton searchImageButton;
    private ImageButton backImageButton;

    private ImageView mapImageView;
    private ImageView climateIconImageView;

    private TextInputEditText searchTextInputEditText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_citydetails, container, false);

        this.cityNameTextView = view.findViewById(R.id.textViewCityName);
        this.climateDescriptionTextView = view.findViewById(R.id.textViewClimateDescription);
        this.temperatureTextView = view.findViewById(R.id.textViewTemperature);
        this.searchImageButton = view.findViewById(R.id.imageButtonSearch);
        this.backImageButton = view.findViewById(R.id.imageButtonBack);
        this.mapImageView = view.findViewById(R.id.imageViewMap);
        this.climateIconImageView = view.findViewById(R.id.imageViewClimateIcon);
        this.searchTextInputEditText = view.findViewById(R.id.searchTextInputEditText);

        CityWeatherViewModel cityWeatherViewModel = new ViewModelProvider(this).get(CityWeatherViewModel.class);

        this.searchImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchTextInputEditText.getText().toString().isEmpty()) {
                    //TODO: Dialogo error
                    Context context = getContext();
                    CharSequence text = "Insert City Name";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    cityWeatherViewModel.getCityWeather(searchTextInputEditText.getText().toString());
                }
            }
        });

        cityWeatherViewModel.cityMutableLiveData.observe(getViewLifecycleOwner(), new Observer<City>() {
            @Override
            public void onChanged(City city) {
                Weather weather = city.getWeatherList().get(0);
                climateDescriptionTextView.setText(weather.getMain());
                cityNameTextView.setText(city.getName());

                String iconURL = String.format("http://openweathermap.org/img/wn/%s@2x.png", weather.getIcon());
                String mapURL = String.format("https://open.mapquestapi.com/staticmap/v4/getmap?key=vwClG1n2G1TAnBDt01BHkW8EViAk57UJ&size=600,400&zoom=13&center=%s,%s",
                        city.getCoordinate().getLatitude().toString(),
                        city.getCoordinate().getLongitude().toString());

                Picasso.get().load(iconURL).into(climateIconImageView);
                Picasso.get().load(mapURL).into(mapImageView);
            }
        });

        backImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle arguments = new Bundle();
                arguments.putString("key","");
                NavHostFragment.findNavController(ViewCityDetailsFragment.this).navigate(R.id.action_viewCityDetailsFragment_to_loginFragment, arguments, new NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build());
            }
        });

        return view;
    }


}
