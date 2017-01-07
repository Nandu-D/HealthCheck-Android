package com.example.android.practiceset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String[] message = {"Do you exercise once or more per week",
      "Do you drink atleast 2L of water everyday",
      "Do you do Yoga everyday",
      "Do you eat a balanced diet",
      "Do you sleep for atleast 6 hrs"
    };
    int qn_no = 0, score=0;


    public void answered_yes(View view) {
        score++;
        qn_no++;

        if(qn_no<6) {
            nextQuestion();
        }
    }

    public void answered_sometimes(View view) {
        qn_no++;
        if(qn_no<6) {
            nextQuestion();
        }
    }

    public void answered_no(View view) {
        score--;
        qn_no++;
        if (qn_no<6) {
            nextQuestion();
        }

    }

    public void reset(View view) {
        score=0;
        qn_no=0;
        nextQuestion();
    }

    private void nextQuestion() {
        String displayMessage;
        TextView questionTextView = (TextView) findViewById(R.id.question_text_view);
        if (qn_no<=3) {
            displayMessage = message[qn_no] + "\nYour current score = " + score;
            questionTextView.setText(displayMessage);
        }
        else if (qn_no == 4) {
            displayMessage = message[qn_no] + "\nYour final score is " + score;
            questionTextView.setText(displayMessage);
        }
        else {
            questionTextView.setText("Your final score is " + score);
        }
    }


}
