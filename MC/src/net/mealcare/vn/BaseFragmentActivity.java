package net.mealcare.vn;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

public abstract class BaseFragmentActivity extends FragmentActivity {
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
}
