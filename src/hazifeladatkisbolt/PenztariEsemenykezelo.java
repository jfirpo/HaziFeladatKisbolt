package hazifeladatkisbolt;

import java.math.BigDecimal;

public interface PenztariEsemenykezelo {

    int vasarlasOsszesen();
    int getArucikkElsoVasarlsa(String arucikkNeve);
    int getArucikkUtolsoVasarlsa(String arucikkNeve);
    int eladottTermekSzam(String arucikkNeve);
    void adottVasrarlasTermekei(int vasarlasSorszama);
    void vasarlasiOsszegekKiirasa();
    int megadottVasarlasKosarMeret(int vasarlasSzama);
    BigDecimal mennyiXDarab(int darabszam);

}
