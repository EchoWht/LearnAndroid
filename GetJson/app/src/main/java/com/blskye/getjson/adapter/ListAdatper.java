package com.blskye.getjson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blskye.getjson.R;
import com.blskye.getjson.model.Blog;
import com.blskye.getjson.utils.HttpUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class ListAdatper extends BaseAdapter {

    private Context context;
    private List<Blog> blogList;

    public ListAdatper(Context context,List<Blog> blogList){
        this.context=context;
        this.blogList=blogList;
    }
    @Override
    public int getCount() {
        return blogList.size();
    }

    @Override
    public Blog getItem(int position) {
        return blogList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.iteam,null);
        }
        TextView tvTitle= (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvPrice= (TextView) convertView.findViewById(R.id.tvPrice);
        ImageView ivPic= (ImageView) convertView.findViewById(R.id.ivPic);
        Blog blog=blogList.get(position);
        tvTitle.setText(blog.getTitle());
        tvPrice.setText(blog.getPrice());
   /*测试链接*/
        String pic_url="http://blskye.com/public/images/drink/drink5.png";
        HttpUtils.setPicBitmap(ivPic,pic_url);
        return convertView;
    }
}
