package com.stingray.framelayoutex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    int imgIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img1 = (ImageView) findViewById(R.id.imgView1);
        img2 = (ImageView) findViewById(R.id.imgView2);
    }

    public void onButtonClicked(View v){
        changeImg();
    }

    private void changeImg(){
        if (imgIndex == 0){
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility((View.INVISIBLE));

            imgIndex = 1;
        }
        else if (imgIndex == 1){
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility((View.VISIBLE));

            imgIndex = 0;
        }
    }
}