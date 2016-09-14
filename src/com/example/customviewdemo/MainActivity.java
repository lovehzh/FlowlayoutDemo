package com.example.customviewdemo;

import java.util.ArrayList;
import java.util.List;

import com.neuwill.jiatianxia.entity.QuickViewEntity;
import com.neuwill.jiatianxia.utils.ScreenUtils;
import com.neuwill.jiatianxia.view.extendlayout.FlowLayout;
import com.neuwill.jiatianxia.view.extendlayout.SingleItem;
import com.neuwill.jiatianxia.view.extendlayout.SingleItemTwo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class MainActivity extends Activity implements OnClickListener, OnTouchListener, OnLongClickListener{
	private List<QuickViewEntity> listdata = new ArrayList<QuickViewEntity>();
	private FlowLayout flowlayout;
	private ScrollView scrollView;
	/** 边距 */
	private int margin = 10;
	/*
	 * 用于记录所有View的坐标的二位数组 points[0][0]用于记录左上角的X points[0][1]用于记录左上角的Y
	 * points[0][2]用于记录右下角的X points[0][3]用于记录右下角的Y
	 */
	private int[][] points;
	private int singleWidth, singleHeight;
	private int doubleWidth, doubleHeight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initData();
		initComponent();
	}
	
	private void initData() {
		QuickViewEntity entity = new QuickViewEntity();
		entity.setDev_name("aaa");
		entity.setIcon_size(1);
		listdata.add(entity);
		
		QuickViewEntity entity10 = new QuickViewEntity();
		entity10.setDev_name("aaa");
		entity10.setIcon_size(1);
		listdata.add(entity10);
		
		QuickViewEntity entity11 = new QuickViewEntity();
		entity11.setDev_name("aaa");
		entity11.setIcon_size(1);
		listdata.add(entity11);
		
		QuickViewEntity entity5 = new QuickViewEntity();
		entity5.setDev_name("ccc");
		entity5.setIcon_size(2);
		listdata.add(entity5);
		
		QuickViewEntity entity12 = new QuickViewEntity();
		entity12.setDev_name("aaa");
		entity12.setIcon_size(1);
		listdata.add(entity12);
		
		QuickViewEntity entity2 = new QuickViewEntity();
		entity2.setDev_name("bbb");
		entity2.setIcon_size(2);
		listdata.add(entity2);
		
		
		
		QuickViewEntity entity4 = new QuickViewEntity();
		entity4.setDev_name("ddd");
		entity4.setIcon_size(1);
		listdata.add(entity4);
		
		QuickViewEntity entity6 = new QuickViewEntity();
		entity6.setDev_name("eee");
		entity6.setIcon_size(1);
		listdata.add(entity6);
		
		QuickViewEntity entity3 = new QuickViewEntity();
		entity3.setDev_name("ccc");
		entity3.setIcon_size(2);
		listdata.add(entity3);
	}
	
	private void initComponent() {
		flowlayout = (FlowLayout) findViewById(R.id.flowlayout_device);
		flowlayout.setLineSpacing(ScreenUtils.px2dip(this, (int) (1 * margin)));
		int width = (int) (getWindowManager().getDefaultDisplay().getWidth());
		int height = (int) (getWindowManager().getDefaultDisplay().getHeight());

		Log.d("xx", "width:" + width);
		
		margin = (int) (width * 0.02);
		singleWidth = (width - 7 * margin) / 4;
		singleHeight = singleWidth;
		doubleWidth = 2 * singleWidth + 1 * margin;
		doubleHeight = singleHeight;
		flowlayout.setPadding(margin, 0, margin, 0);
		
		Log.d("xx", "margin:" + margin);
		
		initAutoView();
	}
	
	/**
	 * 加载自定义控件
	 */
	private void initAutoView() {
		ViewGroup.MarginLayoutParams lp;
		for(int i=0; i<listdata.size(); i++) {
			QuickViewEntity bean = listdata.get(i);
			if(bean.getIcon_size() == 1) {
				lp = new ViewGroup.MarginLayoutParams(singleWidth, singleHeight);
				lp.setMargins(margin, margin, 0, 0);
				SingleItem view = new SingleItem(this, singleWidth, singleHeight);
				view.setTag(i);
				view.setTextViewText(listdata.get(i).getDev_name());
				
				view.setOnClickListener(this);
				view.setOnTouchListener(this);
				view.setOnLongClickListener(this);
				
				flowlayout.addView(view,lp);
			}else {
				lp = new ViewGroup.MarginLayoutParams(doubleWidth, doubleHeight);
				lp.setMargins(margin, margin, 0, 0);
				SingleItemTwo view = new SingleItemTwo(this, doubleWidth, doubleHeight);
				view.setTag(i);
				view.setTextViewText(listdata.get(i).getDev_name());
				
				view.setOnClickListener(this);
				view.setOnTouchListener(this);
				view.setOnLongClickListener(this);
				
				flowlayout.addView(view, lp);
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}


}
