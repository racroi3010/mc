package net.mealcare.vn;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public abstract class BaseActivity extends Activity {
	protected abstract int onGetContentViewResource();
	protected abstract void onInit();
	
	protected final int AUTO_HIDE_DELAY_MILLIS = 3000;
	
	protected Context mContext = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(onGetContentViewResource());
		mContext = this;
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		onInit();
	}

	public void onClick(View v){
		
	}
	
}
