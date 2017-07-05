package com.dingfang.org.testvlayout.entity;

/**
 * Label 宫格数据 实体
 * Created by zuoqing on 2017/7/5.
 */

public class LabelEntity {

    private int labelImage;
    private String labelText;

    public LabelEntity() {
    }

    public LabelEntity(int labelImage, String labelText) {
        this.labelImage = labelImage;
        this.labelText = labelText;
    }

    public int getLabelImage() {
        return labelImage;
    }

    public void setLabelImage(int labelImage) {
        this.labelImage = labelImage;
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    @Override
    public String toString() {
        return "LabelEntity{" +
                "labelImage=" + labelImage +
                ", labelText='" + labelText + '\'' +
                '}';
    }
}
