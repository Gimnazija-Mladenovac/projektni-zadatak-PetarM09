package projekat.model;

import java.util.ArrayList;
import java.util.List;

public class Kombinacija {
    private String izvodjac;
    private List<Numera> numere;

    public Kombinacija(String izvodjac) {
        this.izvodjac = izvodjac;
        this.numere = new ArrayList<>();
    }

    public void addNumera(Numera n){
        this.numere.add(n);
    }

    public String getIzvodjac() {
        return izvodjac;
    }

    public void setIzvodjac(String izvodjac) {
        this.izvodjac = izvodjac;
    }

    public List<Numera> getNumere() {
        return numere;
    }

    public void setNumere(List<Numera> numere) {
        this.numere = numere;
    }
}
