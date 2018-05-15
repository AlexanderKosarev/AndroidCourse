package com.example.alexander.firstlesson;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<CurrentWeatherData> list;
    private static final int[] ids = {511565, 524901, 2643743, 5218069, 3410315, 1850147, 3117735, 2950159, 3067696};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<CurrentWeatherData>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService api = retrofit.create(APIService.class);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        for (int id : ids) {
            api.getWeather(id).enqueue(new Callback<CurrentWeatherData>() {
                @Override
                public void onResponse(Call<CurrentWeatherData> call, Response<CurrentWeatherData> response) {
                    list.add(response.body());
                    recyclerView.getAdapter().notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<CurrentWeatherData> call, Throwable t) {
                    Log.e("retrofit", t.toString());
                }
            });
        }

    }

}
