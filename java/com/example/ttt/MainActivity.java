package com.example.ttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonStartGame;
    private Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartGame = findViewById(R.id.button_newGame);
        buttonStartGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        buttonExit = findViewById(R.id.button_exit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    public void openSettings(){
        Intent settingsIntent = new Intent(this, settings.class);
        startActivity(settingsIntent);
    }
    public void exit(){
        finish();
    }
}
