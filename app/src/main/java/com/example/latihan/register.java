package com.example.latihan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

//        definisi inputan
        EditText inNama = findViewById(R.id.inNama);
        EditText inEmail = findViewById(R.id.inEmail);
        EditText inPass = findViewById(R.id.inPass);
        EditText inPass2 = findViewById(R.id.inPass2);
        Button btnRegis = findViewById(R.id.btnRegis);

        TextView btnLogin = findViewById(R.id.btnLogin);


//        membuat variabel untuk button
        ImageButton btnGoogle = findViewById(R.id.btnGoogle);
        ImageButton btnEmail = findViewById(R.id.btnEmail);
        ImageButton btnFacebook = findViewById(R.id.btnFacebook);
        ImageButton btnWhatsapp = findViewById(R.id.btnWhatsapp);
//        membuat fungsi

//        daftar dengan google
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

//        daftar dengan Gmail
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://mail.google.com/mail/u/0/#inbox";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

//        daftar dengan facebook
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://id-id.facebook.com/login/web/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

//        daftar dengan WhatsApp
        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://web.whatsapp.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });




        btnRegis.setOnClickListener(v -> {
            String Nama = inNama.getText().toString();
            String Email = inEmail.getText().toString();
            String Pass = inPass.getText().toString();
            String Pass2 = inPass2.getText().toString();
            if (Nama.isEmpty() || Email.isEmpty()){
                Toast.makeText(this, "Inputan harus di isi semua", Toast.LENGTH_SHORT).show();
            }else if(Pass.isEmpty() || Pass2.isEmpty()){
                Toast.makeText(this, "Inputan harus di isi semua", Toast.LENGTH_SHORT).show();
            }else if(Pass.equals(Pass2)){
                Toast.makeText(this, "Daftar berhasil, Silahkan Login", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(register.this, login.class);
                i.putExtra("email",Email);
                i.putExtra("pass",Pass);
                startActivity(i);
            }else{
                Toast.makeText(this, "Password 1 dan Password 2 tidak sama", Toast.LENGTH_SHORT).show();
            }
        });
        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(register.this, login.class);
            i.putExtra("email","admin");
            i.putExtra("pass","123");
            startActivity(i);
        });

    }
}