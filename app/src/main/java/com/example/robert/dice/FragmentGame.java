package com.example.robert.dice;


import android.content.res.Resources;
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
import java.util.Arrays;
import java.util.List;


public class FragmentGame extends Fragment {
    ScoreLinkedList scoreList;
    int mRollNumber = 1;

    //cup to roll
    ImageButton mCup;
    //lists to hold image buttons
    List<ImageButton> keepDiceImageButtons = new ArrayList<>();
    List<ImageButton> rollDiceImageButtons = new ArrayList<>();
    //dice
    ImageButton mDice1Keep, mDice2Keep, mDice3Keep, mDice4Keep, mDice5Keep, mDice1Roll, mDice2Roll,
            mDice3Roll, mDice4Roll, mDice5Roll;
    Button mOnesLabel,mTwosLabel,mThreesLabel,mFoursLabel,mFivesLabel,mSixesLabel,m3kindLabel,
            m4kindLabel,mSmStraightLabel,mLgStraighLabel,mChanceLabel,mFullHouiseLabel,m5KindLabel;
    TextView mOnes,mTwos,mThrees,mFours,mFives,mSixes,m3kind,m4kind,mSmStraight,mLgStraight,
            mChance,mFullHouise,m5Kind;

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

    List<TextView> TextScores = new ArrayList<>();
    List<Button> ButtonScores = new ArrayList<>();
    List<Boolean> ButtonScoresFlag = new ArrayList<>();
    public FragmentGame() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        scoreList = new ScoreLinkedList();
        makeList();
        InstantiateWidgets(view);
        AddDiceToLists();
        //AddScoresToList();
        return view;
    }

    public void makeList() {
        Resources res = getActivity().getResources();
        String[] array = res.getStringArray(R.array.game_labels);
        for (int i = 0; i < array.length; i++) {
            ScoreNode temp = new ScoreNode(i, array[i], 0, false);
            scoreList.addScoreNode(temp);
        }
        scoreList.PrintList(scoreList.mHead);
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
        //skipping the total score node
        ScoreNode temp = scoreList.mHead.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_1));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_2));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_3));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_4));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_5));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_6));
        //skipping the bonus score node
        temp = temp.GetNext();
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_3kind));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_4kind));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_smstraight));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_lgstraight));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_fullhuose));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_chance));
        temp = temp.GetNext();
        temp.SetScoreText((TextView) view.findViewById(R.id.score_score_5kind));
        //go back to start of list and set the scoreList head as temp head.
        while (temp.GetPrev() != null) {
            temp = temp.GetPrev();
        }
        scoreList.mHead = temp;
    }

    /**
     * Called by Instantiate Widgets
     * This makes the scores labels, which will have listeners on them
     *
     * @param view The layout holding all these widgets.
     */
    private void InstantiateScoreLabels(View view) {
        //skipping the total score node
        ScoreNode temp = scoreList.mHead.GetNext();
        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_1));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Ones Label", Toast.LENGTH_SHORT).show();
                SetScore(0);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_2));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Twos Label", Toast.LENGTH_SHORT).show();
                SetScore(1);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_3));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Threes Label", Toast.LENGTH_SHORT).show();
                SetScore(2);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_4));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Fours Label", Toast.LENGTH_SHORT).show();
                SetScore(3);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_5));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Fives Label", Toast.LENGTH_SHORT).show();
                SetScore(4);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_6));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Sixes Label", Toast.LENGTH_SHORT).show();
                SetScore(5);
            }
        });
        temp = temp.GetNext();
        //skipping the bonus score node
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_3kind));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed 3 of Kind Label", Toast.LENGTH_SHORT).show();
                SetScore(6);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_4kind));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed 4 of Kind Label", Toast.LENGTH_SHORT).show();
                SetScore(7);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_smstraight));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Small Straight Label", Toast.LENGTH_SHORT).show();
                SetScore(8);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_lgstraight));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Large Straight Label", Toast.LENGTH_SHORT).show();
                SetScore(9);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_fullhouse));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Full House Label", Toast.LENGTH_SHORT).show();
                SetScore(10);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_chance));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed Chance Label", Toast.LENGTH_SHORT).show();
                SetScore(11);
            }
        });
        temp = temp.GetNext();

        temp.SetScoreButton((Button) view.findViewById(R.id.label_score_5kind));
        temp.GetButtonLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pressed 5 of Kind Label", Toast.LENGTH_SHORT).show();
                SetScore(12);
            }
        });
        while (temp.GetPrev() != null) {
            temp = temp.GetPrev();
        }
        scoreList.mHead = temp;
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
                mDice1Keep.setVisibility(View.INVISIBLE);
            }
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
                mDice2Keep.setVisibility(View.INVISIBLE);
            }
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
                mDice4Keep.setVisibility(View.INVISIBLE);
            }
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
                mDice5Keep.setVisibility(View.INVISIBLE);
            }
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
                mDice3Keep.setVisibility(View.VISIBLE);
            }
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
                mDice4Keep.setVisibility(View.VISIBLE);
            }
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
                mDice5Keep.setVisibility(View.VISIBLE);
            }
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
     * This adds buttons to a list.
     * Add score textViews to list.
     * Add booleans to another list.
     * Booleans indicate if a Bbutton has been used.
     */
    private void AddScoresToList() {
        ButtonScores.clear();
        //labels for scores
        ButtonScores.add(mOnesLabel);
        ButtonScores.add(mTwosLabel);
        ButtonScores.add(mThreesLabel);
        ButtonScores.add(mFoursLabel);
        ButtonScores.add(mFivesLabel);
        ButtonScores.add(mSixesLabel);
        ButtonScores.add(m3kindLabel);
        ButtonScores.add(m4kindLabel);
        ButtonScores.add(mSmStraightLabel);
        ButtonScores.add(mLgStraighLabel);
        ButtonScores.add(mChanceLabel);
        ButtonScores.add(mFullHouiseLabel);
        ButtonScores.add(m5KindLabel);
        //scores of the scores
        TextScores.add(mOnes);
        TextScores.add(mTwos);
        TextScores.add(mThrees);
        TextScores.add(mFours);
        TextScores.add(mFives);
        TextScores.add(mSixes);
        TextScores.add(m3kind);
        TextScores.add(m4kind);
        TextScores.add(mSmStraight);
        TextScores.add(mLgStraight);
        TextScores.add(mChance);
        TextScores.add(mFullHouise);
        TextScores.add(m5Kind);
        //boolen list to say if a score has been posted before.
        for (int i = 0; i < ButtonScores.size(); i++) {
            ButtonScoresFlag.add(false);
        }

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

    /**
     * This starts a roll
     */
    private void StartRoll() {
        Toast.makeText(getActivity(), 3 - mRollNumber + " rolls left.", Toast.LENGTH_LONG).show();
        mRollNumber++;
        for (int i = 0; i < rollDice.size(); i++) {
            if (rollDice.get(i).getCanRoll()) {
                rollDice.get(i).setDiceFace(rollDice.get(i).rollDice());
                rollDiceImageButtons.get(i).setVisibility(View.VISIBLE);
                rollDiceImageButtons.get(i).setEnabled(true);
                SetImageButton(rollDiceImageButtons.get(i), keepDiceImageButtons.get(i), rollDice.get(i));
            }
        }
        EnableScoreButtons();

    }

    /**
     * This changes the image buttons src image based on the roll
     *
     * @param rollDiceImage Image button for roll dice
     * @param keepDiceImage Image button for keep dice
     * @param dice          Dice that will have the randomly rolled value of 1 - 6
     */
    private void SetImageButton(ImageButton rollDiceImage, ImageButton keepDiceImage, Dice dice) {
        switch (dice.getDiceFace()) {
            case 1:
                rollDiceImage.setImageResource(R.mipmap.whitedice1);
                keepDiceImage.setImageResource(R.mipmap.greendice1);
                break;
            case 2:
                rollDiceImage.setImageResource(R.mipmap.whitedice2);
                keepDiceImage.setImageResource(R.mipmap.greendice2);
                break;
            case 3:
                rollDiceImage.setImageResource(R.mipmap.whitedice3);
                keepDiceImage.setImageResource(R.mipmap.greendice3);
                break;
            case 4:
                rollDiceImage.setImageResource(R.mipmap.whitedice4);
                keepDiceImage.setImageResource(R.mipmap.greendice4);
                break;
            case 5:
                rollDiceImage.setImageResource(R.mipmap.whitedice5);
                keepDiceImage.setImageResource(R.mipmap.greendice5);
                break;
            case 6:
                rollDiceImage.setImageResource(R.mipmap.whitedice6);
                keepDiceImage.setImageResource(R.mipmap.greendice6);
                break;
        }

    }

    /**
     * enables the buttons to add a score based on dice face values
     */
    private void EnableScoreButtons() {
        int score = 0;
        ScoreNode temp = scoreList.mHead;
        while (temp.GetNext() != null) {
            //skip scores and bonus score node
            if (temp.GetIndex() != 0 && temp.GetIndex() != 7) {
                if (temp.GetScoredYet() == false) {
                    int index = temp.GetIndex();
                    temp.GetButtonLabel().setEnabled(true);
                    score = GetScore(index, rollDice);
                    temp.GetScoreText().setText(score + "");
                    temp=temp.GetNext();
                }
            }
            else {
                temp=temp.GetNext();
            }

        }

    }


    private int GetScore(int i, List<Dice> rollDice) {
        ButtonScores.get(i).setBackgroundResource(R.drawable.game_button_pressed);
        int score = 0;
        int[] array = new int[5];
        for (int k = 0; k < 5; k++) {
            array[k] = rollDice.get(k).getDiceFace();
        }
        Arrays.sort(array);
        switch (i) {
            case 0:
                score = 0;
                for (int j = 0; j < 5; j++) {
                    if (array[j] == 1) {
                        score++;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                break;
            case 1:
                score = 0;
                for (int j = 0; j < 5; j++) {
                    if (array[j] == 2) {
                        score++;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                score = score * 2;
                break;
            case 2:
                score = 0;
                for (int j = 0; j < 5; j++) {
                    if (array[j] == 3) {
                        score++;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                score = score * 3;
                break;
            case 3:
                score = 0;
                for (int j = 0; j < 5; j++) {
                    if (array[j] == 4) {
                        score++;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }

                score = score * 3;
                break;
            case 4:
                score = 0;
                for (int j = 0; j < 5; j++) {
                    if (array[j] == 5) {
                        score++;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                score = score * 5;
                break;
            case 5:
                score = 0;
                for (int j = 0; j < 5; j++) {
                    if (array[j] == 6) {
                        score++;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                score = score * 6;
                break;

            case 6:
                score = 0;
                int[] isThereThreeOfKind = {0, 0, 0, 0, 0,0};
                for (int index = 0; index < 5; index++) {
                    if (array[index] == 1) {
                        isThereThreeOfKind[0]++;
                    } else if (array[index] == 2) {
                        isThereThreeOfKind[1]++;
                    } else if (array[index] == 3) {
                        isThereThreeOfKind[2]++;
                    } else if (array[index] == 4) {
                        isThereThreeOfKind[3]++;
                    } else if (array[index] == 5) {
                        isThereThreeOfKind[4]++;
                    } else if (array[index] == 6) {
                        isThereThreeOfKind[5]++;
                    }
                }
                for (int anIsThereThreeOfKind : isThereThreeOfKind) {
                    if (anIsThereThreeOfKind >= 3) {
                        int oneScore = isThereThreeOfKind[0];
                        int twoScore = isThereThreeOfKind[1] * 2;
                        int threeScore = isThereThreeOfKind[2] * 3;
                        int fourScore = isThereThreeOfKind[3] * 4;
                        int fiveScore = isThereThreeOfKind[4] * 5;
                        int sixScore = isThereThreeOfKind[5] * 6;
                        score = oneScore + twoScore + threeScore + fourScore + fiveScore + sixScore;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                break;
            case 7:
                score = 0;
                int[] isThereFourOfKind = {0, 0, 0, 0, 0,0};
                for (int index = 0; index < 5; index++) {
                    if (array[index] == 1) {
                        isThereFourOfKind[0]++;
                    } else if (array[index] == 2) {
                        isThereFourOfKind[0]++;
                    } else if (array[index] == 3) {
                        isThereFourOfKind[0]++;
                    } else if (array[index] == 4) {
                        isThereFourOfKind[0]++;
                    } else if (array[index] == 5) {
                        isThereFourOfKind[0]++;
                    } else if (array[index] == 6) {
                        isThereFourOfKind[5]++;
                    }
                }
                for (int anIsThereFourOfKind : isThereFourOfKind) {
                    if (anIsThereFourOfKind >= 4) {
                        int oneScore = isThereFourOfKind[0];
                        int twoScore = isThereFourOfKind[1] * 2;
                        int threeScore = isThereFourOfKind[2] * 3;
                        int fourScore = isThereFourOfKind[3] * 4;
                        int fiveScore = isThereFourOfKind[4] * 5;
                        int sixScore = isThereFourOfKind[5] * 6;
                        score = oneScore + twoScore + threeScore + fourScore + fiveScore + sixScore;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                break;
            case 8:
                score = 0;
                if(array[0]==1) {
                    if(array[1]==2){
                        if(array[2]==3) {
                            if(array[3]==4) {
                                ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                                score=30;
                            }
                        }
                    }
                }
                if(array[1]==1) {
                    if(array[2]==2){
                        if(array[3]==3) {
                            if(array[4]==4) {
                                ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                                score=30;
                            }
                        }
                    }
                }
                score = 0;
                if(array[0]==2) {
                    if(array[1]==3){
                        if(array[2]==4) {
                            if(array[3]==5) {
                                ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                                score=30;
                            }
                        }
                    }
                }
                if(array[1]==2) {
                    if(array[2]==3){
                        if(array[3]==4) {
                            if(array[4]==5) {
                                ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                                score=30;
                            }
                        }
                    }
                }
                score = 0;
                if(array[0]==3) {
                    if(array[1]==4){
                        if(array[2]==5) {
                            if(array[3]==6) {
                                ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                                score=30;
                            }
                        }
                    }
                }
                if(array[1]==3) {
                    if(array[2]==4){
                        if(array[3]==5) {
                            if(array[4]==6) {
                                ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                                score=30;
                            }
                        }
                    }
                }
                break;
            case 9:
                score = 0;
                if(array[0]==1) {
                    if(array[1]==2){
                        if(array[2]==3) {
                            if(array[3]==4) {
                                if(array[4]==5){
                                    ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                                    score=40;
                                }
                            }
                        }
                    }
                }
                if(array[0]==2) {
                    if(array[1]==3){
                        if(array[2]==4) {
                            if(array[3]==5) {
                                if(array[4]==6){
                                    ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                                    score=40;
                                }
                            }
                        }
                    }
                }
                break;

            case 11:
                score = 0;
                int[] isThereFullHouse = {0, 0, 0, 0, 0,0};
                for (int index = 0; index < 5; index++) {
                    if (array[index] == 1) {
                        isThereFullHouse[0]++;
                    } else if (array[index] == 2) {
                        isThereFullHouse[0]++;
                    } else if (array[index] == 3) {
                        isThereFullHouse[0]++;
                    } else if (array[index] == 4) {
                        isThereFullHouse[0]++;
                    } else if (array[index] == 5) {
                        isThereFullHouse[0]++;
                    } else if (array[index] == 6) {
                        isThereFullHouse[5]++;
                    }
                }
                for (int anIsThereFullHouse : isThereFullHouse) {
                    boolean pair = false;
                    boolean triple = false;
                    if (anIsThereFullHouse == 2) {
                        pair = true;
                    }
                    if (anIsThereFullHouse == 3) {
                        triple = true;
                    }
                    if (pair) {
                        score = 25;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                break;
            case 12:
                score = array[0]+ array[1] + array[2] + array[3] + array[4];
                ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                break;

            case 13:
                score = 0;
                int[] isThereFiveOfKind = {0, 0, 0, 0, 0,0};
                for (int index = 0; index < 5; index++) {
                    if (array[index] == 1) {
                        isThereFiveOfKind[0]++;
                    } else if (array[index] == 2) {
                        isThereFiveOfKind[0]++;
                    } else if (array[index] == 3) {
                        isThereFiveOfKind[0]++;
                    } else if (array[index] == 4) {
                        isThereFiveOfKind[0]++;
                    } else if (array[index] == 5) {
                        isThereFiveOfKind[0]++;
                    } else if (array[index] == 6) {
                        isThereFiveOfKind[5]++;
                    }
                }
                for (int anIsThereFiveOfKind : isThereFiveOfKind) {
                    if (anIsThereFiveOfKind >= 5) {
                        score = 50;
                        ButtonScores.get(i).setBackgroundResource(R.drawable.available);
                    }
                }
                break;
        }
        return score;
    }

    /**
     * Sets a score, changes flag for that button and disables all score buttons
     * @param index index of flag to be turned to true.
     */
    private void SetScore(int index) {
        int one, two, three, four, five, six, kind3, kind4, kind5, smStr, lgStr, fh, chance = 0;
        ButtonScoresFlag.set(index, true);
        for (int i = 0; i < ButtonScores.size(); i++) {
            ButtonScores.get(i).setEnabled(false);
            if (!ButtonScoresFlag.get(i)) {
                TextScores.get(i).setText(0 + "");
                ButtonScores.get(i).setBackgroundResource(R.drawable.game_button_pressed);
            } else {
                ButtonScores.get(i).setBackgroundResource(R.drawable.scored);
            }
        }
        for (int j = 0; j < keepDiceImageButtons.size(); j++) {
            keepDiceImageButtons.get(j).setEnabled(false);
            keepDiceImageButtons.get(j).setVisibility(View.INVISIBLE);
            keepDice.get(j).setCanRoll(false);
            rollDiceImageButtons.get(j).setEnabled(false);
            rollDiceImageButtons.get(j).setVisibility(View.INVISIBLE);
            rollDice.get(j).setCanRoll(true);
            AddDiceToLists();
        }
    }
}
