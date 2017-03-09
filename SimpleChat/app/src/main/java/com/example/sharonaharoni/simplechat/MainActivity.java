package com.example.sharonaharoni.simplechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private EditText msgBox;
    private ArrayList<String> msgList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* List View */
        msgBox  = (EditText) findViewById(R.id.messageBox);
        msgList = new ArrayList<String>();
        adapter  = new ArrayAdapter<String>(this, R.layout.list_layout, R.id.msg, msgList);

        final Button sendButton = (Button) findViewById(R.id.sendButton);


        msgList.add("Test");

        ListView myFirstListView = (ListView) findViewById( R.id.myFirstListView);

        myFirstListView.setAdapter(adapter);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newMsg = msgBox.getText().toString();
                msgList.add(newMsg);

                adapter.notifyDataSetChanged();
                msgBox.setText("");
            }
        });
    }
}
