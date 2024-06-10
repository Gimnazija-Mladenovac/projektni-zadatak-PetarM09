package projekat.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Database {

    private static Database instance;

    private Map<Numera, Integer> numere;
    private Set<String> izvodjaci;
    private Set<String> zanrovi;

    private List<Kombinacija> mojaKolekcija;

    public static Database getInstance() {
        if(instance == null)
            instance = new Database();
        return instance;
    }

    private Database(){
        this.izvodjaci = new HashSet<>();
        this.numere = new HashMap();
        this.zanrovi = new HashSet<>();
        this.mojaKolekcija = new ArrayList<>();
        ucitaj();
    }

    public void dodajUKolkeciju(List<Numera> numere){
        for(Numera n : numere){
            Kombinacija komb = null;
            for(Kombinacija k : mojaKolekcija){
                if(k.getIzvodjac().equals(n.getIzvodjac())){
                    komb = k;
                    break;
                }
            }
            if(komb != null){
                komb.addNumera(n);
            }else{
                Kombinacija nova = new Kombinacija(n.getIzvodjac());
                nova.addNumera(n);
                mojaKolekcija.add(nova);
            }
        }
    }

    private void ucitaj(){
        File file = new File("katalog.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linija;
            String aktuelniZanr = "";
            while((linija = reader.readLine()) != null){
                String split[] = linija.split(",");
                if(split.length == 1){
                    aktuelniZanr = linija;
                    continue;
                }
                // Vinyl-1
                String tip = split[3].split("-")[0];
                int kolicina = Integer.parseInt(split[3].split("-")[1]);
                Numera n = new Numera(
                        split[0],
                        split[1],
                        Integer.parseInt(split[2]),
                        aktuelniZanr,
                        Tip.valueOf(tip.toUpperCase()),
                        Integer.parseInt(split[4]),
                        Kategorija.valueOf(split[5])
                );
                izvodjaci.add(split[0]);
                numere.put(n, kolicina);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Numera, Integer> getNumere() {
        return numere;
    }

    public Set<String> getIzvodjaci() {
        return izvodjaci;
    }

    public Set<String> getZanrovi() {
        return zanrovi;
    }

    public List<Kombinacija> getMojaKolekcija() {
        return mojaKolekcija;
    }
}