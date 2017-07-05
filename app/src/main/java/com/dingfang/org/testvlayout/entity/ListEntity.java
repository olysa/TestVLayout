package com.dingfang.org.testvlayout.entity;

/**
 * list 列表 数据源
 * Created by zuoqing on 2017/7/5.
 */

public class ListEntity {
    private int imgUrl;
    private String bibName;
    private String author;
    private String bookSummary;

    public ListEntity() {
    }

    public ListEntity(int imgUrl, String bibName, String author, String bookSummary) {
        this.imgUrl = imgUrl;
        this.bibName = bibName;
        this.author = author;
        this.bookSummary = bookSummary;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBibName() {
        return bibName;
    }

    public void setBibName(String bibName) {
        this.bibName = bibName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    @Override
    public String toString() {
        return "ListEntity{" +
                "imgUrl=" + imgUrl +
                ", bibName='" + bibName + '\'' +
                ", author='" + author + '\'' +
                ", bookSummary='" + bookSummary + '\'' +
                '}';
    }
}
