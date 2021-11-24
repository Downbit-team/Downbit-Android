package com.example.downbitjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.example.downbitjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity<mTimer> extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter myRecyclerViewAdapter;
    private ArrayList<ProfileData> profileDataArrayList;


    SwipeRefreshLayout swipeRefreshLayout;

    int increase = 0;

    int start_price = 0;

    int bitcoin = 0;
    int bitcoin_change = bitcoin;
    int doz = 0;
    int doz_change = doz;
    int ed = 0;
    int ed_change = ed;
    int ripple = 0;
    int ripple_change = ripple;
    Random random = new Random();
    double upping = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                price();
                Log.d("refresh", "새로고침 성공 !!");

                price();

                //Update 가 끝났을음 알림
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //intent

        View property_btn = findViewById(R.id.property_btn);
        property_btn.setOnClickListener(this);


        mRecyclerView = findViewById(R.id.recyclerviewid);

        profileDataArrayList = new ArrayList<>();

        price();
        bitcoin = (int) (start_price * upping);
        bitcoin_change = bitcoin - bitcoin_change;

        profileDataArrayList.add(new ProfileData("비트코인", bitcoin_change, upping, bitcoin));

        price();
        doz = (int) (start_price * upping);
        doz_change = doz - doz_change;


        profileDataArrayList.add(new ProfileData("도지코인", doz_change, upping, doz));

        price();
        ed = (int) (start_price * upping);
        ed_change = ed - ed_change;


        profileDataArrayList.add(new ProfileData("이더리움", ed_change, upping, ed));

        price();
        ripple = (int) (start_price * upping);
        ripple_change = ripple - ripple_change;


        profileDataArrayList.add(new ProfileData("리플", ripple_change, upping, ripple));


        //Adapter 시작 (initiate adapter)
        myRecyclerViewAdapter = new RecyclerViewAdapter();

        myRecyclerViewAdapter.setProfileList(profileDataArrayList);

        //RecyclerView 시작 (initiate recyclerview)
        mRecyclerView.setAdapter(myRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));


    }

    void price() {
        start_price = random.nextInt(10000) + 1;
        upping = random.nextInt(200);
    }

    void increase(int coin_price, int coin_change) {

    }


    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getApplicationContext(),Property.class);
        startActivity(intent);
        setResult(RESULT_OK,intent);
        finish();
    }
}
