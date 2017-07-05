package com.dingfang.org.testvlayout.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.dingfang.org.testvlayout.R;
import com.dingfang.org.testvlayout.adapter.base.BaseDelegateAdapter;
import com.dingfang.org.testvlayout.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 顶部banner的适配器
 * Created by zuoqing on 2017/7/4.
 */

public class BannerAdapter extends BaseDelegateAdapter<BannerAdapter.BannerViewHolder> {

    private static final int bannarCount = 1;//banner的数量，一般只有一个

    private List<ImageView> imageViews;

    public BannerAdapter() {
    }

    public BannerAdapter(Context mContext, LayoutHelper mLayoutHelper) {
        this(mContext, mLayoutHelper,null);
    }

    public BannerAdapter(Context mContext, LayoutHelper mLayoutHelper,List<ImageView> imageViews) {
        this(mContext, mLayoutHelper,null,imageViews);
    }

    public BannerAdapter(Context mContext, LayoutHelper mLayoutHelper, VirtualLayoutManager.LayoutParams mLayoutParams,List<ImageView> imageViews) {
        super(mContext, mLayoutHelper, mLayoutParams);
        this.imageViews = imageViews;
    }

    @Override
    public BannerViewHolder doOnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BannerViewHolder( LayoutInflater.from(this.getContext()).inflate(R.layout.view_pager, parent, false));
    }

    @Override
    public void doOnBindViewHolder(BannerViewHolder holder, int position) {
        if (holder.getView() instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) holder.getView();
            viewPager.setAdapter(new BannerViewPager(imageViews));
        }
    }

    @Override
    public int doGetItemCount() {
        return BannerAdapter.bannarCount;
    }

    static class BannerViewHolder extends BaseViewHolder {
        public BannerViewHolder(View itemView) {
            super(itemView);
        }
    }

    //item 中 ViewPager适配器
    static class BannerViewPager extends PagerAdapter{
        private List<ImageView> imageViews;

        public BannerViewPager() {

        }

        public BannerViewPager(List<ImageView> imageViews) {
            this.imageViews = imageViews;
        }

        @Override
        public int getCount() {
            return imageViews == null ? 0 : imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView(imageViews.get(position));
        }
    }
}
