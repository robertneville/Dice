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


public class FragmentGame extends Fragment {
    int mRollNumber = 3;
    //the scores
    TextView mOnes,mTwos,mThrees,mFours,mFives,mSixes,m3kind,m4kind,mSmStraight,mLgStraight,
            mFullHouise,mChance,m5Kind;
    //labels that you will be able to press to enter a score into the scores
    Button mOnesLabel,mTwosLabel,mThreesLabel,mFoursLabel,mFivesLabel,mSixesLabel,m3kindLabel,
            m4kindLabel,mSmStraightLabel,mLgStraighLabel,mFullHouiseLabel,mChanceLabel,m5KindLabel;
    //cup to roll
    ImageButton mCup;
    //dice
    ImageButton mDice1Keep, mDice2Keep, mDice3Keep, mDice4Keep, mDice5Keep, mDice1Roll, mDice2Roll,
            mDice3Roll, mDice4Roll, mDice5Roll;

    public FragmentGame() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        InstantiateWidgets(view);
        return view;
    }

    /**
     * This instantiates the widgets.
     * To keep code tidy, this will call methods to do each type
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
     * @param view The layout holding all these widgets.
     */
    private void InstantiateScoreLabels(View view) {
        mOnesLabel = (Button) view.findViewById(R.id.label_score_1);
        mOnesLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
               Toast.makeText(getActivity(),"Pressed Ones Label", Toast.LENGTH_SHORT).show();
            }
        });
        mTwosLabel = (Button) view.findViewById(R.id.label_score_2);
        mTwosLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Twos Label", Toast.LENGTH_SHORT).show();
            }
        });
        mThreesLabel = (Button) view.findViewById(R.id.label_score_3);
        mThreesLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Threes Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFoursLabel = (Button) view.findViewById(R.id.label_score_4);
        mFoursLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Fours Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFivesLabel = (Button) view.findViewById(R.id.label_score_5);
        mFivesLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Fives Label", Toast.LENGTH_SHORT).show();
            }
        });
        mSixesLabel = (Button) view.findViewById(R.id.label_score_6);
        mSixesLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Sixes Label", Toast.LENGTH_SHORT).show();
            }
        });
        m3kindLabel = (Button) view.findViewById(R.id.label_score_3kind);
        m3kindLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed 3 of Kind Label", Toast.LENGTH_SHORT).show();
            }
        });
        m4kindLabel = (Button) view.findViewById(R.id.label_score_4kind);
        m4kindLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed 4 of Kind Label", Toast.LENGTH_SHORT).show();
            }
        });
        mSmStraightLabel = (Button) view.findViewById(R.id.label_score_smstraight);
        mSmStraightLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Small Straight Label", Toast.LENGTH_SHORT).show();
            }
        });
        mLgStraighLabel = (Button) view.findViewById(R.id.label_score_lgstraight);
        mLgStraighLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Large Straight Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFullHouiseLabel = (Button) view.findViewById(R.id.label_score_fullhouse);
        mFullHouiseLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Full House Label", Toast.LENGTH_SHORT).show();
            }
        });
        mChanceLabel = (Button) view.findViewById(R.id.label_score_chance);
        mChanceLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Chance Label", Toast.LENGTH_SHORT).show();
            }
        });
        m5KindLabel = (Button) view.findViewById(R.id.label_score_5kind);
        m5KindLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed 5 of Kind Label", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Called by Instantiate Widgets
     *  This makes the dice and cup buttons
     *  @param view The layout holding all these widgets.
     */
    private void InstantiateButtons(View view) {

        mDice1Keep = (ImageButton)view.findViewById(R.id.gameDiceKeep1);
        mDice1Keep.setEnabled(false);
        mDice1Keep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Keep 1 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mDice2Keep = (ImageButton)view.findViewById(R.id.gameDiceKeep2);
        mDice2Keep.setEnabled(false);
        mDice2Keep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Keep 2 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mDice3Keep = (ImageButton)view.findViewById(R.id.gameDiceKeep3);
        mDice3Keep.setEnabled(false);
        mDice3Keep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Keep 3 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mDice4Keep = (ImageButton)view.findViewById(R.id.gameDiceKeep4);
        mDice4Keep.setEnabled(false);
        mDice4Keep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Keep 4 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mDice5Keep = (ImageButton)view.findViewById(R.id.gameDiceKeep5);
        mDice5Keep.setEnabled(false);
        mDice5Keep.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Keep 5 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mDice1Roll = (ImageButton)view.findViewById(R.id.gameDiceRoll1);
        mDice1Roll.setEnabled(false);
        mDice1Roll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Roll 1 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mDice2Roll = (ImageButton)view.findViewById(R.id.gameDiceRoll2);
        mDice2Roll.setEnabled(false);
        mDice2Roll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Roll 2 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mDice3Roll = (ImageButton)view.findViewById(R.id.gameDiceRoll3);
        mDice3Roll.setEnabled(false);
        mDice3Roll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Roll 3 Dice", Toast.LENGTH_SHORT).show();
            }
        });

        mDice4Roll = (ImageButton)view.findViewById(R.id.gameDiceRoll4);
        mDice4Roll.setEnabled(false);
        mDice4Roll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Roll 4 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mDice5Roll = (ImageButton)view.findViewById(R.id.gameDiceRoll5);
        mDice5Roll.setEnabled(false);
        mDice5Roll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Roll 5 Dice", Toast.LENGTH_SHORT).show();
            }
        });
        mCup = (ImageButton)view.findViewById(R.id.game_cup);
        mCup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                StartRoll();
            }
        });
    }


    private void StartTurn() {
        mRollNumber = 3;

    };

    private void StartRoll() {
        if(mRollNumber>0 && mRollNumber < 4) {
            Toast.makeText(getActivity(), "No more rolls. Select a score.", Toast.LENGTH_LONG).show();
        }

    }

}
