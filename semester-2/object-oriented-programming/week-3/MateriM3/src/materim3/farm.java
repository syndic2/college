package materim3;
public class farm {
    
    private String jenis;
    private int umur;
    private int hbeli;
    private int hjual;
    private int ctrpakan;
    
    farm() {
    }
    
    void setJenis(String jenis) {this.jenis= jenis;}
    void setUmur(int umur) {this.umur= umur;}
    void setHBeli(int hbeli) {this.hbeli= hbeli;}
    void setHJual(int hjual) {this.hjual= hjual;}
    void setCTRPakan(int ctrpakan) {this.ctrpakan= ctrpakan;}
    
    String getJenis() {return this.jenis;}
    int getUmur() {return this.umur;}
    int getHBeli() {return this.hbeli;}
    int getHJual() {return this.hjual;}
    int getCTRPakan() {return this.ctrpakan;}
    
}
