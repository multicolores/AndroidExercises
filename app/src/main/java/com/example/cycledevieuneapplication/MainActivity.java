package com.example.cycledevieuneapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private String prenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LyfeCycle", "onCreate");
        editText = (EditText) findViewById(R.id.EditTextPrenom);
        button = (Button) findViewById((R.id.ButtonEnvoyer));

    }

    public void envoyer(View v){
        prenom = editText.getText().toString();
        Toast.makeText(MainActivity.this, "hello" + prenom + " !", Toast.LENGTH_SHORT).show();
        ((TextView) findViewById(R.id.TextViewHello)).setText("hello"+prenom);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LyfeCycle", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LyfeCycle", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LyfeCycle", "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LyfeCycle", "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LyfeCycle", "onDestroy");
    }
}
