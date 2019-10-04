package com.example.mylistview;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<FriendInfo> {

    private Activity activity;

    public ListViewAdapter(Activity activity, int resource, List<FriendInfo> objects) {
        super(activity, resource, objects);
        this.activity = activity;
    }

    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        // inflate layout from xml
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource = 0; // determined by view type
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                layoutResource = R.layout.row_receiver;
                break;

            case 1:
                layoutResource = R.layout.row_send;
                break;
        }

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        // set data to views
        if (getItem(position).isGender()) {
            holder.gender.setImageResource(R.drawable.row_receive);
        } else {
            holder.gender.setImageResource(R.drawable.row_send);
        }
        holder.name.setText(getItem(position).getName());

        return convertView;
    }

    private class ViewHolder {
        private ImageView gender;
        private TextView name;

        public ViewHolder(View v) {
            gender = (ImageView) v.findViewById(R.id.img_show);
            name = (TextView) v.findViewById(R.id.txt_msg);
        }
    }

}
