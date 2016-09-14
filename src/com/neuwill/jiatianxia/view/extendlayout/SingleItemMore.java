package com.neuwill.jiatianxia.view.extendlayout;


import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.customviewdemo.R;

public class SingleItemMore extends RelativeLayout implements OnClickListener {
	private ImageView image;
	private Context context;
	private MoreOnClickListner listner;
	public SingleItemMore(Context context) {
		super(context);
		this.context=context;
		this.setBackgroundResource(R.color.singleitem_bg_0);
		LayoutParams params=new LayoutParams(200, 200);
		this.setLayoutParams(params);
		this.setOnClickListener(this);
		image=new ImageView(context);
		image.setBackgroundResource(R.drawable.more);
		RelativeLayout.LayoutParams lpImage=new RelativeLayout.LayoutParams(100, 100);
		lpImage.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		this.addView(image,lpImage);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
//		Log.d("print","SingleItemMore");
//		Intent intent=new Intent(context,ThrSelectActivity.class);
//		context.startActivity(intent);
	}
	
	
	interface MoreOnClickListner{
		void moreOnclickListner();
	}

}
