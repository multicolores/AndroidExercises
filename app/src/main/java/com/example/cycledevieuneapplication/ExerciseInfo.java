package com.example.cycledevieuneapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ExerciseInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_info);

        Intent intent = getIntent();
        String exerciseName = intent.getStringExtra(userinfo.EXTRA_MESSAGE);

        TextView nameView = findViewById(R.id.exerciseName);
        nameView.setText(exerciseName);

        //Todo get exercise info on the db corresponding with the name and put it in the textViews
    }


}
