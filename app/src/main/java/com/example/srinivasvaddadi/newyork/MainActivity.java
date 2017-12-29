package com.example.srinivasvaddadi.newyork;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView quizImageView;
    Button inNYCButton,notInNYCButton;
    boolean isInNewyork;
    int imageArray[];
    boolean answers[];
    int count;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        score = 0;

        imageArray = new int[]{R.drawable.num0,R.drawable.num1,R.drawable.num2,R.drawable.num3,R.drawable.num4,R.drawable.num5,R.drawable.num6,R.drawable.num7,R.drawable.num8,R.drawable.num9};
        answers = new boolean[]{false,true,true,true,true,true,true,true,true,false};



        quizImageView = (ImageView)findViewById(R.id.imageView);
        inNYCButton = (Button)findViewById(R.id.button1);
        notInNYCButton = (Button)findViewById(R.id.button2);

        quizImageView.setImageResource(imageArray[count]);


        inNYCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isInNewyork = true;
                checkAnswer();
            }
        });

        notInNYCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isInNewyork = false;
                checkAnswer();
            }
        });


    }

    private void checkAnswer() {
        if (answers[count] == isInNewyork) {
            score++;
        }
        if (count == answers.length-1){
            // Toast.makeText(this, String.valueOf(score),Toast.LENGTH_SHORT).show();

            // Go to Another activity and pass the score to that activity

            Intent intent = new Intent(this,ScoreActivity.class);
            intent.putExtra("score",score);
            startActivity(intent);

        }else {
            count++;
            quizImageView.setImageResource(imageArray[count]);
        }
    }


}
