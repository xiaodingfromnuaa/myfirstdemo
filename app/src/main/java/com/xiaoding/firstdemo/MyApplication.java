package com.xiaoding.firstdemo;

import android.app.*;
import android.content.*;

public class MyApplication extends Application
{
	private static Context context;

	@Override
	public void onCreate()
	{
		context = getApplicationContext();
	}
	
	public static Context getContext(){
		return context;
	}
}
