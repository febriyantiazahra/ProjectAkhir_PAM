package com.example.pam_projectakhir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class InputDataActivity extends AppCompatActivity {
    private EditText etNama, etTTL, etUmur, etAGAMA, etBB, etTB, etJK, etAlamat;
    private Button btnSimpan;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;
    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        etNama = findViewById(R.id.editNama);
        etTTL = findViewById(R.id.editTTL);
        etUmur = findViewById(R.id.editUmur);
        etAGAMA = findViewById(R.id.editAgama);
        etBB = findViewById(R.id.editBB);
        etTB = findViewById(R.id.editTB);
        etJK = findViewById(R.id.editJK);
        etAlamat = findViewById(R.id.editAlamat);
        btnSimpan = findViewById(R.id.btnSimpan);

        progressDialog = new ProgressDialog(InputDataActivity.this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Menyimpan...");


        btnSimpan.setOnClickListener(V -> {
                if (etNama.getText().length() > 0 &&
                        etTTL.getText().length() > 0 &&
                        etUmur.getText().length() > 0 &&
                        etAGAMA.getText().length() > 0 &&
                        etBB.getText().length() > 0 &&
                        etTB.getText().length() > 0 &&
                        etJK.getText().length() > 0 &&
                        etAlamat.getText().length() > 0)
                {
                    saveData(etNama.getText().toString(),
                            etTTL.getText().toString(),
                            etUmur.getText().toString(),
                            etAGAMA.getText().toString(),
                            etBB.getText().toString(),
                            etTB.getText().toString(),
                            etJK.getText().toString(),
                            etAlamat.getText().toString());
                } else {
                    Toast.makeText(getApplicationContext(),"Silahkan Isi Semua Data!", Toast.LENGTH_SHORT).show();
                }
        });

        Intent intent = getIntent();
        if (intent!=null) {
            id = intent.getStringExtra("id");
            etNama.setText(intent.getStringExtra("nama"));
            etTTL.setText(intent.getStringExtra("ttl"));
            etUmur.setText(intent.getStringExtra("umur"));
            etAGAMA.setText(intent.getStringExtra("agama"));
            etBB.setText(intent.getStringExtra("bb"));
            etTB.setText(intent.getStringExtra("tb"));
            etJK.setText(intent.getStringExtra("jeniskelamin"));
            etAlamat.setText(intent.getStringExtra("alamat"));
        }
    }

    private void saveData(String nama, String ttl, String umur, String agama, String bb, String tb, String jeniskelamin, String alamat) {
        Map<String, Object> user = new HashMap<>();
        user.put("nama", nama);
        user.put("ttl", ttl);
        user.put("umur", umur);
        user.put("agama", agama);
        user.put("bb", bb);
        user.put("tb", tb);
        user.put("jeniskelamin", jeniskelamin);
        user.put("alamat", alamat);

        progressDialog.show();

        if (id != null){
            db.collection("users").document(id)
                    .set(user)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(InputDataActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(InputDataActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }else {
            db.collection("users")
                    .add(user)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(InputDataActivity.this, "Berhasil di simpan", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InputDataActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    });
        }
    }

    public void simpan(View view) {
    }
}