package com.example.iti3;

public class ITI {
    private String _id, _nama, _alamat, _tlpn, _agama, _jenis;
    public ITI(String id, String nama, String alamat, String tlpn, String agama, String jenis){
        this._id =id;
        this._nama=nama;
        this._alamat=alamat;
        this._tlpn=tlpn;
        this._agama=agama;
        this._jenis=jenis;
    }

    public ITI() {

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

    public String get_tlpn() {
        return _tlpn;
    }

    public void set_tlpn(String _tlpn) {
        this._tlpn = _tlpn;
    }

    public String get_agama() {
        return _agama;
    }

    public void set_agama(String _agama) {
        this._agama = _agama;
    }

    public String get_jenis() {
        return _jenis;
    }

    public void set_jenis(String _jenis) {
        this._jenis = _jenis;
    }
}
