package com.stingray.exampleservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.inputName);
        Button btn = (Button) findViewById(R.id.btnServise);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(),MyService.class);
                intent.putExtra("command", "show");
                intent.putExtra("name",name);
                startService(intent);
            }
        });
        Intent passedIntent = getIntent();
        processedIntent(passedIntent);

    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        processedIntent(intent);

        super.onNewIntent(intent);
    }

    private void processedIntent(Intent intent)
    {
        if (intent != null){
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");
            Toast.makeText(this, "command" + command + " ,name : " + name, Toast.LENGTH_LONG).show();
        }
    }
}