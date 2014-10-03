package com.primax.emoticonselect;




import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ImageView imageView_x;
	
	public static int selectedImageIndex;
	
	int existCount;
	
	private static final ScheduledExecutorService worker = 
			  Executors.newSingleThreadScheduledExecutor();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		selectedImageIndex = 30000;
		existCount = 0;
		
		imageView_x = (ImageView) findViewById(R.id.imageView_x);;
		int width = 300;
		int height = 300;
		RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(width,height);
		parms.leftMargin = 800;
		parms.topMargin = 300;
		imageView_x.setLayoutParams(parms);
    	
		final Button button_back = (Button) findViewById(R.id.button_back);
		button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	existCount++;
            	if (existCount == 1) {
            		Toast.makeText(v.getContext(), "more one time to exit", Toast.LENGTH_SHORT).show();
				}
            	
				Runnable task = new Runnable() {
					public void run() {
						existCount = 0;
					}
				};
				worker.schedule(task, 1, TimeUnit.SECONDS);
            	  
            	if (existCount >= 2) {
            		finish();
				}
            	
            }
        });
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		Log.e("gray", "onKeyDown, " + event.toString());
		if (event.getScanCode() == 0) {
			return true;
		}

//		return false;
 		return true;
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {

		Log.e("gray", "onKeyUp, " + event.toString() );
		
//		if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_MUTE) {
		if (event.getScanCode() == 192) {
			Intent intent = new Intent(); 
        	intent.setClass(MainActivity.this, EmotionsActivity.class); 
        	startActivityForResult(intent, 0);
		}
		
//		return false;
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		Log.e("gray", "MainActivity.java: onActivityResult, requestCode: " + requestCode);
		Log.e("gray", "MainActivity.java: onActivityResult, resultCode: " + resultCode);
		
		if (resultCode == 0) {
			
			switch (selectedImageIndex % 4) {
			case 0:
				imageView_x.setImageResource(R.drawable.ic_smile1);
				break;
			case 1:
				imageView_x.setImageResource(R.drawable.ic_smile2);
				break;
			case 2:
				imageView_x.setImageResource(R.drawable.ic_angry1);
				break;
			case 3:
				imageView_x.setImageResource(R.drawable.ic_angry2);
				break;
			default:
				break;
			}
		}
	}
	
}
