package cn.hbu.cs.maingrid;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListMain extends AppCompatActivity {

    private List<ListFruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);
        initFruits(); // 初始化水果数据
        ListFruitAdaptor adapter = new ListFruitAdaptor(ListMain.this, R.layout.list_item, fruitList);
        ListView listView = findViewById(R.id.mListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ListFruit fruit = fruitList.get(position);
                Toast.makeText(ListMain.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            ListFruit apple = new ListFruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);
            ListFruit banana = new ListFruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);
            ListFruit orange = new ListFruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);
            ListFruit watermelon = new ListFruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            ListFruit pear = new ListFruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);
            ListFruit grape = new ListFruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);
            ListFruit pineapple = new ListFruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            ListFruit strawberry = new ListFruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            ListFruit cherry = new ListFruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);
            ListFruit mango = new ListFruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }

}

