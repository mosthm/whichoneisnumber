package com.testme.whichoneisnumber;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameFragment extends Fragment {
    private final int GAME_lEVEL_COUNT=10;
    private final int Left_Button=0,Right_Button=1,Equal_Button=2;

    private Button leftNumber;
    private Button rightNumber;
    private Button equal;
    private TextView point;
    private TextView level;
    private TextView retime;

    private int gLevel=0;
    private int pointNum=0;
    private int leftNum;
    private int rightNum;
    private boolean gameIntProgress = false;
    private CountDownTimer countdowntim;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findviews(view);
        countdowntim = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                retime.setText(getString(R.string.game_time,(int)(millisUntilFinished/1000)));
            }

            @Override
            public void onFinish() {
                retime.setText("Game Finish");
            }
        };
        countdowntim.start();
        gameIntProgress=true;
        configureViews();
        generateNum();
    }

    @Override
    public void onPause() {
        super.onPause();
        countdowntim.cancel();
    }

    private void configureViews(){
        //point.setText(getString(R.string.user_points,0));

        leftNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Left_Button);
            }
        });
        rightNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Right_Button);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateAndContinuGame(Equal_Button);
            }
        });
    }
    private  void evaluateAndContinuGame(int whichPress){
        if(gameIntProgress==false){
            return;
        }else {
            evalute(whichPress);
            point.setText(getString(R.string.user_points,pointNum));
            generateNum();
        }
    }
    private void evalute(int flag){

        if(gLevel==GAME_lEVEL_COUNT){
            return;
        }else {
            if(flag==Left_Button){
                if(leftNum>rightNum){
                    pointNum++;
                }
            }else if(flag==Right_Button){
                if(leftNum<rightNum){
                    pointNum++;
                }
            }else if (flag==Equal_Button){
                if(leftNum==rightNum){
                    pointNum++;
                }
            }
        }

    }
    private  void  findviews(View view){
        // point.setText(getString(R.string.user_points,0));
        leftNumber = (Button) view.findViewById(R.id.left_Number);
        rightNumber =(Button) view.findViewById(R.id.right_Number);
        equal =(Button) view.findViewById(R.id.equal);
        point =(TextView) view.findViewById(R.id.tex_point);
        level =(TextView) view.findViewById(R.id.tex_Level);
        retime =(TextView) view.findViewById(R.id.tex_Time);
    }
    private int intgenerateInt(){
        Random random =new Random();
        int number = random.nextInt();
        if (number<0){
            number = number * -1;
        }
        number = number % 30;
        return number;
    }
    private void generateNum(){

        if(gameIntProgress==false){
            level.setText("Game Finish");
            return;
        }else {
            if(gLevel==GAME_lEVEL_COUNT){
                return;
            }
            else {
                gLevel ++;
                //level.setText(String.valueOf(gLevel));
                level.setText(getString(R.string.game_level,gLevel,GAME_lEVEL_COUNT));
            }
        }
        leftNum=intgenerateInt();
        rightNum=intgenerateInt();
        leftNumber.setText(String.valueOf(leftNum));
        rightNumber.setText(String.valueOf(rightNum));

    }
}
