package com.example.naoclientandroidbuttonexample;

import android.support.v7.app.ActionBarActivity;
//import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
//import android.os.Build;

import android.widget.Button;
//import android.view.View;
import android.view.View.OnClickListener;
import android.os.Handler;

import java.io.BufferedWriter;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class MainActivity extends ActionBarActivity {
    public Socket echoSocket;
    PrintWriter out;
    Button sit, talk, walk, stand, ipConnect;
    EditText et;
    Handler updateConversationHandler;

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		updateConversationHandler = new Handler();

		

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
		Log.d("Here", "Testing if we get here before crash");
		et = (EditText) findViewById(R.id.ipAddress);
		talk = (Button) findViewById(R.id.talk);
	
		talk.setOnClickListener(new View.OnClickListener() {
        
			@Override
			public void onClick(View arg0) {
				send("talk");
			}
		});
		
       ipConnect = (Button) findViewById(R.id.connect);
		ipConnect.setOnClickListener(new View.OnClickListener() {
        
			@Override
			public void onClick(View arg0) {
				try {
					           new Thread(new ClientThread()).start();
					            String str = "Hunter is cool";
					            out = new PrintWriter(new BufferedWriter(
					                    new OutputStreamWriter(echoSocket.getOutputStream())),
					                    true);					
					            out.println(str);					
					        } catch (UnknownHostException e) {
					
					            e.printStackTrace();
					
					        } catch (IOException e) {
					
					            e.printStackTrace();
					
					        } catch (Exception e) {
				
					            e.printStackTrace();
					
					        }			         
			}   
		});
		
	}
	
	
    public void send(String output)
    {
    	Toast.makeText(getApplicationContext(), "Generic " + output,   Toast.LENGTH_LONG).show();
    	//out.println(output);
    }
    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
    


	class ClientThread implements Runnable {

     @Override

     public void run() {
         try {
        	 EditText et = (EditText) findViewById(R.id.ipAddress);
             String serverAddr = et.getText().toString();
             echoSocket = new Socket(serverAddr, 5009);

         } catch (UnknownHostException e1) {
             e1.printStackTrace();
         } catch (IOException e1) {
             e1.printStackTrace();
         }


     }//end of run


 }//end of client

	    	    
}//end of class
