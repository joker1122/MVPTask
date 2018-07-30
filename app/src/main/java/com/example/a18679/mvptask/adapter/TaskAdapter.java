package com.example.a18679.mvptask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a18679.mvptask.R;

import java.util.List;

public class TaskAdapter extends BaseAdapter {
    private List<String> mStrings;
    private LayoutInflater mLayoutInflater;

    public TaskAdapter(Context context, List<String> strings) {
        super();
        mStrings = strings;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public Object getItem(int position) {
        return mStrings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.item_layout, null);
            ImageView imageView = convertView.findViewById(R.id.img);
            TextView textView = convertView.findViewById(R.id.tv);
            viewHolder.mImageView = imageView;
            viewHolder.mTextView = textView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTextView.setText(mStrings.get(position));
        return convertView;
    }

    class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
    }
}
