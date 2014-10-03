package com.primax.emoticonselect;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class EmotionsActivity extends Activity {

	ImageView imageView_smile1;
	ImageView imageView_smile2;
	ImageView imageView_angry1;
	ImageView imageView_angry2;
	ImageView imageView_selected;
	ImageView imageView_smile1_dot;
	ImageView imageView_smile2_dot;
	ImageView imageView_angry1_dot;
	ImageView imageView_angry2_dot;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emotions);
		
		imageView_smile1 = (ImageView) findViewById(R.id.imageView_smile1);
		imageView_smile2 = (ImageView) findViewById(R.id.imageView_smile2);
		imageView_angry1 = (ImageView) findViewById(R.id.imageView_angry1);
		imageView_angry2 = (ImageView) findViewById(R.id.imageView_angry2);
		imageView_selected = (ImageView) findViewById(R.id.imageView_selected);
		imageView_smile1_dot = (ImageView) findViewById(R.id.imageView_smile1_dot);
		imageView_smile2_dot = (ImageView) findViewById(R.id.imageView_smile2_dot);
		imageView_angry1_dot = (ImageView) findViewById(R.id.imageView_angry1_dot);
		imageView_angry2_dot = (ImageView) findViewById(R.id.imageView_angry2_dot);
		
		showSelectedImage(MainActivity.selectedImageIndex);

		int width = 300;
		int height = 300;
		RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(width,height);
		parms.leftMargin = 800;
		parms.topMargin = 100;
		imageView_selected.setLayoutParams(parms);
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
		
		if (event.getKeyCode() == KeyEvent.KEYCODE_MEDIA_NEXT ||
			event.getKeyCode() == KeyEvent.KEYCODE_DPAD_RIGHT) {
			Log.e("gray", "match KEYCODE_MEDIA_NEXT, selectedImageIndex:" + MainActivity.selectedImageIndex);
			MainActivity.selectedImageIndex++;
			showSelectedImage(MainActivity.selectedImageIndex);
		}
		
		if (event.getKeyCode() == KeyEvent.KEYCODE_MEDIA_PREVIOUS || 
			event.getKeyCode() == KeyEvent.KEYCODE_DPAD_LEFT) {
			Log.e("gray", "match KEYCODE_MEDIA_NEXT, selectedImageIndex:" + MainActivity.selectedImageIndex);
			MainActivity.selectedImageIndex--;
			showSelectedImage(MainActivity.selectedImageIndex);
			
		}
		
		if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER ||
			event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		
//		return false;
		return true;
	}
	
	public void showSelectedImage(int index){
		switch (index % 4) {
		case 0:
			imageView_selected.setImageResource(R.drawable.ic_smile1);
			imageView_smile1_dot.setImageResource(R.drawable.ic_circle_green);
			imageView_smile2_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_angry1_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_angry2_dot.setImageResource(R.drawable.ic_circle_black);
			break;
		case 1:
			imageView_selected.setImageResource(R.drawable.ic_smile2);
			imageView_smile1_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_smile2_dot.setImageResource(R.drawable.ic_circle_green);
			imageView_angry1_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_angry2_dot.setImageResource(R.drawable.ic_circle_black);
			break;
		case 2:
			imageView_selected.setImageResource(R.drawable.ic_angry1);
			imageView_smile1_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_smile2_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_angry1_dot.setImageResource(R.drawable.ic_circle_green);
			imageView_angry2_dot.setImageResource(R.drawable.ic_circle_black);
			break;
		case 3:
			imageView_selected.setImageResource(R.drawable.ic_angry2);
			imageView_smile1_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_smile2_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_angry1_dot.setImageResource(R.drawable.ic_circle_black);
			imageView_angry2_dot.setImageResource(R.drawable.ic_circle_green);
			break;
		default:
			break;
		}
	}
	
}
