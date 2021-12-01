package com.example.downbitjava;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.downbitjava.databinding.ActivityAfragmentBinding;
import java.util.ArrayList;
import java.util.Random;

//Fragment 를 상속 받으려면 androidx.fragment.app 으로 해야한다
public class Afragment extends Fragment {

    ActivityAfragmentBinding binding;
    private RecyclerViewAdapter myRecyclerViewAdapter;
    private ArrayList<ProfileData> profileDataArrayList;

    Random random = new Random();

    int bitcoin_change, doz_change, ed_change, ripple_change, hive_change,
            sand_change, bora_change, tron_change, icon_change, start_price;

    int bitcoin = init_start_price();
    int doz = init_start_price();
    int ed = init_start_price();
    int ripple = init_start_price();
    int hive = init_start_price();
    int sand = init_start_price();
    int bora = init_start_price();
    int tron = init_start_price();
    int icon = init_start_price();

    double upping = 0;
    double tmp = 0;

    ProfileData coin1 = new ProfileData("비트코인", bitcoin_change, upping, bitcoin);
    ProfileData coin2 = new ProfileData("도지코인", doz_change, upping, doz);
    ProfileData coin3 = new ProfileData("이더리움", ed_change, upping, ed);
    ProfileData coin4 = new ProfileData("리플", ripple_change, upping, ripple);
    ProfileData coin5 = new ProfileData("하이브", hive_change,upping,hive);
    ProfileData coin6 = new ProfileData("샌드박스", sand_change,upping,sand);
    ProfileData coin7 = new ProfileData("보라",bora_change,upping,bora);
    ProfileData coin8 = new ProfileData("트론",tron_change,upping,tron);
    ProfileData coin9 = new ProfileData("아이콘",icon_change,upping,icon);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = ActivityAfragmentBinding.inflate(inflater, container, false);


        profileDataArrayList = new ArrayList<>();


        //Adapter 시작 (initiate adapter)
        myRecyclerViewAdapter = new RecyclerViewAdapter();
        myRecyclerViewAdapter.setProfileList(profileDataArrayList);

        //RecyclerView 시작 (initiate recyclerview)
        if (binding.recyclerviewid != null) {
            binding.recyclerviewid.setAdapter(myRecyclerViewAdapter);
            binding.recyclerviewid.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.VERTICAL, false));
        }
        getFragmentManager().beginTransaction().replace(R.id.frame_1, new Afragment()).commitAllowingStateLoss();
        add_coin();


        return binding.getRoot();
    }


    int init_start_price() {
        start_price = random.nextInt(100000) + 1;
        return start_price;
    }

    public void calculate(ProfileData a) {
        a.upping = random.nextInt(300) - 100;
        if(a.upping == 0) {
            a.upping = random.nextInt(300) - 100;
        }
//        tmp = a.price;
//        a.price *= a.upping;
//        a.increase = a.price - tmp;

        tmp = a.price;
        a.price = (int)((tmp * (a.upping / 100)));
        a.increase = a.price - tmp;

        if(a.price > 2100000000) {
            a.price = init_start_price();
        }
        System.out.println(a.name + " "+a.price+" " + a.increase);
    }

    public void add_coin() {
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
        changed_recyclerView();
    }

    private void changed_recyclerView(){
        myRecyclerViewAdapter.notifyDataSetChanged();
        handler_time();
    }
    private void handler_time() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                profileDataArrayList.clear();
                add_coin();
            }
        }, 3000);
    }
}
