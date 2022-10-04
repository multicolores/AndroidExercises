package com.example.cycledevieuneapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class userinfo extends AppCompatActivity {
    ListView l;
    public static final String EXTRA_MESSAGE = "com.example.muscuApp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        User user = new User("Mark", "24");

        TextView nameView = findViewById(R.id.userName);
        nameView.setText(user.getName());
        //Todo mettre date du dernier entrainement
        TextView ageView = findViewById(R.id.userAge);
        ageView.setText(user.getAge());

        createGetExercies();

    }

    public void createGetExercies(){
        ArrayList exercisesList = new ArrayList();
        Exercises dips = new Exercises("1","Dips","la description", "pecs, triceps", "8 8 8 7, 9 8 7 7, 9 9 8 7");
        Exercises dvlpCouche = new Exercises("2","Développer couchée","la description", "pecs, triceps, épaules", "8 8 8 7, 9 8 7 7, 9 9 8 7");
        Exercises squat = new Exercises("3","Squat","la description", "quadriceps, ecshio, grand fessier");

        exercisesList.add(dips.getName());
        exercisesList.add(dvlpCouche.getName());
        exercisesList.add(squat.getName());

        l = (ListView) findViewById(R.id.listExercises);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                exercisesList );

        l.setAdapter(arrayAdapter);


        Intent intentExercisesInfo = new Intent(this, ExerciseInfo.class);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                //textView.setText("The best football player is : " + selectedItem);
                Log.d("clicked", selectedItem);   // output :   clicked: A propos des Vélib

                runActivityExoInfo(selectedItem);
            }
        });

    }

    public void runActivityExoInfo(String exerciseName){
        Intent intent = new Intent(this, ExerciseInfo.class);
        intent.putExtra(EXTRA_MESSAGE, exerciseName);
        startActivity(intent);
    }
}
