package hazifeladatkisbolt;

public class Arucikk {
    private String arucikkNev;
    private int arucikkAr;
    private boolean keszVagyok;
    private String hiba;
    
    public Arucikk(){
    }
    
    public Arucikk(String arucikkNev){
        this.arucikkNev = arucikkNev;
        this.arucikkAr = 500;
        setKeszVagyok();
    }

    public void setArucikkNev(String arucikkNev) {
        this.arucikkNev = arucikkNev;
        setKeszVagyok();
    }

    public void setArucikkAr(int arucikkAr) {
        this.arucikkAr = arucikkAr;
    }

    public String getArucikkNev() {
        return arucikkNev;
    }

    public int getArucikkAr() {
        return arucikkAr;
    }
    
    private void setKeszVagyok(){
        if (this.arucikkNev.length()>0 && this.arucikkNev.length()<=20)
            this.keszVagyok = true;
        else hiba = "Nem megfelelo az arucikk neve, a peldanyt nem helyezheto a kosarba ";
    }

    public boolean getKeszVagyok(){
        return this.keszVagyok;
    }
    
    public String getHiba() {
        return hiba;
    }
    
    
    
}
