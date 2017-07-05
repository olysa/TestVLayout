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
import com.dingfang.org.testvlayout.entity.LabelEntity;

import java.util.List;

/**
 * 宫格数据的适配器
 * Created by zuoqing on 2017/7/4.
 */

public class ClassficationAdapter  extends BaseDelegateAdapter<ClassficationAdapter.ClassficationViewHolder> {

    List<LabelEntity> labelEntities;

    public ClassficationAdapter() {
    }

    public ClassficationAdapter(Context mContext, LayoutHelper mLayoutHelper, List<LabelEntity> labelEntities) {
        this(mContext, mLayoutHelper, null, labelEntities);
    }

    public ClassficationAdapter(Context mContext, LayoutHelper mLayoutHelper, VirtualLayoutManager.LayoutParams mLayoutParams, List<LabelEntity> labelEntities) {
        super(mContext, mLayoutHelper, mLayoutParams);
        this.labelEntities = labelEntities;
    }

    @Override
    public ClassficationViewHolder doOnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClassficationViewHolder(LayoutInflater.from(this.getContext()).inflate(R.layout.label_item,parent,false));
    }

    @Override
    public void doOnBindViewHolder(ClassficationViewHolder holder, int position) {
        if (holder instanceof ClassficationViewHolder) {
            LabelEntity item = labelEntities.get(position);
            holder.imageView.setImageResource(item.getLabelImage());
            holder.textView.setText(item.getLabelText());
        }
    }

    @Override
    public int doGetItemCount() {
        return labelEntities == null ? 0 : labelEntities.size();
    }

    static class ClassficationViewHolder extends BaseViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ClassficationViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_label);
            textView = (TextView) itemView.findViewById(R.id.tv_label);
        }
    }
}

