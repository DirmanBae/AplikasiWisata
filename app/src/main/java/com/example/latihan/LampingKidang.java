package com.example.latihan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LampingKidang extends AppCompatActivity {

    ImageView getImageView;
    TextView tvTitle, tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lamping_kidang);

        getImageView = findViewById(R.id.getImageView);
        tvTitle = findViewById(R.id.tvTitle);


        Intent i = getIntent();

        String getTitle = i.getStringExtra("title");

        int getImage = i.getIntExtra("icon", 0);

        getImageView.setImageResource(getImage);
        tvTitle.setText(getTitle);



    }
}