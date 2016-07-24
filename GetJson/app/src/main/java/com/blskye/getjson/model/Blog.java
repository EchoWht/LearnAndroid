package com.blskye.getjson.model;

import java.util.List;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class Blog {
    private String title;
    private String price;
    public Blog(String title, String price, List<Blog> blogs){
        setTitle(title);
        setPrice(price);
    }
    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
