package com.silence5105.nosy.testgsondemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.ArrayList;

/**
 * Created by Nosy on 2015/10/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<CardViewItem> cardViewItems;

    public MyAdapter(Context context, ArrayList<CardViewItem> cardViewItems) {
        this.context = context;
        this.cardViewItems = cardViewItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(cardViewItems.get(position).getTitle());
        holder.info.setText(cardViewItems.get(position).getInfo());
        holder.img.setImageUrl(cardViewItems.get(position).getImg());
//

    }

    @Override
    public int getItemCount() {
        return cardViewItems.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {
        public TextView title;

        public SmartImageView img;

        public TextView info;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.textView);
            img = (SmartImageView) v.findViewById(R.id.imageView);
            info = (TextView) v.findViewById(R.id.textView2);


        }
    }
}
