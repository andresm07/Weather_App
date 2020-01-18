package api;

import models.City;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherService {

    @GET("weather")
    Call<City> getWeather(@Query("q") String cityName, @Query("appid") String apiKey);
}
