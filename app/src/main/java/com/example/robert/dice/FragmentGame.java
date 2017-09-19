package com.example.robert.dice;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentGame extends Fragment {
    //the scores
    TextView mOnes,mTwos,mThrees,mFours,mFives,mSixes,m3kind,m4kind,mSmStraight,mLgStraight,
            mFullHouise,mChance,m5Kind;
    //labels that you will be able to press to enter a score into the scores
    TextView mOnesLabel,mTwosLabel,mThreesLabel,mFoursLabel,mFivesLabel,mSixesLabel,m3kindLabel,
            m4kindLabel,mSmStraightLabel,mLgStraighLabel,mFullHouiseLabel,mChanceLabel,m5KindLabel;
    //cup to roll
    Button cup;
    //dice
    Button mDice1Keep, mDice2Keep, mDice3Keep, mDice4Keep, mDice5Keep, mDice1Roll, mDice2Roll,
            mDice3Roll, mDice4Roll, mDice5Roll;

    public FragmentGame() {
        // Required empty public constructor
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        mOnesLabel = (TextView) view.findViewById(R.id.label_score_1);
        mOnesLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
               Toast.makeText(getActivity(),"Pressed Ones Label", Toast.LENGTH_SHORT).show();
            }
        });
        mTwosLabel = (TextView) view.findViewById(R.id.label_score_2);
        mTwosLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Twos Label", Toast.LENGTH_SHORT).show();
            }
        });
        mThreesLabel = (TextView) view.findViewById(R.id.label_score_3);
        mThreesLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Threes Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFoursLabel = (TextView) view.findViewById(R.id.label_score_4);
        mFoursLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Fours Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFivesLabel = (TextView) view.findViewById(R.id.label_score_5);
        mFivesLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Fives Label", Toast.LENGTH_SHORT).show();
            }
        });
        mSixesLabel = (TextView) view.findViewById(R.id.label_score_6);
        mSixesLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Sixes Label", Toast.LENGTH_SHORT).show();
            }
        });
        m3kindLabel = (TextView) view.findViewById(R.id.label_score_3kind);
        m3kindLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed 3 of Kind Label", Toast.LENGTH_SHORT).show();
            }
        });
        m4kindLabel = (TextView) view.findViewById(R.id.label_score_4kind);
        m4kindLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed 4 of Kind Label", Toast.LENGTH_SHORT).show();
            }
        });
        mSmStraightLabel = (TextView) view.findViewById(R.id.label_score_smstraight);
        mSmStraightLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Small Straight Label", Toast.LENGTH_SHORT).show();
            }
        });
        mLgStraighLabel = (TextView) view.findViewById(R.id.label_score_lgstraight);
        mLgStraighLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Large Straight Label", Toast.LENGTH_SHORT).show();
            }
        });
        mFullHouiseLabel = (TextView) view.findViewById(R.id.label_score_fullhouse);
        mFullHouiseLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Full House Label", Toast.LENGTH_SHORT).show();
            }
        });
        mChanceLabel = (TextView) view.findViewById(R.id.label_score_chance);
        mChanceLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Pressed Chance Label", Toast.LENGTH_SHORT).show();
            }
        });
        m5KindLabel = (TextView) view.findViewById(R.id.label_score_5kind);
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

    }


}
