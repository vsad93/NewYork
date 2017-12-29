package com.example.srinivasvaddadi.newyork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreTextView;
    Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreTextView = (TextView)findViewById(R.id.textView2);
        restartButton = (Button)findViewById(R.id.button1);
        Intent intent =  getIntent();
        int score = intent.getIntExtra("score",0);

        if(score>7){
            scoreTextView.setText("Your score is "+score+" out of 10 and "+"you are a true newyorker");
        }else{
            scoreTextView.setText("Your score is "+score+" out of 10");
        }

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}

