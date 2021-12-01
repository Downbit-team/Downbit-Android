package com.example.downbitjava;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder>{

    private ArrayList<ProfileData> CoinProfileList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(CoinProfileList.get(position));
    }
    public void setProfileList(ArrayList<ProfileData> list) {
        this.CoinProfileList = list;
        notifyDataSetChanged();
    }

//    @RequiresApi(api = Build.VERSION_CODES.N)
//    @NonNull
    @Override
    public int getItemCount() {

        // try - catch 문을 이용한 예외처리
//        try {
//            return CoinProfileList.size();
//        } catch (NullPointerException a1) {
//            Log.d("error", "NPE 발생");
//        }

        if(CoinProfileList != null) {
            return CoinProfileList.size();
        }
        return 0;

    }

}
class ViewHolder extends RecyclerView.ViewHolder {


    TextView sub_name;
    TextView increase;
    TextView upping;
    TextView price;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);


        //RecyclerView Item Click Event 처리
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    Log.d("여기", "onClick: 터치");
                    Dialog dialog = new Dialog(v.getContext());

                }

//                dialog = new DialogActivity(MainActivity.this,R.layout.activity_dialog);
            }
        });

        //부모 클래스로부터 상속받은 필드나 메서드 참조

        sub_name = itemView.findViewById(R.id.coin_sub_name);
        increase = itemView.findViewById(R.id.increase);
        upping = itemView.findViewById(R.id.upping);
        price = itemView.findViewById(R.id.price);


    }

    void onBind(ProfileData item) {
        sub_name.setText(item.getName());
        increase.setText(String.valueOf(item.getIncrease()));
        upping.setText(item.getRate_of_change() + "%");
        price.setText(String.valueOf(item.getPrice()));

    }

}
