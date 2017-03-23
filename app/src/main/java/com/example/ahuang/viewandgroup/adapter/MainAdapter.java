package com.example.ahuang.viewandgroup.adapter; /**
 * MainAdapter  2017-03-09
 * Copyright (c) 2017 HYB Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahuang.viewandgroup.R;

import java.util.List;

/**
 * class description here
 *
 * @author Borje
 * @version 1.0.0
 *          since 2017 03 09
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> list;
    private OnItemClickLitener mOnItemClickLitener;

    public MainAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main,
                parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.tv_title = (TextView) view.findViewById(R.id.viewMeasure);
      //  viewHolder.ll_listen = (LinearLayout) view.findViewById(R.id.ll_listen);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Log.d("hbj","position=" + position);
        holder.tv_title.setText(list.get(position));
        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.tv_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        TextView tv_title;
        LinearLayout ll_listen;
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }
}