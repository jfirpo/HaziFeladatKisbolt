package hazifeladatkisbolt;

import java.util.Scanner;

public class FeladatokKezelese {
    private PenztarEsemenyek penztariEsemenyek = new PenztarEsemenyek();;    
    private Scanner keyboardReader = new Scanner(System.in);                                    // a 4. feladat bekeres penztariEsemenyekldanya es valtozoi
    private int vasarlasSorszama = 2;
    private String arucikkNeve = "colostok";
    private int darabszam = 2;
    private final int ELSOVASARLO = 1;

    public FeladatokKezelese() {
        
    }
    
    public void feladat2(){
        System.out.println("2. feladat");
        System.out.println("A fizetesek szama: " + penztariEsemenyek.vasarlasOsszesen());        
        System.out.println();    
    }
    
    public void feladat3(){
        System.out.println("3. feladat");
        System.out.print("Az " + ELSOVASARLO + ". vasarlo ");
        System.out.print(penztariEsemenyek.megadottVasarlasKosarMeret(ELSOVASARLO));
        System.out.println(" db termeket vasarolt.");
        System.out.println();    
    }
    
    public void feladat4(){
        System.out.println("4. feladat");
        System.out.print("Kerem adja meg a vasarlas sorszamat: ");
        /*
        try{
            vasarlasSorszama = keyboardReader.nextInt();}
        catch (InputMismatchException in){
            }
        
        System.out.print("Kerem adja meg az arucikk nevet: ");
            arucikkNeve =  keyboardReader.next();

            System.out.print("Kerem adja meg a darabszamot: ");
        try{            
            darabszam = keyboardReader.nextInt();}
        catch (InputMismatchException in){
            }
        keyboardReader.close();
        */
        System.out.println();    
    }
    
    public void feladat5(){
        System.out.println("5. feladat");
        if (penztariEsemenyek.getArucikkElsoVasarlsa(arucikkNeve) > 0)
            System.out.println("Az elso vasarlas sorszama: " + penztariEsemenyek.getArucikkElsoVasarlsa(arucikkNeve));
        else System.out.println("Nincs ilyen termek.");
        if (penztariEsemenyek.getArucikkElsoVasarlsa(arucikkNeve) > 0)
            System.out.println("Az utolso vasarlas sorszama: " + penztariEsemenyek.getArucikkUtolsoVasarlsa(arucikkNeve));
        else System.out.println("Nincs ilyen termek.");
        System.out.println("Eladott darabszam: " + penztariEsemenyek.eladottTermekSzam(arucikkNeve));
        System.out.println();    
    }
    
    public void feladat6(){
        System.out.println("6. feladat");
        System.out.println(darabszam + " darab vetelekor fizetendo: " + penztariEsemenyek.mennyiXDarab(darabszam));
        System.out.println();    
    }
    
    public void feladat7(){
        System.out.println("7. feladat");
        penztariEsemenyek.adottVasrarlasTermekei(vasarlasSorszama);
        penztariEsemenyek.vasarlasiOsszegekKiirasa();
    }
    
}
