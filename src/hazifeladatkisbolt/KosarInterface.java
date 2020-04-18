package hazifeladatkisbolt;

import java.util.ArrayList;

public interface KosarInterface {
       ArrayList<Arucikk> getArucikkek();
       int kosarMerete();
       void kosarbaHelyez(Arucikk arucikk);
}
