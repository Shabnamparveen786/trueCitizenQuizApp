package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private Button nextButton;
    private TextView questionTextView;

    private int currentQuestionIndex = 0;



    private Question[] questionBank = new Question[]{
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.Question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion,true),
            new Question(R.string.question_government,false),
            new Question(R.string.question_government_feds,false),
            new Question(R.string.question_gevernment_senators,true),

    };
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // Question question = new Question(R.string.Question_declaration, true);
        
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.answer_text_view);
//        falseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                
//            }
//        });
        
        falseButton.setOnClickListener(this); //register our buttons to listen to click events
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.false_button:
                checkAnswer(false);
              //  Toast.makeText(MainActivity.this, "False",
                //        Toast.LENGTH_SHORT).show();
                break;
            case R.id.true_button:
                checkAnswer(true);
                //Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
                break;

            case R.id.next_button:
                //currentQuestionIndex++;
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
               // Log.d("Current","onClick:" + currentQuestionIndex);
                //questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
                updateQuestion();
        }
    }

         private void updateQuestion(){
             Log.d("Current","onClick:" + currentQuestionIndex);
             questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());

         }

         private void checkAnswer(boolean userChooseCorrect){
               boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
               int toastMessageId;

               if(userChooseCorrect == answerIsTrue){
                   toastMessageId = R.string.correct_answer;
               }else{
                   toastMessageId = R.string.wrong_answer;
               }

               Toast.makeText(MainActivity.this,toastMessageId,Toast.LENGTH_SHORT).show();
         }
}
