package com.example.ahuang.viewandgroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahuang.viewandgroup.viewmeasure.ViewMeasureActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.viewMeasure)
    TextView mViewMeasure;
    @Bind(R.id.activity_main)
    LinearLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mViewMeasure.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.viewMeasure:
                Intent intent_measure=new Intent(MainActivity.this, ViewMeasureActivity.class);
                startActivity(intent_measure);
                break;
        }
    }
}
