package com.example.alexander.firstlesson;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lib.CurrentWeatherData;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView temp, ddate, wind, cloudiness, pressure, humidity, sunrise, sunset, coords;
    CurrentWeatherData currentWeatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        currentWeatherData = new CurrentWeatherData(new CurrentWeatherData.Coord(37.62,55.75),
                new CurrentWeatherData.Weather(800,"Clear", "clear sky", "01d"),
                "stations",
                new CurrentWeatherData.Main(9, 1027, 19, 9, 9),
                10000,
                new CurrentWeatherData.Wind(1, 0),
                new CurrentWeatherData.Cloud(0),
                1523539800,
                new CurrentWeatherData.Sys(1, 7325, 0.0018, "RU",1523500278,1523550622),
                524901,"Moscow", 200);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = (TextView) findViewById(R.id.Temp);
        ddate = findViewById(R.id.Date);
        wind = findViewById(R.id.Wind);
        cloudiness = findViewById(R.id.Cloudiness);
        pressure = findViewById(R.id.Pressure);
        humidity = findViewById(R.id.Humidity);
        sunrise = findViewById(R.id.Sunrise);
        sunset = findViewById(R.id.Sunset);
        coords = findViewById(R.id.Coords);
        outPut();
    }

    @SuppressLint("SetTextI18n")
    private void outPut(){
        temp.setText("Температура: " + currentWeatherData.getMain().getTemp());
//        ddate.setText("Дата: " + new Date(currentWeatherData.getDate()).toString());
        ddate.setText("Время: 18:13 Apr 12");
        if (currentWeatherData.getWind().getDeg() == 0) {
            wind.setText("Ветер: " + currentWeatherData.getWind().getSpeed());
        }else wind.setText("Ветер: " + currentWeatherData.getWind().getSpeed() + " Направление: " + currentWeatherData.getWind().getDeg());
        cloudiness.setText("Погода: " + currentWeatherData.getWeather().getDescription());
        pressure.setText("Давление: " + currentWeatherData.getMain().getPressure() + "hpa");
        humidity.setText("Влажность воздуха: " + currentWeatherData.getMain().getHumidity() + "%");
//        sunrise.setText("Восход: " + new Date(currentWeatherData.getSys().getSunrise()).toString());
//        sunset.setText("Закат: " + new Date(currentWeatherData.getSys().getSunset()).toString());
        sunrise.setText("Восход: 05:31");
        sunset.setText("Закат: 19:30");
        coords.setText("Координаты: [" + currentWeatherData.getCoord().getLon() + "," + currentWeatherData.getCoord().getLat() + "]");
    }
}
