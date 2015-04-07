package com.example.sales;



import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.widget.Toast;

public class Network extends Service {

	private BroadcastReceiver receiver = new BroadcastReceiver() {    

        @Override
        public void onReceive(Context context, Intent intent) {

        	int status = NetworkUtil.getConnectivityStatusString(context);
        	 
            if (status==1){
            	Toast.makeText(context, "Internet chaliracha bhane assume garum.", Toast.LENGTH_LONG).show();
            	Intent service = new Intent(context, Internet.class);
        		context.startService(service);
            }
            
        }    
    };
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		final IntentFilter rece = new IntentFilter();
		{
			rece.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
			rece.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		}
		
		
		
		registerReceiver(receiver, rece);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unregisterReceiver(receiver);
	}
}
