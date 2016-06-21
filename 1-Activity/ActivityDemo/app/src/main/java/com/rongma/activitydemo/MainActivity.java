package com.rongma.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button mBtnNext;
    private EditText mEtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ActivityDemo生命周期","create");
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mEtText = (EditText) findViewById(R.id.et_title);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String text = mEtText.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
                intent.putExtra("title",text);
                startActivityForResult(intent,0x01);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ActivityDemo生命周期","start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("ActivityDemo生命周期","restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ActivityDemo生命周期","resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ActivityDemo生命周期","pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ActivityDemo生命周期","stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ActivityDemo生命周期","destroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0x01 && resultCode == 0x02) {
            String text = data.getStringExtra("haha");
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
