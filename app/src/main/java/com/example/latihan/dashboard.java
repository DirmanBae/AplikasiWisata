package com.example.latihan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<CustomModel> customModelArrayList = new ArrayList<>();
//LinearLayoutManager linearLayoutManager;
//MyRvAdapter myRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        recyclerView = findViewById(R.id.recyclerView);
//        menampilkan recyclerView secara horizontal
        recyclerView.setLayoutManager(new LinearLayoutManager(dashboard.this, LinearLayoutManager.HORIZONTAL, false));


        customModelArrayList.add(new CustomModel(R.drawable.mount, "Lamping Kidang", "Cisantana, Cigugur"));
        customModelArrayList.add(new CustomModel(R.drawable.telaga, "Talaga Surian", "Pasawahan, Kuningan"));
        customModelArrayList.add(new CustomModel(R.drawable.curug, "IPUKAN", "Ciremai, Kuningan"));
        customModelArrayList.add(new CustomModel(R.drawable.cikaracak, "Cilengkrang", "Pajambon, Gunung Keling"));


        CustomAdapter customAdapter = new CustomAdapter(this, customModelArrayList);
        recyclerView.setAdapter(customAdapter);






//        setting data resouce
//        dataSource = new ArrayList<>();
//        dataSource.add("Lamping Kidang");
//        dataSource.add("Talaga Surian");
//        dataSource.add("Puncak Ciremai");
//        dataSource.add("the");
//        dataSource.add("code");
//        dataSource.add("city");
//        dataSource.add("Dirman");
//
//        linearLayoutManager = new LinearLayoutManager(dashboard.this, LinearLayoutManager.HORIZONTAL, false);
//        myRvAdapter = new MyRvAdapter(dataSource);
//        rv.setLayoutManager(linearLayoutManager);
//        rv.setAdapter(myRvAdapter);

    }
//    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder>{
//
//        ArrayList<String> data;
//        public MyRvAdapter(ArrayList<String> data) {
//            this.data = data;
//        }
//
//        @NonNull
//        @Override
//        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(dashboard.this).inflate(R.layout.rv_item, parent, false);
//            return new MyHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//            holder.tvTitle.setText(data.get(position));
//        }
//
//        @Override
//        public int getItemCount() {
//            return data.size();
//        }
//
//        class MyHolder extends RecyclerView.ViewHolder{
//            TextView tvTitle;
//            public MyHolder(@NonNull View itemView) {
//                super(itemView);
//                tvTitle = itemView.findViewById(R.id.tvTitle);
//            }
//        }
//
//    }
}