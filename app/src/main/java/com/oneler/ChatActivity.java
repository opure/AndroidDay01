package com.oneler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vanvalt123 on 2016/5/24.
 */
public class ChatActivity extends AppCompatActivity {
    private ListView listView;
    private EditText inputText;
    private Button send;
    private MsgAdapter msgAdapter;
    private List<Msg> msgList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.chat);
        initMsg();
        msgAdapter = new MsgAdapter(ChatActivity.this,R.layout.msg_item, msgList);
        inputText = (EditText) findViewById(R.id.input_text);
        send  = (Button) findViewById(R.id.send);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString().trim();
                if(!TextUtils.isEmpty(content)) {
                    Msg msg = new Msg(content ,Msg.TYPE_SENT);
                    msgList.add(msg);
                    msgAdapter.notifyDataSetChanged();
                    listView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });
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
}
