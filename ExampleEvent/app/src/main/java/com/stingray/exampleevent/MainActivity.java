package com.stingray.exampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.txtView);

        View view = findViewById(R.id.view1);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if (action == MotionEvent.ACTION_DOWN)
                {
                    printLn("손가락 눌림: " + curX+ " , " + curY);
                } else if(action == MotionEvent.ACTION_MOVE){
                    printLn("손가락 움직임: " + curX+ " , " + curY);
                } else if (action == MotionEvent.ACTION_UP){
                    printLn("손가락 땜: " + curX+ " , " + curY);
                }
                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                printLn("onDown");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                printLn("onShowPress");

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                printLn("onSingleTapUp");

                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                printLn("onScroll");

                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                printLn("onLongPress");


            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                printLn("onFling");

                return false;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                detector.onTouchEvent(motionEvent);
                return false;
            }
        });

    }
    public void printLn(String data){
        textView.append(data + "\n");
    }

    public  boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "Press BACK key", Toast.LENGTH_LONG).show();
        }
        return false;
    }

}

