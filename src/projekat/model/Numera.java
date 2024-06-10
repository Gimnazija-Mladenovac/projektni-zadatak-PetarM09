package projekat.model;

import javax.xml.crypto.Data;
import java.util.Objects;

public class Numera {

    private String izvodjac;
    private String naziv;
    private int godina;
    private String zanr;
    private Tip tip;
    private int cena;
    private Kategorija kategorija;

    public Numera(String izvodjac, String naziv, int godina, String zanr, Tip tip, int cena, Kategorija kategorija) {
        this.izvodjac = izvodjac;
        this.naziv = naziv;
        this.godina = godina;
        this.zanr = zanr;
        this.tip = tip;
        this.cena = cena;
        this.kategorija = kategorija;
    }

    @Override
    public String toString() {
        return String.format("%s ,,%s\" %ddin.", izvodjac, naziv, cena);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numera numera = (Numera) o;
        return godina == numera.godina && cena == numera.cena && izvodjac.equals(numera.izvodjac) && naziv.equals(numera.naziv) && zanr.equals(numera.zanr) && tip == numera.tip && kategorija == numera.kategorija;
    }

    @Override
    public int hashCode() {
        return Objects.hash(izvodjac, naziv, godina, zanr, tip, cena, kategorija);
    }

    public String getIzvodjac() {
        return izvodjac;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getGodina() {
        return godina;
    }

    public String getZanr() {
        return zanr;
    }

    public Tip getTip() {
        return tip;
    }

    public int getCena() {
        return cena;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public int getKomad(){
        for(var x : Database.getInstance().getNumere().entrySet()){
            if(this.equals(x.getKey()))
                return x.getValue();
        }
        return -1;
    }
}