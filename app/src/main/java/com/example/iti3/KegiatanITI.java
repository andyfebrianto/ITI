package com.example.iti3;

public class KegiatanITI {
    private String _id, _nama, _alamat, _tgl, _agama, _kegiatan;
    public KegiatanITI(String id, String nama, String alamat, String tgl, String agama, String kegiatan){
        this._id =id;
        this._nama=nama;
        this._alamat=alamat;
        this._tgl=tgl;
        this._agama=agama;
        this._kegiatan=kegiatan;
    }

    public KegiatanITI() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_alamat() {
        return _alamat;
    }

    public void set_alamat(String _alamat) {
        this._alamat = _alamat;
    }

    public String get_tgl() {
        return _tgl;
    }

    public void set_tgl(String _tgl) {
        this._tgl = _tgl;
    }

    public String get_agama() {
        return _agama;
    }

    public void set_agama(String _agama) {
        this._agama = _agama;
    }

    public String get_kegiatan() {
        return _kegiatan;
    }

    public void set_kegiatan(String _kegiatan) {
        this._kegiatan = _kegiatan;
    }
}
