package com.quwb.shop.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.quwb.shop.R;

/**
 * Created by quwb on 2016/8/25.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        final View startView = View.inflate(this, R.layout.activity_main, null);
        setContentView(startView);
    }
}
