package tugasprakw6;
import java.util.*;
public abstract class bomb {
    private String icon,icond,name;
    private int x,y;
    
    void setName(String name) {this.name= name;} 
    void setIcon(String icon) {this.icon= icon;}
    void setIcond(String icond) {this.icond= icond;}
    void setX(int x) {this.x= x;}
    void setY(int y) {this.y= y;}
    
    String getName() {return this.name;}
    String getIcon() {return this.icon;}
    String getIcond() {return this.icond;}
    int getX() {return this.x;}
    int getY() {return this.y;}
    
    void plant(int xu, int yu) {};
    abstract void explode(int xu, int yu);
}

class type1 extends bomb{
    type1() {
        setName("4D");
        setIcon("B");
        setIcond("4");
    }
    
    @Override
    void plant(int xu, int yu) {
        setX(xu);
        setY(yu);
    }

    @Override
    public void explode(int xu, int yu) {
        if((xu==getX()-1 && yu==getY()) || (xu==getX()+1 && yu==getY()) || 
           (xu==getX() && yu==getY()-1) || (xu==getX() && yu==getY()+1) || 
           (xu==getX() && yu==getY())) {
         System.out.println("Explode!");
        }else {
         System.out.println("Explode!");
        }
    }      
}

class type2 extends type1{
    type2() {
        setName("Horriz");
        setIcon("B");
        setIcond("H");
        setX(0);
        setY(0);
    }
    
    @Override
    void plant(int xu, int yu) {
        setX(xu);
        setY(yu);
    }
    
    @Override
    public void explode(int xu, int yu) {
        if((xu==getX()-1 && yu==getY()) || (xu==getX()-2 && yu==getY()) ||
           (xu==getX()+1 && yu==getY()) || (xu==getX()+2 && yu==getY()) ||
           (xu==getX() && yu==getY())) {
         System.out.println("Explode!");
        }else{
         System.out.println("Explode!");
        }
    }   
}

class type3 extends type2{
    type3() {
        setName("Verti");
        setIcon("B");
        setIcond("V");
        setX(0);
        setY(0);
    }
    
    @Override
    void plant(int xu, int yu) {
        setX(xu);
        setY(yu);
    }
    
    @Override
    public void explode(int xu, int yu) {
        if((xu==getX() && yu==getY()-1) || (xu==getX() && yu==getY()-2) ||
           (xu==getX() && yu==getY()+1) || (xu==getX() && yu==getY()+2) ||
           (xu==getX() && yu==getY())) {
         System.out.println("Explode!");
        }else{
         System.out.println("Explode!");
        }
    }
}
