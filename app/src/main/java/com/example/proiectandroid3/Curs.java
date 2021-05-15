package com.example.proiectandroid3;

public class Curs {
    private String nume_curs;
    private String continut_curs;
    private Integer imagine_curs;

    public Curs(String nume_curs, String continut_curs, Integer imagine_curs) {
        this.nume_curs = nume_curs;
        this.continut_curs = continut_curs;
        this.imagine_curs = imagine_curs;
    }

    public String getNume_curs() {
        return nume_curs;
    }

    public void setNume_curs(String nume_curs) {
        this.nume_curs = nume_curs;
    }

    public String getContinut_curs() {
        return continut_curs;
    }

    public void setContinut_curs(String continut_curs) {
        this.continut_curs = continut_curs;
    }

    public Integer getImagine_curs() {
        return imagine_curs;
    }

    public void setImagine_curs(Integer imagine_curs) {
        this.imagine_curs = imagine_curs;
    }
}
