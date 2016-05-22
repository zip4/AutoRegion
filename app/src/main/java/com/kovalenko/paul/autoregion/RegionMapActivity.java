package com.kovalenko.paul.autoregion;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RegionMapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_map);

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        TextView tv = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        int regionMap = intent.getIntExtra("regionMap", 0);
        String regionName = intent.getStringExtra("regionName");

        if (regionMap == R.drawable.kyiv){
            ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            iv.setLayoutParams(layoutParams);
        }

        if (iv != null) {
            iv.setImageResource(regionMap);
        }
        if (tv != null) {
            tv.setText(regionName);
        }

    }
}
