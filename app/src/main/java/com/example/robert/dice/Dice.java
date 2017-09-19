package com.example.robert.dice;

import java.util.Random;

/**
 * Created by Robert on 18/09/2017.
 */

public class Dice {
    Random random = new Random();
    int mRolls=0;
    int mFace;

    public Dice () {
        mRolls = 3;
    }

    public int getDiceFace () {
        return mFace;
    }

    public void setDiceFace(int face) {
        mFace = face;
    }

    public int rollDice() {
        mFace = (int)(Math.random()*6+1);
        return mFace;
    }
}
