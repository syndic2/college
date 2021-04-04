package tugasprakw4;
import java.util.*;
public class enemy {
    private String name,icon,element,sname;
    private int hp,hpm;
    private int mp,mpm,mpc;
    private int atk,magic;
    private int armor,acc;
    private int expdrop,goldrop;
    private int xm,ym,xb,yb;
    
    void setName(String name) {this.name= name;}
    void setElement(String element) {this.element= element;}
    void setIcon(String icon) {this.icon= icon;}
    void setHp(int hp) {this.hp= hp;}
    void setHpm(int hpm) {this.hpm= hpm;}
    void setMp(int mp) {this.mp= mp;}
    void setMpm(int mpm) {this.mpm= mpm;}
    void setMpc(int mpc) {this.mpc= mpc;}
    void setAtk(int atk) {this.atk= atk;}
    void setMagic(int magic) {this.magic= magic;}
    void setSname(String name) {this.sname= name;}
    void setArmor(int armor) {this.armor= armor;}
    void setAcc(int acc) {this.acc= acc;}
    void setExpdrop(int exp) {this.expdrop= exp;}
    void setGolddrop(int gold) {this.goldrop= gold;}
    void setXb(int x) {this.xb= x;}
    void setYb(int y) {this.yb= y;}
    void setXm(int x) {this.xm= x;}
    void setYm(int y) {this.ym= y;}
    
    String getName() {return this.name;}
    String getElement() {return this.element;}
    String getIcon() {return this.icon;}
    int getHp() {return this.hp;}
    int getHpm() {return this.hpm;}
    int getMp() {return this.mp;}
    int getMpm() {return this.mpm;}
    int getMpc() {return this.mpc;}
    int getAtk() {return this.atk;}
    int getMagic() {return this.magic;}
    String getSname() {return this.sname;}
    int getArmor() {return this.armor;}
    int getAcc() {return this.acc;}
    int getExpdrop() {return this.expdrop;}
    int getGolddrop() {return this.goldrop;}
    int getXb() {return this.xb;}
    int getYb() {return this.yb;}
    int getXm() {return this.xm;}
    int getYm() {return this.ym;}
    
    void statsBattle(String name) {}
    void attackHero(String name,int dmgh) {}
}

class mons extends enemy{
    Random r= new Random();
    mons() {
        setName("BOSS");
        setIcon("B");
        setHp(2000);
        setHpm(getHp());
        setMp(400);
        setMpm(getMp());
        setAtk(80);
        setMagic(40);
        setSname("Increase Attack");
        setMpc(10);
        setArmor(25);
        setAcc(100);
        setExpdrop(r.nextInt(20)+40);
        setGolddrop(300);
    }
    //overloading
    mons(int type,int elem) {
        if(type==0) {
         setName("Wild Dog");
         setIcon("w");
         setHp(150);
         setHpm(getHp());
         setMp(50);
         setMpm(getMp());
         setMpc(40);
         setAtk(32);
         setMagic(10);
         setSname("Fire Torch");
         setArmor(15);
         setAcc(100);
         setExpdrop(r.nextInt(5)+15);
         setGolddrop(120);
        }else if(type==1) {
         setName("Magic Monster");
         setIcon("m");
         if(elem==0) {
          setElement("Fire");
          setSname("Fire spell");
         }else if(elem==1) {
          setElement("Water");
          setSname("Water spell");
         }else if(elem==2) {
          setElement("Thunder");
          setSname("Thunder spell");
         }else if(elem==3) {
          setElement("Ice");
          setSname("Ice spell");
         }
         setHp(200);
         setHpm(getHp());
         setMp(300);
         setMpm(getMp());
         setMpc(50);
         setAtk(7);
         setMagic(70);
         setArmor(20);
         setAcc(100);
         setExpdrop(r.nextInt(5)+20);
         setGolddrop(150);       
        }else if(type==2) {
         setName("Wild Dog");
         setIcon("w");
         setHp(150);
         setHpm(getHp());
         setMp(50);
         setMpm(getMp());
         setMpc(40);
         setAtk(32);
         setMagic(10);
         setSname("Fire Torch");
         setArmor(15);
         setAcc(100);
         setExpdrop(r.nextInt(5)+15);
         setGolddrop(120);
        }else if(type==3) {
         setName("Magic Monster");
         setIcon("m");
         if(elem==0) {
          setElement("Fire");
          setSname("Fire spell");
         }else if(elem==1) {
          setElement("Water");
          setSname("Water spell");
         }else if(elem==2) {
          setElement("Thunder");
          setSname("Thunder spell");
         }else if(elem==3) {
          setElement("Ice");
          setSname("Ice spell");
         }
         setHp(200);
         setHpm(getHp());
         setMp(300);
         setMpm(getMp());
         setMpc(50);
         setAtk(7);
         setMagic(70);
         setArmor(20);
         setAcc(100);
         setExpdrop(r.nextInt(5)+20);
         setGolddrop(150);       
        }else if(type==4) {
         setName("Wild Dog");
         setIcon("w");
         setHp(150);
         setHpm(getHp());
         setMp(50);
         setMpm(getMp());
         setMpc(40);
         setAtk(32);
         setMagic(10);
         setSname("Fire Torch");
         setArmor(15);
         setAcc(100);
         setExpdrop(r.nextInt(5)+15);
         setGolddrop(120);
        }
    } 
    
    @Override
    void statsBattle(String name) {
        if("BOSS".equals(name)) {
         System.out.println(getName());
         System.out.println("HP: "+getHp()+"/"+getHpm());
         System.out.println("MP: "+getMp()+"/"+getMpm());
        }else if("Wild Dog".equals(name)) {
         System.out.println(getName());
         System.out.println("HP: "+getHp()+"/"+getHpm());
         System.out.println("MP: "+getMp()+"/"+getMpm());
        }
        else if("Magic Monster".equals(name)) {
         System.out.println(getName());
         System.out.println("Element: "+getElement());
         System.out.println("HP: "+getHp()+"/"+getHpm());
         System.out.println("MP: "+getMp()+"/"+getMpm());
        }
    }
    
    @Override
    void attackHero(String name,int dmgh) {
        setHp(getHp()-(dmgh-getArmor()));
        System.out.println(name+" attack "+getName());
    }
    
    void bossSkill() {
        setMp(getMp()-getMpc());
        setAtk(getAtk()+5);
        System.out.println(getName()+" using "+getSname());
    }
    
    void powerBreak(String name,int dmgh,String sname1) {
        setHp(getHp()-(dmgh-getArmor()));
        setAtk(getAtk()-(getAtk()*10/100));
        System.out.println(name+" use "+sname1);   
    }
    
    void armorBreak(String name,int dmgh, String sname2) {
        setHp(getHp()-(dmgh-getArmor()));
        setArmor(0);
        System.out.println(name+" use "+sname2);
    }
    
    void poarmBreak(String name,int dmgh,String sname1) {
        setHp(getHp()-(dmgh-getArmor()));
        setAtk(getAtk()-(getAtk()*10/100));
        setArmor(0);
        System.out.println(name+" use "+sname1); 
    }
    
    void magicBall(String name,int magich,String sname1) {
        setHp(getHp()-magich);
        System.out.println(name+" use "+sname1);  
    }
    
    void elementBoss(String name,int magich,int subskill,String sname1) {
        if(subskill==1) { //Fire
         setHp(getHp()-(magich*10/10));
         System.out.println(name+" use Fire "+sname1); 
        }else if(subskill==2) { //Water
         setHp(getHp()-(magich*5/10));
         System.out.println(name+" use Water "+sname1);
        }else if(subskill==3) { //Thunder
         setHp(getHp()-(magich*5/10));
         System.out.println(name+" use Thunder "+sname1);
        }else if(subskill==4) { //Ice
         setHp(getHp()-(magich*10/10));
         System.out.println(name+" use Ice "+sname1);
        }
    }
    
    void elementMons(String name,String elem,int magich,int subskill,String sname1) {
        if("Wild Dog".equals(name)) {
         if(subskill==1) { //Fire
          setHp(getHp()-(magich*10/10));
          System.out.println(name+" use Fire "+sname1); 
         }else if(subskill==2) { //Water
          setHp(getHp()-(magich*5/10));
          System.out.println(name+" use Water "+sname1);
         }else if(subskill==3) { //Thunder
          setHp(getHp()-(magich*5/10));
          System.out.println(name+" use Thunder "+sname1);
         }else if(subskill==4) { //Ice
          setHp(getHp()-(magich*5/10));
          System.out.println(name+" use Ice "+sname1);
         }
        }else if("Magic Monster".equals(name)) {
         if(subskill==1) { //Fire
          if("Fire".equals(elem)) {
            setHp(getHp()-(magich*5/10));
            System.out.println("Not Effective!");
          }else if("Ice".equals(elem)) {
            setHp(getHp()-((magich*15/10+(magich*50/100))));
            System.out.println("Super Effective!");
          }else setHp(getHp()-magich);
         }else if(subskill==2) { //Water
           if("Water".equals(elem)) {
             setHp(getHp()-(magich*5/10));
             System.out.println("Not Effective!");
           }else if("Thunder".equals(elem)) {
             setHp(getHp()-((magich*15/10)+(magich*50/100)));
             System.out.println("Super Effective!");
           }else setHp(getHp()-magich);
         }else if(subskill==3) { //Thunder
           if("Thunder".equals(elem)) {
             setHp(getHp()-(magich*5/10));
             System.out.println("Not Effective!");
           }else if("Water".equals(elem)) {
             setHp(getHp()-((magich*15/10)+(magich*50/100)));
             System.out.println("Super Effective!");
           }else setHp(getHp()-magich);
         }else if(subskill==4) { //Ice
           if("Ice".equals(elem)) {
             setHp(getHp()-(magich*5/10));
             System.out.println("Not Effective!");
           }else if("Fire".equals(elem)) {
             setHp(getHp()-((magich*15/10)+(magich*50/100)));
             System.out.println("Super Effective!");
           }else setHp(getHp()-magich);
          }
        }
    }
}

