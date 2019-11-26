package com.example.iti3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private EditText Eid ,Enama, Ealamat, Etlpn, Eagama, Ejenis;
    private String Sid ,Snama, Salamat, Stlpn, Sagama, Sjenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updl);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Salamat = i.getStringExtra("Ialamat");
        Stlpn = i.getStringExtra("Itlpn");
        Sagama = i.getStringExtra("Iagama");
        Sjenis = i.getStringExtra("Ijenis");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ealamat = (EditText) findViewById(R.id.updel_alamat);
        Etlpn = (EditText) findViewById(R.id.updel_tlpn);
        Eagama = (EditText) findViewById(R.id.updel_agama);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Enama.setText(Snama);
        Ealamat.setText(Salamat);
        Etlpn.setText(Stlpn);
        Eagama.setText(Sagama);
        Ejenis.setText(Sjenis);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Stlpn = String.valueOf(Etlpn.getText());
                Sagama = String.valueOf(Eagama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                } if (Stlpn.equals("")){
                    Etlpn.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi No Tlpn",
                            Toast.LENGTH_SHORT).show();
                } if (Sagama.equals("")){
                    Eagama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi agama",
                            Toast.LENGTH_SHORT).show();
                } if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMahasiswa(new ITI(Sid, Snama, Salamat, Stlpn, Sagama, Sjenis));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMahasiswa(new ITI(Sid, Snama, Salamat, Stlpn, Sagama, Sjenis));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}