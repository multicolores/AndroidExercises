package com.example.cycledevieuneapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciseInfo extends AppCompatActivity {
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_info);

        Intent intent = getIntent();
        String exerciseName = intent.getStringExtra(userinfo.EXTRA_MESSAGE);


        getExerciseInfo(exerciseName);


    }

    public void getExerciseInfo(String exerciseName){

        TextView nameView = findViewById(R.id.exerciseName);
        nameView.setText(exerciseName);

        //Todo get exercise info on the db corresponding with the name and put it in the textViews
        Exercises dips = new Exercises("1","Dips","Exercise poly-articulaire travaillant principalement les pecs et les triceps. Posibilité de se lester pour rendre l'éxercise pour difficile", "pecs, triceps", "8 8 8 7, 9 8 7 7, 9 9 8 7, 9 8 7 7, 9 9 8 7, 9 8 7 7, 10 10 8 7");

        TextView descriptionView = findViewById(R.id.exerciseDescription);
        descriptionView.setText(dips.getDescription());

        TextView musclesView = findViewById(R.id.exerciseMuscles);
        musclesView.setText(dips.getMuscles());

        List<String> repsList = new ArrayList<>(Arrays.asList(dips.getLastsWorkoutRepetitions().split(",")));
        l = (ListView) findViewById(R.id.listRepetitions);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                repsList );

        l.setAdapter(arrayAdapter);

    }

}
