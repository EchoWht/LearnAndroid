package com.cnwante.wantedrink.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/30 0030.
 */
public class HttpUtils {
    public static void getJSON(final String url, final Handler handler){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn;
                InputStream is;
                try {
                    conn= (HttpURLConnection) new URL(url).openConnection();
                    conn.setRequestMethod("POST");

                    DataOutputStream out=new DataOutputStream(conn.getOutputStream());
                    out.writeBytes("key=1");

                    is=conn.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(is));
                    String line="";
                    StringBuilder result=new StringBuilder();
                    while ((line=reader.readLine())!=null){
                        result.append(line);
                    }
                    Message msg=new Message();
                    msg.obj=result.toString();
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
   public static void setPicBitmap(ImageView pic, final String pic_url){
    new Thread(new Runnable() {
        @Override
        public void run() {
            HttpURLConnection conn=new URL(pic_url)
        }
    }).start();
   }
}
