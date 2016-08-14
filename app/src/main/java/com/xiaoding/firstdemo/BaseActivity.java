package com.xiaoding.firstdemo;

import android.app.*;
import android.os.*;
import android.util.*;
import android.support.v7.app.*;


public class BaseActivity extends AppCompatActivity
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
