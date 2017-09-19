package com.example.robert.dice;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //make a new fragment
        FragmentStart startFrag = new FragmentStart();
        //make a transaction to replace existing fragment
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //put fragment into the container in activity_main.xml
        ft.replace(R.id.main_frame_layout,startFrag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }

}
