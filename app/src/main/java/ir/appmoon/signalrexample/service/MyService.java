package ir.appmoon.signalrexample.service;


import android.util.Log;

import com.google.gson.JsonElement;

import ir.appmoon.signalrstart.service.SignalRService;

public class MyService extends SignalRService {


    @Override
    public void onMessageRecive(JsonElement json) {

        Log.d("jhjhjhhj", "onMessageRecive: "+json);

    }
}
