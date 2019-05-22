package com.example.thuytran.persionality;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Intro extends AppCompatActivity {
    ListView listView;
    List<Question> questionList;
    QuestionAdapter myAdapter;
    TextView txtCH;
    StringBuilder dulieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        try {
            getData();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        txtCH = (TextView) findViewById(R.id.textCH);
        myAdapter = new QuestionAdapter(this, R.layout.activity_row_list_view, questionList);
        listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(myAdapter);
    }

    private void getData()  throws ExecutionException, InterruptedException, JSONException {
        listView = (ListView) findViewById(R.id.list_item);
        questionList = new ArrayList<>();
        String url = "http://10.0.3.2:8080//hello";
        DownloadJson downloadJSON = new DownloadJson(url);
        Log.i("question2",  "hihih");
        downloadJSON.execute();
        String dataJSON = downloadJSON.get();
        JSONArray jsonArrayDanhSachSanPham = new JSONArray(dataJSON);
        for (int i = 0; i < jsonArrayDanhSachSanPham.length() ; i++){
            Question q = new Question((JSONObject) jsonArrayDanhSachSanPham.get(i));
            questionList.add(q);
        }
    }


}

