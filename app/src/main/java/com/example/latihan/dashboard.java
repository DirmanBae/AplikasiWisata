package com.example.latihan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

    }
}