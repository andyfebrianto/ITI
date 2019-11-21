package com.example.iti3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_ITI";
    private static final String tb_iti = "tb_iti";
    private static final String iti_id = "id";
    private static final String iti_nama = "nama";
    private static final String iti_alamat = "alamat";
    private static final String iti_tlpn = "tlpn";
    private static final String iti_agama = "agama";
    private static final String iti_jenis = "jenis";
    private static final String CREATE_TABLE_ITI = "CREATE TABLE " +
            tb_iti + "("
            + iti_id + " INTEGER PRIMARY KEY ,"
            + iti_nama + " TEXT,"
            + iti_alamat + " TEXT, "
            + iti_tlpn + " TEXT,"
            + iti_agama + " TEXT,"
            + iti_jenis + " TEXT " +")";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ITI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void CreateMahasiswa(ITI mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(iti_id, mdNotif.get_id());
        values.put(iti_nama, mdNotif.get_nama());
        values.put(iti_alamat, mdNotif.get_alamat());
        values.put(iti_tlpn, mdNotif.get_tlpn());
        values.put(iti_agama, mdNotif.get_agama());
        values.put(iti_jenis, mdNotif.get_jenis());
        db.insert(tb_iti, null, values);
        db.close();
    }

    public List<ITI> ReadMahasiswa() {
        List<ITI> judulModelList = new ArrayList<ITI>();
        String selectQuery = "SELECT * FROM " + tb_iti;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ITI mdKontak = new ITI();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_alamat(cursor.getString(2));
                mdKontak.set_tlpn(cursor.getString(3));
                mdKontak.set_agama(cursor.getString(4));
                mdKontak.set_jenis(cursor.getString(5));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateMahasiswa(ITI mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(iti_nama, mdNotif.get_nama());
        values.put(iti_alamat, mdNotif.get_alamat());
        values.put(iti_tlpn, mdNotif.get_tlpn());
        values.put(iti_agama, mdNotif.get_agama());
        values.put(iti_jenis, mdNotif.get_jenis());
        return db.update(tb_iti, values, iti_id + " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
    }

    public void DeleteMahasiswa(ITI mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_iti, iti_id + " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}