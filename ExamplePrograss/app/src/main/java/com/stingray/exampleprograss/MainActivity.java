package com.stingray.exampleprograss;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setProgress(80);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog = new ProgressDialog(MainActivity.this);
               dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
               dialog.setMessage("데이터를 확인하는 중입니다");
               dialog.show();
            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog != null){
                    dialog.dismiss();
                }

            }
        });

        txtView = (TextView) findViewById(R.id.txtView);
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout seekBalPanel = (LinearLayout) findViewById(R.id.seekBalPanel);
                seekBalPanel.setVisibility(View.VISIBLE);
            }
        });

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setBrightness(i);
                txtView.setText("변경된 값 : "+ i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private  void setBrightness(int value)
    {
        if (value < 10)
        {
            value = 10;
        }
        else if (value > 100)
        {
            value = 100;
        }

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float)value/100;
        getWindow().setAttributes(params);
    }
}