package com.example.latihan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class booking extends AppCompatActivity {
    private int ticketCount = 0;
    private int hargaTiket = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);

        Intent i = getIntent();
        String titleWisata = i.getStringExtra("title");

        ImageView gambar = findViewById(R.id.imgBooking);
        TextView title = findViewById(R.id.txtTitle);
        TextView harga = findViewById(R.id.titleHarga);
//        mengatur gambar yg akan di tampilkan

        ImageButton btnMinus = findViewById(R.id.btnMinus);
        ImageButton btnPlus = findViewById(R.id.btnTambah);
        TextView tiket = findViewById(R.id.tiket);
        EditText jumTiket = findViewById(R.id.inJumlah);
        EditText setelahDiskon = findViewById(R.id.diskon);
        TextView totalBiaya = findViewById(R.id.total);

//        set gambar sesuai data booking

        if(titleWisata.equals("Lamping Kidang")){
            gambar.setImageResource(R.drawable.lampingkidang);
            title.setText("WIsata "+titleWisata+"\nHarga untuk 1 tiket");
            harga.setText("Rp.30.000");
            hargaTiket = 30000;
        }else if(titleWisata.equals("Talaga Surian")){
            gambar.setImageResource(R.drawable.talagasurian);
            title.setText("WIsata "+titleWisata+"\nHarga untuk 1 tiket");
            harga.setText("Rp.23.000");
            hargaTiket = 23000;
        }else if(titleWisata.equals("IPUKAN")){
            gambar.setImageResource(R.drawable.ipukan);
            title.setText("WIsata "+titleWisata+"\nHarga untuk 1 tiket");
            harga.setText("Rp.20.000");
            hargaTiket = 20000;
        }else if(titleWisata.equals("Cilengkrang")){
            gambar.setImageResource(R.drawable.cilengkrang);
            title.setText("WIsata "+titleWisata+"\nHarga untuk 1 tiket");
            harga.setText("Rp.25.000");
            hargaTiket = 25000;
        }else {
            gambar.setImageResource(R.drawable.bg1);
            title.setText("Judul Defaul");
            harga.setText("Rp.25.000");
        }


//        fungsi tombol minus
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ticketCount--; // Tambahkan jumlah tiket
                int itemTotal = ticketCount * hargaTiket;
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
                int itemTotal = ticketCount * hargaTiket;
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