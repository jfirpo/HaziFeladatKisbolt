package hazifeladatkisbolt;

import java.util.ArrayList;

public class Kosar implements KosarInterface{
    private final ArrayList<Arucikk> arucikkek = new ArrayList<>();
   
    public Kosar(){ 
    }

    @Override
    public ArrayList<Arucikk> getArucikkek() {
        return arucikkek;
    }
     
    @Override
    public void kosarbaHelyez(Arucikk arucikk){
        arucikkek.add(arucikk);
    }    
    @Override
    public int kosarMerete() {
        return arucikkek.size();
    }

    @Override
    public void kosarbolKivesz(Arucikk arucikk) {
       arucikkek.remove(arucikk);
    }
}
