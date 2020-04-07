package hazifeladatkisbolt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PenztarEsemenyek {
    private Arucikk aru;
    private Kosar kosar = new Kosar();
    private Penztar vasarlas;
    private ArrayList<Penztar> penztarNaplo = new ArrayList<>();
    private Scanner lemezOlvaso;
    private String hiba;
    private boolean keszVagyok;
    
    public PenztarEsemenyek() {
            setKeszVagyok();
        if (keszVagyok){
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
    }

    public boolean getKeszVagyok(){
        return keszVagyok;
    }

    public String hiba(){
        return this.hiba;
    }
    
    public ArrayList<Penztar> getPenztarNaplo() {
        return penztarNaplo;
    }
    
    public int getArucikkElsoVasarlsa(String keresettArucikkNev){
        int vasarlasSzama = 0, j = 0, lefutas = 0;
        String vizsgaltArucikkNev = "";
        do{    
            while(j < penztarNaplo.get(vasarlasSzama).getKosar().getArucikkek().size()){
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
    
    public void adottVasrarlasTermekei(int vasarlasSorszama){
        if (vasarlasSorszama > 0 && vasarlasSorszama < penztarNaplo.size())
            penztarNaplo.get(--vasarlasSorszama).kosartartalmaMegjelenito();
        else System.out.println("Nincs ilyen szamu vasarlas");
    }

    public int mennybeKerulXDarab(int darabszam){
        int ar = 0;
        for (int i = 1; i <= darabszam; i++){
            if(i == 1) ar += 500;
            if(i == 2) ar += 450;
            if(i > 2)  ar += 400;
        }
        
        return ar;
    }    
        
    public void setKeszVagyok() {
        int sor = 0;
        try {            
            lemezOlvaso = new Scanner(new File("penztar.txt"));
            do{        
                    lemezOlvaso.nextLine();
                    sor++;
                } while(lemezOlvaso.hasNext());
            lemezOlvaso.close();
            if(sor <= 1000)    
             this.keszVagyok = true;
            else hiba = "Tul sok a sor a fileban";
        } catch (FileNotFoundException ex) {           
            hiba = "Nincs meg a file.";
        }        
    } 

    public void vasarlasiOsszegekKiirasa(){
        try {
            BufferedWriter iro = new BufferedWriter(new FileWriter("osszeg.txt"));
            int i = 1;
            String sor;
            for (Penztar fizetes : penztarNaplo){
                sor = Integer.toString(++i);
                sor += ": ";
                sor += Integer.toString(fizetes.getVegosszeg());
                iro.write(sor);
                iro.newLine();
                iro.flush();
        }

        } catch (IOException ex) {
            Logger.getLogger(PenztarEsemenyek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
