package com.example.robert.dice;

/**
 * Created by Robert on 28/09/2017.
 */

public class ScoreNode {

    int mIndex;
    String mLabel;
    int mScore;
    boolean mScoredYet;

    public ScoreNode() {

    }

    /**
     * 
     * @param index index of node in list
     * @param label name of node.
     * @param score score of node. Starts as 0;
     * @param scoredYet If a score from game has been entered. Starts as false.
     */
    public ScoreNode(int index, String label, int score, boolean scoredYet) {
        mIndex = index;
        mLabel = label;
        mScore = score;
        mScoredYet = scoredYet;
    }

    /**************************************
     * GETTERS
     *************************************/
    public int GetIndex() {
        return mIndex;
    }

    public String GetLabel() {
        return mLabel;
    }

    public int GetScore() {
        return mScore;
    }

    public boolean GetScoredYet() {
        return mScoredYet;
    }
    /**************************************
     * SETTERS
     *************************************/
    public void SetIndex(int index) {
        mIndex = index;
    }

    public void SetLabel(String label) {
        mLabel = label;
    }

    public void SetScore(int score) {
        mScore = score;
    }

    public void SetScoredYet(boolean scoredYet) {
        mScoredYet = scoredYet;
    }
}
