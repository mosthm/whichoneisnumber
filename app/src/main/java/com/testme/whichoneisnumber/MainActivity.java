package com.testme.whichoneisnumber;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameFragment gameFragement = new GameFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frag_container,gameFragement)
                .commit();


    }

}
