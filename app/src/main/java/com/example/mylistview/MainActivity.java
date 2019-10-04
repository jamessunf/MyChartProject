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
    String msg[] = {"receive 1","send 1","receive 2","send 2","send 3","receive 3","receive 4"};
    int t[] = {1,2,1,2,2,1,1};

    //lab 4 update


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.list_chart);

       ReceiverAdapter adpt = new ReceiverAdapter(this,t,msg);
        //MyAdapter adpt = new MyAdapter(this,t,msg);

       // ArrayAdapter<String> adpt = new ArrayAdapter<String>(this,R.layout.row_send,msg);
        listview.setAdapter(adpt);


    }



   public class ReceiverAdapter extends ArrayAdapter<String> {

        Context context;
        String rMsg[];
        int rt[];


         ReceiverAdapter(Context c,int t[], String msg[]) {

             super(c,R.layout.row_receiver,R.id.txt_send,msg);

             this.context = c;
             this.rMsg = msg;
             this.rt = t;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            View row;



       //   if(t[position] == 1)
              row = layoutInflater.inflate(R.layout.row_send,parent, false);
         // else
           //  row = layoutInflater.inflate(R.layout.row_send,parent, false);


            ImageView images = row.findViewById(R.id.img_receiver);
            TextView message = row.findViewById(R.id.txt_receiver);

            images.setImageResource(R.drawable.row_receive);

            message.setText(rMsg[position]);





            return row;
        }


   }


    public class SendAdapter extends ArrayAdapter<String>{

        Context context;
        String rMsg[];
        int rt[];


        SendAdapter(Context c,int t[], String msg[]) {
            super(c,R.layout.row_send,R.id.txt_send,msg);

            this.context = c;
            this.rMsg = msg;
            this.rt = t;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row_send,parent, false);
            ImageView images = row.findViewById(R.id.img_send);
            TextView message = row.findViewById(R.id.txt_send);

            images.setImageResource(R.drawable.row_send);
            message.setText(rMsg[position]);


            return row;
        }
    }
}
