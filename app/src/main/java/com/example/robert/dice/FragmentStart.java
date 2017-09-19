package com.example.robert.dice;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentStart extends Fragment {
    //Decalre the buttons
    Button mNewGame;
    Button mLoadGame;
    Button mHighScores;
    //Give SharedPreferences files names and save to constants
    public static final String GAME_STATE = "NewGameOrSaveDame";
    public static final String SAVED_GAME_DATA = "SavedGameData";
    public static final String HIGH_SCORES = "HighScoreData";
    //this sends a 0 or 1. 0 for new game, 1 for load saved game
    SharedPreferences mGameTypePreferecnes;
    //make the SharedPreferences editor
    SharedPreferences.Editor editor;
    //this contains the last saved game data.
    SharedPreferences mSavedGamePreferecnes;
    //this is the games high scores
    SharedPreferences mHighScoresPreferecnes;

    public FragmentStart() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        //instantiate SharedSettings and the editor
        mGameTypePreferecnes = this.getActivity().getSharedPreferences(GAME_STATE,
                Context.MODE_PRIVATE);
        editor = mGameTypePreferecnes.edit();
        //instantiate the saved game data
        mSavedGamePreferecnes = this.getActivity().getSharedPreferences(SAVED_GAME_DATA,
                Context.MODE_PRIVATE);
        //instantiate the high score data
        mHighScoresPreferecnes = this.getActivity().getSharedPreferences(HIGH_SCORES,
                Context.MODE_PRIVATE);
        //instantiate the buttons
        InstantiatButtons(view);

        return view;
    }

    /**
     * Instantiate s button and sets listeners to each of them
     * @param view This is the Layout that is loaded into main.java
     */
    private void InstantiatButtons(View view) {
        mNewGame = (Button) view.findViewById(R.id.new_game);
        mNewGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                NewGame(0);
            }
        });

        mLoadGame = (Button) view.findViewById(R.id.load_game);
        mLoadGame.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(mSavedGamePreferecnes.contains("saved_data")) {
                    //setting mode to 1. This will load game data
                    NewGame(1);
                }
                else {
                    Toast.makeText(getActivity(), "No Saved Game. Loading New Game",
                            Toast.LENGTH_SHORT).show();
                    //no saved game. load new game
                    NewGame(0);
                }
            }
        });

        mHighScores = (Button) view.findViewById(R.id.high_score);
        mHighScores.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(mHighScoresPreferecnes.contains("high_scores")) {
                    LoadHighScores();
                }
                else {
                    Toast.makeText(getActivity(), "There are no high scores.",
                            Toast.LENGTH_SHORT).show();
                    LoadHighScores();
                }
            }
        });
    }

    /**
     * Loads a new or saved game
     * @param gameMode If 0, it is a new game. If it is a 1 then it is a saved game
     */
    public void NewGame(int gameMode) {
        //set game mode value
        editor.putInt("game_mode", gameMode);
        editor.apply();
        //create a FragmentAGame fragment
        FragmentGame gameFrag = new FragmentGame();
        //make a transaction to replace existing fragment
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //put fragment into the container in activity_main.xml
        ft.replace(R.id.main_frame_layout,gameFrag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void LoadHighScores() {
        //create a FragmentAGame fragment
        FragmentScores highScoreFrag = new FragmentScores();
        //make a transaction to replace existing fragment
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //put fragment into the container in activity_main.xml
        ft.replace(R.id.main_frame_layout,highScoreFrag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }
}
