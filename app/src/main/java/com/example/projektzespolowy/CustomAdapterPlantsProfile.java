package com.example.projektzespolowy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterPlantsProfile extends BaseAdapter {


    private int[] imagesPhoto;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapterPlantsProfile(int[] imagesPhoto, Context context) {
        this.imagesPhoto = imagesPhoto;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagesPhoto.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = layoutInflater.inflate(R.layout.plant_pic_row_item, viewGroup, false);
        }
        ImageView imagePhoto = view.findViewById(R.id.imageView);

        imagePhoto.setImageResource(imagesPhoto[i]);

        return view;
    }
}
