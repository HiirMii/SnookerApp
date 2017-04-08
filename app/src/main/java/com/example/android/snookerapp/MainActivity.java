package com.example.android.snookerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * Global variables
     */

    int scorePlayerOne = 0;
    int scorePlayerTwo = 0;
    String gameInfo = "";
    boolean newGameEnabled;
    boolean finishGameEnabled;
    boolean oneEnabled;
    boolean twoEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Fetching buttons by their IDs
         */

        final Button newGame = (Button) findViewById(R.id.new_game);
        final Button finishGame = (Button) findViewById(R.id.finish_game);
        final Button one1 = (Button) findViewById(R.id.one1);
        final Button one2 = (Button) findViewById(R.id.one2);
        final Button one3 = (Button) findViewById(R.id.one3);
        final Button one4 = (Button) findViewById(R.id.one4);
        final Button one5 = (Button) findViewById(R.id.one5);
        final Button one6 = (Button) findViewById(R.id.one6);
        final Button one7 = (Button) findViewById(R.id.one7);
        final Button missOne = (Button) findViewById(R.id.one_miss);
        final Button two1 = (Button) findViewById(R.id.two1);
        final Button two2 = (Button) findViewById(R.id.two2);
        final Button two3 = (Button) findViewById(R.id.two3);
        final Button two4 = (Button) findViewById(R.id.two4);
        final Button two5 = (Button) findViewById(R.id.two5);
        final Button two6 = (Button) findViewById(R.id.two6);
        final Button two7 = (Button) findViewById(R.id.two7);
        final Button missTwo = (Button) findViewById(R.id.two_miss);

        /**
         * New Game Button - updating the info TextView, resetting score to 0,
         * enabling/disabling controls, saving all buttons enable state to global variables.
         */

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfo = "Player 1 is currently playing...";
                displayInfo(gameInfo);
                scorePlayerOne = 0;
                displayForPlayerOne(scorePlayerOne);
                scorePlayerTwo = 0;
                displayForPlayerTwo(scorePlayerTwo);
                one1.setEnabled(true);
                one2.setEnabled(true);
                one3.setEnabled(true);
                one4.setEnabled(true);
                one5.setEnabled(true);
                one6.setEnabled(true);
                one7.setEnabled(true);
                missOne.setEnabled(true);
                newGame.setEnabled(false);
                finishGame.setEnabled(true);
                oneEnabled = true;
                newGameEnabled = false;
                finishGameEnabled = true;

            }
        });

        /**
         * Finish Game Button - displaying result in the info TextView,
         * enabling/disabling controls, saving all buttons enable state to global variables.
         */

        finishGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameResult(v);
                one1.setEnabled(false);
                one2.setEnabled(false);
                one3.setEnabled(false);
                one4.setEnabled(false);
                one5.setEnabled(false);
                one6.setEnabled(false);
                one7.setEnabled(false);
                missOne.setEnabled(false);
                two1.setEnabled(false);
                two2.setEnabled(false);
                two3.setEnabled(false);
                two4.setEnabled(false);
                two5.setEnabled(false);
                two6.setEnabled(false);
                two7.setEnabled(false);
                missTwo.setEnabled(false);
                newGame.setEnabled(true);
                finishGame.setEnabled(false);
                oneEnabled = false;
                twoEnabled = false;
                newGameEnabled =true;
                finishGameEnabled = false;
            }
        });

        /**
         * Player 1 Miss Button - updating the info TextView,
         * enabling/disabling controls, saving all buttons enable state to global variables.
         */

        missOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfo = "Player 2 is currently playing...";
                displayInfo(gameInfo);
                one1.setEnabled(false);
                one2.setEnabled(false);
                one3.setEnabled(false);
                one4.setEnabled(false);
                one5.setEnabled(false);
                one6.setEnabled(false);
                one7.setEnabled(false);
                missOne.setEnabled(false);
                two1.setEnabled(true);
                two2.setEnabled(true);
                two3.setEnabled(true);
                two4.setEnabled(true);
                two5.setEnabled(true);
                two6.setEnabled(true);
                two7.setEnabled(true);
                missTwo.setEnabled(true);
                oneEnabled = false;
                twoEnabled = true;
            }
        });

        /**
         * Player 2 Miss Button - updating the info TextView,
         * enabling/disabling controls, saving all buttons enable state to global variables.
         */

        missTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameInfo = "Player 1 is currently playing...";
                displayInfo(gameInfo);
                one1.setEnabled(true);
                one2.setEnabled(true);
                one3.setEnabled(true);
                one4.setEnabled(true);
                one5.setEnabled(true);
                one6.setEnabled(true);
                one7.setEnabled(true);
                missOne.setEnabled(true);
                two1.setEnabled(false);
                two2.setEnabled(false);
                two3.setEnabled(false);
                two4.setEnabled(false);
                two5.setEnabled(false);
                two6.setEnabled(false);
                two7.setEnabled(false);
                missTwo.setEnabled(false);
                oneEnabled = true;
                twoEnabled = false;
            }
        });

        /**
         * Retrieving all saved controls and displays states
         * and setting them back to what they were.
         */

        if (savedInstanceState != null) {
            scorePlayerOne = savedInstanceState.getInt("scoreOne");
            scorePlayerTwo = savedInstanceState.getInt("scoreTwo");
            gameInfo = savedInstanceState.getString("gameInfo");
            displayForPlayerOne(scorePlayerOne);
            displayForPlayerTwo(scorePlayerTwo);
            displayInfo(gameInfo);
            newGameEnabled = savedInstanceState.getBoolean("new");
            newGame.setEnabled(newGameEnabled);
            finishGameEnabled = savedInstanceState.getBoolean("finish");
            finishGame.setEnabled(finishGameEnabled);
            oneEnabled = savedInstanceState.getBoolean("one");
            one1.setEnabled(oneEnabled);
            one2.setEnabled(oneEnabled);
            one3.setEnabled(oneEnabled);
            one4.setEnabled(oneEnabled);
            one5.setEnabled(oneEnabled);
            one6.setEnabled(oneEnabled);
            one7.setEnabled(oneEnabled);
            missOne.setEnabled(oneEnabled);
            twoEnabled = savedInstanceState.getBoolean("two");
            two1.setEnabled(twoEnabled);
            two2.setEnabled(twoEnabled);
            two3.setEnabled(twoEnabled);
            two4.setEnabled(twoEnabled);
            two5.setEnabled(twoEnabled);
            two6.setEnabled(twoEnabled);
            two7.setEnabled(twoEnabled);
            missTwo.setEnabled(twoEnabled);
        }
    }

    /**
     * Saving instance state for all controls and displays.
     */

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("scoreOne", scorePlayerOne);
        outState.putInt("scoreTwo", scorePlayerTwo);
        outState.putString("gameInfo", gameInfo);
        outState.putBoolean("new", newGameEnabled);
        outState.putBoolean("finish", finishGameEnabled);
        outState.putBoolean("one", oneEnabled);
        outState.putBoolean("two", twoEnabled);
    }

    /**
     * Increase the score for Player 1 by 1 point.
     */

    public void addOnePlayerOne (View view) {
        scorePlayerOne = scorePlayerOne + 1;
        displayForPlayerOne(scorePlayerOne);
    }

    /**
     * Increase the score for Player 1 by 2 points.
     */

    public void addTwoPlayerOne (View view) {
        scorePlayerOne = scorePlayerOne + 2;
        displayForPlayerOne(scorePlayerOne);
    }

    /**
     * Increase the score for Player 1 by 3 points.
     */

    public void addThreePlayerOne (View view) {
        scorePlayerOne = scorePlayerOne + 3;
        displayForPlayerOne(scorePlayerOne);
    }

    /**
     * Increase the score for Player 1 by 4 points.
     */

    public void addFourPlayerOne (View view) {
        scorePlayerOne = scorePlayerOne + 4;
        displayForPlayerOne(scorePlayerOne);
    }

    /**
     * Increase the score for Player 1 by 5 points.
     */

    public void addFivePlayerOne (View view) {
        scorePlayerOne = scorePlayerOne + 5;
        displayForPlayerOne(scorePlayerOne);
    }

    /**
     * Increase the score for Player 1 by 6 points.
     */

    public void addSixPlayerOne (View view) {
        scorePlayerOne = scorePlayerOne + 6;
        displayForPlayerOne(scorePlayerOne);
    }

    /**
     * Increase the score for Player 1 by 7 points.
     */

    public void addSevenPlayerOne (View view) {
        scorePlayerOne = scorePlayerOne + 7;
        displayForPlayerOne(scorePlayerOne);
    }

    /**
     * Increase the score for Player 2 by 1 point.
     */

    public void addOnePlayerTwo (View view) {
        scorePlayerTwo = scorePlayerTwo + 1;
        displayForPlayerTwo(scorePlayerTwo);
    }

    /**
     * Increase the score for Player 2 by 2 points.
     */

    public void addTwoPlayerTwo (View view) {
        scorePlayerTwo = scorePlayerTwo + 2;
        displayForPlayerTwo(scorePlayerTwo);
    }

    /**
     * Increase the score for Player 2 by 3 points.
     */

    public void addThreePlayerTwo (View view) {
        scorePlayerTwo = scorePlayerTwo + 3;
        displayForPlayerTwo(scorePlayerTwo);
    }

    /**
     * Increase the score for Player 2 by 4 points.
     */

    public void addFourPlayerTwo (View view) {
        scorePlayerTwo = scorePlayerTwo + 4;
        displayForPlayerTwo(scorePlayerTwo);
    }

    /**
     * Increase the score for Player 2 by 5 points.
     */

    public void addFivePlayerTwo (View view) {
        scorePlayerTwo = scorePlayerTwo + 5;
        displayForPlayerTwo(scorePlayerTwo);
    }

    /**
     * Increase the score for Player 2 by 6 points.
     */

    public void addSixPlayerTwo (View view) {
        scorePlayerTwo = scorePlayerTwo + 6;
        displayForPlayerTwo(scorePlayerTwo);
    }

    /**
     * Increase the score for Player 2 by 7 points.
     */

    public void addSevenPlayerTwo (View view) {
        scorePlayerTwo = scorePlayerTwo + 7;
        displayForPlayerTwo(scorePlayerTwo);
    }

    /**
     * Displays the given score for Player 1.
     */
    public void displayForPlayerOne (int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_1_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player 2.
     */
    public void displayForPlayerTwo (int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_2_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Set the game info to final result.
     */

    public void gameResult (View view) {
        if (scorePlayerOne > scorePlayerTwo) {
            gameInfo = "Player 1 wins.";
            displayInfo(gameInfo);
        } else if (scorePlayerOne < scorePlayerTwo) {
            gameInfo = "Player 2 wins.";
            displayInfo(gameInfo);
        } else {
            gameInfo = "It's a draw.";
            displayInfo(gameInfo);
        }
    }

    /**
     * Displays the game info.
     */
    public  void displayInfo (String info) {
        TextView infoView = (TextView) findViewById(R.id.info);
        infoView.setText(info);
    }
}
