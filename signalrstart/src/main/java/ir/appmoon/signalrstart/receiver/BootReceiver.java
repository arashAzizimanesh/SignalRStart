package ir.appmoon.signalrstart.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import ir.appmoon.signalrstart.Signalr.SignalRStart;


public class BootReceiver extends BroadcastReceiver {


    private SharedPreferences sharedPreferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        SignalRStart signalRStart = new SignalRStart(context);

        sharedPreferences = context.getSharedPreferences("SIGNALR", context.MODE_PRIVATE);
        String url = sharedPreferences.getString("url", "");
        String className = sharedPreferences.getString("className", "");
        signalRStart.start(url, className);
    }
}
