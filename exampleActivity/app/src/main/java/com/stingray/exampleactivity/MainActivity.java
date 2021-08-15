package com.stingray.exampleactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent);
                /*startActivityForResult(intent, REQUEST_CODE_MENU);*/


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MENU)
        {
            Toast.makeText(getApplicationContext(),"Call result activity" +
                    requestCode + "result code: "+ resultCode, Toast.LENGTH_LONG).show();
        }
        if(resultCode == RESULT_OK)
        {
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "response name: "+
                    name, Toast.LENGTH_SHORT).show();
        }
    }
}