package com.oneler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vanvalt123 on 2016/5/24.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    public FruitAdapter(Context context, int textViewResouceId, List<Fruit> objects) {
        super(context, textViewResouceId, objects);
        resourceId = textViewResouceId;
    }

    private class ViewHolder {
        ImageView fruitImage;
        TextView  fruitName;
        public ViewHolder(View view) {
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }
}
