package com.example.proiectandroid3;

public class Categorie {
    private String nume_categorie;
    private String poza;

    public Categorie(String nume_categorie, String poza) {
        this.nume_categorie = nume_categorie;
        this.poza = poza;
    }

    public String getNume_categorie() {
        return nume_categorie;
    }

    public void setNume_categorie(String nume_categorie) {
        this.nume_categorie = nume_categorie;
    }

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }
}
