package com.example.ahuang.viewandgroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.ahuang.viewandgroup.activity.CanvasOperationActivity;
import com.example.ahuang.viewandgroup.activity.DrawActivity;
import com.example.ahuang.viewandgroup.adapter.MainAdapter;
import com.example.ahuang.viewandgroup.activity.ViewMeasureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Bind(R.id.activity_main)
    LinearLayout mActivityMain;
    @Bind(R.id.recycleView)
    RecyclerView mRecycleView;
    private List<String> list = new ArrayList<String>();
    private MainAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //  mViewMeasure.setOnClickListener(this);
        list.add("View的测量");
        list.add("View的绘制");
        list.add("Canvas操作");

        Log.d("hbj",list.size()+"");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(layoutManager);

        mAdapter = new MainAdapter(this, list);
        mRecycleView.setAdapter(mAdapter);
        mAdapter.setOnItemClickLitener(new MainAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0: //view的测量
                        Intent intent_measure = new Intent(MainActivity.this, ViewMeasureActivity.class);
                        startActivity(intent_measure);
                        break;
                    case 1: //view的绘制
                        Intent intent_draw = new Intent(MainActivity.this, DrawActivity.class);
                        startActivity(intent_draw);
                        break;
                    case 2:  //canvas操作
                        Intent intent_canvas=new Intent(MainActivity.this, CanvasOperationActivity.class);
                        startActivity(intent_canvas);
                        break;

                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.viewMeasure:
//                Intent intent_measure = new Intent(MainActivity.this, ViewMeasureActivity.class);
//                startActivity(intent_measure);
//                break;
        }
    }
}
