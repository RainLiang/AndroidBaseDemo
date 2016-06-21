package com.rongma.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends Activity {
    private TextView mTvAnother;
    private Button mBtnPre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        mTvAnother = (TextView) findViewById(R.id.tv_another);
        mBtnPre = (Button) findViewById(R.id.btn_last);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        mTvAnother.setText(title);
        mBtnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(AnotherActivity.this,MainActivity.class);
                intent2.putExtra("haha","hello!!");
                setResult(0x02,intent2);
                finish();
            }
        });
    }
}
