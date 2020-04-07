package hazifeladatkisbolt;

import java.util.ArrayList;

public class Kosar {
    private ArrayList<Arucikk> arucikkek = new ArrayList<>();
    private boolean keszVagyok;

    public Kosar(){ 
    }

    public ArrayList<Arucikk> getArucikkek() {
        return arucikkek;
    }
    
    
    public void kosarbaHelyez(Arucikk arucikk){
        if (arucikk.getKeszVagyok())
            arucikkek.add(arucikk);
            ellenorzes();
    }
    
    private void ellenorzes(){
        if (arucikkek.size()<=20 && arucikkek.size()>0)
            this.keszVagyok = true;
        else this.keszVagyok = false;
    }
    
    public boolean getKeszVagyok(){
        return this.keszVagyok;
    }
}
