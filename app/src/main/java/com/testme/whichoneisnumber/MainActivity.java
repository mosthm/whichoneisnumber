package com.testme.whichoneisnumber;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startGame;
    Button showBestScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        configure();



    }
    private void findViews(){
        startGame=(Button) findViewById((R.id.start_game));
        showBestScore=(Button) findViewById((R.id.best_score));
    }
    private void configure(){
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameFragment gameFragement = new GameFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frag_container,gameFragement)
                        .addToBackStack(null)
                        .commit();
            }
        });
        showBestScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BestScoreFragment bestScoreFragment = new BestScoreFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frag_container,bestScoreFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
