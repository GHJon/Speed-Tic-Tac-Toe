package com.example.ttt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class settings extends AppCompatActivity implements View.OnClickListener{
    private Button startGame;
    private Button browse;

    private RadioGroup fonts;
    private RadioGroup color;

    private EditText et1;
    private EditText et2;
    private String st1;
    private String st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        color = findViewById(R.id.radiogroup1);

        fonts = findViewById(R.id.radiogroup2);

        startGame = findViewById(R.id.button_startGame);
        et1 = findViewById(R.id.editText_setPlayer1Name);
        et2 = findViewById(R.id.editText_setPlayer2Name);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBoard();

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    public void startBoard(){
        int radioIDFonts = fonts.getCheckedRadioButtonId();
        int radioIDColor = color.getCheckedRadioButtonId();

        Intent boardIntent = new Intent(settings.this, Board.class);

        st1 = et1.getText().toString();
        st2 = et2.getText().toString();
        boardIntent.putExtra("Value1", st1);
        boardIntent.putExtra("Value2", st2);

        boardIntent.putExtra("Value 3", radioIDFonts);
        boardIntent.putExtra("Value 4", radioIDColor);

        startActivity(boardIntent);
        finish();
    }
}
