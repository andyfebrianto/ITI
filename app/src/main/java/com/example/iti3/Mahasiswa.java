package com.example.iti3;

class Mahasiswa {
    private String nama;
        private String nim;
        private String jurusan;
        private Integer foto;


    Mahasiswa(String nama, String nim, String jurusan, Integer foto) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
