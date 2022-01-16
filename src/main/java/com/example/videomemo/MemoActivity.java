package com.example.videomemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MemoActivity extends AppCompatActivity {

    private ArrayList<MemoData> dataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        this.InitializeData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new MyAdapter(dataArrayList));

    }

    public void InitializeData(){
        dataArrayList = new ArrayList<>();
        dataArrayList.add(new MemoData("https://youtu.be/lelVripbt2M","깃 기본 이해 쌓기", "코드를 원격저장소에 저장하여 공유되고 협업할수 있게 하는 용도"));
//        dataArrayList.add(new MemoData("https://youtu.be/smt8QgMy9NI","나중에 볼것", "재택근무 원해요"));
    }
}