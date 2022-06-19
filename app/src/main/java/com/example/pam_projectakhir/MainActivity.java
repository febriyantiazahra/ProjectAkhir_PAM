package com.example.pam_projectakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnSignIn;

    //Deklarasi variabel untuk TextView
    TextView edregister;

    //Deklarasi variabel untuk EditText
    EditText ednama, edpassword;

    //Deklarasi variabel untuk String
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnSignIn = findViewById(R.id.btSignIn);

        //Menghubungkan variabel ednama dengan componen button pada layout
        ednama = findViewById(R.id.edNama);

        //Menghubungkan variabel edPassword dengan componen button pada layout
        edpassword = findViewById(R.id.edPassword);

        //Menghubungkan variabel edregister dengan componen button pada layout
        edregister = findViewById(R.id.eBuat);

        //Membuat fungsi onclick pada textview edregister
        edregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Membuat objek intent berpindah activity dari MainActivity ke RegisterActivity
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);

                //berpindah ke RegisterActivity
                startActivity(i);
            }
        });

        //Membuat fungsi onclick pada button btnSignIn
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext nama kedalam variabel nama
                nama = ednama.getText().toString();
                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //mengeset nama yang benar
                String nm = "Febriyanti";
                //mengeset password yang benar
                String pass = "12345";

                //Membuat peringatan validasi inputan
                if(nama.isEmpty()) {
                    ednama.setError("Nama Diperlukan");
                }
                else if (password.isEmpty()) {
                    ednama.setError("Password Diperlukan");
                }

                //Membuat validasi Sign-In inputan user
                else if (nama.equals(nm) && password.equals(pass)){
                    Toast.makeText(getApplicationContext(),"Login Berhasil", Toast.LENGTH_SHORT).show();

                    Bundle b = new Bundle();
                    b.putString("a", nama.trim());
                    b.putString("b", password.trim());

                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    i.putExtras(b);
                    startActivity(i);

                    //Menghapus isi dari textview
                    ednama.getText().clear();
                    edpassword.getText().clear();
                }
                else if (nama.equals(nm)) {
                    Toast.makeText(getApplicationContext(),"Password Salah", Toast.LENGTH_SHORT).show();
                }
                else if (password.equals(pass)) {
                    Toast.makeText(getApplicationContext(),"Nama Salah", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Email dan Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}