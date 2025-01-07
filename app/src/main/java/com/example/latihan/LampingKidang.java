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
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lamping_kidang);

        getImageView = findViewById(R.id.getImageView);
        tvTitle = findViewById(R.id.tvTitle);

        TextView des = findViewById(R.id.deskripsi);
        TextView harga = findViewById(R.id.txtHarga);
        TextView kontak = findViewById(R.id.kontak);
        String textIpukan = getString(R.string.ipukan);
        String textLampingKidang = getString(R.string.lampingkidang);
        String textTalagasurian = getString(R.string.talagasurian);
        String textCilengkrang = getString(R.string.cilengkrang);

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
//mengatur deskripsi dan harga tiket dan kontak booking dari setiap wisata
        if(getTitle.equals("Lamping Kidang")){
            des.setText(textLampingKidang);
            harga.setText("Rp. 30.000/orang");
            kontak.setText("Asnawi");
        }else if(getTitle.equals("IPUKAN")){
            des.setText(textIpukan);
            harga.setText("Rp. 20.000/orang");
            kontak.setText("Jamal Mustopa");
        }else if(getTitle.equals("Talaga Surian")){
            des.setText(textTalagasurian);
            harga.setText("Rp. 23.000/orang");
            kontak.setText("Yunita");
        }else if(getTitle.equals("Cilengkrang")){
            des.setText(textCilengkrang);
            harga.setText("Rp. 25.000/orang");
            kontak.setText("Irfan");
        }else{
            des.setText("deskripsi wisata");
        }



        Button btnBooking = findViewById(R.id.btnBooking);
        btnBooking.setOnClickListener(v -> {
            Intent intent = new Intent(LampingKidang.this, booking.class);
            intent.putExtra("title", getTitle);
            startActivity(intent);
        });



    }
}