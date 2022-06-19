package com.example.pam_projectakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText edtNama, edtEmail, edtPassword, edtrepass;
    Button reg;

    String name, email, password, repass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNama = findViewById(R.id.edNama);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPass);
        edtrepass = findViewById(R.id.edrepass);
        reg = findViewById(R.id.btSignUp);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtNama.getText().toString();
                email = edtEmail.getText().toString();
                password = edtPassword.getText().toString();
                repass = edtrepass.getText().toString();

                //Membuat kondisi untuk mengecek apakah EditText kosong atau tidak
                if (name.isEmpty()) {
                    edtNama.setError("Nama Diperlukan");
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Toast.makeText(getApplicationContext(), "Wajib isi seluruh data !!!", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    edtEmail.setError("Email Diperlukan");
                    Toast.makeText(getApplicationContext(), "Wajib isi seluruh data !!!", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(repass)) {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();

                        Bundle b = new Bundle();
                        b.putString("a", name.trim());
                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        i.putExtras(b);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Password dan Re-Password harus sama!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}