package com.hackhamp.masterblaster.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class ColorGame extends AppCompatActivity {

    TextView word;
    Integer num = 0;
    Random r = new Random();
    Integer scorecount = 0;
    Integer wnum = 0;
    Integer seconds = 20000;
    Integer timercheck = 0;
    TextView timerText;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_game);
        playMusic();
        setupMessageButton();
    }

    private void playMusic(){
        player = MediaPlayer.create(ColorGame.this,R.raw.luckystar);
        player.start();
    }

    private void nextActivity (){
        player.stop();
        Intent x = new Intent(ColorGame.this, End.class);
                startActivity(x);

    }

    private void startTimer(){
        timerText = (TextView)findViewById(R.id.Timer);
                CountDownTimer timer = new CountDownTimer(seconds, 1000) {
                    @Override
                    public void onTick(long millis) {
                        timerText.setText("Seconds left: " + millis/1000);
                    }

                    @Override
                    public void onFinish() {
                        timerText.setText("Finished");
                        nextActivity();
                    }
                }.start();
    }

    private void setupMessageButton(){
        changeColor();
        changeWord();
        final TextView Scoreboard = (TextView)findViewById(R.id.Score);

        final Button button1 = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);
        final Button button3 = (Button)findViewById(R.id.button3);

        // red
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timercheck == 0) {
                    startTimer();
                    timercheck = 1;
                }
                if(wnum == 0){
                    scorecount++;
                    Scoreboard.setText("Score: " + scorecount);
                }
                else {
                    scorecount--;
                    Scoreboard.setText("Score: " + scorecount);
                }

                changeColor();
                changeWord();
            }
        });
        // green
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timercheck == 0) {
                    startTimer();
                    timercheck = 1;
                }
                if(wnum == 2){
                    scorecount++;
                    Scoreboard.setText("Score: " + scorecount);
                }
                else {
                    scorecount--;
                    Scoreboard.setText("Score: " + scorecount);
                }

                changeColor();
                changeWord();
            }
        });
        // blue
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timercheck == 0) {
                    startTimer();
                    timercheck = 1;
                }
                if(wnum == 1){
                    scorecount++;
                    Scoreboard.setText("Score: " + scorecount);
                }
                else {
                    scorecount--;
                    Scoreboard.setText("Score: " + scorecount);
                }

                changeColor();
                changeWord();
            }
        });
    }

    private void changeColor(){
        word = (TextView)(findViewById(R.id.Trippy));
        num = r.nextInt(3);
        if (num == 0){
            // red
            word.setTextColor(Color.parseColor("#FF0000"));
            wnum = num;
        }
        else if (num == 1){
            // blue
            word.setTextColor(Color.parseColor("#0000FF"));
            wnum = num;
        }
        else if (num == 2)
            // green
            word.setTextColor(Color.parseColor("#008000"));
            wnum = num;
    }

    private void changeWord(){
        word = (TextView)(findViewById(R.id.Trippy));
        num = r.nextInt(3);
        if (num == 0){
            word.setText("Green");
        }
        else if (num == 1){
            word.setText("Red");
        }
        else if (num == 2)
            word.setText("Blue");
    }
}


