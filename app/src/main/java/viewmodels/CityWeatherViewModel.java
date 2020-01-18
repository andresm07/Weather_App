package viewmodels;

import androidx.lifecycle.MutableLiveData;

import api.RetroFitAdapter;
import models.City;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityWeatherViewModel {

    public MutableLiveData<City> cityMutableLiveData = new MutableLiveData<>();

    public void getCityWeather (String cityName) {
        RetroFitAdapter.getOpenWeatherService().getWeather(cityName, "").enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if(response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {

            }
        });
    }
}
