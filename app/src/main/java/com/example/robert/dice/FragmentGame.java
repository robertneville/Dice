package com.example.robert.dice;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FragmentGame extends Fragment {
    int mRollNumber = 1;
    //the scores
    TextView mOnes, mTwos, mThrees, mFours, mFives, mSixes, m3kind, m4kind, mSmStraight, mLgStraight,
            mFullHouise, mChance, m5Kind;
    //labels that you will be able to press to enter a score into the scores
    Button mOnesLabel, mTwosLabel, mThreesLabel, mFoursLabel, mFivesLabel, mSixesLabel, m3kindLabel,
            m4kindLabel, mSmStraightLabel, mLgStraighLabel, mFullHouiseLabel, mChanceLabel, m5KindLabel;
    //cup to roll
    ImageButton mCup;
    //lists to hold image buttons
    List<ImageButton> keepDiceImageButtons = new ArrayList<>();
    List<ImageButton> rollDiceImageButtons = new ArrayList<>();
    //dice
    ImageButton mDice1Keep, mDice2Keep, mDice3Keep, mDice4Keep, mDice5Keep, mDice1Roll, mDice2Roll,
            mDice3Roll, mDice4Roll, mDice5Roll;

    //dice lists to hold dice;
    List<Dice> keepDice = new ArrayList<>();
    List<Dice> rollDice = new ArrayList<>();
    //dice that will be rolled
    Dice rollDice1 = new Dice();
    Dice rollDice2 = new Dice();
    Dice rollDice3 = new Dice();
    Dice rollDice4 = new Dice();
    Dice rollDice5 = new Dice();
    Dice keepDice1 = new Dice();
    Dice keepDice2 = new Dice();
    Dice keepDice3 = new Dice();
    Dice keepDice4 = new Dice();
    Dice keepDice5 = new Dice();

    public FragmentGame() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        InstantiateWidgets(view);
        AddDiceToLists();
        return view;
    }

    /**
     * This instantiates the widgets.
     * To keep code tidy, this will call methods to do each type
     *
     * @param view The layout holding all these widgets.
     */
    private void InstantiateWidgets(View view) {
        //the scores
        InstantiateScores(view);
        //the labels for scores
        InstantiateScoreLabels(view);
        //the cup and dice buttons
        InstantiateButtons(view);
    }

    /**
     * Called by Instantiate Widgets
     * This makes the scores
     *
     * @param view The layout holding all these widgets.
     */
    private void InstantiateScores(View view) {
        mOnes = (TextView) view.findViewById(R.id.score_score_1);
        mTwos = (TextView) view.findViewById(R.id.score_score_2);
        mThrees = (TextView) view.findViewById(R.id.score_score_3);
        mFours = (TextView) view.findViewById(R.id.score_score_4);
        mFives = (TextView) view.findViewById(R.id.score_score_5);
        mSixes = (TextView) view.findViewById(R.id.score_score_6);
        m3kind = (TextView) view.findViewById(R.id.score_score_3kind);
        m4kind = (TextView) view.findViewById(R.id.score_score_4kind);
        mSmStraight = (TextView) view.findViewById(R.id.score_score_smstraight);
        mLgStraight = (TextView) view.findViewById(R.id.score_score_lgstraight);
        mFullHouise = (TextView) view.findViewById(R.id.score_score_fullhuose);
        mChance = (TextView) view.findViewById(R.id.score_score_chance);
        m5Kind = (TextView) view.findViewById(R.id.score_score_5kind);

    }

    /**
     * Called by Instantiate Widgets
     * This makes the scores labels, which will have listeners on them
     *
     * @param view The layout holding all these widgets.
     */
    private void InstantiateScoreLabels(View view) {
        mOnesLabel = (Button) view.findViewById(R.id.label_score_1);
        mOnesLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Ones Label", Toast.LENGTH_SHORT).show();
            }
        });
        mTwosLabel = (Button) view.findViewById(R.id.label_score_2);
        mTwosLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Twos Label", Toast.LENGTH_SHORT).show();
            }
        });
        mThreesLabel = (Button) view.findViewById(R.id.label_score_3);
        mThreesLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Threes Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFoursLabel = (Button) view.findViewById(R.id.label_score_4);
        mFoursLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Fours Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFivesLabel = (Button) view.findViewById(R.id.label_score_5);
        mFivesLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Fives Label", Toast.LENGTH_SHORT).show();
            }
        });
        mSixesLabel = (Button) view.findViewById(R.id.label_score_6);
        mSixesLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Sixes Label", Toast.LENGTH_SHORT).show();
            }
        });
        m3kindLabel = (Button) view.findViewById(R.id.label_score_3kind);
        m3kindLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed 3 of Kind Label", Toast.LENGTH_SHORT).show();
            }
        });
        m4kindLabel = (Button) view.findViewById(R.id.label_score_4kind);
        m4kindLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed 4 of Kind Label", Toast.LENGTH_SHORT).show();
            }
        });
        mSmStraightLabel = (Button) view.findViewById(R.id.label_score_smstraight);
        mSmStraightLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Small Straight Label", Toast.LENGTH_SHORT).show();
            }
        });
        mLgStraighLabel = (Button) view.findViewById(R.id.label_score_lgstraight);
        mLgStraighLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Large Straight Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFullHouiseLabel = (Button) view.findViewById(R.id.label_score_fullhouse);
        mFullHouiseLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Full House Label", Toast.LENGTH_SHORT).show();
            }
        });
        mChanceLabel = (Button) view.findViewById(R.id.label_score_chance);
        mChanceLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Chance Label", Toast.LENGTH_SHORT).show();
            }
        });
        m5KindLabel = (Button) view.findViewById(R.id.label_score_5kind);
        m5KindLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed 5 of Kind Label", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Called by Instantiate Widgets
     * This makes the dice and cup buttons
     *
     * @param view The layout holding all these widgets.
     */
    private void InstantiateButtons(View view) {

        mDice1Keep = (ImageButton) view.findViewById(R.id.gameDiceKeep1);
        mDice1Keep.setVisibility(View.INVISIBLE);
        mDice1Keep.setEnabled(false);
        mDice1Keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice1Roll.setEnabled(true);
                mDice1Roll.setVisibility(View.VISIBLE);
                rollDice.get(0).setCanRoll(true);
                mDice1Keep.setEnabled(false);
                mDice1Keep.setVisibility(View.INVISIBLE);            }
        });
        keepDiceImageButtons.add(mDice1Keep);

        mDice2Keep = (ImageButton) view.findViewById(R.id.gameDiceKeep2);
        mDice2Keep.setVisibility(View.INVISIBLE);
        mDice2Keep.setEnabled(false);
        mDice2Keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice2Roll.setEnabled(true);
                mDice2Roll.setVisibility(View.VISIBLE);
                rollDice.get(1).setCanRoll(true);
                mDice2Keep.setEnabled(false);
                mDice2Keep.setVisibility(View.INVISIBLE);            }
        });
        keepDiceImageButtons.add(mDice2Keep);

        mDice3Keep = (ImageButton) view.findViewById(R.id.gameDiceKeep3);
        mDice3Keep.setVisibility(View.INVISIBLE);
        mDice3Keep.setEnabled(false);
        mDice3Keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice3Roll.setEnabled(true);
                mDice3Roll.setVisibility(View.VISIBLE);
                rollDice.get(2).setCanRoll(true);
                mDice3Keep.setEnabled(false);
                mDice3Keep.setVisibility(View.INVISIBLE);
            }
        });
        keepDiceImageButtons.add(mDice3Keep);
        mDice4Keep = (ImageButton) view.findViewById(R.id.gameDiceKeep4);
        mDice4Keep.setVisibility(View.INVISIBLE);
        mDice4Keep.setEnabled(false);
        mDice4Keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice4Roll.setEnabled(true);
                mDice4Roll.setVisibility(View.VISIBLE);
                rollDice.get(3).setCanRoll(true);
                mDice4Keep.setEnabled(false);
                mDice4Keep.setVisibility(View.INVISIBLE);            }
        });
        keepDiceImageButtons.add(mDice4Keep);

        mDice5Keep = (ImageButton) view.findViewById(R.id.gameDiceKeep5);
        mDice5Keep.setVisibility(View.INVISIBLE);
        mDice5Keep.setEnabled(false);
        mDice5Keep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice5Roll.setEnabled(true);
                mDice5Roll.setVisibility(View.VISIBLE);
                rollDice.get(4).setCanRoll(true);
                mDice5Keep.setEnabled(false);
                mDice5Keep.setVisibility(View.INVISIBLE);            }
        });
        keepDiceImageButtons.add(mDice5Keep);

        mDice1Roll = (ImageButton) view.findViewById(R.id.gameDiceRoll1);
        mDice1Roll.setVisibility(View.INVISIBLE);
        mDice1Roll.setEnabled(false);
        mDice1Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice1Roll.setEnabled(false);
                mDice1Roll.setVisibility(View.INVISIBLE);
                rollDice.get(0).setCanRoll(false);
                mDice1Keep.setEnabled(true);
                mDice1Keep.setVisibility(View.VISIBLE);
            }
        });
        rollDiceImageButtons.add(mDice1Roll);

        mDice2Roll = (ImageButton) view.findViewById(R.id.gameDiceRoll2);
        mDice2Roll.setVisibility(View.INVISIBLE);
        mDice2Roll.setEnabled(false);
        mDice2Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice2Roll.setEnabled(false);
                mDice2Roll.setVisibility(View.INVISIBLE);
                rollDice.get(1).setCanRoll(false);
                mDice2Keep.setEnabled(true);
                mDice2Keep.setVisibility(View.VISIBLE);
            }
        });
        rollDiceImageButtons.add(mDice2Roll);

        mDice3Roll = (ImageButton) view.findViewById(R.id.gameDiceRoll3);
        mDice3Roll.setVisibility(View.INVISIBLE);
        mDice3Roll.setEnabled(false);
        mDice3Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice3Roll.setEnabled(false);
                mDice3Roll.setVisibility(View.INVISIBLE);
                rollDice.get(2).setCanRoll(false);
                mDice3Keep.setEnabled(true);
                mDice3Keep.setVisibility(View.VISIBLE);            }
        });
        rollDiceImageButtons.add(mDice3Roll);

        mDice4Roll = (ImageButton) view.findViewById(R.id.gameDiceRoll4);
        mDice4Roll.setVisibility(View.INVISIBLE);
        mDice4Roll.setEnabled(false);
        mDice4Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice4Roll.setEnabled(false);
                mDice4Roll.setVisibility(View.INVISIBLE);
                rollDice.get(3).setCanRoll(false);
                mDice4Keep.setEnabled(true);
                mDice4Keep.setVisibility(View.VISIBLE);            }
        });
        rollDiceImageButtons.add(mDice4Roll);

        mDice5Roll = (ImageButton) view.findViewById(R.id.gameDiceRoll5);
        mDice5Roll.setVisibility(View.INVISIBLE);
        mDice5Roll.setEnabled(false);
        mDice5Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDice5Roll.setEnabled(false);
                mDice5Roll.setVisibility(View.INVISIBLE);
                rollDice.get(4).setCanRoll(false);
                mDice5Keep.setEnabled(true);
                mDice5Keep.setVisibility(View.VISIBLE);            }
        });
        rollDiceImageButtons.add(mDice5Roll);

        mCup = (ImageButton) view.findViewById(R.id.game_cup);
        mCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartTurn();
            }
        });
    }

    /**
     * This adds dice to the lists.
     */
    private void AddDiceToLists() {
        keepDice.clear();
        rollDice.clear();
        rollDice.add(rollDice1);
        rollDice.add(rollDice2);
        rollDice.add(rollDice3);
        rollDice.add(rollDice4);
        rollDice.add(rollDice5);
        keepDice.add(keepDice1);
        keepDice.add(keepDice2);
        keepDice.add(keepDice3);
        keepDice.add(keepDice4);
        keepDice.add(keepDice5);
    }

    /**
     * This checks to see how many rolls have been used and uses the appropiate
     * method depending on the number of rolls. 1 - 3 rolls, continue with turn
     * more than 3 rolls. Must accept a score.
     */
    private void StartTurn() {
        //not a new turn
        if (mRollNumber > 0 && mRollNumber < 4) {
            StartRoll();
        }
        //this is a new turn
        else {
            Toast.makeText(getActivity(), "No more rolls. Select a score.", Toast.LENGTH_LONG).show();
        }

    }

    ;

    /**
     * This starts a roll
     */
    private void StartRoll() {
        Toast.makeText(getActivity(), 3 - mRollNumber + " rolls left.", Toast.LENGTH_LONG).show();
        mRollNumber++;
        rollDice1.setDiceFace(rollDice1.rollDice());
        rollDice2.setDiceFace(rollDice2.rollDice());
        rollDice3.setDiceFace(rollDice3.rollDice());
        rollDice4.setDiceFace(rollDice4.rollDice());
        rollDice5.setDiceFace(rollDice5.rollDice());
        for(int i = 0; i < rollDice.size();i++) {
            if (rollDice.get(i).getCanRoll()==true) {
                rollDice.get(i).setDiceFace(rollDice.get(i).rollDice());
                rollDiceImageButtons.get(i).setVisibility(View.VISIBLE);
                rollDiceImageButtons.get(i).setEnabled(true);
            }
        }

    }


}
