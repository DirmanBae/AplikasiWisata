package com.example.latihan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class booking extends AppCompatActivity {
    private int ticketCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);

        ImageButton btnMinus = findViewById(R.id.btnMinus);
        ImageButton btnPlus = findViewById(R.id.btnTambah);
        TextView tiket = findViewById(R.id.tiket);
        EditText jumTiket = findViewById(R.id.inJumlah);
        EditText setelahDiskon = findViewById(R.id.diskon);
        TextView totalBiaya = findViewById(R.id.total);


//        fungsi tombol minus
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketCount--; // Tambahkan jumlah tiket
                int itemTotal = ticketCount * 20000;
                int Diskon = itemTotal - 20 * itemTotal / 100;
                int total = Diskon + 2000;
//                merubah hasil ke dalam string
                String totalString = String.valueOf(total);
                String itemTotalString = String.valueOf(itemTotal);
                String DiskonString = String.valueOf(Diskon);
//                menampilkan / set ke layar
                jumTiket.setText(itemTotalString);
                setelahDiskon.setText(DiskonString);
                totalBiaya.setText("Rp."+" "+totalString);
                tiket.setText(String.valueOf(ticketCount));
            }
        });


//        fungsi tombol plus
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketCount++; // Tambahkan jumlah tiket
                int itemTotal = ticketCount * 20000;
                int Diskon = itemTotal - 20 * itemTotal / 100;
                int total = Diskon + 2000;
//                merubah hasil ke dalam string
                String totalString = String.valueOf(total);
                String itemTotalString = String.valueOf(itemTotal);
                String DiskonString = String.valueOf(Diskon);
//                menampilkan / set ke layar
                jumTiket.setText(itemTotalString);
                setelahDiskon.setText(DiskonString);
                totalBiaya.setText("Rp."+" "+totalString);
                tiket.setText(String.valueOf(ticketCount));
            }
        });

        Button btnBayar = findViewById(R.id.btnBayar);
        btnBayar.setOnClickListener(v -> {
            Intent intent = new Intent(booking.this, bayar.class);
            intent.putExtra("Diskon", setelahDiskon.getText().toString());
            intent.putExtra("Total", totalBiaya.getText().toString());
            startActivity(intent);
        });
    }
}