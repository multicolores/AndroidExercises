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
import java.util.List;

public class userinfo extends AppCompatActivity {
    ListView l;
    public static final String EXTRA_MESSAGE = "com.example.muscuApp.MESSAGE";

    private ArrayList exercisesList = new ArrayList();
    private ArrayAdapter<Exercises> listViewAdapter;

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

        // createGetExercies();   Données en local

        //loadFromDBToMemory();
        //createExercises();





        l = (ListView) findViewById(R.id.listExercises);

        SQLiteManager db = new SQLiteManager(this);
        //db.createDefaultExo(); si on veut créer une base de donnée de base

        //List<Exercises> list =  db.getAllExercises();
        List<Exercises> list =  db.getAllExercisesNames();

        this.exercisesList.addAll(list);


        this.listViewAdapter = new ArrayAdapter<Exercises>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, this.exercisesList);

        // Assign adapter to ListView
        this.l.setAdapter(this.listViewAdapter);

        // Register the ListView for Context menu

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                exercisesList );

        l.setAdapter(arrayAdapter);
    }


    private void loadFromDBToMemory() {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.populateExercisesListArray();
    }

    public void createExercises() {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);

        Exercises newExo = new Exercises("1","Dips","Exercise poly-articulaire travaillant principalement les pecs et les triceps.",
                "pecs, triceps", "8 8 8 7, 9 8 7 7", "12-12-2022");

        Exercises.exoArrayList.add(newExo);
        sqLiteManager.addExerciseToDatabase(newExo);

        finish();
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
