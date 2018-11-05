package com.example.jurir.minuapp;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayListFragment();
    }

    public void displayListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frame, new MainFragment());

        fragmentTransaction.commit();
    }

    public void displayDetailsFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //LÜHIKE
       // fragmentTransaction.replace (isInTablet() ? R.id.frame2 : R.id.frame, fragment); // asendame, kui on tahvel (frame 2 ei ole null, funktsioonis isInTablet, siis paneme frame2-te else juhul frame-sse.

        //PIKK
        if (isInTablet()) {fragmentTransaction.replace(R.id.frame2, fragment);}
        else fragmentTransaction.replace(R.id.frame, fragment);



        fragmentTransaction.commit();
    }

    private boolean isInTablet() {
        //pikk variant
//        boolean hasSecondFrame = false;
//        if (findViewById(R.id.frame2) != null) {hasSecondFrame = true;}
//        return hasSecondFrame;

        //Sama asi lühidalt
        return findViewById(R.id.frame2) != null;





    }

}
