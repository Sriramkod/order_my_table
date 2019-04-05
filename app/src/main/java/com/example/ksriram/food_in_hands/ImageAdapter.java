package com.example.ksriram.food_in_hands;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter{
    private Context context;
    private LayoutInflater layoutInflater;
    private int[] mImageIds = new int[]{R.drawable.im5, R.drawable.im6, R.drawable.im7, R.drawable.im8, R.drawable.im9,R.drawable.im13,R.drawable.im14,R.drawable.im15,R.drawable.im16};

    public ImageAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        imageView.setImageResource(mImageIds[position]);
        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp= (ViewPager) container;
        View view =(View) object;
        vp.removeView(view);
    }


}
