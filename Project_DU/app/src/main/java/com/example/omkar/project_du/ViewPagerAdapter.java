package com.example.omkar.project_du;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.omkar.project_du.R;

public class ViewPagerAdapter extends PagerAdapter
{
    private Context mcontext;
    private int [] mimages= new int[] {R.drawable.hansrajslide2, R.drawable.hansrajslide3, R.drawable.hansrajslide4};
    ViewPagerAdapter(Context context){
        mcontext=context;
    }

    @Override
    public int getCount() {
        return mimages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView=new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mimages[position]);
        container.addView(imageView,0);
        return imageView;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }
}
