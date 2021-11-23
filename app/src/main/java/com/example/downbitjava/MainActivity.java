package com.example.downbitjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.downbitjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter myRecyclerViewAdapter;
    private ArrayList<ProfileData> profileDataArrayList;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mRecyclerView = findViewById(R.id.recyclerviewid);

        profileDataArrayList = new ArrayList<>();

        Random random = new Random();

        double upping = random.nextInt(200) + 1;
        start_price = random.nextInt(10000000) + 1;
        bitcoin = (int) (start_price * upping);
        bitcoin_change = bitcoin - bitcoin_change;

        profileDataArrayList.add(new ProfileData("비트코인",bitcoin_change,upping,bitcoin));

            start_price = random.nextInt(10000000) + 1;
            upping = random.nextInt(200);
            doz = (int)(start_price * upping);
            doz_change = doz - doz_change;

            profileDataArrayList.add(new ProfileData("도지코인",doz_change,upping,doz));

            start_price();
            ed = (int)(start_price * upping);
            ed_change = ed - ed_change;



            profileDataArrayList.add(new ProfileData("이더리움",ed_change,upping,ed));

            start_price = random.nextInt(10000000) + 1;
            upping = random.nextInt(200);
            ripple = (int)(start_price * upping);
            ripple_change = ripple - ripple_change;


            profileDataArrayList.add(new ProfileData("리플",ripple_change,upping,ripple));


        //Adapter 시작 (initiate adapter)
        myRecyclerViewAdapter = new RecyclerViewAdapter();

        myRecyclerViewAdapter.setProfileList(profileDataArrayList);

        //RecyclerView 시작 (initiate recyclerview)
        mRecyclerView.setAdapter(myRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));


        void price() {

        }

    }

}
