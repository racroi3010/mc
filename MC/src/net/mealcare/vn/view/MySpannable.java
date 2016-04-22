package net.mealcare.vn.view;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class MySpannable extends ClickableSpan {
	private boolean isUnderLine = true;
	
	public MySpannable(boolean isUnderLine) {
		this.isUnderLine = isUnderLine;
	}
	

	@Override
	public void updateDrawState(TextPaint ds) {
		ds.setUnderlineText(isUnderLine);
		ds.setColor(Color.BLUE);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
