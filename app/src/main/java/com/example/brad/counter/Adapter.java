package com.example.brad.counter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class Adapter extends ArrayAdapter<Counter> {

    private List<Counter> countList;
    private Context context;


    public Adapter(List<Counter> countList, Context ctx) {
        super(ctx, R.layout.img_row_layout, countList);
        this.countList = countList;
        this.context = ctx;
    }

    public int getCount() {
        return countList.size();
    }

    public Counter getItem(int position) {
        return countList.get(position);
    }

    public long getItemId(int position) {
        return countList.get(position).hashCode();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;



        CountHolder holder = new CountHolder();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.img_row_layout, null);
            TextView tv = (TextView) v.findViewById(R.id.name);
            TextView distView = (TextView) v.findViewById(R.id.dist);


            holder.countNameView = tv;
            holder.currentCount = distView;

            v.setTag(holder);
        }
        else
            holder = (CountHolder) v.getTag();

        Counter c = countList.get(position);
        //Displays the name of the counter as title and the current count as subtitle
        holder.countNameView.setText(c.getName());
        holder.currentCount.setText("" + c.getCurrent_count());


        return v;
    }


    private static class CountHolder {
        public TextView countNameView;
        public TextView currentCount;
    }


}