package com.blskye.getjson;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.blskye.getjson.adapter.ListAdatper;
import com.blskye.getjson.model.Blog;
import com.blskye.getjson.utils.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private ListAdatper adatper;
    private List<Blog> blogList;

    public static final String GET_URL="http://blskye.com/test";
    private Handler getListHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String jsonData= (String) msg.obj;
//            System.out.println(jsonData);
            try {
                JSONArray jsonArray=new JSONArray(jsonData);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject object=jsonArray.getJSONObject(i);
                    String title =object.getString("title");
                    String content =object.getString("content");
                    System.out.println(title);
                    blogList.add(new Blog(title,content,blogList));
                }
                adatper.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv= (ListView) findViewById(R.id.lv);
        blogList=new ArrayList<Blog>();
        adatper=new ListAdatper(this,blogList);
        lv.setAdapter(adatper);
        HttpUtils.getJSON(GET_URL,getListHandler);
    }
}
