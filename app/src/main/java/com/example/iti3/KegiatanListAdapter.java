package com.example.iti3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KegiatanListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<KegiatanITI> movieItems;
    public KegiatanListAdapter(Activity activity, List<KegiatanITI> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list_kg, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.text_alamat);
        TextView tgl = (TextView) convertView.findViewById(R.id.text_tgl);
        TextView agama = (TextView) convertView.findViewById(R.id.text_agama);
        TextView kegiatan = (TextView) convertView.findViewById(R.id.text_kegiatan);
        KegiatanITI m = movieItems.get(position);
        nama.setText("Nama Tempat Ibadah : "+ m.get_nama());
        alamat.setText("Alamat : "+ m.get_alamat());
        tgl.setText("No Tlpn : "+ m.get_tgl());
        agama.setText("Agama : "+ m.get_agama());
        kegiatan.setText("Jenis Tempat : "+ m.get_kegiatan());
        return convertView;
    }
}