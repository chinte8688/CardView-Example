package com.silence5105.nosy.testgsondemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nosy on 2015/10/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<CardViewAdapter> cardViewAdapters;
    Bitmap bitmap;
    public MyAdapter(Context context, ArrayList<CardViewAdapter> cardViewAdapters){
        this.context = context;
        this.cardViewAdapters = cardViewAdapters;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardViewAdapter cardViewAdapter = cardViewAdapters.get(position);
        holder.title.setText(cardViewAdapter.getTitle());
        holder.info.setText(cardViewAdapter.getInfo());
        holder.img.setImageUrl(cardViewAdapter.getImg());
//

    }

    @Override
    public int getItemCount() {
        return cardViewAdapters.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder
    {
        public TextView title ;

        public SmartImageView img;

        public TextView info;

        public ViewHolder( View v )
        {
            super(v);
            title = (TextView) v.findViewById(R.id.textView);
            img = (SmartImageView) v.findViewById(R.id.imageView);
            info = (TextView) v.findViewById(R.id.textView2);


        }
    }
}
