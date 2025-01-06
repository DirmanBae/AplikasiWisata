package com.example.latihan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

//        mengambil isi dari Inten
        Intent intent = getIntent();
        String Iemail = intent.getStringExtra("email");
        String Ipass = intent.getStringExtra("pass");

        EditText inEmail = findViewById(R.id.inEmail);
        EditText inPass = findViewById(R.id.inPass);

        Button btnLogin = findViewById(R.id.btnLogin);
        TextView btnRegis = findViewById(R.id.btnRegis);

        btnRegis.setOnClickListener(v -> {
            Intent i = new Intent(login.this, register.class);
            startActivity(i);
        });

        btnLogin.setOnClickListener(v -> {
            String email = inEmail.getText().toString().trim();
            String pass = inPass.getText().toString().trim();
            if( email.isEmpty() || pass.isEmpty() ){
                Toast.makeText(this, "Email dan Password harus diisi dahulu", Toast.LENGTH_SHORT).show();
                inEmail.setText("");
                inPass.setText("");
            }else if(email.equals(Iemail) && pass.equals(Ipass)){
                Toast.makeText(this, "Selamat Datang"+" "+email, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(login.this, dashboard.class);
                i.putExtra("email", email);
                startActivity(i);
            }else{
                Toast.makeText(this, "kombinasi Email dan Password salah", Toast.LENGTH_SHORT).show();
                inEmail.setText("");
                inPass.setText("");
            }

        });
    }
}