package com.example.alexander.firstlesson;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RemindViewHolder>{
    private List<CurrentWeatherData> data;
    public MyAdapter(List<CurrentWeatherData> myDataSet){
        this.data = myDataSet;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public MyAdapter.RemindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card, parent, false);
        RemindViewHolder remindViewHolder = new RemindViewHolder(v);
        return remindViewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.RemindViewHolder holder, int position) {
        holder.cityTV.setText(data.get(position).getName());
        if (data.get(position).getMain().getTempMin() > 0)
            holder.tempTV.setText("+"+data.get(position).getMain().getTempMin()+"..+"+data.get(position).getMain().getTempMax());
        else if (data.get(position).getMain().getTempMax()<0)
            holder.tempTV.setText(data.get(position).getMain().getTempMin()+".."+data.get(position).getMain().getTempMax());
        else holder.tempTV.setText(data.get(position).getMain().getTempMin()+"..+"+data.get(position).getMain().getTempMax());
        holder.presTV.setText(holder.presTV.getText()+""+data.get(position).getMain().getPressure()+" hpa");
        holder.windTV.setText(holder.windTV.getText()+""+data.get(position).getWind().getSpeed()+"m/s");
        Picasso.get().load("http://openweathermap.org/img/w/"+data.get(position).getWeather()[0].getIcon()+".png").into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class RemindViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView cityTV, tempTV, presTV, windTV;
        ImageView imageView;

        public RemindViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            cityTV = itemView.findViewById(R.id.city);
            tempTV = itemView.findViewById(R.id.temperature);
            presTV = itemView.findViewById(R.id.pressure);
            windTV = itemView.findViewById(R.id.wind);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}