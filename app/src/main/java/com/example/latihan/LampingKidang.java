package com.example.latihan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

        ImageButton btnContact = findViewById(R.id.btnContact);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = "0838224855998";
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + tel));
                startActivity(i);
            }
        });


        Intent i = getIntent();

        String getTitle = i.getStringExtra("title");

        int getImage = i.getIntExtra("icon", 0);

        getImageView.setImageResource(getImage);
        tvTitle.setText(getTitle);

        Button btnBooking = findViewById(R.id.btnBooking);
        btnBooking.setOnClickListener(v -> {
            Intent intent = new Intent(LampingKidang.this, booking.class);
            startActivity(intent);
        });



    }
}