package com.example.projek_tam;

public class TaskObject {
    private String acara;
    private String berakhir;
    private String catatan;
    private String lokasi;
    private String mulai;
    private String tanggal;

    public TaskObject(String acara){
        this.acara = acara;
    }

    public TaskObject(String acara, String berakhir, String catatan, String lokasi, String mulai, String tanggal) {
        this.acara = acara;
        this.berakhir = berakhir;
        this.catatan = catatan;
        this.lokasi = lokasi;
        this.mulai = mulai;
        this.tanggal = tanggal;
    }

    public String getAcara() {
        return acara;
    }

    public void setAcara(String acara) {
        this.acara = acara;
    }

    public String getBerakhir() {
        return berakhir;
    }

    public void setBerakhir(String berakhir) {
        this.berakhir = berakhir;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
