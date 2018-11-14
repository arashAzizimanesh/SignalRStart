package ir.appmoon.signalrexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ir.appmoon.signalrstart.Signalr.SignalRStart;


public class MainActivity extends AppCompatActivity {

// crete connection with signalR hub

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SignalRStart signalRStart = new SignalRStart(this);
        signalRStart.start("http://176.9.8.58:709/pushNotificationHub","ir.appmoon.signalrexample.service.MyService");




//        final HubConnection connection = new WebSocketHubConnectionP2("http://176.9.8.58:709/pushNotificationHub", "");
//        connection.addListener(this);
//        connection.subscribeToEvent("Register", new HubEventListener() {
//            @Override
//            public void onEventMessage(HubMessage message) {
//
//
//                JsonElement[] arguments = message.getArguments();
//
//
//
//
//                Log.d("onEventMessage", "onEventMessage: " + arguments[0]);
//
//            }
//        });
//        connection.subscribeToEvent("Recive", new HubEventListener() {
//            @Override
//            public void onEventMessage(HubMessage message) {
//                Log.d("Recive", "onEventMessage: "+message.getArguments()[0]);
//            }
//        });
//
//        connection.connect();

    }


//    @Override
//    public void onConnected() {
//
//        Log.d("onConnected", "onConnected: ");
//
//    }
//
//    @Override
//    public void onDisconnected() {
//
//    }
//
//    @Override
//    public void onMessage(final HubMessage message) {
//
//        Log.d("onMessage", "onMessage: "+message.getArguments()[0]);
//        JsonElement[] arguments = message.getArguments();
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.this,""+message.getArguments()[0],Toast.LENGTH_LONG).show();
//            }
//        });
//
//
//    }
//
//    @Override
//    public void onError(Exception exception) {
//
//    }
}
