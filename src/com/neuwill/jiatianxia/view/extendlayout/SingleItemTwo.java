package com.neuwill.jiatianxia.view.extendlayout;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.customviewdemo.R;
import com.neuwill.jiatianxia.view.autofittextview.AutofitTextView;

public class SingleItemTwo extends Single implements OnClickListener {

	private AutofitTextView text;
	private ImageView leftImage;
	private ImageView rightImage;
	private ImageView image;
	private IconOnclickLitenerTwo litener;
	private LeftImageOnclickLitener leftLitener;
	private RightImageOnclickLitener rightLitener;
	private ImageView selectImage;

	private ImageView deleteImage;

	private DeleteImageOnclickLitenerTwo deleteLitener;

	public SingleItemTwo(Context context, int width, int height) {
		super(context);
		this.setBackgroundResource(R.drawable.bg_selected_white_color);
		LayoutParams params = new LayoutParams(width, height);
		this.setLayoutParams(params);

		this.setOnClickListener(this);
		// //image
		RelativeLayout.LayoutParams lpImage = new RelativeLayout.LayoutParams((int) (width * 0.3),
				(int) (width * 0.25));
		lpImage.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		lpImage.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		lpImage.setMargins(0, 20, 0, 0);
		image = new ImageView(context);
		image.setBackgroundResource(R.drawable.kongtiao);
		this.addView(image, lpImage);
		// leftImage
		RelativeLayout.LayoutParams lpLeftImage = new RelativeLayout.LayoutParams((int) (height * 0.45), (int) (height * 0.45));
		lpLeftImage.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lpLeftImage.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lpLeftImage.setMargins(0, 0, 0, 16);
		leftImage = new ImageView(context);
		leftImage.setBackgroundResource(R.drawable.kongtiaoadd);
		leftImage.setClickable(true);
		leftImage.setOnClickListener(this);
		leftImage.setTag("left");
		this.addView(leftImage, lpLeftImage);
		// rightImage
		RelativeLayout.LayoutParams lpRightImage = new RelativeLayout.LayoutParams((int) (height * 0.45), (int) (height * 0.45));
		lpRightImage.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lpRightImage.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		lpRightImage.setMargins(0, 0, 0, 16);
		rightImage = new ImageView(context);
		rightImage.setBackgroundResource(R.drawable.kongtiaosub);
		rightImage.setClickable(true);
		rightImage.setOnClickListener(this);
		rightImage.setTag("right");
		this.addView(rightImage, lpRightImage);
		// text
		text = new AutofitTextView(context);
		text.setText("离家");
		text.setSingleLine(true);
		text.setMaxLines(1);
		text.setSizeToFit(true);
//		text.setTextSize(TypedValue.COMPLEX_UNIT_PX, 30);
//		text.setMaxTextSize(TypedValue.COMPLEX_UNIT_PX, 30);
		text.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
		text.setMaxTextSize(TypedValue.COMPLEX_UNIT_SP,14);
		text.setMinTextSize(8);
		text.setTextColor(0xffffffff);
		RelativeLayout.LayoutParams lpText = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		lpText.addRule(RelativeLayout.CENTER_HORIZONTAL);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == leftImage) {
			leftLitener.leftImageOnclick(v, this);
		} else if (v == rightImage) {
			rightLitener.rightImageOnclick(v, this);
		} else if (v == deleteImage) {
			deleteLitener.deleteImageOnclick(v, this);
		} else if (v == selectImage) {
			litener.IconOnclick(v);
		}

	}

	public interface IconOnclickLitenerTwo {// item点击
		void IconOnclick(View view);
	}

	public void setIconOnclickLitener(IconOnclickLitenerTwo litener) {
		this.litener = litener;
	}

	public interface LeftImageOnclickLitener {// 左图片点击
		void leftImageOnclick(View view, SingleItemTwo singleItemTwo);
	}

	public void setLeftImageOnclickLitener(LeftImageOnclickLitener litener) {
		this.leftLitener = litener;
	}

	public interface RightImageOnclickLitener {// 右图片点击
		void rightImageOnclick(View view, SingleItemTwo singleItemTwo);
	}

	public void setRightImageOnclickLitener(RightImageOnclickLitener litener) {
		this.rightLitener = litener;
	}

	public void setTextViewText(String string) {
		text.setText(string);
	}

	public void setTextViewColor(int color) {
		text.setTextColor(color);
	}

	public void setIconImage(int iconid) {
		image.setBackgroundResource(iconid);
	}

	public void setLeftImage(int leftid) {
		leftImage.setBackgroundResource(leftid);
	}

	public void setRightIamge(int rightid) {
		rightImage.setBackgroundResource(rightid);
	}

	public void setSlecteIsShow() {// ÉèÖÃÑ¡ÖÐ¡°¹´¡±
		if (selectImage.getVisibility() == View.GONE) {
			selectImage.setVisibility(View.VISIBLE);
		} else {
			selectImage.setVisibility(View.GONE);
		}
	}

	public void showDeleteImage() {// ¡°²æ¡±
		if (deleteImage.getVisibility() == View.GONE) {
			deleteImage.setVisibility(View.VISIBLE);
		} else {
			deleteImage.setVisibility(View.GONE);
		}
	}

	public interface DeleteImageOnclickLitenerTwo {
		void deleteImageOnclick(View view, SingleItemTwo item);
	}

	public void setDeleteImageOnclickLitener(DeleteImageOnclickLitenerTwo litener) {
		this.deleteLitener = litener;
	}

}
