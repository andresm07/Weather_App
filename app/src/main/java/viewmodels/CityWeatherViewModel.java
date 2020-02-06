package viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import api.RetroFitAdapter;
import models.City;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityWeatherViewModel extends AndroidViewModel {

    public MutableLiveData<City> cityMutableLiveData = new MutableLiveData<>();

    public CityWeatherViewModel (Application application) {
        super(application);
    }

    public void getCityWeather (String cityName) {
        RetroFitAdapter.getOpenWeatherService().getWeather(cityName, "209aad063772d0d0ebde7864ea49921d").enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if(response.isSuccessful()) {
                    cityMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {

            }
        });
    }
}
