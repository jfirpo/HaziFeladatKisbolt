package hazifeladatkisbolt;

import java.util.ArrayList;
import java.util.Iterator;

public class Penztar {
    private Kosar kosar;
    private int vegosszeg;
    private ArrayList<Arucikk> szamla = new ArrayList<>();
    private boolean tortentFizetes;
    
    private Penztar(){};
    
    public Penztar(Kosar kosar){
        if (kosar.getKeszVagyok()){
            this.kosar = kosar;
            setVegosszeg();
            this.tortentFizetes = true;
        }
    }

    public Kosar getKosar() {
        return kosar;
    }

    public int getVegosszeg() {
        return vegosszeg;
    }
  
    private void setVegosszeg(){
        for (int i = 0; i < kosar.getArucikkek().size(); i++){
            int darabszam = 1;
            for (int j = 0; j < szamla.size(); j++)
                if (szamla.get(j).getArucikkNev().equals(kosar.getArucikkek().get(i).getArucikkNev())) darabszam++;
            if (darabszam > 1)
                if (darabszam == 2) kosar.getArucikkek().get(i).setArucikkAr(450);
                    else kosar.getArucikkek().get(i).setArucikkAr(400);
        szamla.add(kosar.getArucikkek().get(i));        
            vegosszeg += szamla.get(i).getArucikkAr();
        }
    }
    
    public void kosartartalmaMegjelenito(){
        ArrayList<String> kosarbanLevoTermekek = new ArrayList<>();
        for (int i = 0; i < szamla.size(); i++) {
            if(!kosarbanLevoTermekek.contains(szamla.get(i).getArucikkNev()))
                kosarbanLevoTermekek.add(szamla.get(i).getArucikkNev());
        }
        int i;
        for (String kosarbanLevoTermekek1 : kosarbanLevoTermekek) {            
            i = 0;
            for (Arucikk szamla1 : szamla) {
                if(kosarbanLevoTermekek1.equals(szamla1.getArucikkNev()))
                    i++;
            }
            System.out.println(i +" " + kosarbanLevoTermekek1);
        }
    }
}
