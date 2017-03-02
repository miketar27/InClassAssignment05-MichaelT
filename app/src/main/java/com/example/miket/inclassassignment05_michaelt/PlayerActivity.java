package com.example.miket.inclassassignment05_michaelt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    private String displayMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        getSupportActionBar().setTitle("Player Roster");

        Intent intent = getIntent();
        ArrayList<Player> players = (ArrayList<Player>) intent.getSerializableExtra("Player List");

        for (int i = 0; players.size() > i; i++) {
            String s = players.get(i).toString();
            displayMessage = displayMessage + s + "\n\n";
        }

        TextView rosterView = (TextView) findViewById(R.id.roster_textbox);
        rosterView.setText("Roster Information:" + "\n\n" + displayMessage);
    }
}
