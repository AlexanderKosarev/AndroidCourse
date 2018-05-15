package com.example.alexander.firstlesson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("weather?appid=ae0bc420c80e6fcaa49e417a49eb90f3&units=metric&lang=ru")
    Call<CurrentWeatherData> getWeather(@Query("id") int cityId);
}
