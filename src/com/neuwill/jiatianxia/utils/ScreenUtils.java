package com.neuwill.jiatianxia.utils;

import android.app.Activity;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;

public class ScreenUtils {
	private static TypedValue mTmpValue = new TypedValue();

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, int dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(Context context, int pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * 将px值转换为sp值，保证文字大小不变
	 * 
	 * @param pxValue
	 * @param fontScale
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int px2sp(Context context, float pxValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (pxValue / fontScale + 0.5f);
	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 * 
	 * @param spValue
	 * @param fontScale
	 *            （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int sp2px(Context context, float spValue) {
		final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}
	
	/**
	 * 根据资源id获取控件在xml文件中定义的尺寸值(dip,sp,...)
	 * @param context
	 * @param id
	 * @return
	 */
	public static int getXmlDef(Context context, int id) {
		synchronized (mTmpValue) {
			TypedValue value = mTmpValue;
			context.getResources().getValue(id, value, true);
			return (int) TypedValue.complexToFloat(value.data);
		}
	}
	
	/**
	 * 等比例缩放宽高
	 * @param srcWidth 原始宽度
	 * @param srcHeight 原始高度
	 * @param targetMeasure 目标尺寸
	 * @param measure 尺寸类型，0:表示宽度；1:表示高度
	 * @return 缩放后的宽高值
	 */
	public static int[] adjustEqualityConstrain(int srcWidth,int srcHeight,int targetMeasure,int measure){
		int w = 0,h = 0;
		switch(measure){
		case 0:
			w = targetMeasure;
			h = w*srcHeight/srcWidth;
			break;
		case 1:
			h = targetMeasure;
			w = h*srcWidth/srcHeight;
			break;
		}
		return new int[]{w,h};
	}
	
	/**
	 * 获取屏宽
	 * @param activity
	 * @return
	 */
	public static int getScreenWidth(Activity activity) {
		int width = activity.getWindowManager().getDefaultDisplay().getWidth();
		return width;
	}

	/**
	 * 获取屏高
	 * @param activity
	 * @return
	 */
	public static int getScreenHeight(Activity activity) {
		// TODO Auto-generated method stub
		int height = activity.getWindowManager().getDefaultDisplay().getHeight();
		return height;
	}
	
	/**
	 * 获取控件view的坐标位置
	 * @param v
	 * @return
	 */
	public static int[] getLocation(View v) {
	    int[] loc = new int[4];
	    int[] location = new int[2];
	    v.getLocationOnScreen(location);
	    loc[0] = location[0];
	    loc[1] = location[1];
	    int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
	    int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
	    v.measure(w, h);

	    loc[2] = v.getMeasuredWidth();
	    loc[3] = v.getMeasuredHeight();

	    return loc;
	}
}
