package com.example.latihan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class bayar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bayar);
//        mengambil nilai dari intent
        String Diskon = getIntent().getStringExtra("Diskon");
        String Total = getIntent().getStringExtra("Total");
//        menampilkan ke layar
        TextView tvBayar = findViewById(R.id.inBayar);
        TextView tvTotal = findViewById(R.id.inTotal);

        TextView tvTanggal = findViewById(R.id.Tanggal);
//        ngambil tanggal
        String BuatTgl = getCurrentDate();
//        menampilkan tanggal
        tvTanggal.setText(BuatTgl);

        tvBayar.setText(Diskon);
        tvTotal.setText(Total);

        Button btnMaps = findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(v -> {
            Intent i = new Intent(bayar.this, maps.class);
            startActivity(i);
        });


    }
    private String getCurrentDate() {
        // Format tanggal (contoh: 05 Januari 2025)
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = new Date(); // Dapatkan tanggal saat ini
        return dateFormat.format(date); // Format tanggal sesuai kebutuhan
    }
}