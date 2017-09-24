package com.example.robert.dice;

import java.util.Random;

/**
 * Created by Robert on 18/09/2017.
 */

public class Dice {
    Random random = new Random();
    int mFace;
    boolean mCanRoll = true;

    public Dice () {
        mCanRoll = true;
        mFace = 0;
    }

    public int getDiceFace () {
        return mFace;
    }

    public void setDiceFace(int face) {
        mFace = face;
    }

    public boolean getCanRoll() {
        return mCanRoll;
    }

    public void setCanRoll(boolean canRoll) {
        mCanRoll = canRoll;
    }

    public int rollDice() {
        mFace = (int)(Math.random()*6+1);
        return mFace;
    }
}
