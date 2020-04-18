/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazifeladatkisbolt;

import java.math.BigDecimal;

/**
 *
 * @author Krisztián
 */
public interface PenztarInterface {
        KosarInterface getKosar();
        BigDecimal getVegosszeg();
        void kosartartalmaMegjelenitoMap();
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
