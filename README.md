# SignalRStart
Use SignalRStart for easier use of signalR

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
