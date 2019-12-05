package com.example.iti3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdelKegiatan extends AppCompatActivity {
    private DB_Kegiatan db;
    private EditText Eid ,Enama, Ealamat, Etgl, Eagama, Ekegiatan;
    private String Sid ,Snama, Salamat, Stgl, Sagama, Skegiatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel_kg);
        db = new DB_Kegiatan(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Salamat = i.getStringExtra("Ialamat");
        Stgl = i.getStringExtra("Itgl");
        Sagama = i.getStringExtra("Iagama");
        Skegiatan = i.getStringExtra("Ikegiatan");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ealamat = (EditText) findViewById(R.id.updel_alamat);
        Etgl = (EditText) findViewById(R.id.updel_tgl);
        Eagama = (EditText) findViewById(R.id.updel_agama);
        Ekegiatan = (EditText) findViewById(R.id.updel_kegiatan);
        Enama.setText(Snama);
        Ealamat.setText(Salamat);
        Etgl.setText(Stgl);
        Eagama.setText(Sagama);
        Ekegiatan.setText(Skegiatan);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Stgl = String.valueOf(Etgl.getText());
                Sagama = String.valueOf(Eagama.getText());
                Skegiatan = String.valueOf(Ekegiatan.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdelKegiatan.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainUpdelKegiatan.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                } if (Stgl.equals("")){
                    Etgl.requestFocus();
                    Toast.makeText(MainUpdelKegiatan.this, "Silahkan isi No Tgl",
                            Toast.LENGTH_SHORT).show();
                } if (Sagama.equals("")){
                    Eagama.requestFocus();
                    Toast.makeText(MainUpdelKegiatan.this, "Silahkan isi agama",
                            Toast.LENGTH_SHORT).show();
                } if (Skegiatan.equals("")){
                    Ekegiatan.requestFocus();
                    Toast.makeText(MainUpdelKegiatan.this, "Silahkan isi kegiatan",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMahasiswa(new KegiatanITI(Sid, Snama, Salamat, Stgl, Sagama, Skegiatan));
                    Toast.makeText(MainUpdelKegiatan.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMahasiswa(new KegiatanITI(Sid, Snama, Salamat, Stgl, Sagama, Skegiatan));
                Toast.makeText(MainUpdelKegiatan.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}