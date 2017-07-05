package com.dingfang.org.testvlayout.util;

import android.content.Context;
import android.widget.ImageView;

import com.dingfang.org.testvlayout.R;
import com.dingfang.org.testvlayout.entity.LabelEntity;
import com.dingfang.org.testvlayout.entity.ListEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuoqing on 2017/7/5.
 */

public class RequestData {
    public static final int[] images = {R.mipmap.banner01, R.mipmap.banner02, R.mipmap.banner03, R.mipmap.banner04, R.mipmap.banner05};
    public static final int[] labelImages = {R.mipmap.label_economy,R.mipmap.label_history,R.mipmap.label_history02,R.mipmap.label_for_more,
            R.mipmap.label_economy,R.mipmap.label_history,R.mipmap.label_history02,R.mipmap.label_for_more};
    public static final String[] labelTexts = {"文学","军事","社会科学","生态学","时代前沿","历时传记","自然科学","科技文献"};

    /**
     *获取banner的数据
     * @param context
     * @return
     */
    public static List<ImageView> getImageViewsForBanner(Context context) {
        List<ImageView> imageViews = new ArrayList<>();
        for (int item : images) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(item);
            imageViews.add(imageView);
        }
        return imageViews;
    }

    /**
     * label数据构造
     * @return
     */
    public static List<LabelEntity> getLabels() {
        List<LabelEntity> labelEntities = new ArrayList<>();
        int len = labelImages.length;
        for (int i=0;i<len ;i++) {
            LabelEntity item = new LabelEntity(labelImages[i], labelTexts[i]);
            labelEntities.add(item);
        }
        return labelEntities;
    }

    /**
     * list 数据构造
     * @return
     */
    public static List<ListEntity> getListItems() {
        List<ListEntity> listEntities = new ArrayList<>();
        for (int i = 0; i<6;i++) {
            ListEntity item = new ListEntity(-1,"三新集团的未来展望" +(i+1) ,"董事长","我们对未来很有信息，目前，我们的管配效率在行业内是遥遥领先同行的" +
                    "，我们有30万电子资源，与全国上百家图书管有合作关系，我们对未来充满期望和信息，相信我们的努力一定会有相应的收获，努力是不会骗人的");
            listEntities.add(item);
        }
        return listEntities;
    }


}
