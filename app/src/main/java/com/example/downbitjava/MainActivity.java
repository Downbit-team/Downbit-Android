package com.example.downbitjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.downbitjava.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.frame_1, new Afragment()).commit();

        TabLayout Tab_btn = (TabLayout)findViewById(R.id.Tab_btn);

        Tab_btn.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_1, new Afragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_1, new Bfragment()).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//
//        upping_textView = findViewById(R.id.upping);
//
//        profileDataArrayList = new ArrayList<>();
//
//        mRecyclerView = findViewById(R.id.recyclerviewid);
//
//        //Adapter 시작 (initiate adapter)
//        myRecyclerViewAdapter = new RecyclerViewAdapter();
//        myRecyclerViewAdapter.setProfileList(profileDataArrayList);
//
////        getSupportFragmentManager().beginTransaction().add(프래그먼트이름::).commit();
////        getSupportFragmentManager().beginTransaction().add(프래그먼트이름::).commit();
//
//        //RecyclerView 시작 (initiate recyclerview)
//        if(mRecyclerView != null) {
//            mRecyclerView.setAdapter(myRecyclerViewAdapter);
//            mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
//        }
//
//        add_coin();
//
////        swipeRefreshLayout = findViewById(R.id.swiperefresh);
////        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
////            @Override
////            public void onRefresh() {
////                Log.d("refresh", "새로고침 성공 !!");
////
////
////                //Update 가 끝났음을 알림
////                swipeRefreshLayout.setRefreshing(false);
////            }
////        });
//
//        //property-intent
////        View property_btn = findViewById(R.id.property_btn);
////        property_btn.setOnClickListener(this);
//
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_1, new Afragment()).commit();
//
//    }
//
//    int init_start_price() {
//        start_price = random.nextInt(100000) + 1;
//        return start_price;
//    }
//
//    public void calculate(ProfileData a) {
//        a.upping = random.nextInt(300) - 100;
//        if(a.upping == 0) {
//            a.upping = random.nextInt(300) - 100;
//        }
////        tmp = a.price;
////        a.price *= a.upping;
////        a.increase = a.price - tmp;
//        tmp = a.price;
//        a.price = (int)((tmp * (a.upping / 100)));
//        a.increase = a.price - tmp;
//
//        if(a.price > 2100000000) {
//            a.price = init_start_price();
//        }
//        System.out.println(a.name + " "+a.price+" " + a.increase);
//    }
//
//    public void add_coin() {
//        calculate(coin1);
//        profileDataArrayList.add(coin1);
//        calculate(coin2);
//        profileDataArrayList.add(coin2);
//        calculate(coin3);
//        profileDataArrayList.add(coin3);
//        calculate(coin4);
//        profileDataArrayList.add(coin4);
//        calculate(coin5);
//        profileDataArrayList.add(coin5);
//        calculate(coin6);
//        profileDataArrayList.add(coin6);
//        calculate(coin7);
//        profileDataArrayList.add(coin7);
//        calculate(coin8);
//        profileDataArrayList.add(coin8);
//        calculate(coin9);
//        profileDataArrayList.add(coin9);
//        changed_recyclerView();
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        Intent intent = new Intent(getApplicationContext(),Property.class);
//        startActivity(intent);
//        setResult(RESULT_OK,intent);
//        finish();
//    }
//
//    private void changed_recyclerView(){
//        myRecyclerViewAdapter.notifyDataSetChanged();
//        handler_time();
//    }
//    private void handler_time(){
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                profileDataArrayList.clear();
//                add_coin();
//            }
//        },3000);
//    }
    }

}