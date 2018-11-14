package ir.appmoon.signalrstart.Signalr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;


import ir.appmoon.signalrstart.service.SignalRService;

public class SignalRStart {


    Context context;
    private SharedPreferences sharedPreferences;


    public SignalRStart(Context context) {
        this.context = context;
    }

    public void start(String url, String className) {

        Intent intent = new Intent(context, SignalRService.class);
        sharedPreferences = context.getSharedPreferences("SIGNALR", context.MODE_PRIVATE);
        sharedPreferences.edit().putString("url", url).commit();
        sharedPreferences.edit().putString("className", className).commit();


        try {

            Class<?> act = Class.forName(className);
            Intent serviceStatt = new Intent(context, act);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


                context.startForegroundService(serviceStatt);
            } else {
                context.startService(serviceStatt);
            }


            Log.d("starrrrrrtSrvice", "onEventMessage: ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.d("starrrrrrtSrvice", "catch: " + e);
        }

//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            context.startForegroundService(intent);
//        } else {
//            context.startService(intent);
//        }

    }
}
