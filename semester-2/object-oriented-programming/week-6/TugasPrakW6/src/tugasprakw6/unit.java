package tugasprakw6;
import java.util.*;
public class unit {
    private String icon;
    private int x,y;
    private boolean hp;
    private boolean gerak;
    private boolean plant;
    
    void setIcon(String icon) {this.icon= icon;}
    void setX(int x) {this.x= x;}
    void setY(int y) {this.y= y; }
    void setHp(boolean hp) {this.hp= hp;}
    void setGerak(boolean gerak) {this.gerak= gerak;}
    void setPlant(boolean plant) {this.plant= plant;}
    
    String getIcon() {return this.icon;}
    int getX() {return this.x;}
    int getY() {return this.y;}
    boolean getHp() {return this.hp;}
    boolean getGerak() {return this.gerak;}
    boolean getPlant() {return this.plant;}
}

class player extends unit implements move{
    player() {
        setIcon("P");
        setX(1);
        setY(1);
        setHp(true);
    }
    
    @Override
    public void move(String step, String[][] map) {
        if("w".equals(step) && !"*".equals(map[getY()-1][getX()])) {
         map[getY()][getX()]= " ";
         setY(getY()-1);
        }else if("a".equals(step) && !"*".equals(map[getY()][getX()-1])) {
         map[getY()][getX()]= " ";
         setX(getX()-1);
        }else if("s".equals(step) && !"*".equals(map[getY()+1][getX()])) {
         map[getY()][getX()]= " ";
         setY(getY()+1);
        }else if("d".equals(step) && !"*".equals(map[getY()][getX()+1])) {
         map[getY()][getX()]= " ";
         setX(getX()+1);
        }
    }
}

class enemy extends unit{
    enemy() {
        setIcon("M");
        setX(11);
        setY(11);
        setHp(true);
        setGerak(true);
        setPlant(true);
    }
}

interface move{
   
    void move(String step, String map[][]);
    
}

