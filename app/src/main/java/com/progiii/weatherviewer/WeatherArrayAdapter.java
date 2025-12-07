package com.progiii.weatherviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class WeatherArrayAdapter extends ArrayAdapter<Weather> {

    private Context context;

    public WeatherArrayAdapter(Context context, List<Weather> weatherList) {
        super(context, -1, weatherList);
        this.context = context;
    }
    private static class ViewHolder{
        TextView conditionTextView;
        TextView dayTextView;
        TextView lowTextView;
        TextView hiTextView;
        TextView humidityTextView;
        TextView descriptionTextView;
    }

    /*private Map<String, Bitmap> bitmaps = new HashMap<>();*/

    /*public WeatherArrayAdapter(Context context, List<Weather> forecast){
        super(context, -1, forecast);
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.conditionTextView = convertView.findViewById(R.id.conditionTextView);
            viewHolder.dayTextView = convertView.findViewById(R.id.dayTextView);
            viewHolder.descriptionTextView = convertView.findViewById(R.id.descriptionTextView);
            viewHolder.lowTextView = convertView.findViewById(R.id.lowTextView);
            viewHolder.hiTextView = convertView.findViewById(R.id.hiTextView);
            viewHolder.humidityTextView = convertView.findViewById(R.id.humidityTextView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Obter o Weather correspondente
        Weather day = getItem(position);

        if (day != null) {
            // Exibir emoji do JSON
            viewHolder.conditionTextView.setText(day.icon);

            // Exibir o dia da semana
            viewHolder.dayTextView.setText(day.dayOfWeek);

            viewHolder.descriptionTextView.setText(day.description);

            // Preencher temperaturas e umidade
            viewHolder.lowTextView.setText(day.minTemp);
            viewHolder.hiTextView.setText(day.maxTemp);
            viewHolder.humidityTextView.setText(day.humidity);
        }

        return convertView;
    }
}
