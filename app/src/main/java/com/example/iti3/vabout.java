package com.example.iti3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class vabout extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        addData();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_1);
        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(vabout.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void addData() {
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("ANDY FEBRIANTO", "1718014", "TEKNIK INFORMATIKA",R.drawable.ic_person));
        mahasiswaArrayList.add(new Mahasiswa("STEVANIA HILDEGARDIS BERE", "1718017", "TEKNIK INFORMATIKA", R.drawable.ic_person));
        mahasiswaArrayList.add(new Mahasiswa("OFHY DINI SUSANTI", "1718018", "TEKNIK INFORMATIKA", R.drawable.ic_person));
        mahasiswaArrayList.add(new Mahasiswa("PRATEDYO SEPTIARDO", "1718028", "TEKNIK INFORMATIKA", R.drawable.ic_person));
    }

}
