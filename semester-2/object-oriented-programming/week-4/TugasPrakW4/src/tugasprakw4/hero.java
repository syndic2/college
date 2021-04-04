package tugasprakw4;
import java.util.*;
public class hero {
    private String name,icon,sname1,sname2;
    private int hp,hpm;
    private int mp,mpm,mpc,mpc1,mpc2;
    private int atk,magic;
    private int armor,eva,acc;
    private int lv,exp,expm,sp;
    private int xh,yh;
    
    void setName(String name) {this.name= name;}
    void setIcon(String icon) {this.icon= icon;}
    void setHp(int hp) {this.hp= hp;}
    void setHpm(int hpm) {this.hpm= hpm;}
    void setMp(int mp) {this.mp= mp;}
    void setMpm(int mpm) {this.mpm= mpm;}
    void setMpc(int mpc) {this.mpc= mpc;}
    void setMpc1(int mpc) {this.mpc1= mpc;}
    void setMpc2(int mpc) {this.mpc2= mpc;}
    void setAtk(int atk) {this.atk= atk;}
    void setMagic(int magic) {this.magic= magic;}
    void setSname1(String s1) {this.sname1= s1;}
    void setSname2(String s2) {this.sname2= s2;}
    void setArmor(int armor) {this.armor= armor;}
    void setEva(int eva) {this.eva= eva;}
    void setAcc(int acc) {this.acc= acc;}
    void setLv(int lv) {this.lv= lv;}
    void setExp(int exp) {this.exp= exp;}
    void setExpm(int expm) {this.expm= expm;}
    void setSp(int sp) {this.sp= sp;}
    
    String getName() {return this.name;}
    String getIcon() {return this.icon;}
    int getHp() {return this.hp;}
    int getHpm() {return this.hpm;}
    int getMp() {return this.mp;}
    int getMpm() {return this.mpm;}
    int getMpc() {return this.mpc;}
    int getMpc1() {return this.mpc1;}
    int getMpc2() {return this.mpc2;}
    int getAtk() {return this.atk;}
    int getMagic() {return this.magic;}
    String getSname1() {return this.sname1;}
    String getSname2() {return this.sname2;}
    int getArmor() {return this.armor;}
    int getEva() {return this.eva;}
    int getAcc() {return this.acc;}
    int getLv() {return this.lv;}
    int getExp() {return this.exp;}
    int getExpm() {return this.expm;}
    int getSp() {return this.sp;}
    
    void Stats(int idx) {}
    void statsBattle() {}
    void SkillPoint(int sp) {}
    void HealPoint() {}
    void Evolve(String name) {}
    void attackEnemy(String name,int dmge,int acce,int acc) {}
    void defense(String name,int dmge,int acce,int acc) {}
    void listSkill() {}
    void listElement() {}
}

class tier1 extends hero{
    Random r= new Random();
    tier1(String name) {
    if("Warrior".equals(name)) {
        setName("Warrior");
        setIcon("W");
        setHp(520);
        setHpm(getHp());
        setMp(30);
        setMpm(getMp());
        setMpc(8);
        setAtk(100);
        setMagic(20);
        setSname1("Power Break");
        setSname2("Armor Break");
        setArmor(8);
        setEva(0);
        setAcc(90);
        setExp(0);
        setExpm(100);
        setLv(1);
        setSp(0);
    }else if("Mage".equals(name)) {
        setName("Mage");
        setIcon("M");
        setHp(360);
        setHpm(getHp());
        setMp(120);
        setMpm(getMp());
        setMpc(4);
        setAtk(30);
        setMagic(200);
        setSname1("Magic Ball");
        setSname2("Magic Boost");
        setArmor(2);
        setEva(10);
        setAcc(75);
        setExp(0);
        setExpm(100);
        setLv(1);
        setSp(0);
    }else if("Range".equals(name)) {
        setName("Range");
        setIcon("R");
        setHp(610);
        setHpm(getHp());
        setMp(40);
        setMpm(getMp());
        setMpc(5);
        setAtk(70);
        setMagic(100);
        setSname1("Blind Attack");
        setSname2("Silence Attack");
        setArmor(4);
        setEva(5);
        setAcc(100);
        setExp(0);
        setExpm(100);
        setLv(1);
        setSp(0);
     }
    }
    
    @Override
    void SkillPoint(int sp) {
        if(sp==1) {setHp(getHpm()+300);}
        else if(sp==2) {setMp(getMpm()+20);}
        else if(sp==3) {setAtk(getAtk()+20);}
        else if(sp==4) {setArmor(getArmor()+1);}
        else if(sp==5) {setEva(getEva()+3);}
        else if(sp==6) {setAcc(getAcc()+2);}
    }
    
    @Override
    void Stats(int idx) {
        System.out.println((idx+1)+". Hero: "+getName());
        System.out.println("Level: "+getLv());
        System.out.println("EXP: "+getExp());
        System.out.println("HP: "+getHp());
        System.out.println("MP: "+getMp());
    }
    
    @Override
    void statsBattle() {
        System.out.println(getName());
        System.out.println("HP: "+getHp()+"/"+getHpm());
        System.out.println("MP: "+getMp()+"/"+getMpm());
    }
    
    @Override
    void HealPoint() {
        setHp(getHpm());
        setMp(getMpm());
    }
    
    @Override
    void Evolve(String name) {
        if("Warrior".equals(name)) {
         System.out.println("Warrior evolved to Knight!");
         setName("Knight");
         setIcon("K");
         setHp(getHp()+(getHp()*20/100));
         setHpm(getHp());
         setMp(getMp()+(getMp()*0/100));
         setMpm(getMp());
         setMpc1(12);
         setMpc2(4);
         setAtk(getAtk()+(getAtk()*25/100));
         setMagic(getMagic()-(getMagic()*5/100));
         setSname1("Power + Armor");
         setSname2("Sentinel");
         setArmor(getArmor()+8);
         setEva(0);
         setAcc(95);
        }else if("Mage".equals(name)) {
         System.out.println("Mage evolved to Sorcerer!");
         setName("Sorcerer");
         setIcon("S");
         setHp(getHp()+(getHp()*5/100));
         setHpm(getHp());
         setMp(getMp()+(getMp()*100/100));
         setMpm(getMp());
         setMpc1(8);
         setMpc2(10);
         setAtk(getAtk()+(getAtk()*5/100));
         setMagic(getMagic()+(getMagic()*30/100));
         setSname1("Element spell");
         setSname2("Heal");
         setArmor(getArmor()+1);
         setEva(20);
         setAcc(75);
        }else if("Range".equals(name)) {
         System.out.println("Range evolved to Trooper!");
         setName("Trooper");
         setIcon("T");
         setHp(getHp()+(getHp()*10/100));
         setHpm(getHp());
         setMp(getMp()+(getMp()*10/100));
         setMpm(getMp());
         setMpc1(10);
         setMpc2(12);
         setAtk(getAtk()+(getAtk()*20/100));
         setMagic(getMagic()+(getMagic()*10/100));
         setSname1("Blind + Silence Attack");
         setSname2("Drain");
         setArmor(getArmor()+2);
         setEva(10);
         setAcc(100);
        }
    }
    
    @Override
    void attackEnemy(String name,int dmge,int acce,int acc) {
        int eva= r.nextInt(100);
        if(acc<=acce) {
         if(eva>getEva()) {
          setHp(getHp()-(dmge-getArmor()));
          System.out.println(name+" attack "+getName());
         }else if(eva<=getEva()) {
          System.out.println(name+" attack miss!");
         }
        }else if(acc>acce) {
         System.out.println(name+" attack miss!");
        }
    }
    
    void momonSkill(String name,String elem,String sname,int magice) {
        if("Wild Dog".equals(name)) {
         setHp(getHp()-magice);
         System.out.println(name+" use "+sname);
        }else if("Magic Monster".equals(name)) {
         if("Fire".equals(elem)) {
          setHp(getHp()-magice);
          System.out.println(name+" use "+sname);
         }else if("Water".equals(elem)) {
          setHp(getHp()-magice);
          System.out.println(name+" use "+sname);
         }else if("Thunder".equals(elem)) {
          setHp(getHp()-magice);
          System.out.println(name+" use "+sname);
         }else if("Ice".equals(elem)) {
          setHp(getHp()-magice);
          System.out.println(name+" use "+sname);
         }
        }   
    }
    
    @Override
    void defense(String name,int dmge,int acce,int acc) {
        int eva= r.nextInt(100);
        if(acc<=acce) {
         if(eva>getEva()) {
          setHp(getHp()-((dmge-dmge*70/100)-getArmor()));
          System.out.println(name+" attack "+getName());
         }else if(eva<=getEva()) {
          System.out.println(name+" attack miss!");
         }
        }else if(acc>acce) {
         System.out.println(name+" attack miss!");
        }
    }
    
    @Override
    void listSkill() {
        System.out.println("1. "+getSname1());
        System.out.println("2. "+getSname2());
    }
    
    @Override
    void listElement() {
        System.out.println("1. Fire");
        System.out.println("2. Water");
        System.out.println("3. Thunder");
        System.out.println("4. Ice");
    }
    
    void magicBoost() {
        setMp(getMp()-getMpc());
        setMagic(getMagic()+(getMagic()*50/100));
        System.out.println(getName()+" use "+getSname2());
    }
    
    void heal() {
        setMp(getMp()-getMpc2());
        setHp(getHp()+(getHpm()*60/100));
        System.out.println(getName()+" use "+getSname2());
    }
    
    void Sentinel(String name,int dmge,int acce,int acc) {
        int eva= r.nextInt(100);
        if(acc<=acce) {
         if(eva>getEva()) {
          setHp(getHp()-((dmge-dmge*95/100)-getArmor()));
          System.out.println(name+" attack "+getName());
         }else if(eva<=getEva()) {
          System.out.println(name+" attack miss!");
         }
        }else if(acc>acce) {
         System.out.println(name+" attack miss!");
        }   
    }
    
    void Drain(String name) {
        setMp(getMp()-getMpc2());
        setHp(getHp()+getMagic());
        System.out.println(getName()+" use "+getSname2());
        System.out.println(name+" HP Drained!");
    }
}




