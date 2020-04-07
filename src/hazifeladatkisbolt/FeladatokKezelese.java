package hazifeladatkisbolt;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class FeladatokKezelese {
    private PenztarEsemenyek pe = new PenztarEsemenyek();;    
    private Scanner kb = new Scanner(System.in);                                    // a 4. feladat bekeres peldanya es valtozoi
    private int vasarlasSorszama;
    private String arucikkNeve;
    private int darabszam;

    public FeladatokKezelese() {
      if (pe.getKeszVagyok()){
        System.out.println("2. feladat");
        System.out.println("A fizetesek szama: " + pe.getPenztarNaplo().size());
        System.out.println();
        System.out.println("3. feladat");
        System.out.print("Az elso vasarlo ");
        System.out.print(pe.getPenztarNaplo().get(0).getKosar().getArucikkek().size());
        System.out.println(" db termeket vasarolt.");
        System.out.println();
        System.out.println("4. feladat");
        System.out.print("Kerem adja meg a vasarlas sorszamat: ");
 
        try{
            vasarlasSorszama = kb.nextInt();}
        catch (InputMismatchException in){
            }
        
        System.out.print("Kerem adja meg az arucikk nevet: ");
            arucikkNeve =  kb.next();

            System.out.print("Kerem adja meg a darabszamot: ");
        try{            
            darabszam = kb.nextInt();}
        catch (InputMismatchException in){
            }
        kb.close();
        System.out.println();
        System.out.println("5. feladat");
        if (pe.getArucikkElsoVasarlsa(arucikkNeve) > 0)
            System.out.println("Az elso vasarlas sorszama: " + pe.getArucikkElsoVasarlsa(arucikkNeve));
        else System.out.println("Nincs ilyen termek.");
        if (pe.getArucikkElsoVasarlsa(arucikkNeve) > 0)
            System.out.println("Az utolso vasarlas sorszama: " + pe.getArucikkUtolsoVasarlsa(arucikkNeve));
        else System.out.println("Nincs ilyen termek.");
        System.out.println("Eladott darabszam: " + pe.eladottTermekSzam(arucikkNeve));
        System.out.println();
        System.out.println("6. feladat");
        System.out.println(darabszam + " darab vetelekor fizetendo: " + pe.mennybeKerulXDarab(darabszam));
        System.out.println();
        System.out.println("7. feladat");
        pe.adottVasrarlasTermekei(vasarlasSorszama);
        pe.vasarlasiOsszegekKiirasa();
      }
        else System.out.println(pe.hiba());
    }
}
