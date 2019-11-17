package com.example.android.tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeScreen extends AppCompatActivity
{
    Button btnFriend, btnComputer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        btnComputer = findViewById(R.id.btnComputer);
        btnFriend = findViewById(R.id.btnFriend);

        btnFriend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(WelcomeScreen.this, PlayWithFriendActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnComputer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(WelcomeScreen.this, PlayWithComputerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
