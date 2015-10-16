package com.silence5105.nosy.testgsondemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nosy on 2015/10/16.
 */
public class CardViewItem {
   public String img;
   public String title;
   public String info;

//    public CardViewItem(JSONObject list) {
//
//        try {
//            this.img = list.getString("img");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    public CardViewItem(JSONObject list) {
        this.title = title;
        this.info = info;
        this.img = img;
        try {
            this.title = list.getString("subject");
            this.info = list.getString("info");
            this.img = list.getString("img");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


//    public CardViewItem(JSONObject list) {
//        try {
////            this.url=list.getString("CouponBannerSrc");
//            this.title = list.getString("title");
//            this.info = list.getString("info");
//            this.img = list.getString("img");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
