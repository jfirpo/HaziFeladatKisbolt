package hazifeladatkisbolt;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Penztar{
    private Kosar kosar = new Kosar();
    private Map<String, Integer> termekek;
    private final int MINIMUMVASARLASIMENNYISEG = 1;
    private final int MAXIMUMVASARLASIMENNYISEG = 20;
    
    private Penztar(){};
    
    public Penztar(Kosar kosar){
        this.kosar = kosar;
        if (kosar.kosarMerete() >= MINIMUMVASARLASIMENNYISEG && kosar.kosarMerete() <= MAXIMUMVASARLASIMENNYISEG){
            termekek = new HashMap<>();
            setTermekek(kosar);
        }    
    }

    private void setTermekek(Kosar kosar) {
        for (Arucikk termek : kosar.getArucikkek()){            
            if (termekek.containsKey(termek.getArucikkNev())){
                termekek.put(termek.getArucikkNev(), 1+termekek.get(termek.getArucikkNev()));
            }
            else{
                termekek.put(termek.getArucikkNev(), 1);
            }                        
        }
    }

    public Kosar getKosar() {
        return kosar;
    }
    
    public boolean vanXtermekakosarban(String xTermekNev){        
        for(Map.Entry<String, Integer> vizsgalt : termekek.entrySet()) {
            String vizgaltTermek = vizsgalt.getKey();
            if (vizgaltTermek.equals(xTermekNev))
                return true;
        }            
        return false;
    }
    
    public int hanyDarabXTermekVanAKosarban(String xTermekNev){
        for(Map.Entry<String, Integer> vizsgalt : termekek.entrySet()) {
            String vizgaltTermek = vizsgalt.getKey();
            int darabSzam = vizsgalt.getValue();
            if (xTermekNev.equals(vizgaltTermek))
                return darabSzam;
        }                        
        return 0;
    }
    
    public BigDecimal vasarlasVegosszege() {
        BigDecimal vegosszeg = BigDecimal.ZERO;
        for(Map.Entry<String, Integer> termek : termekek.entrySet()) {
           int j = termek.getValue();                    
           BigDecimal ertek ;
            ertek = mennybeKerulXDarab(j);
           vegosszeg = vegosszeg.add(ertek);
        }
        return vegosszeg;
    }
    
    public  static BigDecimal mennybeKerulXDarab(int darabszam){
        BigDecimal ar = BigDecimal.ZERO;
        for (int i = 1; i <= darabszam; i++){
            if(i == 1)
                ar = ar.add(new BigDecimal(500));
            if(i == 2)
                ar = ar.add(new BigDecimal(450));
            if(i > 2)
                ar = ar.add(new BigDecimal(400));
        }        
        return ar;
    }            
    
    public void kosartartalmaMegjelenitoMap(){
        System.out.println(this.termekek);
    }    

    public int kosarMerete(){
        return kosar.kosarMerete();
    }
}
