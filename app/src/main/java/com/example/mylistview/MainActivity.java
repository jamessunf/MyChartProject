package com.example.mylistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    String msg[] = {"receive 1","send 1","receive 2","send 2"};
    int img[] = {R.drawable.row_receive,R.drawable.row_send,R.drawable.row_receive,R.drawable.row_send};

    //lab 4 update


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.list_chart);

        MyAdapter adpt = new MyAdapter(this,msg,img);
        listview.setAdapter(adpt);


    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rMsg[];
        int rImg[];


         MyAdapter(Context c, String msg[],int img[]) {
             super(c,R.layout.row_send,R.id.txt_send,msg);

             this.context = c;
            this.rMsg = msg;
            this.rImg = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row_send,parent, false);
            ImageView images = row.findViewById(R.id.img_send);
            TextView message = row.findViewById(R.id.txt_send);

            images.setImageResource(rImg[position]);
            message.setText(rMsg[position]);


            return row;
        }
    }
}
