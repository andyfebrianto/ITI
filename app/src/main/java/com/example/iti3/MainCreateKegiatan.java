package com.example.iti3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreateKegiatan extends AppCompatActivity {
    private DB_Kegiatan db;
    private EditText Enama, Ealamat, Etgl, Eagama, Ekegiatan;
    private String Snama, Salamat, Stgl, Sagama, Skegiatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create_kg);
        db = new DB_Kegiatan(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ealamat = (EditText) findViewById(R.id.create_alamat);
        Etgl = (EditText) findViewById(R.id.create_tgl);
        Eagama = (EditText) findViewById(R.id.create_agama);
        Ekegiatan = (EditText) findViewById(R.id.create_kegiatan);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Stgl = String.valueOf(Etgl.getText());
                Sagama = String.valueOf(Eagama.getText());
                Skegiatan = String.valueOf(Ekegiatan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreateKegiatan.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainCreateKegiatan.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                } if (Stgl.equals("")){
                    Etgl.requestFocus();
                    Toast.makeText(MainCreateKegiatan.this, "Silahkan isi tanggal",
                            Toast.LENGTH_SHORT).show();
                } if (Sagama.equals("")){
                    Eagama.requestFocus();
                    Toast.makeText(MainCreateKegiatan.this, "Silahkan isi agama",
                            Toast.LENGTH_SHORT).show();
                } else if (Skegiatan.equals("")){
                    Ekegiatan.requestFocus();
                    Toast.makeText(MainCreateKegiatan.this, "Silahkan isi kegiatan",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ealamat.setText("");
                    Etgl.setText("");
                    Eagama.setText("");
                    Ekegiatan.setText("");
                    Toast.makeText(MainCreateKegiatan.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new KegiatanITI(null, Snama, Salamat, Stgl, Sagama, Skegiatan ));
                    Intent a = new Intent(MainCreateKegiatan.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}