package com.xiaoding.firstdemo.utils;

import android.annotation.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import com.xiaoding.firstdemo.*;

@SuppressLint("InflateParams")
public class ToastUtil
{
	private static Toast mToast;
	private static TextView toast_tv;
	
	public static final void show(final Context context,final String s){
		if(mToast != null){
			mToast.cancel();
			mToast = null;
		}
		
		mToast = Toast.makeText(context,s,Toast.LENGTH_LONG);
		View view = LayoutInflater.from(context).inflate(R.layout.toast_bg,null);
		toast_tv = (TextView)view.findViewById(R.id.tv_message);
		mToast.setView(view);
		toast_tv.setText(s);
		mToast.show();
	}
	
	public static final void showCenter(final Context context,final String s){
		if(mToast != null){
			mToast.cancel();
			mToast = null;
		}

		mToast = Toast.makeText(context,s,Toast.LENGTH_LONG);
		View view = LayoutInflater.from(context).inflate(R.layout.toast_bg,null);
		toast_tv = (TextView)view.findViewById(R.id.tv_message);
		mToast.setView(view);
		toast_tv.setText(s);
		mToast.setGravity(Gravity.CENTER,0,0);
		mToast.show();
	}
}
