package com.example.mylistview;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private LinkedList<FriendInfo> friends;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list_chart);
        setData();
        setListViewAdapter();
    }

    private void setListViewAdapter() {
        adapter = new ListViewAdapter(this, R.layout.row_send, friends);
        listView.setAdapter(adapter);
    }

    //set "demo" data for list view adapter
    private void setData() {
        friends = new LinkedList<FriendInfo>();

        friends.add(new FriendInfo("Hello", false));
        friends.add(new FriendInfo("Hello!", true));
        friends.add(new FriendInfo("How are you?", true));
        friends.add(new FriendInfo("I'm fine", false));
        friends.add(new FriendInfo("The weather is great", true));
        friends.add(new FriendInfo("it is", false));
        friends.add(new FriendInfo("Are you go home?", true));
         friends.add(new FriendInfo("No, I'm going to school", true));
        friends.add(new FriendInfo("great", false));
        friends.add(new FriendInfo("see you", false));
         friends.add(new FriendInfo("baby", true));
    }

}
