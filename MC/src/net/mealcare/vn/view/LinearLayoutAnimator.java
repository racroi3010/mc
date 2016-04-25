package net.mealcare.vn.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.LinearLayout;

public class LinearLayoutAnimator extends LinearLayout {
	public LinearLayoutAnimator(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	private Animation inAnimation;
	private Animation outAnimation;
	
	
	public void setInAnimation(Animation inAnimation) {
		this.inAnimation = inAnimation;
	}
	public void setOutAnimation(Animation outAnimation) {
		this.outAnimation = outAnimation;
	}
	@Override
	public void setVisibility(int visibility) {
		if(getVisibility() != visibility){
			if(VISIBLE == visibility){
				if(null != inAnimation) startAnimation(inAnimation);
			} else {
				if(null != outAnimation) startAnimation(outAnimation);
			}
		}
		super.setVisibility(visibility);
	}

	
}
