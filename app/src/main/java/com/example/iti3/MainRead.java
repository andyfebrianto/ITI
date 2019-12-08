package com.example.iti3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<ITI> ListMahasiswa = new ArrayList<ITI>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dti);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMahasiswa);
        mListView = (ListView) findViewById(R.id.list_mahasiswa);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMahasiswa.clear();
        List<ITI> contacts = db.ReadMahasiswa();
        for (ITI cn : contacts) {
            ITI judulModel = new ITI();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_alamat(cn.get_alamat());
            judulModel.set_tlpn(cn.get_tlpn());
            judulModel.set_agama(cn.get_agama());
            judulModel.set_jenis(cn.get_jenis());
            ListMahasiswa.add(judulModel);
            if ((ListMahasiswa.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        ITI obj_itemDetails = (ITI) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Salamat = obj_itemDetails.get_alamat();
        String Stlpn = obj_itemDetails.get_tlpn();
        String Sagama = obj_itemDetails.get_agama();
        String Sjenis = obj_itemDetails.get_jenis();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ialamat", Salamat);
        goUpdel.putExtra("Itlpn", Stlpn);
        goUpdel.putExtra("Iagama", Sagama);
        goUpdel.putExtra("Ijenis", Sjenis);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListMahasiswa.clear();
        mListView.setAdapter(adapter_off);
        List<ITI> contacts = db.ReadMahasiswa();
        for (ITI cn : contacts) {
            ITI judulModel = new ITI();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_alamat(cn.get_alamat());
            judulModel.set_tlpn(cn.get_tlpn());
            judulModel.set_agama(cn.get_agama());
            judulModel.set_jenis(cn.get_jenis());
            ListMahasiswa.add(judulModel);
            if ((ListMahasiswa.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
