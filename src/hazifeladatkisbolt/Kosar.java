package hazifeladatkisbolt;

import java.util.ArrayList;
import java.util.List;

public class Kosar{
    private List<Arucikk> arucikkek = new ArrayList<>();
   
    public Kosar(){        
    }

    public List<Arucikk> getArucikkek() {
        return arucikkek;
    }
     
    public void kosarbaHelyez(Arucikk arucikk){
        arucikkek.add(arucikk);
    }    

    public int kosarMerete() {
        return arucikkek.size();
    }

    public void kosarbolKivesz(Arucikk arucikk) {
       arucikkek.remove(arucikk);
    }
}
