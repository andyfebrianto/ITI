package com.example.iti3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DB_Kegiatan extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_ITI_KG";
    private static final String tb_iti_kg = "tb_iti_kg";
    private static final String iti_id = "id";
    private static final String iti_nama = "nama";
    private static final String iti_alamat = "alamat";
    private static final String iti_tgl = "tgl";
    private static final String iti_agama = "agama";
    private static final String iti_kegiatan = "kegiatan";
    private static final String CREATE_TABLE_ITI = "CREATE TABLE " +
            tb_iti_kg + "("
            + iti_id + " INTEGER PRIMARY KEY ,"
            + iti_nama + " TEXT,"
            + iti_alamat + " TEXT, "
            + iti_tgl + " TEXT,"
            + iti_agama + " TEXT,"
            + iti_kegiatan + " TEXT " +")";

    public DB_Kegiatan(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ITI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void CreateMahasiswa(KegiatanITI mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(iti_id, mdNotif.get_id());
        values.put(iti_nama, mdNotif.get_nama());
        values.put(iti_alamat, mdNotif.get_alamat());
        values.put(iti_tgl, mdNotif.get_tgl());
        values.put(iti_agama, mdNotif.get_agama());
        values.put(iti_kegiatan, mdNotif.get_kegiatan());
        db.insert(tb_iti_kg, null, values);
        db.close();
    }

    public List<KegiatanITI> ReadMahasiswa() {
        List<KegiatanITI> judulModelList = new ArrayList<KegiatanITI>();
        String selectQuery = "SELECT * FROM " + tb_iti_kg;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                KegiatanITI mdKontak = new KegiatanITI();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_alamat(cursor.getString(2));
                mdKontak.set_tgl(cursor.getString(3));
                mdKontak.set_agama(cursor.getString(4));
                mdKontak.set_kegiatan(cursor.getString(5));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }

    public int UpdateMahasiswa(KegiatanITI mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(iti_nama, mdNotif.get_nama());
        values.put(iti_alamat, mdNotif.get_alamat());
        values.put(iti_tgl, mdNotif.get_tgl());
        values.put(iti_agama, mdNotif.get_agama());
        values.put(iti_kegiatan, mdNotif.get_kegiatan());
        return db.update(tb_iti_kg, values, iti_id + " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
    }

    public void DeleteMahasiswa(KegiatanITI mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_iti_kg, iti_id + " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}