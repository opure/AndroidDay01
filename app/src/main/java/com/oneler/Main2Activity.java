package com.oneler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btn;
    private ListView lv;
    private MyAdapter adapter;
    private List<Msg> msgList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        lv = (ListView) findViewById(R.id.lv);
        initMsg();
        adapter = new MyAdapter(this,msgList);
        btn.setOnClickListener(this);
        lv.setAdapter(adapter);
    }

    private void initMsg() {
        for (int i =0;i<20;i++) {
            if (i%2 ==0) {
                Msg msg = new Msg("Hello"+i, Msg.TYPE_RECIVED);
                msgList.add(msg);
            } else {
                Msg msg = new Msg("hellow to"+i, Msg.TYPE_SENT);
                msgList.add(msg);
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                Toast.makeText(this,"aa",Toast.LENGTH_LONG).show();
        }
    }
}
