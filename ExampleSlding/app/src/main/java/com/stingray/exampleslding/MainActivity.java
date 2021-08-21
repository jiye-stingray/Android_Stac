package com.stingray.exampleslding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean isPageOpen = false;

    Animation translateLeftAnim;
    Animation translateRightAnim;

    LinearLayout page2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        page2 = (LinearLayout) findViewById(R.id.page2);
        translateLeftAnim = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this,R.anim.translate_right);

        SlidingRageAnimationListener animListener = new SlidingRageAnimationListener();
        translateLeftAnim.setAnimationListener(animListener);
        translateRightAnim.setAnimationListener(animListener);
    }

    public void onButton1Clicked(View v)
    {
        if (isPageOpen)
        {
            page2.startAnimation(translateRightAnim);
        } else{
            page2.setVisibility(View.VISIBLE);
            page2.startAnimation(translateLeftAnim);
        }
    }


    private class SlidingRageAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (isPageOpen){
                page2.setVisibility(View.INVISIBLE);
                button.setText("Open");
                isPageOpen = false;
            }
            else{
                isPageOpen = true;
                button.setText("Close");
            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}