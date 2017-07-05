package com.dingfang.org.testvlayout;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.dingfang.org.testvlayout.adapter.BannerAdapter;
import com.dingfang.org.testvlayout.adapter.ClassficationAdapter;
import com.dingfang.org.testvlayout.adapter.ListAdapter;
import com.dingfang.org.testvlayout.util.RequestData;

import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView; //跟布局
    private VirtualLayoutManager layoutManager; //管理工具
    private DelegateAdapter delegateAdapter;    //适配器代理
    private List<DelegateAdapter.Adapter> adapters; //具体布局的适配器集合


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initWedgitAdapter();
        doCombine();
    }


    /**
     * 初始化视图
     */
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.main_view);

        /**
         * 签订管理协议
         */
        layoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        /**
         * 设置适配器
         */
        delegateAdapter = new DelegateAdapter(layoutManager, true);//true or false 表示不同类型的adpter，item是否会复用
        recyclerView.setAdapter(delegateAdapter);

        /**
         * 具体布局的适配器 集合
         */
        adapters = new LinkedList<>();
    }

    /**
     * 初始化具体的布局
     */
    private void initWedgitAdapter() {
        adapters.add(new BannerAdapter(this, new LinearLayoutHelper(), new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300), RequestData.getImageViewsForBanner(this)));

        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);//列，
        gridLayoutHelper.setVGap(4); // 垂直的间距
//        gridLayoutHelper.setWeights(new float[]{20.0f,30.0f,30.0f,20.0f}); //设置比例
        adapters.add(new ClassficationAdapter(this, gridLayoutHelper, RequestData.getLabels()));

        LinearLayoutHelper layoutHelper1 = new LinearLayoutHelper();
//        layoutHelper1.setAspectRatio(1.0f);// width / height,即宽高比
        layoutHelper1.setDividerHeight(10);
        adapters.add(new ListAdapter(this, layoutHelper1, RequestData.getListItems()));

    }

    /**
     * 最后的一步
     */
    private void doCombine() {
        delegateAdapter.setAdapters(adapters);
    }

    /**
     * 数据获取
     * @return
     */


    /**
     * item下划线以及边距相关
     */
    private void addItemDecoration() {
        RecyclerView.ItemDecoration itemDecoration = new RecyclerView.ItemDecoration() {
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = ((VirtualLayoutManager.LayoutParams) view.getLayoutParams()).getViewPosition();
                outRect.set(4, 4, 4, 4);
            }
        };
        this.recyclerView.addItemDecoration(itemDecoration);
    }

    /**
     * 设置回收复用池大小，
     */
    private void addRecycledViewPool() {
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

        this.recyclerView.setRecycledViewPool(viewPool);

        viewPool.setMaxRecycledViews(0, 20);
    }

}
