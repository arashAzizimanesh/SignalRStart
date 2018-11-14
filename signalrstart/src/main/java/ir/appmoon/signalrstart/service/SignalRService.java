package ir.appmoon.signalrstart.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.google.gson.JsonElement;
import com.smartarmenia.dotnetcoresignalrclientjava.HubConnectionListener;
import com.smartarmenia.dotnetcoresignalrclientjava.HubMessage;
import com.smartarmenia.dotnetcoresignalrclientjava.WebSocketHubConnectionP2;

import ir.appmoon.signalrstart.Signalr.SignalRStart;


public class SignalRService extends Service   {
    private WebSocketHubConnectionP2 connection;
    private String url;
    private SharedPreferences sharedPreferences;
    private int mStartId;
    private String className;

    public WebSocketHubConnectionP2 getConnection() {
        return connection;
    }

    public SignalRService() {

        Log.d("Sdsdsds", "SignalRService: ");
    }


    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        mStartId = startId;

        sharedPreferences = getApplicationContext().getSharedPreferences("SIGNALR", getApplicationContext().MODE_PRIVATE);
        url = sharedPreferences.getString("url", "");
        className = sharedPreferences.getString("className", "");


        Log.d("urlllll", "onStartCommand: " + url);

        if (connection == null) {

            connection = new WebSocketHubConnectionP2(url, "");
            connection.addListener(new HubConnectionListener() {
                @Override
                public void onConnected() {

                }

                @Override
                public void onDisconnected() {

                }

                @Override
                public void onMessage(HubMessage message) {
                    String json = message.getArguments()[0].toString();
//
        if (json.startsWith("{")) {

            onMessageRecive(message.getArguments()[0]);

        }
                }

                @Override
                public void onError(Exception exception) {

                }
            });



            connection.connect();
        }


        return START_REDELIVER_INTENT;


    }

    @Override
    public void onDestroy() {


        connection = null;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SignalRStart signalRStart = new SignalRStart(getBaseContext());
                signalRStart.start(url, className);
                Log.d("sdsdsd", "run: ");
            }
        }, 1000);
        super.onDestroy();
    }

    public void onMessageRecive(JsonElement json) {

        Log.d("dadsds", "onMessageRecive: " + json);
    }


//    @Override
//    public void onConnected() {
//
//    }
//
//    @Override
//    public void onDisconnected() {
//
//    }
//
//    @Override
//    public void onMessage(HubMessage message) {
//
//    }
//
//    @Override
//    public void onError(Exception exception) {
//
//    }
}