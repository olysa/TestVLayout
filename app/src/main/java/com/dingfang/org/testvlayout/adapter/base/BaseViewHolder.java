package com.dingfang.org.testvlayout.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 通用的ViewHolider
 * Created by zuoqing on 2017/7/4.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{
    private View itemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }
    public View getView() {
        return this.itemView;
    }
}
