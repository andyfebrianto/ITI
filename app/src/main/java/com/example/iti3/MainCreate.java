package com.example.iti3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ealamat, Etlpn, Eagama, Ejenis;
    private String Snama, Salamat, Stlpn, Sagama, Sjenis;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(this, vabout.class));
        } else if (item.getItemId() == R.id.dti) {
            startActivity(new Intent(this, MainRead.class));
        } else if (item.getItemId() == R.id.ti) {
            startActivity(new Intent(this, MainCreate.class));
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ealamat = (EditText) findViewById(R.id.create_alamat);
        Etlpn = (EditText) findViewById(R.id.create_tlpn);
        Eagama = (EditText) findViewById(R.id.create_agama);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Stlpn = String.valueOf(Etlpn.getText());
                Sagama = String.valueOf(Eagama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                } if (Stlpn.equals("")){
                    Etlpn.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tlpn",
                            Toast.LENGTH_SHORT).show();
                } if (Sagama.equals("")){
                    Eagama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi agama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ealamat.setText("");
                    Etlpn.setText("");
                    Eagama.setText("");
                    Ejenis.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new ITI(null, Snama, Salamat, Stlpn, Sagama, Sjenis ));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}