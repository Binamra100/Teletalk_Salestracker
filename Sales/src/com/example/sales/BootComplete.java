package com.example.sales;

import java.util.Calendar;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.widget.Toast;

public class BootComplete extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Boot Complete", Toast.LENGTH_LONG).show();
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.SECOND, 10);
		
		Intent i = new Intent(context, Alaram_Receiver.class);
    
		
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent pending = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        //set the alarm for particular time
        alarmManager.setRepeating(AlarmManager.RTC,cal.getTimeInMillis(), pending);
		
	}

}
