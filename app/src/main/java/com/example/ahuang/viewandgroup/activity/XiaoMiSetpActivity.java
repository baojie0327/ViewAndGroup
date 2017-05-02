package com.example.ahuang.viewandgroup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ahuang.viewandgroup.R;
import com.example.ahuang.viewandgroup.view.XiaoMiStep;

import butterknife.Bind;
import butterknife.ButterKnife;

public class XiaoMiSetpActivity extends AppCompatActivity {

    @Bind(R.id.xiaoMiStep)
    XiaoMiStep mXiaoMiStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao_mi_setp);
        ButterKnife.bind(this);

        mXiaoMiStep.setMyFootNum(4500);
    }
}
