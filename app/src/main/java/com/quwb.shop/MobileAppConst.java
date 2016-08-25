package com.quwb.shop;

import android.os.Environment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MobileAppConst {
    public static String FILEPATH = Environment.getExternalStorageDirectory() + "/.shop/.cache/";

    public static final String USERINFO = "user_info";
    public static final int VERSION_CODE = 1;
    public static final String SERVICE_TYPE = "service_type";
    public static final String ORDERINFO = "order_info";
    public static final String USERID = "user_id";
    public static final String SERVICE_TYPE_ID = "service_type_id";

    public static String imageName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String time = format.format(date);
        String imageName = "IMG_" + time + ".jpg";
        return imageName;
    }

    public static String videoName() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String time = format.format(date);
        String imageName = "Video_" + time + ".mp4";
        return imageName;
    }
}