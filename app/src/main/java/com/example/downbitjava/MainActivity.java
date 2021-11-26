package com.example.downbitjava;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.downbitjava.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity<mTimer> extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter myRecyclerViewAdapter;
    private ArrayList<ProfileData> profileDataArrayList;

    SwipeRefreshLayout swipeRefreshLayout;

    Random random = new Random();

    int bitcoin_change, doz_change, ed_change, ripple_change, hive_change,
            sand_change, bora_change, tron_change, icon_change, start_price;

    int bitcoin = price();
    int doz = price();
    int ed = price();
    int ripple = price();
    int hive = price();
    int sand = price();
    int bora = price();
    int tron = price();
    int icon = price();

    double upping = 0;
    int tmp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileDataArrayList = new ArrayList<>();

        ProfileData coin1 = new ProfileData("비트코인", bitcoin_change, upping, bitcoin);
        ProfileData coin2 = new ProfileData("도지코인", doz_change, upping, doz);
        ProfileData coin3 = new ProfileData("이더리움", ed_change, upping, ed);
        ProfileData coin4 = new ProfileData("리플", ripple_change, upping, ripple);
        ProfileData coin5 = new ProfileData("하이브", hive_change,upping,hive);
        ProfileData coin6 = new ProfileData("샌드박스", sand_change,upping,sand);
        ProfileData coin7 = new ProfileData("보라",bora_change,upping,bora);
        ProfileData coin8 = new ProfileData("트론",tron_change,upping,tron);
        ProfileData coin9 = new ProfileData("아이콘",icon_change,upping,icon);

        calculate(coin1);
        profileDataArrayList.add(coin1);
        calculate(coin2);
        profileDataArrayList.add(coin2);
        calculate(coin3);
        profileDataArrayList.add(coin3);
        calculate(coin4);
        profileDataArrayList.add(coin4);
        calculate(coin5);
        profileDataArrayList.add(coin5);
        calculate(coin6);
        profileDataArrayList.add(coin6);
        calculate(coin7);
        profileDataArrayList.add(coin7);
        calculate(coin8);
        profileDataArrayList.add(coin8);
        calculate(coin9);
        profileDataArrayList.add(coin9);

        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("refresh", "새로고침 성공 !!");
                profileDataArrayList.clear();
                //Update 가 끝났음을 알림
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //intent
        View property_btn = findViewById(R.id.property_btn);
        property_btn.setOnClickListener(this);

        mRecyclerView = findViewById(R.id.recyclerviewid);

        //Adapter 시작 (initiate adapter)
        myRecyclerViewAdapter = new RecyclerViewAdapter();

        myRecyclerViewAdapter.setProfileList(profileDataArrayList);

        //RecyclerView 시작 (initiate recyclerview)
        mRecyclerView.setAdapter(myRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

    }

    int price() {
        start_price = random.nextInt(10000) + 1;
        return start_price;
    }

    public void calculate(ProfileData a) {
        a.upping = random.nextInt(200);

        tmp = a.price;
        a.price *= upping;
        a.increase = a.price - tmp;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getApplicationContext(),Property.class);
        startActivity(intent);
        setResult(RESULT_OK,intent);
        finish();
    }

}
