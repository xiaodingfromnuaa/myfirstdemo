package com.xiaoding.firstdemo.utils;

import android.app.*;
import android.content.*;
import android.net.*;
import android.net.wifi.*;
import android.os.*;
import android.telephony.*;
import android.util.*;
import java.io.*;

public class VersionUtil
{
	
	public static String getPhoneDetail() {
		String phoneInfo = "Product: " + Build.PRODUCT;
		phoneInfo += ", CPU_ABI: " + Build.CPU_ABI;
		phoneInfo += ", TAGS: " + Build.TAGS;
		phoneInfo += ", VERSION_CODES.BASE: " + Build.VERSION_CODES.BASE;
		phoneInfo += ", MODEL: " + Build.MODEL;
		phoneInfo += ", SDK: " + Build.VERSION.SDK_INT;
		phoneInfo += ", SDK_INT: " + Build.VERSION.SDK_INT;
		phoneInfo += ", VERSION.RELEASE: " + Build.VERSION.RELEASE;
		phoneInfo += ", DEVICE: " + Build.DEVICE;
		phoneInfo += ", DISPLAY: " + Build.DISPLAY;
		phoneInfo += ", BRAND: " + Build.BRAND;
		phoneInfo += ", BOARD: " + Build.BOARD;
		phoneInfo += ", FINGERPRINT: " + Build.FINGERPRINT;
		phoneInfo += ", ID: " + Build.ID;
		phoneInfo += ", MANUFACTURER: " + Build.MANUFACTURER;
		phoneInfo += ", USER: " + Build.USER;
		return phoneInfo;
	}
	
	public static String getDisplayMetric(Activity activity) {
		// 获取屏幕分辨率
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		// 分辨率
		return String.valueOf(dm.heightPixels + "*" + dm.widthPixels);
	}

	public static void installLoadedApkFile(Context context, File file) {
		Intent installIntent = new Intent();
		installIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		installIntent.setAction(android.content.Intent.ACTION_VIEW);
		installIntent.setDataAndType(Uri.fromFile(file),
									 "application/vnd.android.package-archive");
		context.startActivity(installIntent);
	}

	public static String getLocalMacAddress(Context c) {
		WifiManager wifi = (WifiManager) c
			.getSystemService(Context.WIFI_SERVICE);
		WifiInfo info = wifi.getConnectionInfo();
		if (info == null || info.getMacAddress() == null) {
			return "";
		}
		return info.getMacAddress();
	}

	/* SIM卡唯一识别码*/
	public static String getIMSI(Context c) {
		TelephonyManager mTelephonyMgr = (TelephonyManager) c
			.getSystemService(Context.TELEPHONY_SERVICE);
		String imsi = mTelephonyMgr.getSubscriberId();
		if (imsi == null) {
			return "";
		}
		return imsi;
	}

	public static String getPhone(Context c) {
		// 创建电话管理
		TelephonyManager tm = (TelephonyManager)
			// 与手机建立连接
			c.getSystemService(Context.TELEPHONY_SERVICE);
		// 获取手机号码
		String phoneId = tm.getLine1Number();
		if (phoneId == null) {
			phoneId = "";
		}
		return phoneId;
	}

	/* 获取IMEI 手机设备唯一码 */
	public static String getIMEI(Context c) {
		TelephonyManager mTelephonyMgr = (TelephonyManager) c
			.getSystemService(Context.TELEPHONY_SERVICE);
		String imei = mTelephonyMgr.getDeviceId();
		if (imei == null) {
			return "";
		}
		return imei;
	}
}
