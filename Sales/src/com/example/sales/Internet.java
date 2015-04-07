package com.example.sales;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



import android.app.ProgressDialog;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Internet extends Service {
	HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    List<NameValuePair> nameValuePairs;
    ProgressDialog dialog = null;
    TextView status;
    Button b;
    String imei, model;
    int a=0;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
				Toast.makeText(Internet.this,"Sending to server...", Toast.LENGTH_SHORT).show();
				new Thread(new Runnable() {
				    public void run() {
				    	send();					      
				    }
				  }).start();	
                   
       	}
	public void send(){
		imei = "011756104";
		model="S89";
		// Create a new HttpClient and Post Header
		HttpClient httpclient = new DefaultHttpClient();
		//URI website = new URI("http://localhost/connect.php");
		//HttpGet request = new HttpGet();
		a =1;
		
		//HttpPost httppost = new HttpPost("http://10.0.2.2/insert.php");
		HttpPost httppost = new HttpPost("http://192.168.222.1/update1.php");
		//This is the data to send
		
		try {
		// Add your data
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		nameValuePairs.add(new BasicNameValuePair("imei", imei));
		nameValuePairs.add(new BasicNameValuePair("model", model));
		
		
		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		// Execute HTTP Post Request

		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String response = httpclient.execute(httppost, responseHandler);

		//This is the response from a php application
		
		System.out.println("ERRORRRR=="+response);
		//Toast.makeText(this, "response" + reverseString, Toast.LENGTH_LONG).show();
		

		} catch (ClientProtocolException e) {
		//Toast.makeText(this, "CPE response " + e.toString(), Toast.LENGTH_LONG).show();
		// TODO Auto-generated catch block
			
		} catch (IOException e) {
		//Toast.makeText(this, "IOE response " + e.toString(), Toast.LENGTH_LONG).show();
		// TODO Auto-generated catch block
			
		}
	    }	

}

