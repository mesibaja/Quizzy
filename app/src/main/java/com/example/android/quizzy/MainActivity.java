package com.example.android.quizzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.quizzy.R;

public class MainActivity extends AppCompatActivity {

    // Free text answer for Question 1
    private EditText mQuestion1AnswerEditText;

    // Correct CheckBox options for Question 2
    private CheckBox mQuestion2IncorrectAnswer1CheckBox;
    private CheckBox mQuestion2CorrectAnswer1CheckBox;
    private CheckBox mQuestion2CorrectAnswer2CheckBox;

    // Correct RadioButton option for Question 3
    private RadioButton mQuestion3CorrectAnswerRadioButton;

    private EditText mQuestion4AnswerEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcos);

        // Bind Question 1 answer
        mQuestion1AnswerEditText = (EditText) findViewById(R.id.et_question1_answer);

        // Bind Question 2 correct answers and the 1 incorrect answer
        mQuestion2IncorrectAnswer1CheckBox = (CheckBox) findViewById(R.id.cb_question2_incorrect_answer_1);
        mQuestion2CorrectAnswer1CheckBox = (CheckBox) findViewById(R.id.cb_question2_correct_answer_1);
        mQuestion2CorrectAnswer2CheckBox = (CheckBox) findViewById(R.id.cb_question2_correct_answer_2);

        // Bind Question 3 correct answer
        mQuestion3CorrectAnswerRadioButton = (RadioButton) findViewById(R.id.rb_question3_correct_answer);

        // Bind Question 4 answer
        mQuestion4AnswerEditText = (EditText) findViewById(R.id.et_question4_answer);

    }

    public void onClickSubmit(View view) {
        int numberOfCorrectAnswers = 0;

        // Evaluate Question 1
        // Get the answer for question 1
        String question1Answer = mQuestion1AnswerEditText.getText().toString();
        // Checks if it is equal to the correct answer that is stored in the strings.xml
        if (question1Answer.equals(getString(R.string.question_1_correct_answer))) {
            numberOfCorrectAnswers++;
        }

        if (!mQuestion2IncorrectAnswer1CheckBox.isChecked() &&
                mQuestion2CorrectAnswer1CheckBox.isChecked() &&
                mQuestion2CorrectAnswer2CheckBox.isChecked()) {
            numberOfCorrectAnswers++;
        }

        if (mQuestion3CorrectAnswerRadioButton.isChecked()) {
            numberOfCorrectAnswers++;
        }

        String question4Answer = mQuestion1AnswerEditText.getText().toString();
        // Checks if it is equal to the correct answer that is stored in the strings.xml
        if (question1Answer.equals(getString(R.string.question4_correct_answer))) {
            numberOfCorrectAnswers++;
        }

        if (numberOfCorrectAnswers < 2) {
            Toast.makeText(this, "Points reached: less than 2. Not bad but you need more practice in order to stay healthy.", Toast.LENGTH_LONG).show();
        } else if (numberOfCorrectAnswers < 3) {
            Toast.makeText(this, "Points reached: less than 3. Well done! You made it quite good but there is always room for improvement!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Points reached: more than 3. Excellent! You have a big chance to stay healthy!", Toast.LENGTH_LONG).show();
        }
    }
}