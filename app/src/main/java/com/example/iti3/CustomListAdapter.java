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

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ITI> movieItems;
    public CustomListAdapter(Activity activity, List<ITI> movieItems) {
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
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView alamat = (TextView) convertView.findViewById(R.id.text_alamat);
        TextView tlpn = (TextView) convertView.findViewById(R.id.text_tlpn);
        TextView agama = (TextView) convertView.findViewById(R.id.text_agama);
        TextView jenis = (TextView) convertView.findViewById(R.id.text_jenis);
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        ITI m = movieItems.get(position);
        nama.setText("Nama Tempat Ibadah : "+ m.get_nama());
        alamat.setText("Alamat : "+ m.get_alamat());
        tlpn.setText("No Tlpn : "+ m.get_tlpn());
        agama.setText("Agama : "+ m.get_agama());
        jenis.setText("Jenis Tempat : "+ m.get_jenis());
        return convertView;
    }
}