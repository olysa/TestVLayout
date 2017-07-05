package com.dingfang.org.testvlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.dingfang.org.testvlayout.R;
import com.dingfang.org.testvlayout.adapter.base.BaseDelegateAdapter;
import com.dingfang.org.testvlayout.adapter.base.BaseViewHolder;
import com.dingfang.org.testvlayout.entity.ListEntity;

import java.util.List;

/**
 * 列表页数据适配器
 * Created by zuoqing on 2017/7/5.
 */

public class ListAdapter  extends BaseDelegateAdapter<ListAdapter.ListViewHolder>{

    List<ListEntity> listEntities;

    public ListAdapter() {
    }

    public ListAdapter(Context mContext, LayoutHelper mLayoutHelper, List<ListEntity> listEntities) {
        this(mContext, mLayoutHelper,null,listEntities);
    }

    public ListAdapter(Context mContext, LayoutHelper mLayoutHelper, VirtualLayoutManager.LayoutParams mLayoutParams, List<ListEntity> listEntities) {
        super(mContext, mLayoutHelper, mLayoutParams);
        this.listEntities = listEntities;
    }

    @Override
    public ListViewHolder doOnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListViewHolder( LayoutInflater.from(this.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void doOnBindViewHolder(ListViewHolder holder, int position) {
        if (holder instanceof ListViewHolder ){
            ListEntity item = listEntities.get(position);
//            holder.ivImgUrl.setImageResource(item.getImgUrl());
            holder.tvBibName.setText(item.getBibName());
            holder.tvAuthor.setText(item.getAuthor());
            holder.tvBookSummary.setText(item.getBookSummary());
        }
    }

    @Override
    public int doGetItemCount() {
        return listEntities == null ? 0 : listEntities.size();
    }

    static class ListViewHolder extends BaseViewHolder {
        public ImageView ivImgUrl;
        public TextView tvBibName;
        public TextView tvAuthor;
        public TextView tvBookSummary;

        public ListViewHolder(View itemView) {
            super(itemView);
            ivImgUrl = (ImageView) itemView.findViewById(R.id.iv_list);
            tvBibName = (TextView) itemView.findViewById(R.id.tv_bibname_list);
            tvAuthor = (TextView) itemView.findViewById(R.id.tv_author_list);
            tvBookSummary = (TextView) itemView.findViewById(R.id.tv_book_summary_list);
        }
    }
}

