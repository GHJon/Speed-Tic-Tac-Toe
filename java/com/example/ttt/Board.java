package com.example.ttt;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Board extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button [3][3];
    private boolean player1Turn = true;
    private int roundCounts = 0;
    private int pointsP1 = 0;
    private int pointsP2 = 0;
    private TextView player1Points;
    private TextView player2Points;
    private TextView textViewPlayer1;
    private String st1;
    private TextView textViewPlayer2;
    private String st2;
    private TextView roundText;
    private int newRound = 1;
    private Button buttonReset;
    private int fontChoice;
    private int colorChoice;
    private TextView countdownTextP1;
    private TextView countdownTextP2;
    private CountDownTimer countDownTimerP1;
    private CountDownTimer countDownTimerP2;
    private long timeLeftInMillisecondsP1 = 5000; // 5 sec
    private long timeLeftInMillisecondsP2 = 5000; // 5 sec
    private boolean timeRunningP1;
    private boolean timeRunningP2;
    private int millisecondsP1;
    private int millisecondsP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        fontChoice = getIntent().getExtras().getInt("Value 3");
        if(fontChoice == 2131165299){
            Typeface font = Typeface.createFromAsset(getAssets(), "sans.ttf");
            ((TextView)findViewById(R.id.textViewScore1)).setTypeface(font);
            ((TextView)findViewById(R.id.textViewScore2)).setTypeface(font);
            ((TextView)findViewById(R.id.textView_player1)).setTypeface(font);
            ((TextView)findViewById(R.id.textView2_player2)).setTypeface(font);
            ((TextView)findViewById(R.id.textView_round)).setTypeface(font);
            ((TextView)findViewById(R.id.textView3_p1_Timer)).setTypeface(font);
            ((TextView)findViewById(R.id.textView4_p2_timer)).setTypeface(font);
            ((TextView)findViewById(R.id.buttonReset)).setTypeface(font);
        }
        else if (fontChoice == 2131165294){
            Typeface font = Typeface.createFromAsset(getAssets(), "serif.ttf");
            ((TextView)findViewById(R.id.textViewScore1)).setTypeface(font);
            ((TextView)findViewById(R.id.textViewScore2)).setTypeface(font);
            ((TextView)findViewById(R.id.textView_player1)).setTypeface(font);
            ((TextView)findViewById(R.id.textView2_player2)).setTypeface(font);
            ((TextView)findViewById(R.id.textView_round)).setTypeface(font);
            ((TextView)findViewById(R.id.textView3_p1_Timer)).setTypeface(font);
            ((TextView)findViewById(R.id.textView4_p2_timer)).setTypeface(font);
            ((TextView)findViewById(R.id.buttonReset)).setTypeface(font);
        }
        else{
            Typeface font = Typeface.createFromAsset(getAssets(), "monospace.ttf");
            ((TextView)findViewById(R.id.textViewScore1)).setTypeface(font);
            ((TextView)findViewById(R.id.textViewScore2)).setTypeface(font);
            ((TextView)findViewById(R.id.textView_player1)).setTypeface(font);
            ((TextView)findViewById(R.id.textView2_player2)).setTypeface(font);
            ((TextView)findViewById(R.id.textView_round)).setTypeface(font);
            ((TextView)findViewById(R.id.textView3_p1_Timer)).setTypeface(font);
            ((TextView)findViewById(R.id.textView4_p2_timer)).setTypeface(font);
            ((TextView)findViewById(R.id.buttonReset)).setTypeface(font);
        }
        colorChoice = getIntent().getExtras().getInt("Value 4");
        if(colorChoice == 2131165300){ //Red
            ((TextView)findViewById(R.id.textViewScore1)).setTextColor(Color.RED);
            ((TextView)findViewById(R.id.textViewScore2)).setTextColor(Color.RED);
            ((TextView)findViewById(R.id.textView_player1)).setTextColor(Color.RED);
            ((TextView)findViewById(R.id.textView2_player2)).setTextColor(Color.RED);
            ((TextView)findViewById(R.id.textView_round)).setTextColor(Color.RED);
            ((TextView)findViewById(R.id.textView3_p1_Timer)).setTextColor(Color.RED);
            ((TextView)findViewById(R.id.textView4_p2_timer)).setTextColor(Color.RED);
            ((TextView)findViewById(R.id.buttonReset)).setTextColor(Color.RED);
        }
        else if (colorChoice == 2131165295){ //Green
            ((TextView)findViewById(R.id.textViewScore1)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.textViewScore2)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.textView_player1)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.textView2_player2)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.textView_round)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.textView3_p1_Timer)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.textView4_p2_timer)).setTextColor(Color.GREEN);
            ((TextView)findViewById(R.id.buttonReset)).setTextColor(Color.GREEN);
        }
        else if (colorChoice == 2131165296){ //Blue
            ((TextView)findViewById(R.id.textViewScore1)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textViewScore2)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textView_player1)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textView2_player2)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textView_round)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textView3_p1_Timer)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.textView4_p2_timer)).setTextColor(Color.BLUE);
            ((TextView)findViewById(R.id.buttonReset)).setTextColor(Color.BLUE);
        }
        else{ //Black
            ((TextView)findViewById(R.id.textViewScore1)).setTextColor(Color.BLACK);
            ((TextView)findViewById(R.id.textViewScore2)).setTextColor(Color.BLACK);
            ((TextView)findViewById(R.id.textView_player1)).setTextColor(Color.BLACK);
            ((TextView)findViewById(R.id.textView2_player2)).setTextColor(Color.BLACK);
            ((TextView)findViewById(R.id.textView_round)).setTextColor(Color.BLACK);
            ((TextView)findViewById(R.id.textView3_p1_Timer)).setTextColor(Color.BLACK);
            ((TextView)findViewById(R.id.textView4_p2_timer)).setTextColor(Color.BLACK);
            ((TextView)findViewById(R.id.buttonReset)).setTextColor(Color.BLACK);
        }

        textViewPlayer1 = findViewById(R.id.textView_player1);
        st1 = getIntent().getExtras().getString("Value1");
        textViewPlayer1.setText(st1);
        textViewPlayer2 = findViewById(R.id.textView2_player2);
        st2 = getIntent().getExtras().getString("Value2");
        textViewPlayer2.setText(st2);
        roundText = findViewById(R.id.textView_round);

        player1Points = findViewById(R.id.textViewScore1);
        player2Points = findViewById(R.id.textViewScore2);

        countdownTextP1 = findViewById(R.id.textView3_p1_Timer);
        countdownTextP2 = findViewById(R.id.textView4_p2_timer);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(!((Button)v).getText().toString().equals("")){ //If button has a x or o
            return; //Don't do anything
        }
        if(player1Turn){
            ((Button)v).setText("X");
            startStop2();

        }
        else{
            ((Button)v).setText("O");
            startStop1();
        }
        roundCounts++;
        if(checkForWin()){
            if(player1Turn || (((Integer.toString(millisecondsP1).charAt(0) == '0') && (Integer.toString(millisecondsP1).charAt(1)) == '0'))){
                player1Wins();
            }
            else{
                player2Wins();
            }
        }
        else if(roundCounts == 9){
            draw();
        }
        else{
            player1Turn = !player1Turn;
        }
    }
    private boolean checkForWin(){
        String[][] field = new String[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for(int i = 0; i < 3; i++){
            if(field[i][0].equals(field[i][1]) //Comparing 3 field next to each other
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")){ //Ensure that there aren't 3 empty fields
                return true;
            }
        }
        for(int i = 0; i < 3; i++){
            if(field[0][i].equals(field[1][i]) //Comparing 3 field next to each other
                    && field[0][i].equals(field[2][i])
                    && !field[i][0].equals("")){ //Ensure that there aren't 3 empty fields
                return true;
            }
        }
        if(field[0][0].equals(field[1][1]) //Comparing 3 field next to each other
                && field[0][0].equals(field[2][2])
                && !(field[0][0].equals(""))){ //Ensure that there aren't 3 empty fields
            return true;
        }
        if(field[0][2].equals(field[1][1]) //Comparing 3 field next to each other
                && field[0][2].equals(field[2][0])
                && !(field[0][2].equals(""))){ //Ensure that there aren't 3 empty fields
            return true;
        }
        return false;
    }
    private void player1Wins(){
        pointsP1++;
        player1Points.setText(String.valueOf(pointsP1));
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updateRound();
        resetBoard();
    }
    private void player2Wins(){
        pointsP2++;
        player1Points.setText(String.valueOf(pointsP2));
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updateRound();
        resetBoard();
    }
    private void draw(){
        Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        resetBoard();
        updateRound();
    }

    private void updateRound(){
        roundText.setText("Round " + newRound++);

    }
    private void resetBoard(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttons[i][j].setText("");
            }
        }
        roundCounts = 0;
        player1Turn = true;
        timeLeftInMillisecondsP1 = 5000;
        timeLeftInMillisecondsP2 = 5000;
        updateTimer1();
        updateTimer2();
    }
    private void resetGame(){
        player1Points.setText("0");
        player2Points.setText("0");
        newRound = 1;
        updateRound();
        resetBoard();
    }
    public void startStop1(){
        if(timeRunningP1){
            stopTimer1();
        }
        else{
            startTimer1();
        }
    }
    public void startStop2(){
        if(timeRunningP2){
            stopTimer2();
        }
        else{
            startTimer2();
        }
    }
    public void startTimer1(){
        countDownTimerP1 = new CountDownTimer(timeLeftInMillisecondsP1, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisecondsP1 = millisUntilFinished;
                updateTimer1();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timeRunningP1 = true;
    }
    public void startTimer2(){
        countDownTimerP2 = new CountDownTimer(timeLeftInMillisecondsP2, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillisecondsP2 = millisUntilFinished;
                updateTimer2();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timeRunningP2 = true;
    }
    public void stopTimer1(){
        countDownTimerP1.cancel();
        timeRunningP1 = false;
    }
    public void stopTimer2(){
        countDownTimerP2.cancel();
        timeRunningP2 = false;
    }
    public void updateTimer1(){
        millisecondsP1 = (int) timeLeftInMillisecondsP1 %6000 / 100;

        String timeLeftTextP1;
        timeLeftTextP1 = Integer.toString(millisecondsP1).charAt(0)
        + "." + Integer.toString(millisecondsP1).charAt(1);

        countdownTextP1.setText(timeLeftTextP1);
    }
    public void updateTimer2(){
        millisecondsP2 = (int) timeLeftInMillisecondsP2 %6000 / 100;

        String timeLeftTextP2;
        timeLeftTextP2 = Integer.toString(millisecondsP2).charAt(0)
                + "." + Integer.toString(millisecondsP2).charAt(1);

        countdownTextP2.setText(timeLeftTextP2);
    }
}