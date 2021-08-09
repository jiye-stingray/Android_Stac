package com.stingray.scrollviewapp;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    BitmapDrawable bitmap;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = (ImageView) findViewById(R.id.imgView);
        scrollView = (ScrollView) findViewById(R.id.scrView);
        scrollView.setHorizontalScrollBarEnabled(true);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);

        int bitmapWidth =  bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imgView.setImageDrawable(bitmap);
        imgView.getLayoutParams().width = bitmapWidth;
        imgView.getLayoutParams().height = bitmapHeight;
    }

    public void onButton1Clicked(View v){
        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);

        int bitmapWidth =  bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imgView.setImageDrawable(bitmap);
        imgView.getLayoutParams().width = bitmapWidth;
        imgView.getLayoutParams().height = bitmapHeight;
    }
}