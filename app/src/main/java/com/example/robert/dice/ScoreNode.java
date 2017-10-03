package com.example.robert.dice;

import android.widget.Button;
import android.widget.TextView;

/**
 * This is a node that will the name of the node, its index, its score and whether is has a score
 * added to it by the user.
 * Created by Robert Neville on 28/09/2017.
 */

class ScoreNode {

    private int mIndex;
    private String mLabel;
    private ScoreNode mNext;
    private ScoreNode mPrev;
    private int mScore;
    private boolean mScoredYet;
    private Button mScoreLabel;
    private TextView mScoreText;

    /**
     * Empty constructor
     */
    public ScoreNode() {

    }

    /**
     * Creates a new node. mNext will be null so we dont need it as argument.
     * @param index index of node in list
     * @param label name of node.
     * @param score score of node. Starts as 0;
     * @param scoredYet If a score from game has been entered. Starts as false.
     */
    public ScoreNode(int index, String label, int score, boolean scoredYet) {
        mIndex = index;
        mLabel = label;
        mNext = null;
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

    public ScoreNode GetNext() {
        return mNext;
    }

    public ScoreNode GetPrev() {
        return mPrev;
    }

    public int GetScore() {
        return mScore;
    }

    public boolean GetScoredYet() {
        return mScoredYet;
    }

    public Button GetButtonLabel() {
        return mScoreLabel;
    }

    public TextView GetScoreText() {
        return mScoreText;
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

    public void SetNext(ScoreNode next) {
        mNext=next;
    }

    public void SetPrev(ScoreNode prev) {
        mPrev = prev;
    }

    public void SetScore(int score) {
        mScore = score;
    }

    public void SetScoredYet(boolean scoredYet) {
        mScoredYet = scoredYet;
    }

    public void SetScoreButton(Button scoreLabel) {
        mScoreLabel = scoreLabel;
    }

    public void SetScoreText(TextView scoreText) {
        mScoreText = scoreText;
    }
}
