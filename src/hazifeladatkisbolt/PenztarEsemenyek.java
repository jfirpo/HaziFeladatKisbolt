package hazifeladatkisbolt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PenztarEsemenyek{
    private Arucikk aru;
    private Kosar kosar = new Kosar();
    private Penztar vasarlas;
    private List<Penztar> penztarNaplo = new ArrayList();
    private Scanner lemezOlvaso;
    private final String URESSTRING = "";
    
    public PenztarEsemenyek() {
        penztarMemoriaBetoltese();
    }
     
    public int getArucikkElsoVasarlsa(String keresettArucikkNev){
        for (int i = 0; i < penztarNaplo.size(); i++){
            if (penztarNaplo.get(i).vanXtermekakosarban(keresettArucikkNev))
                return ++i;
        }
        return 0;
    }

    public int getArucikkUtolsoVasarlsa(String keresettArucikkNev){
        for (int i = penztarNaplo.size()-1; i != 0; i--){
            if (penztarNaplo.get(i).vanXtermekakosarban(keresettArucikkNev))
                return ++i;
        }
        return 0;
    }
        
    public int eladottTermekSzam(String arucikkNev){
        int osszesenEladottTermekszam = 0;
        for(Penztar eladas : penztarNaplo){
            osszesenEladottTermekszam += eladas.hanyDarabXTermekVanAKosarban(arucikkNev);
        }
        return osszesenEladottTermekszam;
    }    

    public void adottVasrarlasTermekei(int vasarlasSorszama){
        if (vasarlasSorszama > 0 && vasarlasSorszama < penztarNaplo.size())
            penztarNaplo.get(--vasarlasSorszama).kosartartalmaMegjelenitoMap();
        else System.out.println("Nincs ilyen szamu vasarlas");
    }
        
    public void vasarlasiOsszegekKiirasa(){
        try {
            eladasokFilebaIrasa();
        } 
        catch (IOException ex) {
            Logger.getLogger(PenztarEsemenyek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eladasokFilebaIrasa() throws IOException {
            BufferedWriter iro = new BufferedWriter(new FileWriter("osszeg.txt"));
            int i = 1;
            String sor;
            for (Penztar fizetes : penztarNaplo){
                sor = Integer.toString(i++);
                sor += ": ";
                sor += fizetes.vasarlasVegosszege().toString();
                iro.write(sor);
                iro.newLine();
                iro.flush();
            }
    }
    
    public int vasarlasOsszesen(){
        return this.penztarNaplo.size();
    }

    public int megadottVasarlasKosarMeret(int vasarlasSzama) {
        return penztarNaplo.get(--vasarlasSzama).kosarMerete();
    }

    public BigDecimal mennyiXDarab(int darabszam) {
        return Penztar.mennybeKerulXDarab(darabszam);
    }

    private void penztarMemoriaBetoltese() {
            try {
              fileOlvasas();
            } 
            catch (FileNotFoundException ex) {                
            }
    }

    private void fileOlvasas() throws FileNotFoundException {
            String vasarlasVege = "F";
            String sor;          
            lemezOlvaso = new Scanner(new File("penztar.txt"));
            do{        
                sor = URESSTRING;
                kosar = new Kosar();
                do{
                    sor = lemezOlvaso.nextLine();                             
                    if(!sor.equals(vasarlasVege)) {
                        aru = new Arucikk(sor);
                        kosar.kosarbaHelyez(aru);
                    }    
                } while(!sor.equals(vasarlasVege));                    
                vasarlas = new Penztar(kosar);                
                penztarNaplo.add(vasarlas);                
            } while(lemezOlvaso.hasNext());
            lemezOlvaso.close();
    }
}
