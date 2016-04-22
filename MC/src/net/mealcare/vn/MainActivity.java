package net.mealcare.vn;

import net.mealcare.vn.view.MySpannable;
import android.content.Intent;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
	@Override
	protected int onGetContentViewResource() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}

	@Override
	protected void onInit() {
		
		TextView txtPost1 = (TextView) findViewById(R.id.txt_post_1);
		TextView txtPost2 = (TextView) findViewById(R.id.txt_post_2);
		
		addViewMoreText(txtPost1, "Xem Thêm");
		addViewMoreText(txtPost2, "Xem Thêm");
		
		
		
	}	
	private void addViewMoreText(final TextView txtView, final String expandText){
		ViewTreeObserver vto = txtView.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				ViewTreeObserver obs = txtView.getViewTreeObserver();
				obs.removeGlobalOnLayoutListener(this);
				int lineEndIndex = txtView.getLayout().getLineEnd(txtView.getLayout().getLineCount() - 1);
				String text = txtView.getText().subSequence(0, lineEndIndex) + " " + expandText;
				txtView.setText(text);
				txtView.setMovementMethod(LinkMovementMethod.getInstance());
				txtView.setText(addClickablePart(Html.fromHtml(txtView.getText().toString()), txtView, expandText), BufferType.SPANNABLE);
			}
		});
	}
	private SpannableStringBuilder addClickablePart(final Spanned strSpanned, final TextView txtView, final String spanableText) {
		String str = strSpanned.toString();
		SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);
		if(str.contains(spanableText)){
			int index = str.indexOf(spanableText);
			ssb.setSpan(new MySpannable(false) {
				
				@Override
				public void onClick(View widget) {
					Intent intent = new Intent(mContext, PostActivity.class);
					startActivity(intent);
				}
			}, index, index + spanableText.length(), 0);
		}
		
		return ssb;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_map:
			Intent intent = new Intent(mContext, MapActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
	
}
