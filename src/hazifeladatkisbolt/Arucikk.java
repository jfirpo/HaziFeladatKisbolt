package hazifeladatkisbolt;

import java.math.BigDecimal;

public class Arucikk {
    private String arucikkNev;
    private BigDecimal arucikkAr;
    private final BigDecimal ALAPAR = new BigDecimal("500");
    
    public Arucikk(){
    }
    
    public Arucikk(String arucikkNev){
        this.arucikkNev = arucikkNev;
        this.arucikkAr = ALAPAR;
    }

    public void setArucikkAr(BigDecimal arucikkAr) {
        this.arucikkAr = arucikkAr;
    }

    public String getArucikkNev() {
        return arucikkNev;
    }

    public BigDecimal getArucikkAr() {
        return arucikkAr;
    }    
}