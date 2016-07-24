package com.blskye.posttest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<String,Void,Void>(){

                    @Override
                    protected Void doInBackground(String... params) {
                        try {
                            URL url=new URL(params[0]);
                            HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();

                            /*配置conncetion*/
                            urlConnection.setDoOutput(true);
                            urlConnection.setRequestMethod("POST");

                            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(urlConnection.getOutputStream(),"utf-8");
                            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                            bufferedWriter.write("keyfrom=testHttphi&key=1412894395&type=data&doctype=json&version=1.1&q=good");
                            bufferedWriter.flush();
                            InputStream inputStream= urlConnection.getInputStream();
                            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"utf-8");
                            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                            String line;
                            while((line=bufferedReader.readLine())!=null){
                                System.out.println(line);
                            }
                            bufferedReader.close();
                            inputStreamReader.close();
                            inputStream.close();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.execute("http://fanyi.youdao.com/openapi.do");
            }
        });
    }
}
