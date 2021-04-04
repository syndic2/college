package tugasprakw5;
import java.util.*;
public class tanaman {
    private String nama,symbol;
    private String musim,dead;
    private int grow,regrow;
    private int umur;
    private int xt,yt;
    
    void setNama(String n) {this.nama= n;}
    void setSymbol(String s) {this.symbol= s;}
    void setMusim(String m) {this.musim= m;} 
    void setDead(String d) {this.dead= d;}
    void setGrow(int g) {this.grow= g;}
    void setRegrow(int rg) {this.regrow= rg;}
    void setUmur(int u ) {this.umur= u;}
    void setXt(int x) {this.xt= x;}
    void setYt(int y) {this.yt= y;}
    
    String getNama() {return this.nama;}
    String getSymbol() {return this.symbol;}
    String getMusim() {return this.musim;}
    String getDead() {return this.dead;}
    int getGrow() {return this.grow;}
    int getRegrow() {return this.regrow;}
    int getUmur() {return this.umur;}
    int getXt() {return this.xt;}
    int getYt() {return this.yt;}
}

class grass extends tanaman{
    grass() {
        setSymbol("g");
        setXt(0);
        setYt(0);
    }
}

class turnip1 extends tanaman{
    turnip1() {
        setSymbol("t");
        setDead("x");
        setMusim("Spring");
        setUmur(1);
        setGrow(5);
        setXt(0);
        setYt(0);
    }
}

class turnip2 extends turnip1{
    turnip2() {
        setSymbol("T");
        setDead("x");
        setMusim("Spring");
        setUmur(1);
        setGrow(5);
        setXt(0);
        setYt(0);
    }
}

class potato1 extends tanaman{
    potato1() {
        setSymbol("p");
        setDead("x");
        setMusim("Spring");
        setUmur(1);
        setGrow(8);
        setXt(0);
        setYt(0);
    }
}

class potato2 extends potato1{
    potato2() {
        setSymbol("P");
        setDead("x");
        setMusim("Spring");
        setUmur(1);
        setGrow(8);
        setXt(0);
        setYt(0);
    }
}

class cucumber1 extends tanaman{
    cucumber1() {
        setSymbol("c");
        setDead("x");
        setMusim("Spring");
        setUmur(1);
        setGrow(10);
        setRegrow(5);
        setXt(0);
        setYt(0);
    }
}

class cucumber2 extends cucumber1{
    cucumber2() {
        setSymbol("C");
        setDead("x");
        setMusim("Spring");
        setUmur(1);
        setGrow(10);
        setRegrow(5);
        setXt(0);
        setYt(0);
    }
}

class tomato1 extends tanaman{
    tomato1() {
        setSymbol("m");
        setDead("x");
        setMusim("Summer");
        setUmur(1);
        setGrow(10);
        setRegrow(3);
        setXt(0);
        setYt(0);
    }
}

class tomato2 extends tomato1{
    tomato2() {
        setSymbol("M");
        setDead("x");
        setMusim("Summer");
        setUmur(1);
        setGrow(10);
        setRegrow(3);
        setXt(0);
        setYt(0);     
    }
}

class corn1 extends tanaman{
    corn1() {
        setSymbol("j");
        setDead("x");
        setMusim("Summer");
        setUmur(1);
        setGrow(15);
        setRegrow(4);
        setXt(0);
        setYt(0);     
    }
}

class corn2 extends corn1{
    corn2() {
        setSymbol("J");
        setDead("x");
        setMusim("Summer");
        setUmur(1);
        setGrow(15);
        setRegrow(4);
        setXt(0);
        setYt(0);            
    }
}

class onion1 extends tanaman{
    onion1() {
        setSymbol("o");
        setDead("x");
        setMusim("Summer");
        setUmur(1);
        setGrow(8);
        setXt(0);
        setYt(0);   
    }   
}

class onion2 extends onion1{
    onion2() {
        setSymbol("O");
        setDead("x");
        setMusim("Summer");
        setUmur(1);
        setGrow(8);
        setXt(0);
        setYt(0);
    }
}