package hazifeladatkisbolt;

import java.math.BigDecimal;

public interface PenztarInterface {
        KosarInterface getKosar();
        BigDecimal vasarlasVegosszege();
        void kosartartalmaMegjelenitoMap();
        int kosarMerete();
        boolean vanXtermekakosarban(String xTermekNev);
        int hanyDarabXTermekVanAKosarban(String xTermekNev);

        static BigDecimal mennybeKerulXDarab(int darabszam){
               BigDecimal ar = new BigDecimal(0);
             for (int i = 1; i <= darabszam; i++){
                 if(i == 1)ar = ar.add(new BigDecimal(500));
                 if(i == 2)ar = ar.add(new BigDecimal(450));
                 if(i > 2) ar = ar.add(new BigDecimal(400));
        }
        
        return ar;
        };
        
         
}
