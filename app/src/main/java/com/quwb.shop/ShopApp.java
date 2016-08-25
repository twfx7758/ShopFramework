package com.quwb.shop;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.telephony.TelephonyManager;

import com.BeeFramework.BeeFrameworkApp;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by quwb on 2016/8/25.
 */
public class ShopApp extends BeeFrameworkApp {

    public static DisplayImageOptions options; // DisplayImageOptions是用于设置图片显示的类
    public static DisplayImageOptions options_head; // DisplayImageOptions是用于设置图片显示的类
    public static DisplayImageOptions options_home;
    @Override
    public void onCreate() {
        super.onCreate();

        String device_id = ShopApp.getDeviceId(getApplicationContext());
        SharedPreferences shared;
        SharedPreferences.Editor editor;

        shared = this.getSharedPreferences(MobileAppConst.USERINFO, 0);
        editor = shared.edit();
        editor.putString(Config.DEVICE_UUID, device_id);
        editor.commit();

        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.default_image) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.default_image) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.default_image) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
                // .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .bitmapConfig(Bitmap.Config.RGB_565).build();

        options_head = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.e8_profile_no_avatar)			// 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.e8_profile_no_avatar)	// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.e8_profile_no_avatar)		// 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)						            // 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)							            // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(30))	            // 设置成圆角图片
                .build();

        options_home = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.home_icon_bg)			// 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.home_icon_bg)	// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.home_icon_bg)		// 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)						// 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)							// 设置下载的图片是否缓存在SD卡中
                .build();

        //LocationManager locationManager = new LocationManager(this);
        //locationManager.refreshLocation();

    }

    public int getCacheUserId() {
        SharedPreferences shared;
        SharedPreferences.Editor editor;

        shared = this.getSharedPreferences(MobileAppConst.USERINFO, 0);
        editor = shared.edit();
        int userId = shared.getInt("uid", 0);
        return userId;
    }

    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(TELEPHONY_SERVICE);
        String deviceId = tm.getDeviceId();
        return deviceId;
    }

}