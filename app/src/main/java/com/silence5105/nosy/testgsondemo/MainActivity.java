package com.silence5105.nosy.testgsondemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;


import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AQuery aQuery;
    Context context;
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    ArrayList<CardViewItem> cardViewItems = new ArrayList<CardViewItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //aquery
        aQuery = new AQuery(this);
        context = getApplication();
//
        //rv
        recyclerView = (RecyclerView) findViewById(R.id.rv);
//
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//
        myAdapter = new MyAdapter(this, cardViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));




//        Gson gson = new Gson();

//        String url = "http://hashtag.fofo.tw/api/get_tags_info_list?hashtag_sn=12223323";
        String url = "http://eatwhere.ladesign.tw/api/get_food_list";
//        String url = "http://babysmile2015.cetaphil.com.tw/api/get_list";

//        gson.fromJson(url,null);
//        System.out.println("===="+gson);

        aQuery.ajax(url, null, JSONObject.class, new AjaxCallback<JSONObject>() {
            @Override
            public void callback(String url, JSONObject object, AjaxStatus status) {
                super.callback(url, object, status);
                System.out.println("===url===" + url);
                System.out.println("==obj==" + object);
                System.out.println("=status=" + status);
                try {
                    String img = object.getJSONArray("list").getJSONObject(0).getString("img").toString();
                    System.out.println("====" + img);
                    for (int i = 0; i < object.getJSONArray("list").length(); i++) {
//
                        cardViewItems.add(new CardViewItem(object.getJSONArray("list").getJSONObject(i)));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                }

                recyclerView.setAdapter(myAdapter);
            }
        });

    }
}
