package com.example.latihan;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dashboard extends AppCompatActivity {
RecyclerView recyclerView;
EditText cari;
ArrayList<CustomModel> customModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);

        String email = getIntent().getStringExtra("email");
        TextView txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("Hi, "+email+" \nSelamat Pagi");

        ImageButton btnVn = findViewById(R.id.btnVn);
        cari = findViewById(R.id.inCari);

//        fitur vn ketika di klik maka akan fokus ke searchview
        btnVn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cari.requestFocus();

//                memunculkan keyboard
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(cari, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);

//        menampilkan recyclerView secara horizontal
        recyclerView.setLayoutManager(new LinearLayoutManager(dashboard.this, LinearLayoutManager.HORIZONTAL, false));


        customModelArrayList.add(new CustomModel(R.drawable.lampingkidang, "Lamping Kidang", "Cisantana, Cigugur"));
        customModelArrayList.add(new CustomModel(R.drawable.talagasurian, "Talaga Surian", "Pasawahan, Kuningan"));
        customModelArrayList.add(new CustomModel(R.drawable.ipukan, "IPUKAN", "Ciremai, Kuningan"));
        customModelArrayList.add(new CustomModel(R.drawable.cilengkrang, "Cilengkrang", "Pajambon, Gunung Keling"));


        CustomAdapter customAdapter = new CustomAdapter(this, customModelArrayList);
        recyclerView.setAdapter(customAdapter);

    }
}