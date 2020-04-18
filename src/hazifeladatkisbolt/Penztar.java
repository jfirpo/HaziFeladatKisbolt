package hazifeladatkisbolt;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Penztar implements PenztarInterface{
    private KosarInterface kosar = new Kosar();
    private Map<String, Integer> termekek;
    
    private Penztar(){};
    
    public Penztar(KosarInterface kosar){
        termekek = new HashMap<>();
        this.kosar = kosar;
        setTermekek(kosar);
    }

    @Override
    public KosarInterface getKosar() {
        return kosar;
    }

    @Override
    public BigDecimal getVegosszeg() {
        BigDecimal vegosszeg = new BigDecimal(0);
        for(Map.Entry<String, Integer> termek : termekek.entrySet()) {
           int j = termek.getValue();                    
           BigDecimal ertek ;
            ertek = mennybeKerulXDarab(j);
           vegosszeg = vegosszeg.add(ertek);
        }
        return vegosszeg;
    }
    
    @Override
    public void kosartartalmaMegjelenitoMap(){
          System.out.println(this.termekek);
    }    

    private void setTermekek(KosarInterface kosar) {
        for (Arucikk termek : kosar.getArucikkek()){            
            if (termekek.containsKey(termek.getArucikkNev())){
                termekek.put(termek.getArucikkNev(), 1+termekek.get(termek.getArucikkNev()));
            }   else{
                    termekek.put(termek.getArucikkNev(), 1);
                }                        
        }

    }
    
    public  static BigDecimal mennybeKerulXDarab(int darabszam){
        BigDecimal ar = new BigDecimal(0);
        for (int i = 1; i <= darabszam; i++){
            if(i == 1)ar = ar.add(new BigDecimal(500));
            if(i == 2)ar = ar.add(new BigDecimal(450));
            if(i > 2) ar = ar.add(new BigDecimal(400));
        }
        
        return ar;
    }        
}
