package com.example.robert.dice;

import android.util.Log;

/**
 * This list will hold the ScoreNodes for a game of dice
 * Created by Robert on 28/09/2017.
 */

class ScoreLinkedList {
    ScoreNode mHead;
    ScoreNode mTail;
    int mLength;

    public ScoreLinkedList() {
        mHead = null;
        mLength = 0;
    }

    public void addScoreNode(ScoreNode node) {
        if(mHead==null) {
            mHead=node;
            mHead.SetPrev(null);
            mTail=node;

        }

        else {
            mTail.SetNext(node);
            node.SetPrev(mTail);
            mTail=node;
            mLength++;
        }
    }

    public void PrintList(ScoreNode head) {
        ScoreNode current = head;
        while(current.GetNext()!=null) {
            String message = "Current node index is " + current.GetIndex() + ". It is called: "
                    + current.GetLabel() + ". The score of this label is " + current.GetScore();
            Log.d("NODE", message);
            current=current.GetNext();
        }
        String messageLast = "Current node index is " + current.GetIndex() + ". It is called: "
                + current.GetLabel() + ". The score of this label is " + current.GetScore();
        Log.d("NODE", messageLast);
    }

}
