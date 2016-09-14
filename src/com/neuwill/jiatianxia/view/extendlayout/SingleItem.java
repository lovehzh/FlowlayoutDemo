package com.neuwill.jiatianxia.view.extendlayout;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.customviewdemo.R;
import com.neuwill.jiatianxia.view.autofittextview.AutofitTextView;

public class SingleItem extends Single implements OnClickListener, OnLongClickListener {

	private Context context;

	private ImageView image;

	private AutofitTextView text;

	private ImageView selectImage;

	private ImageView deleteImage;

	private IconOnclickListener listener;// 选中图标监听

	private DeleteImageOnclickListener deleteListener;// 删除图标监听

	private IconLongOnclickListener longListener;//

	public SingleItem(Context context, int width, int height) {
		super(context);
		this.context = context;
		this.setBackgroundResource(R.drawable.bg_selected_white_color);
		LayoutParams params = new LayoutParams(width, height);
		this.setLayoutParams(params);
		this.setOnClickListener(this);
		this.setLongClickable(true);
		this.setOnLongClickListener(this);
		image = new ImageView(context);
		image.setBackgroundResource(R.drawable.beijingyinyue);

		RelativeLayout.LayoutParams lpImage = new RelativeLayout.LayoutParams((int) (width * 0.6),
				(int) (height * 0.5));
		lpImage.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		lpImage.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		lpImage.setMargins(0, 20, 0, 0);

		this.addView(image, lpImage);

		text = new AutofitTextView(context);
		text.setText("离家");
//		text.setTextSize(R.styleable.PercentLayout_Layout_layout_textSizePercent);
		text.setSingleLine(true);
		text.setMaxLines(1);
		text.setSizeToFit(true);
		text.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
		text.setMaxTextSize(TypedValue.COMPLEX_UNIT_SP,14);
		text.setMinTextSize(8);
		text.setTextColor(0xffffffff);
		text.setGravity(Gravity.CENTER);
		
		
		RelativeLayout.LayoutParams lpText = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		lpText.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		lpText.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		lpText.setMargins(0, 0, 0, 16);

		this.addView(text, lpText);

		selectImage = new ImageView(context);
		selectImage.setBackgroundResource(R.drawable.select);
		RelativeLayout.LayoutParams lpSlectImage = new RelativeLayout.LayoutParams(50, 50);
		lpSlectImage.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		lpSlectImage.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		selectImage.setVisibility(View.GONE);
		selectImage.setClickable(true);
		selectImage.setOnClickListener(this);
		this.addView(selectImage, lpSlectImage);

		deleteImage = new ImageView(context);
		deleteImage.setBackgroundResource(R.drawable.select);
		RelativeLayout.LayoutParams lpDeleteImage = new RelativeLayout.LayoutParams(50, 50);
		lpDeleteImage.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		lpDeleteImage.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		deleteImage.setVisibility(View.GONE);
		deleteImage.setClickable(true);
		deleteImage.setOnClickListener(this);
		this.addView(deleteImage, lpDeleteImage);
	}

	public void setTextViewText(String string) {// 设置TextView显示的内容
		text.setText(string);
	}

	public void setImageSrc(int id) {// 设置Image的背景
		image.setBackgroundResource(id);
	}

	public String getTextViewText() {// 获取text的内容
		return text.getText().toString();
	}

	public void setItemBackgroundResource(int resid) {
		this.setBackgroundResource(resid);
	}

	public void setItemBackgroundColor(int color) {
		this.setBackgroundColor(color);
	}

	public void setTextViewColor(int red) {
		// TODO Auto-generated method stub
		text.setTextColor(red);
	}

	@Override
	public void onClick(View v) {
		if (v == deleteImage) {
			if (deleteListener == null) {
				return;
			}
			deleteListener.deleteImageOnclick(v, this);
		} else if (v == selectImage) {
			if (listener == null) {
				return;
			}
			listener.IconOnclick(v);
		}

	}

	public interface IconOnclickListener {
		void IconOnclick(View view);
	}

	public void setIconOnclickListener(IconOnclickListener listener) {
		this.listener = listener;
	}

	public interface DeleteImageOnclickListener {
		void deleteImageOnclick(View view, SingleItem item);
	}

	public void setDeleteImageOnclickLitener(DeleteImageOnclickListener litener) {
		this.deleteListener = litener;
	}

	public interface IconLongOnclickListener {
		void longOnclickListener(View view, SingleItem item);
	}

	public void setIconLongOnclickListener(IconLongOnclickListener listener) {
		this.longListener = listener;
	}

	public void setSlecteIsShow() {// ÉèÖÃÑ¡ÖÐ¡°¹´¡±
		if (selectImage.getVisibility() == View.GONE) {
			selectImage.setVisibility(View.VISIBLE);
		} else {
			selectImage.setVisibility(View.GONE);
		}
	}

	public void showDeleteImage() {
		if (deleteImage.getVisibility() == View.GONE) {
			deleteImage.setVisibility(View.VISIBLE);
		} else {
			deleteImage.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		this.longListener.longOnclickListener(v, this);
		return true;
	}

}
