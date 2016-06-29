package com.rongma.tarot;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTvQuestion;
    private Button mBtnTrue;
    private Button mBtnFalse;
    private ImageView mIvPre;
    private ImageView mIvNext;
    private ArrayList<Question> questions;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvQuestion = (TextView) findViewById(R.id.tv_question);
        mBtnTrue = (Button) findViewById(R.id.btn_true);
        mBtnFalse = (Button) findViewById(R.id.btn_false);
        mIvPre = (ImageView) findViewById(R.id.iv_pre);
        mIvNext = (ImageView) findViewById(R.id.iv_next);
        mTvQuestion.setOnClickListener(this);
        mBtnTrue.setOnClickListener(this);
        mBtnFalse.setOnClickListener(this);
        mIvNext.setOnClickListener(this);
        mIvPre.setOnClickListener(this);
        questions = new ArrayList<Question>();
        questions.add(new Question("塔罗牌有100张",false));
        questions.add(new Question("塔罗牌分为主牌和副牌",true));
        questions.add(new Question("0号牌是法师",false));
        questions.add(new Question("塔罗牌不需要切牌",false));
        questions.add(new Question("塔罗牌的英文:Tarot",true));
        questions.add(new Question("塔罗牌不可以拍照",false));
        mTvQuestion.setText(questions.get(index).getResouceText());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tv_question:
                //到下一题
                turnNextQuestion();
                break;
            case R.id.btn_true:
                checkQuestion(true);
                break;
            case R.id.btn_false:
                checkQuestion(false);
                break;
            case R.id.iv_pre:
                trunPreQuestion();
                break;
            case R.id.iv_next:
                turnNextQuestion();
                break;
        }
        showQuestion();
    }

    private void showQuestion()
    {
        mTvQuestion.setText(questions.get(index).getResouceText());
    }

    //调到上一题
    private void trunPreQuestion() {
        if(index == 0)
        {
            Toast.makeText(this, "已经是第一道题!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            index--;
        }
    }

    //判断对错
    private void checkQuestion(boolean isTrue)
    {
        if(questions.get(index).isTrue() == isTrue)
        {
            Toast.makeText(this, "答对了", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "答错了", Toast.LENGTH_SHORT).show();
        }
    }

    //调到下一题
    private void turnNextQuestion()
    {
        if(index >= questions.size()-1)
        {
            Toast.makeText(this, "已经是最后一道题!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            index++;
        }
    }


}
