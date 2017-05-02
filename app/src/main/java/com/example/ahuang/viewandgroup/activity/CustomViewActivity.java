package com.example.ahuang.viewandgroup.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ahuang.viewandgroup.R;
import com.example.ahuang.viewandgroup.view.TopBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomViewActivity extends AppCompatActivity {

    @Bind(R.id.topBar)
    TopBar mTopBar;
    @Bind(R.id.activity_custon_view)
    LinearLayout mActivityCustonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custon_view);
        ButterKnife.bind(this);

        mTopBar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(CustomViewActivity.this, "click left", Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(CustomViewActivity.this, "click right", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
