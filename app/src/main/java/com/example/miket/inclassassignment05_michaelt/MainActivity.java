package com.example.miket.inclassassignment05_michaelt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Player> playerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String key = getString(R.string.saved_username);

        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);

        String username = sharedPref.getString(key, getString(R.string.saved_username_default));

        TextView usernameDisplay = (TextView) findViewById(R.id.username_display);
        usernameDisplay.setText("Welcome, " + username + "!");

    }

    public void changeUsername(View view) {
        EditText editText = (EditText) findViewById(R.id.new_username);
        String newUsername = editText.getText().toString();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.saved_username), newUsername);
        editor.commit();

        editText.setText("");
        TextView usernameDisplay = (TextView) findViewById(R.id.username_display);
        usernameDisplay.setText("Welcome, " + newUsername + "!");
    }


    public void clear_button(View view) {
        EditText playerInputName = (EditText) findViewById(R.id.player_name_edittext);
        EditText playerInputNumber = (EditText) findViewById(R.id.player_number_edittext);
        EditText playerInputNote = (EditText) findViewById(R.id.player_note_edittext);

        playerInputName.setText(null);
        playerInputNumber.setText(null);
        playerInputNote.setText(null);

        Toast t = Toast.makeText(this, "Form Cleared", Toast.LENGTH_SHORT);
        t.show();
    }

    public void savePlayerInfo(View view) {
        EditText playerInputName = (EditText) findViewById(R.id.player_name_edittext);
        String nameInput = playerInputName.getText().toString();

        EditText playerInputNumber = (EditText) findViewById(R.id.player_number_edittext);
        int numberInput = Integer.parseInt(playerInputNumber.getText().toString());

        EditText playerInputNote = (EditText) findViewById(R.id.player_note_edittext);
        String noteInput = playerInputNote.getText().toString();

        Player p = new Player(nameInput, numberInput, noteInput);
        playerList.add(p);

        playerInputName.setText(null);
        playerInputNumber.setText(null);
        playerInputNote.setText(null);

        Toast t = Toast.makeText(this, "Player Information Saved", Toast.LENGTH_SHORT);
        t.show();
    }

    public void seeRoster(View view) {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Player List", playerList);
        startActivity(intent);
    }
}