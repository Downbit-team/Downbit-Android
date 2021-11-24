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

import com.example.downbitjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity<mTimer> extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter myRecyclerViewAdapter;
    private ArrayList<ProfileData> profileDataArrayList;


    SwipeRefreshLayout swipeRefreshLayout;

    Random random = new Random();

    int increase = 0;

    int start_price = 0;

    int bitcoin = price();
    int bitcoin_change;
    int doz = price();
    int doz_change;
    int ed = price();
    int ed_change;
    int ripple = price();
    int ripple_change;
    double upping = 0;
    int tmp = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("refresh", "새로고침 성공 !!");

                //Update 가 끝났음을 알림
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //intent

        View property_btn = findViewById(R.id.property_btn);
        property_btn.setOnClickListener(this);


        mRecyclerView = findViewById(R.id.recyclerviewid);

        profileDataArrayList = new ArrayList<>();

        calculate(bitcoin,bitcoin_change);
        profileDataArrayList.add(new ProfileData("비트코인", bitcoin_change, upping, bitcoin));

        calculate(doz,doz_change);
        profileDataArrayList.add(new ProfileData("도지코인", doz_change, upping, doz));

        calculate(ed,ed_change);
        profileDataArrayList.add(new ProfileData("이더리움", ed_change, upping, ed));

        calculate(ripple,ripple_change);
        profileDataArrayList.add(new ProfileData("리플", ripple_change, upping, ripple));


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

    void calculate(int coin, int change) {
        upping = random.nextInt(200);

        tmp = coin;
        coin *= upping;
        change = coin - tmp;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getApplicationContext(),Property.class);
        startActivity(intent);
        setResult(RESULT_OK,intent);
        finish();
    }
}
