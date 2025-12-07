package com.progiii.weatherviewer;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Weather {

    public final String dayOfWeek;
    public final String minTemp;
    public final  String maxTemp;
    public final String humidity;
    public final String description;

    public final String icon;

    //constructor
    public Weather(String dateString, double minTemp, double maxTemp,
                   double humidity, String description, String icon){
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(0);

        this.dayOfWeek = convertDateStringToDay(dateString);
        this.minTemp = numberFormat.format(minTemp) + "\u00B0C";
        this.maxTemp = numberFormat.format(maxTemp) + "\u00B0C";
        this.humidity =
                NumberFormat.getPercentInstance().format(humidity / 100.0);
        this.description = description;
        this.icon = icon;
    }

    // conver timestamp to a day's name
    // Converte a string "yyyy-MM-dd" para o dia da semana
    private static String convertDateStringToDay(String dateString){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", new Locale("pt", "BR"));
            return dayFormat.format(date);
        } catch (ParseException e){
            e.printStackTrace();
            return "";
        }
    }
}


