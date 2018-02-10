package com.hackhamp.masterblaster.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        endGame();
        replayGame();
    }

    private void endGame (){
        final Button endButton = (Button)findViewById(R.id.Quit);
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        });
    }

    private void replayGame(){
        final Button replayButton = (Button)findViewById(R.id.Replay);
        replayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent x = new Intent(End.this, ColorGame.class);
                startActivity(x);
            }
        });
    }

}
