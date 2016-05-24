package com.oneler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vanvalt123 on 2016/5/24.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Msg> list;

    public MyAdapter(Context context, List<Msg> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null ;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.lv_item, null);
            viewHolder = new ViewHolder();
            viewHolder.ll_left = (LinearLayout) view.findViewById(R.id.ll_left);
            viewHolder.ll_right = (LinearLayout) view.findViewById(R.id.ll_rigth);
            viewHolder.tv_left = (TextView) view.findViewById(R.id.tv_left);
            viewHolder.tv_right = (TextView) view.findViewById(R.id.tv_right);
            view.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) view.getTag();
        }

        if (list.get(position).getType() == Msg.TYPE_RECIVED) {
            System.out.println("ll_left"+viewHolder.ll_left);
            viewHolder.ll_left.setVisibility(View.VISIBLE);
            viewHolder.ll_right.setVisibility(View.GONE);
            viewHolder.tv_left.setText(list.get(position).getContent());
        } else if (list.get(position).getType() == Msg.TYPE_SENT) {
            viewHolder.ll_right.setVisibility(View.VISIBLE);
            viewHolder.ll_left.setVisibility(View.GONE);
            viewHolder.tv_right.setText(list.get(position).getContent());

        }
        return view;
    }

    class ViewHolder {
        LinearLayout ll_left;
        LinearLayout ll_right;
        TextView tv_left;
        TextView tv_right;
    }

}
