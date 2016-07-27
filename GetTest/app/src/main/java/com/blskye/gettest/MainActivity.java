package com.blskye.gettest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends Activity {
    private Button button;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        text= (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                                    JSONObject blog=array.getJSONObject(i);
                                    String username=blog.getString("username");
                                    System.out.println(username);
                                    text.setText(username);
                                }
                            }else {
                                System.out.println("error,not work!!!");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }.execute("http://blskye.com/test");
            }
        });
    }
    private void parseJson(String json){
        try {
            JSONObject object=new JSONObject(json);
            int result=object.getInt("result");
            if (result==1){
                System.out.println("ok,it is work!!!");
                JSONArray array=object.getJSONArray("returndata");
                for (int i=0;i<array.length();i++){
                    JSONObject blog=array.getJSONObject(i);
                    String username=blog.getString("username");
                    System.out.println(username);
                }

            }else {
                System.out.println("error,not work!!!");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
