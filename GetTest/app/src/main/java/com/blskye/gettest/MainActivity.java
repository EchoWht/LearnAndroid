package com.blskye.gettest;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
                            while((line=bufferedReader.readLine())!=null){
//                                System.out.println(line);
                                return line;
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
                    @Override
                    protected void onPostExecute(String s) {
                        text.setText(s);
                    }
                }.execute("http://blskye.com/test");
            }
        });
    }
}
