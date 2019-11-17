package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayWithComputerActivity extends Activity implements View.OnClickListener
{

    boolean playerTurn = true; // true = X & false = O
    int turnCount = 0, playerCount = 0, computerCount = 0;
    Button[] bArray = null;
    Button a1, a2, a3, b1, b2, b3, c1, c2, c3;
    TextView tvTurnIndicator, playerPlayedTurns, computerPlayedTurns;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_with_computer);
        a1 = (Button) findViewById(R.id.A1);
        b1 = (Button) findViewById(R.id.B1);
        c1 = (Button) findViewById(R.id.C1);
        a2 = (Button) findViewById(R.id.A2);
        b2 = (Button) findViewById(R.id.B2);
        c2 = (Button) findViewById(R.id.C2);
        a3 = (Button) findViewById(R.id.A3);
        b3 = (Button) findViewById(R.id.B3);
        c3 = (Button) findViewById(R.id.C3);
        tvTurnIndicator = findViewById(R.id.tvTurnIndicator);
        playerPlayedTurns = findViewById(R.id.playerPlayedTurns);
        computerPlayedTurns = findViewById(R.id.computerPlayedTurns);

        bArray = new Button[] { a1, a2, a3, b1, b2, b3, c1, c2, c3 };

        for (Button b : bArray)
        {
            b.setOnClickListener(this);
        }
        Button bnew = (Button) findViewById(R.id.button1);
        bnew.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                playerTurn = true;
                turnCount = 0;
                Intent intent = new Intent(PlayWithComputerActivity.this, WelcomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        buttonClicked(v);
    }

    private void buttonClicked(View v)
    {
        Button b = (Button) v;
        if (playerTurn)
        {
            tvTurnIndicator.setText("Player's Turn");
            // Player's playerTurn -- P
            playerCount++;
            b.setText("P");
            String playerTurn= "Player Played : " + String.valueOf(playerCount);
            playerPlayedTurns.setText(playerTurn);
        }
        else
        {
            // Computer's playerTurn -- C
            tvTurnIndicator.setText("Computer's Turn");
            computerCount++;
            b.setText("C");
            String computerTurn= "Computer Played : " + String.valueOf(computerCount);
            computerPlayedTurns.setText(computerTurn);
        }
        turnCount++;
        b.setClickable(false);
        b.setBackgroundResource(R.drawable.button_selected_background);
        playerTurn = !playerTurn;

        checkForWinner();
    }

    private void checkForWinner()
    {

        boolean there_is_a_winner = false;

        // horizontal:
        if (a1.getText() == a2.getText() && a2.getText() == a3.getText()
                && !a1.isClickable())
        {
            there_is_a_winner = true;
        }
        else if (b1.getText() == b2.getText() && b2.getText() == b3.getText()
                && !b1.isClickable())
        {
            there_is_a_winner = true;
        }
        else if (c1.getText() == c2.getText() && c2.getText() == c3.getText()
                && !c1.isClickable())
        {
            there_is_a_winner = true;
        }

        // vertical:
        else if (a1.getText() == b1.getText() && b1.getText() == c1.getText()
                && !a1.isClickable())
        {
            there_is_a_winner = true;
        }
        else if (a2.getText() == b2.getText() && b2.getText() == c2.getText()
                && !b2.isClickable())
        {
            there_is_a_winner = true;
        }
        else if (a3.getText() == b3.getText() && b3.getText() == c3.getText()
                && !c3.isClickable())
        {
            there_is_a_winner = true;
        }

        // diagonal:
        else if (a1.getText() == b2.getText() && b2.getText() == c3.getText()
                && !a1.isClickable())
        {
            there_is_a_winner = true;
        }
        else if (a3.getText() == b2.getText() && b2.getText() == c1.getText()
                && !b2.isClickable())
        {
            there_is_a_winner = true;
        }
        // i repeat.. DO NOT TRY THIS AT HOME

        if (there_is_a_winner)
        {
            if (!playerTurn)
            {
                message("Player wins");
                tvTurnIndicator.setText("Player wins");
            }
            else
            {
                message("Computer wins");
                tvTurnIndicator.setText("Computer wins");
            }
            enableOrDisable(false);
        }
        else if (turnCount == 9)
        {
            message("Draw!");
            tvTurnIndicator.setText("Draw");
        }
    }

    private void message(String text)
    {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
                .show();
    }

    private void enableOrDisable(boolean enable)
    {

        for (Button b : bArray)
        {
            b.setClickable(enable);
            if (enable)
            {
                b.setBackgroundColor(Color.parseColor("#33b5e5"));
            }
            else
            {
                b.setBackgroundResource(R.drawable.button_selected_background);
            }
        }
    }
}
