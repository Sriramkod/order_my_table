package com.example.ksriram.food_in_hands;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class grid_adapter extends BaseAdapter {

    private Context mContext;
    private final int[] Imageid;
    private final String[] web;



    private final String[] web1;



    Intent intent;
    public grid_adapter(Context c,String[] web,int[] Imageid,String[] web1 )
    {
        mContext = c;
        this.Imageid = Imageid;
        this.web=web;
        this.web1=web1;
    }


    @Override
    public int getCount()
    {
        return Imageid.length;
    }
    @Override
    public Object getItem(int position)
    {
        return position;
    }
    @Override
    public long getItemId(int position)
    {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent)
    {
        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null)
        {
            gridView = new View(mContext);
            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.grid_layout, null);
            // set value into textview
            TextView textView = (TextView)
                    gridView.findViewById(R.id.grid_item_label);
            textView.setText(web[position]);
            // set image based on selected text
            ImageView imageView = (ImageView)
                    gridView.findViewById(R.id.grid_item_image);
            imageView.setImageResource(Imageid[position]);
        }
        else
        {
            gridView = (View) convertView;
        }
        return gridView;

    }

}
