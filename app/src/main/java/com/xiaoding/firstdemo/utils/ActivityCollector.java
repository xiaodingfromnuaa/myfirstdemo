package com.xiaoding.firstdemo.utils;

import java.util.*;
import android.app.*;

public class ActivityCollector
{
	public static List<Activity> activities = new ArrayList<Activity>();
	
	public static void addActivity(Activity activity){
		if(!activities.contains(activity)){
			activities.add(activity);
		}
	}
	
	public static void removeActivity(Activity activity){
		activities.remove(activity);
	}
	
	public static void finishAll(){
		for(Activity activity : activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
}
