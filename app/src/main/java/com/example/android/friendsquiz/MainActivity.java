package com.example.android.friendsquiz;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quizScore;

    boolean isSmallestScreenWidthDp600;
    boolean isPhonePortrait;
    boolean isPhoneLandscape;

    ScrollView scrollView;

    EditText nameField;
    TextView showName;
    Button buttonStart;

    Button buttonQ1;
    Button buttonQ2;
    Button buttonQ3;
    Button buttonQ4;
    Button buttonQ5;
    Button buttonQ6;
    Button buttonQ7;
    Button buttonQ8;
    Button buttonQ9;
    Button buttonQ10;

    View question1;
    View question2;
    View question3;
    View question4;
    View question5;
    View question6;
    View question7;
    View question8;
    View question9;
    View question10;

    View endOf1;
    View endOf2;
    View endOf3;
    View endOf4;
    View endOf5;
    View endOf6;
    View endOf7;
    View endOf8;
    View endOf9;
    View endOf10;

    CheckBox answerQ1A1;
    CheckBox answerQ1A2;
    CheckBox answerQ1A3;
    CheckBox answerQ1A4;
    RadioButton answerQ2A3;
    RadioButton answerQ3A4;
    CheckBox answerQ4A1;
    CheckBox answerQ4A2;
    CheckBox answerQ4A3;
    CheckBox answerQ4A4;
    EditText answerQ5A1;
    RadioButton answerQ6A1;
    RadioButton answerQ7A4;
    RadioButton answerQ8A1;
    RadioButton answerQ9A2;
    RadioButton answerQ10A4;

    View mainLinear;

    View bgImage;
    View group456;

    /**
     * "Q" is for Question
     * "A" is for Answer
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.main_scroll_view);

        nameField = findViewById(R.id.name_field);
        showName = findViewById(R.id.show_name);
        buttonStart = findViewById(R.id.start_quiz);

        buttonQ1 = findViewById(R.id.button_q1);
        buttonQ2 = findViewById(R.id.button_q2);
        buttonQ3 = findViewById(R.id.button_q3);
        buttonQ4 = findViewById(R.id.button_q4);
        buttonQ5 = findViewById(R.id.button_q5);
        buttonQ6 = findViewById(R.id.button_q6);
        buttonQ7 = findViewById(R.id.button_q7);
        buttonQ8 = findViewById(R.id.button_q8);
        buttonQ9 = findViewById(R.id.button_q9);
        buttonQ10 = findViewById(R.id.button_q10);

        question1 = findViewById(R.id.question_1);
        question2 = findViewById(R.id.question_2);
        question3 = findViewById(R.id.question_3);
        question4 = findViewById(R.id.question_4);
        question5 = findViewById(R.id.question_5);
        question6 = findViewById(R.id.question_6);
        question7 = findViewById(R.id.question_7);
        question8 = findViewById(R.id.question_8);
        question9 = findViewById(R.id.question_9);
        question10 = findViewById(R.id.question_10);

        endOf1 = findViewById(R.id.end_of_1);
        endOf2 = findViewById(R.id.end_of_2);
        endOf3 = findViewById(R.id.end_of_3);
        endOf4 = findViewById(R.id.end_of_4);
        endOf5 = findViewById(R.id.end_of_5);
        endOf6 = findViewById(R.id.end_of_6);
        endOf7 = findViewById(R.id.end_of_7);
        endOf8 = findViewById(R.id.end_of_8);
        endOf9 = findViewById(R.id.end_of_9);
        endOf10 = findViewById(R.id.end_of_10);

        answerQ1A1 = findViewById(R.id.Q1A1);
        answerQ1A2 = findViewById(R.id.Q1A2);
        answerQ1A3 = findViewById(R.id.Q1A3);
        answerQ1A4 = findViewById(R.id.Q1A4);
        answerQ2A3 = findViewById(R.id.Q2A3);
        answerQ3A4 = findViewById(R.id.Q3A4);
        answerQ4A1 = findViewById(R.id.Q4A1);
        answerQ4A2 = findViewById(R.id.Q4A2);
        answerQ4A3 = findViewById(R.id.Q4A3);
        answerQ4A4 = findViewById(R.id.Q4A4);
        answerQ5A1 = findViewById(R.id.Q5A1);
        answerQ6A1 = findViewById(R.id.Q6A1);
        answerQ7A4 = findViewById(R.id.Q7A4);
        answerQ8A1 = findViewById(R.id.Q8A1);
        answerQ9A2 = findViewById(R.id.Q9A2);
        answerQ10A4 = findViewById(R.id.Q10A4);

        mainLinear = findViewById(R.id.main_linear);

        bgImage = findViewById(R.id.bg_image);
        group456 = findViewById(R.id.group_456);

        isSmallestScreenWidthDp600 = getResources().getConfiguration().smallestScreenWidthDp >= 600;
        isPhonePortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        isPhoneLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

    }

    public void startQuiz(View view) {

        // Get user submitted name to string:

        String getNameField = nameField.getText().toString();

        // Update the message shown at the end:

        showName.setText(getString(R.string.are_you_ready) + " " + getNameField + '?');

        // If there is no name, show error & disable first question

        if (TextUtils.isEmpty(getNameField)) {
            nameField.setError(getString(R.string.name_error));
            buttonQ1.setEnabled(false);

            // If there is a name, disable the start button & scroll to the first question

        } else {

            buttonStart.setEnabled(false);
            buttonQ1.setEnabled(true);

            if (isSmallestScreenWidthDp600)

            {

                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, bgImage.getBottom());
                    }
                }, 100);

            } else {

                if (isPhonePortrait)

                {
                    scrollView.postDelayed(new Runnable() {
                        public void run() {
                            scrollView.scrollBy(0, question1.getTop());
                        }
                    }, 100);
                }

                // If orientation is horizontal, scroll to the bottom (!) of first question:

                else if (isPhoneLandscape)

                {
                    scrollView.postDelayed(new Runnable() {
                        public void run() {
                            scrollView.scrollTo(0, endOf1.getTop());
                        }
                    }, 100);
                }
            }

        }
    }

    /**
     * ***** ***** ***** Question nr. 1 ***** ***** *****
     */

    public void submitAnswer1(View view) {

        // Get user submitted answer:

        boolean isCheckedQ1A1 = answerQ1A1.isChecked();
        boolean isCheckedQ1A2 = answerQ1A2.isChecked();
        boolean isCheckedQ1A3 = answerQ1A3.isChecked();
        boolean isCheckedQ1A4 = answerQ1A4.isChecked();

        // Check if the answer is correct & update the quiz score:

        if ((!isCheckedQ1A1) && isCheckedQ1A2 && isCheckedQ1A3 && isCheckedQ1A4) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ1.setEnabled(false);

        // Finish here & scroll to the next question:

        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, bgImage.getBottom());
                }
            }, 100);

        } else {
            // If orientation is vertical, scroll to the top (!) of next question:

            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question2.getTop());
                    }
                }, 100);
            }

            // If orientation is horizontal, scroll to the bottom (!) of next question:

            else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf2.getBottom());
                    }
                }, 100);
            }
        }

    }

    /**
     * ***** ***** ***** Question nr. 2 ***** ***** *****
     */

    public void submitAnswer2(View view) {

        boolean isCheckedQ2A3 = answerQ2A3.isChecked();

        // Check if the answer is correct & update the quiz score:

        if (isCheckedQ2A3) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ2.setEnabled(false);

        // Finish here & scroll to the next question:

        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, bgImage.getBottom());
                }
            }, 100);

        } else {

            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question3.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf3.getTop());
                    }
                }, 100);
            }

        }
    }

    /**
     * ***** ***** ***** Question nr. 3 ***** ***** *****
     */

    public void submitAnswer3(View view) {

        boolean isCheckedQ3A4 = answerQ3A4.isChecked();

        // Check if the answer is correct & update the quiz score:

        if (isCheckedQ3A4) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ3.setEnabled(false);

        // Finish here & scroll to the next question:

        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, group456.getTop());
                }
            }, 100);

        } else {

            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question4.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf4.getBottom());
                    }
                }, 100);
            }

        }
    }

    /**
     * ***** ***** ***** Question nr. 4 ***** ***** *****
     */

    public void submitAnswer4(View view) {

        // Get user submitted answer:

        boolean isCheckedQ4A1 = answerQ4A1.isChecked();
        boolean isCheckedQ4A2 = answerQ4A2.isChecked();
        boolean isCheckedQ4A3 = answerQ4A3.isChecked();
        boolean isCheckedQ4A4 = answerQ4A4.isChecked();

        // Check if the answer is correct & update the quiz score:

        if (isCheckedQ4A1 && (!isCheckedQ4A2) && isCheckedQ4A3 && isCheckedQ4A4) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ4.setEnabled(false);

        // Finish here & scroll to the next question:

        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, group456.getTop());
                }
            }, 100);

        } else {

            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question5.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf5.getBottom());
                    }
                }, 100);
            }

        }
    }

    /**
     * ***** ***** ***** Question nr. 5 ***** ***** *****
     */

    public void submitAnswer5(View view) {

        // Check if the answer is correct & update the quiz score:

        if (answerQ5A1.getText().toString().equals("Gunther")) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ5.setEnabled(false);

        // Finish here & scroll to the next question:

        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, group456.getTop());
                }
            }, 100);

        } else {

            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question6.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf6.getBottom());
                    }
                }, 100);
            }
        }
    }

    /**
     * ***** ***** ***** Question nr. 6 ***** ***** *****
     */

    public void submitAnswer6(View view) {

        boolean isCheckedQ6A1 = answerQ6A1.isChecked();

        // Check if the answer is correct & update the quiz score:

        if (isCheckedQ6A1) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ6.setEnabled(false);

        // Finish here & scroll to the next question:
        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, group456.getBottom());
                }
            }, 100);

        } else {
            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question7.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf7.getBottom());
                    }
                }, 100);
            }
        }
    }

    /**
     * ***** ***** ***** Question nr. 7 ***** ***** *****
     */

    public void submitAnswer7(View view) {

        boolean isCheckedQ7A4 = answerQ7A4.isChecked();

        // Check if the answer is correct & update the quiz score:

        if (isCheckedQ7A4) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ7.setEnabled(false);

        // Finish here & scroll to the next question:
        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, group456.getBottom());
                }
            }, 100);

        } else {
            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question8.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf8.getBottom());
                    }
                }, 100);
            }

        }
    }

    /**
     * ***** ***** ***** Question nr. 8 ***** ***** *****
     */

    public void submitAnswer8(View view) {

        boolean isCheckedQ8A1 = answerQ8A1.isChecked();

        // Check if the answer is correct & update the quiz score:

        if (isCheckedQ8A1) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ8.setEnabled(false);

        // Finish here & scroll to the next question:
        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, group456.getBottom());
                }
            }, 100);

        } else {
            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question9.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf9.getBottom());
                    }
                }, 100);
            }

        }
    }

    /**
     * ***** ***** ***** Question nr. 9 ***** ***** *****
     */

    public void submitAnswer9(View view) {

        boolean isCheckedQ9A2 = answerQ9A2.isChecked();

        // Check if the answer is correct & update the quiz score:

        if (isCheckedQ9A2) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ9.setEnabled(false);

        // Finish here & scroll to the next question:
        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, mainLinear.getBottom());
                }
            }, 100);

        } else {
            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, question10.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, endOf10.getBottom());
                    }
                }, 100);
            }
        }
    }

    /**
     * ***** ***** ***** Question nr. 10 ***** ***** *****
     */

    public void submitAnswer10(View view) {

        boolean isCheckedQ10A4 = answerQ10A4.isChecked();

        // Check if the answer is correct & update the quiz score:

        if (isCheckedQ10A4) {
            quizScore = quizScore + 1;
            Log.v("MainActivity", "Score is " + quizScore);
        }

        // Prevent multiple answer submitting:

        buttonQ10.setEnabled(false);

        // Finish here & scroll to the end:
        if (isSmallestScreenWidthDp600)

        {
            scrollView.postDelayed(new Runnable() {
                public void run() {
                    scrollView.scrollTo(0, mainLinear.getBottom());
                }
            }, 100);

        } else {
            if (isPhonePortrait)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, showName.getTop());
                    }
                }, 100);
            } else if (isPhoneLandscape)

            {
                scrollView.postDelayed(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(0, mainLinear.getBottom());
                    }
                }, 100);
            }

        }
    }

    /**
     * Show the quiz score toast:
     */

    public void buttonScore(View view) {

        if (quizScore == 10) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.you_scored).toUpperCase() + " " + quizScore + " " + getString(R.string.out_of_10).toUpperCase() + "\n\n\n" + getString(R.string.how_you_doin), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        if (quizScore > 5 && quizScore < 10) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.you_scored).toUpperCase() + " " + quizScore + " " + getString(R.string.out_of_10).toUpperCase() + "\n\n\n" + getString(R.string.they_dont_know), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        if (quizScore <= 5) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.you_scored).toUpperCase() + " " + quizScore + " " + getString(R.string.out_of_10).toUpperCase() + "\n\n\n" + getString(R.string.big_deal), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }

    /**
     * ***** ***** ***** Reset quiz: ***** ***** *****
     */

    public void buttonReset(View view) {
        Intent i = getApplicationContext().getPackageManager()
                .getLaunchIntentForPackage(getApplicationContext().getPackageName());

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

    }

}
