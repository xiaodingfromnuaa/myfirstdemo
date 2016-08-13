package com.xiaoding.firstdemo;

import android.app.*;
import android.os.*;
import android.util.*;


public class BaseActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d("BaseActivity",getClass().getSimpleName());
		ActivityCollector.addActivity(this);
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
	
}
