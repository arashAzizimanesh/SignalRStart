# SignalRStart
Easier use for sending notifications with signalR

# dependencies


allprojects 
{

		repositories {
		
		
			maven { url "https://jitpack.io" }
			
		}
		
	}
	
	dependencies {
	        implementation 'com.github.arashAzizimanesh:SignalRStart:1.0.0'
	}
	
	
	
# use
	
add a permission in manifest


	  <uses-permission android:name="android.permission.INTERNET" />
		
		


Then create a service that inherits signalRService



       public class MyService extends SignalRService {
       @Override
    public void onMessageRecive(JsonElement json) {

        Log.d("json", "onMessageRecive: "+json);

     }
    }
    
    




Then create an object from the SignalRstart in Activity and give it its full service path

  SignalRStart signalRStart = new SignalRStart(this);
        signalRStart.start("your url server","ir.appmoon.signalrexample.service.MyService");
        
        
        
