package com.example.jkakeno.whichanimal.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jkakeno.whichanimal.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Math.*;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private TextView mQuestionTextView;
    private Button mSubmit;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    int count = 0;
    int selection;
    int dolphinSum = 0;
    int elephantSum = 0;
    int monkeySum = 0;
    int redpandaSum = 0;
    int tigerSum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
//Create a resource object
        Resources res = getResources();
//Use the resource object to point to the question resource and build the questions array
        final String[] questions = res.getStringArray(R.array.questions);
        final int[] selections = new int[questions.length];
        final int[] dolphinAnswers = res.getIntArray(R.array.dolphin_answer);
        final int[] elephantAnswers = res.getIntArray(R.array.elephant_answer);
        final int[] monkeyAnswers = res.getIntArray(R.array.monkey_answer);
        final int[] redpandaAnswers = res.getIntArray(R.array.redpanda_answer);
        final int[] tigerAnswers = res.getIntArray(R.array.tiger_answer);
        final int[] dolphinDifference = new int[selections.length];
        final int[] elephantDifference = new int[selections.length];
        final int[] monkeyDifference = new int[selections.length];
        final int[] redpandaDifference = new int[selections.length];
        final int[] tigerDifference = new int[selections.length];

        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mSubmit = (Button) findViewById(R.id.submit);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);

//Load question[0] initially
//Assign the question string to question in the nth place of the array defined by count
        String question = questions[count];
//Apply the question string to the text view
        mQuestionTextView.setText(question);

        final View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        selection = 1;
                        break;

                    case R.id.button2:
                        selection = 2;
                        break;

                    case R.id.button3:
                        selection = 3;
                        break;

                    case R.id.button4:
                        selection = 4;
                        break;

                    case R.id.button5:
                        selection = 5;
                        break;

                    case R.id.submit:
//Only apply user selection to selections[] when the selection is not 0 to prevent 0 be added to the array when user presses submit without making a selection
                        if (selection != 0) {
//Get the user selection defined by the switch statement of the buttons above and apply each selection to an array called selections[] at the nth place of the array
                            selections[count] = selection;

//Compared how close selection is from answer by subtracting answers[] from selections[] and putting the result into difference[]
                            dolphinDifference[count] = dolphinAnswers[count] - selections[count];
                            elephantDifference[count] = elephantAnswers[count] - selections[count];
                            monkeyDifference[count] = monkeyAnswers[count] - selections[count];
                            redpandaDifference[count] = redpandaAnswers[count] - selections[count];
                            tigerDifference[count] = tigerAnswers[count] - selections[count];

//Make the difference an absolute value
                            if (dolphinDifference[count] < 0) {
                                dolphinDifference[count] *= -1;
                            }
                            if (elephantDifference[count] < 0) {
                                elephantDifference[count] *= -1;
                            }
                            if (monkeyDifference[count] < 0) {
                                monkeyDifference[count] *= -1;
                            }
                            if (redpandaDifference[count] < 0) {
                                redpandaDifference[count] *= -1;
                            }
                            if (tigerDifference[count] < 0) {
                                tigerDifference[count] *= -1;
                            }
//Print all arrays to the log to verify the data is placed in each array as intended
                            Log.d(TAG, "selections is:" + Arrays.toString(selections));
                            Log.d(TAG, "dolphin answers is:" + Arrays.toString(dolphinAnswers));
                            Log.d(TAG, "dolphin difference is:" + Arrays.toString(dolphinDifference));
                            Log.d(TAG, "elephant answers is:" + Arrays.toString(elephantAnswers));
                            Log.d(TAG, "elephant difference is:" + Arrays.toString(elephantDifference));
                            Log.d(TAG, "monkey answers is:" + Arrays.toString(monkeyAnswers));
                            Log.d(TAG, "monkey difference is:" + Arrays.toString(monkeyDifference));
                            Log.d(TAG, "redpanda answers is:" + Arrays.toString(redpandaAnswers));
                            Log.d(TAG, "redpanda difference is:" + Arrays.toString(redpandaDifference));
                            Log.d(TAG, "tiger answers is:" + Arrays.toString(tigerAnswers));
                            Log.d(TAG, "tiger difference is:" + Arrays.toString(tigerDifference));
//Sum all the values in difference[] and return the total
                            dolphinSum = dolphinDifference[0] + dolphinDifference[1] + dolphinDifference[2] + dolphinDifference[3] + dolphinDifference[4];
                            elephantSum = elephantDifference[0] + elephantDifference[1] + elephantDifference[2] + elephantDifference[3] + elephantDifference[4];
                            monkeySum = monkeyDifference[0] + monkeyDifference[1] + monkeyDifference[2] + monkeyDifference[3] + monkeyDifference[4];
                            redpandaSum = redpandaDifference[0] + redpandaDifference[1] + redpandaDifference[2] + redpandaDifference[3] + redpandaDifference[4];
                            tigerSum = tigerDifference[0] + tigerDifference[1] + tigerDifference[2] + tigerDifference[3] + tigerDifference[4];

//Display the sum of the difference for each animal
                            Log.d(TAG, "dolphin sum is:" + dolphinSum + "   elephant sum is:" + elephantSum + "   monkey sum is:" + monkeySum + "   redpanda sum is:" + redpandaSum + "   tiger sum is:" + tigerSum);

//Increment the count to control the place where data is placed in the arrays, this runs after the 1st submit button press
                            if (count == questions.length - 1) {

//Pass the drawable Id of the drawable resource to displayAnimal()
//Display dolphin if the dolphin has the lowest sum
                                if (dolphinSum == min(dolphinSum, min(elephantSum, min(monkeySum, min(redpandaSum, tigerSum))))) {

                                    Toast.makeText(MainActivity.this, "You are a dolphin", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "You are a dolphin");
                                    String mDrawableName = "dolphin";
                                    int animalId = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
                                    displayAnimal(animalId);
                                    Log.d(TAG, "resId is:" + animalId);
                                }
//Display elephant if the elephant has the lowest sum
                                if (elephantSum == min(elephantSum, min(dolphinSum, min(monkeySum, min(redpandaSum, tigerSum))))) {
                                    Toast.makeText(MainActivity.this, "You are an elephant", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "You are an elephant");
                                    String mDrawableName = "elephant";
                                    int animalId = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
                                    displayAnimal(animalId);
                                    Log.d(TAG, "resId is:" + animalId);
                                }
//Display elephant if the elephant has the lowest sum
                                if (monkeySum == min(monkeySum, min(elephantSum, min(dolphinSum, min(redpandaSum, tigerSum))))) {
                                    Toast.makeText(MainActivity.this, "You are a monkey", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "You are a monkey");
                                    String mDrawableName = "monkey";
                                    int animalId = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
                                    displayAnimal(animalId);
                                    Log.d(TAG, "resId is:" + animalId);
                                }
//Display elephant if the elephant has the lowest sum
                                if (redpandaSum == min(redpandaSum, min(monkeySum, min(elephantSum, min(dolphinSum, tigerSum))))) {
                                    Toast.makeText(MainActivity.this, "You are a redpanda", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "You are a redpanda");
                                    String mDrawableName = "redpanda";
                                    int animalId = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
                                    displayAnimal(animalId);
                                    Log.d(TAG, "resId is:" + animalId);
                                }
//Display elephant if the elephant has the lowest sum
                                if (tigerSum == min(tigerSum, min(redpandaSum, min(monkeySum, min(elephantSum, dolphinSum))))) {
                                    Toast.makeText(MainActivity.this, "You are a tiger", Toast.LENGTH_SHORT).show();
                                    Log.d(TAG, "You are a tiger");
                                    String mDrawableName = "tiger";
                                    int animalId = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
                                    displayAnimal(animalId);
                                    Log.d(TAG, "resId is:" + animalId);
                                }
                                count = 0;
//Reset sum [] once the count reaches the number of questions
//selections.clear() can't be used with Arrays need ArrayList to use this method
                                dolphinSum = 0;
                                elephantSum = 0;
                                monkeySum = 0;
                                redpandaSum = 0;
                                tigerSum = 0;
                                Log.d(TAG, "dolphin sum is:" + dolphinSum + "   elephant sum is:" + elephantSum + "   monkey sum is:" + monkeySum + "   redpanda sum is:" + redpandaSum + "   tiger sum is:" + tigerSum);
                            } else {
                                count++;
//Gets the questions from the resources and apply to the text view
//Assign the question string to question in the nth place of the array defined by count
                                String question = questions[count];
//Apply the question string to the text view
                                mQuestionTextView.setText(question);
                            }
                        }
                        break;
                }
            }
            private void displayAnimal(int animalId){
                Intent intent = new Intent(MainActivity.this,AnimalActivity.class);
                intent.putExtra("animal",animalId);
                startActivity(intent);
            }
        };
        mButton1.setOnClickListener(listener);
        mButton2.setOnClickListener(listener);
        mButton3.setOnClickListener(listener);
        mButton4.setOnClickListener(listener);
        mButton5.setOnClickListener(listener);
        mSubmit.setOnClickListener(listener);
    }
}
