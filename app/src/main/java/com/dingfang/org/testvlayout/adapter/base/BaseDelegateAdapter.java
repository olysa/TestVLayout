package com.dingfang.org.testvlayout.adapter.base;

import android.content.Context;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;

/**
 * 适配器抽象类
 * Created by zuoqing on 2017/7/4.
 */

public abstract class BaseDelegateAdapter <T extends BaseViewHolder> extends DelegateAdapter.Adapter<T>  {

    /**
     * 上下文环境
     * 提供get方法来获取
     */
    private Context mContext;

    /**
     * 必要的布局管理属性
     * 被框架管理，所以写在抽象类里面
     */
    private LayoutHelper mLayoutHelper;

    /**
     * itemView布局中 跟布局的布局参数
     * 因为每一个实体类都要做此操作，所以也放在抽象类里面
     */
    private VirtualLayoutManager.LayoutParams mLayoutParams;

    public BaseDelegateAdapter() {

    }

    public BaseDelegateAdapter(Context mContext, LayoutHelper mLayoutHelper) {
        this(mContext,mLayoutHelper,null);
    }

    public BaseDelegateAdapter(Context mContext, LayoutHelper mLayoutHelper, VirtualLayoutManager.LayoutParams mLayoutParams) {
        this.mContext = mContext;
        this.mLayoutHelper = mLayoutHelper;
        this.mLayoutParams = mLayoutParams;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return this.mLayoutHelper;
    }

    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        return doOnCreateViewHolder(parent,viewType);
    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        if (this.mLayoutParams != null) {
            holder.getView().setLayoutParams(this.mLayoutParams);
        }
        doOnBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return doGetItemCount();
    }

    public abstract T doOnCreateViewHolder(ViewGroup parent, int viewType);
    public abstract void doOnBindViewHolder(T holder, int position);
    public abstract int doGetItemCount();
}
