package com.example.sales;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Alaram_Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Started after some time", Toast.LENGTH_LONG).show();

		Intent service = new Intent(context, Network.class);
		context.startService(service);
	}

}
