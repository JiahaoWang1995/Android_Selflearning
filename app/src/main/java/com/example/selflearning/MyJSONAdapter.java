package com.example.selflearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyJSONAdapter extends ArrayAdapter<String[]> {
    private List<String[]> data;
    private int mResourceId;
//    Context mContext;

    public MyJSONAdapter(Context context, int resource, List<String[]> objects) {
        super(context, resource, objects);
        data = objects;
        mResourceId = resource;
//        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mResourceId, parent, false);
        TextView idText = view.findViewById(R.id.id);
        TextView nameText = view.findViewById(R.id.name);
        TextView ideText = view.findViewById(R.id.ide);
        idText.setText(data.get(position)[0]);
        nameText.setText(data.get(position)[1]);
        ideText.setText(data.get(position)[2]);
        return view;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
