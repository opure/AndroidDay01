package com.oneler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity{
    private List<Fruit> fruitList = new ArrayList<>();
    private TextView chatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        chatButton = (Button) findViewById(R.id.btn_chat);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("text", "onClick: aaaa");
                Toast.makeText(MainActivity.this,"hah",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,ChatActivity.class);
            }
        });
        initFruits();
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.d("xdpi"+xdpi,"ydpi"+ydpi);
//        FruitAdapter adapter = new FruitAdapter(MainActivity.this,
//                R.layout.fruit_item, fruitList);
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Fruit fruit = fruitList.get(position);
//                Toast.makeText(MainActivity.this, fruit.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });
       /* for (int i=0; i<100;i++) {
            list.add(i+"号你好");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_expandable_list_item_1,list);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/

    }

    private void initFruits() {
        for  (int i=0;i<20;i++) {
            Fruit apple = new Fruit(i+"号Apple",R.drawable.ic_launcher);
            fruitList.add(apple);
        }
    }

}

