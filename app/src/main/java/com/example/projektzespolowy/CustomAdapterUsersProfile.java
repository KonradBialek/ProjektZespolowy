package com.example.projektzespolowy;
//implementacja customowego adaptera
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterUsersProfile extends BaseAdapter { //dziedziczy po klasie BaseAdapter
//przedstawia całe zaadoptowanie tego grida
    private String[] plantsNames;
    private int[] imagesPhoto;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapterUsersProfile(String[] plantsNames, int[] imagesPhoto, Context context) {
        this.plantsNames = plantsNames;
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
            view = layoutInflater.inflate(R.layout.plant_row_item, viewGroup, false);
        }
        TextView tvName = view.findViewById(R.id.minPlantName);
        ImageView imagePhoto = view.findViewById(R.id.imageView);

        tvName.setText(plantsNames[i]);
        imagePhoto.setImageResource(imagesPhoto[i]);

        return view;
    }
}
