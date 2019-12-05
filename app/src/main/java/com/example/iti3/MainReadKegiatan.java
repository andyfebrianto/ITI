package com.example.iti3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainReadKegiatan extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private KegiatanListAdapter adapter_off;
    private DB_Kegiatan db;
    private List<KegiatanITI> ListKegiatan = new ArrayList<KegiatanITI>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read_kg);
        db = new DB_Kegiatan(this);
        adapter_off = new KegiatanListAdapter(this, ListKegiatan);
        mListView = (ListView) findViewById(R.id.list_mahasiswa);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListKegiatan.clear();
        List<KegiatanITI> contacts = db.ReadMahasiswa();
        for (KegiatanITI cn : contacts) {
            KegiatanITI judulModel = new KegiatanITI();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_alamat(cn.get_alamat());
            judulModel.set_tgl(cn.get_tgl());
            judulModel.set_agama(cn.get_agama());
            judulModel.set_kegiatan(cn.get_kegiatan());
            ListKegiatan.add(judulModel);
            if ((ListKegiatan.isEmpty()))
                Toast.makeText(MainReadKegiatan.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        KegiatanITI obj_itemDetails = (KegiatanITI) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Salamat = obj_itemDetails.get_alamat();
        String Stgl = obj_itemDetails.get_tgl();
        String Sagama = obj_itemDetails.get_agama();
        String Skegiatan = obj_itemDetails.get_kegiatan();
        Intent goUpdel = new Intent(MainReadKegiatan.this, MainUpdelKegiatan.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ialamat", Salamat);
        goUpdel.putExtra("Itgl", Stgl);
        goUpdel.putExtra("Iagama", Sagama);
        goUpdel.putExtra("Ikegiatan", Skegiatan);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListKegiatan.clear();
        mListView.setAdapter(adapter_off);
        List<KegiatanITI> contacts = db.ReadMahasiswa();
        for (KegiatanITI cn : contacts) {
            KegiatanITI judulModel = new KegiatanITI();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_alamat(cn.get_alamat());
            judulModel.set_tgl(cn.get_tgl());
            judulModel.set_agama(cn.get_agama());
            judulModel.set_kegiatan(cn.get_kegiatan());
            ListKegiatan.add(judulModel);
            if ((ListKegiatan.isEmpty()))
                Toast.makeText(MainReadKegiatan.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
