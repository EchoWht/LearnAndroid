package com.blskye.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridview = (GridView) findViewById(R.id.GridView);
        ArrayList<HashMap<String, Object>> meumList = new ArrayList<HashMap<String, Object>>();
        for(int i = 1;i < 11;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage",R.mipmap.drink+i);
            map.put("ItemText", "咖啡"+i);
            meumList.add(map);
        }
        SimpleAdapter saItem = new SimpleAdapter(this,
                meumList, //数据源
                R.layout.item, //xml实现
                new String[]{"ItemImage","ItemText"}, //对应map的Key
                new int[]{R.id.ItemImage,R.id.ItemText});  //对应R的Id

        //添加Item到网格中
        gridview.setAdapter(saItem);
        //添加点击事件
        gridview.setOnItemClickListener(
                new OnItemClickListener()
                {
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
                    {
                        int index=arg2+1;//id是从0开始的，所以需要+1
                        Toast.makeText(getApplicationContext(), "test"+index, Toast.LENGTH_SHORT).show();
                        //Toast用于向用户显示一些帮助/提示
                        Intent intent=new Intent(MainActivity.this,PaytypeActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}