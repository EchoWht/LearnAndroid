package com.blskye.gridviewtest;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends Activity {

    private GridView gridView;
    private List<Map<String,Object>> data_list;
    private SimpleAdapter simpleAdapter;

    private  int[] icon={
            R.mipmap.drink1,R.mipmap.drink1,R.mipmap.drink1,R.mipmap.drink1
    };
    private String[] iconName={
            "咖啡","橙汁","苹果","桃汁"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        gridView= (GridView) findViewById(R.id.gridView);
        data_list=new ArrayList<Map<String, Object>>();

        getData();


        String[] from={"image","text"};
        int[] to={R.id.image,R.id.text};
        simpleAdapter=new SimpleAdapter(this,data_list,R.layout.item,from,to);
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index=position+1;
                Toast.makeText(getApplicationContext(),"点击了"+index,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public List<Map<String,Object>> getData(){
         /*测试 获取json数据*/
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... params) {
                try {
                    URL url=new URL(params[0]);
                    URLConnection urlConnection= url.openConnection();
                    InputStream inputStream= urlConnection.getInputStream();
                    InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    String line;

                    StringBuilder builder=new StringBuilder();
                    while((line=bufferedReader.readLine())!=null){
                        return line;
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String s) {
                try {
                    JSONObject object=new JSONObject(s);
                    int result=object.getInt("result");
                    if (result==1){
                        System.out.println("ok,it is work!!!");
                        JSONArray array=object.getJSONArray("returndata");

                        for (int i=0;i<array.length();i++){
                            JSONObject drinkObject=array.getJSONObject(i);
                            String drinkname=drinkObject.getString("drinkname");

                            System.out.println(drinkname+i);
                        }
                    }else {
                        System.out.println("error,not work!!!");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.execute("http://blskye.com/test/index/drink");


        /*测试 获取json数据*/
        for (int i=0;i<icon.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }
}
