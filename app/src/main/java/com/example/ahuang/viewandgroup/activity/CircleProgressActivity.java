package com.example.ahuang.viewandgroup.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahuang.viewandgroup.R;
import com.example.ahuang.viewandgroup.view.CircleProgress;

public class CircleProgressActivity extends AppCompatActivity {

    private CircleProgress mCircleProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);

        mCircleProgress=(CircleProgress) findViewById(R.id.circle_progress);


        mCircleProgress.setMax(100);
        mCircleProgress.setProgressWithAnimation(100);
    }
}
