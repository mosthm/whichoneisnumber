package com.testme.whichoneisnumber;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPrefrenceManger {

    private static MyPrefrenceManger instance =null;
    private SharedPreferences sharedPreferences=null;
    private SharedPreferences.Editor editor=null;
    public static MyPrefrenceManger getInstance(Context context){
        if(instance==null){
            instance=new MyPrefrenceManger();
        }
        return instance;
    }
    private MyPrefrenceManger(Context context){

    }
}
