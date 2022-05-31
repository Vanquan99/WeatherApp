package com.vanquan.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {


    private Context context;
    private ArrayList<WeatherModel> weatherModelArrayList;

    public WeatherAdapter(Context context, ArrayList<WeatherModel> weatherModelArrayList) {
        this.context = context;
        this.weatherModelArrayList = weatherModelArrayList;
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.weather_rv_item,parent,false);

        return new ViewHolder(view);
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {

        WeatherModel model = weatherModelArrayList.get(position);
        holder.temperature.setText(model.getTemperator()+"C");

        Picasso.get().load("http".concat(model.getIcon())).into(holder.condition);

        holder.wind.setText(model.getWindSpeed()+"km/h");

        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");
        try {
            Date t = input.parse(model.getTime());
            holder.time.setText(output.format(t));
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return weatherModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView wind,temperature,time;
        private ImageView condition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            wind = itemView.findViewById(R.id.idTVWindspeed);
            temperature = itemView.findViewById(R.id.idTVTemperature);
            time = itemView.findViewById(R.id.idTVTime);
            condition = itemView.findViewById(R.id.idTVCondition);
        }
    }
}