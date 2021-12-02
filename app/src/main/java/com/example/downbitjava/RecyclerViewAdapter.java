package com.example.downbitjava;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
    Context context;


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
                final EditText ed = new EditText(v.getContext());
                ed.setRawInputType(InputType.TYPE_CLASS_NUMBER);
                ed.setHint("숫자를 입력해주세요.");

                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    Log.d("여기", "onClick: 터치");


                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                    builder.setView(R.layout.activity_dialog1);
                    builder.setTitle("구매");

                    builder.setMessage("코인을 구매 하시겠습니까?");
                    builder.setNegativeButton("구매" , new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

//                            builder.setView(R.layout.activity_dialog1);
                                builder.setTitle("구매");
                                builder.setMessage("몇 개를 구입 하시겠습니까?");
                                builder.setView(ed);

                                builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                builder.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                builder.show();
                        }
                    });
                    builder.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    builder.show();
                }
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
