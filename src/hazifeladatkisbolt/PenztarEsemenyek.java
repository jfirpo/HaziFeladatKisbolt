package hazifeladatkisbolt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PenztarEsemenyek implements PenztariEsemenykezelo{
    private Arucikk aru;
    private KosarInterface kosar = new Kosar();
    private Penztar vasarlas;
    private ArrayList<Penztar> penztarNaplo = new ArrayList<>();
    private Scanner lemezOlvaso;
    
    public PenztarEsemenyek() {
            try {
                lemezOlvaso = new Scanner(new File("penztar.txt"));
            do{        
                int p = 0;
                String sor;          
                sor = "";
                kosar = new Kosar();
                do{
                    sor = lemezOlvaso.nextLine();                             
                    if(!sor.equals("F")) {
                        aru = new Arucikk(sor);
                        kosar.kosarbaHelyez(aru);
                    }    
                } while(!sor.equals("F"));                    
                vasarlas = new Penztar(kosar);                
                penztarNaplo.add(vasarlas);                
            } while(lemezOlvaso.hasNext());
            lemezOlvaso.close();
            } catch (FileNotFoundException ex) {                
            }
    }
     
    @Override
    public int getArucikkElsoVasarlsa(String keresettArucikkNev){
        int vasarlasSzama = 0, j = 0, lefutas = 0;
        String vizsgaltArucikkNev = "";
        do{    
            while(j < penztarNaplo.get(vasarlasSzama).getKosar().kosarMerete()){
                if (keresettArucikkNev.equals(penztarNaplo.get(vasarlasSzama).getKosar().getArucikkek().get(j).getArucikkNev()))
                    vizsgaltArucikkNev = keresettArucikkNev;                    
                j++;
            }
            vasarlasSzama++;
            j = 0;
            lefutas++;
        } while(!keresettArucikkNev.equals(vizsgaltArucikkNev) && lefutas != penztarNaplo.size());     
        if (vizsgaltArucikkNev.equals(keresettArucikkNev) )
            return vasarlasSzama;
        else return 0;
    }
    
    @Override
    public int getArucikkUtolsoVasarlsa(String keresettArucikkNev){
        int vasarlasSzama = penztarNaplo.size()-1, j = 0, lefutas = 0;
        String vizsgaltArucikkNev = "";
        do{     
            while(j < penztarNaplo.get(vasarlasSzama).getKosar().getArucikkek().size()){
                if (keresettArucikkNev.equals(penztarNaplo.get(vasarlasSzama).getKosar().getArucikkek().get(j).getArucikkNev()))
                    vizsgaltArucikkNev = keresettArucikkNev;                    
                j++;
            }
            vasarlasSzama--;
            j = 0;
            lefutas++;
        } while(!keresettArucikkNev.equals(vizsgaltArucikkNev) && lefutas != penztarNaplo.size());     //while(!keresettArucikkNev.equals(vizsgaltArucikkNev));     
        if (vizsgaltArucikkNev.equals(keresettArucikkNev) )
            return 2+vasarlasSzama;
        else return 0;
    }
    
    @Override
    public int eladottTermekSzam(String arucikkNev){
        int eladottTermekszam = 0;
        for (int i = 0; i < penztarNaplo.size();i++){   
            for (int j = 0; j<penztarNaplo.get(i).getKosar().getArucikkek().size(); j++){
                if (penztarNaplo.get(i).getKosar().getArucikkek().get(j).getArucikkNev().equals(arucikkNev))
                    eladottTermekszam++;
            }
        }
        return eladottTermekszam;    
    }
    
    @Override
    public void adottVasrarlasTermekei(int vasarlasSorszama){
        if (vasarlasSorszama > 0 && vasarlasSorszama < penztarNaplo.size())
            penztarNaplo.get(--vasarlasSorszama).kosartartalmaMegjelenitoMap();
        else System.out.println("Nincs ilyen szamu vasarlas");
    }
        
    @Override
    public void vasarlasiOsszegekKiirasa(){
        try {
            BufferedWriter iro = new BufferedWriter(new FileWriter("osszeg.txt"));
            int i = 1;
            String sor;
            for (Penztar fizetes : penztarNaplo){
                sor = Integer.toString(i++);
                sor += ": ";
                sor += fizetes.getVegosszeg().toString();
                iro.write(sor);
                iro.newLine();
                iro.flush();
        }

        } catch (IOException ex) {
            Logger.getLogger(PenztarEsemenyek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int vasarlasOsszesen(){
        return this.penztarNaplo.size();
    }

    @Override
    public int megadottVasarlasKosarMeret(int vasarlasSzama) {
        return penztarNaplo.get(--vasarlasSzama).getKosar().kosarMerete();
    }

    @Override
    public BigDecimal mennyiXDarab(int darabszam) {
        return Penztar.mennybeKerulXDarab(darabszam);
    }
}
