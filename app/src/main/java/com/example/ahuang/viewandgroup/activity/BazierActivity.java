package com.example.ahuang.viewandgroup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ahuang.viewandgroup.R;
import com.example.ahuang.viewandgroup.view.BezierThree;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BazierActivity extends AppCompatActivity {

    @Bind(R.id.control1)
    RadioButton mControl1;
    @Bind(R.id.control2)
    RadioButton mControl2;
    @Bind(R.id.radiogroup)
    RadioGroup mRadiogroup;
    @Bind(R.id.activity_bazier_two)
    LinearLayout mActivityBazierTwo;
    @Bind(R.id.bezierThree)
    BezierThree mBezierThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazier_two);
        ButterKnife.bind(this);
        mRadiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.control1:
                        mBezierThree.setMode(true);
                        break;
                    case R.id.control2:
                        mBezierThree.setMode(false);
                        break;
                }
            }
        });
    }
}
