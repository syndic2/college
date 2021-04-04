package tugasprakw3;
public class villain {
    private String villain,icon,skill;
    private int skilluse;
    private int hp,hpmax;
    private int mp,mpmax,mpcost;
    private int batk,matk,armor,acc;
    private int expdrop,goldrop;
    private int xm1,ym1;
    private int xm2,ym2;
    private int xm3,ym3;
    private int xm4,ym4;
    private int xm5,ym5;
    private int xm6,ym6;
    private int xm7,ym7;
    private int xm8,ym8;
    private int xm9,ym9;
    private int xb,yb;
    villain(int typem) {
     if(typem==0) {
      this.villain= "Wild Dog";
      this.icon= "w";
      this.skill= "Fire Torch";
      this.skilluse= this.matk;
      this.hp= 150;
      this.hpmax= this.hp;
      this.mp= 50;
      this.mpcost= 40;
      this.mpmax= this.mp;
      this.batk= 32;
      this.matk= 10;
      this.armor= 15;
      this.acc= 100;
      this.expdrop= (int)(Math.random()*5+15);
      this.goldrop= 120;
     }
     else if(typem==1) {
      this.villain= "Magic Monster";
      this.icon= "m";
      this.skill= "Thunder";
      this.skilluse= this.matk;
      this.hp= 200;
      this.hpmax= this.hp;
      this.mp= 300;
      this.mpcost= 50;
      this.mpmax= this.mp;
      this.batk= 7;
      this.matk= 70;
      this.armor= 20;
      this.acc= 100;
      this.expdrop= (int)(Math.random()*5+20);
      this.goldrop= 150;
     }
     else if(typem==2) {
      this.villain= "Wild Dog";
      this.icon= "w";
      this.skill= "Fire Torch";
      this.skilluse= this.matk;
      this.hp= 150;
      this.hpmax= this.hp;
      this.mp= 50;
      this.mpcost= 40;
      this.mpmax= this.mp;
      this.batk= 32;
      this.matk= 10;
      this.armor= 15;
      this.acc= 100;
      this.expdrop= (int)(Math.random()*5+15);
      this.goldrop= 120;
     }
     else if(typem==3) {
      this.villain= "Magic Monster";
      this.icon= "m";
      this.skill= "Thunder";
      this.skilluse= this.matk;
      this.hp= 200;
      this.hpmax= this.hp;
      this.mp= 300;
      this.mpcost= 50;
      this.mpmax= this.mp;
      this.batk= 7;
      this.matk= 70;
      this.armor= 20;
      this.acc= 100;
      this.expdrop= (int)(Math.random()*5+20);
      this.goldrop= 150;
     }
     else if(typem==4) {
      this.villain= "Wild Dog";
      this.icon= "w";
      this.skill= "Fire Torch";
      this.skilluse= this.matk;
      this.hp= 150;
      this.hpmax= this.hp;
      this.mp= 50;
      this.mpcost= 40;
      this.mpmax= this.mp;
      this.batk= 32;
      this.matk= 10;
      this.armor= 15;
      this.acc= 100;
      this.expdrop= (int)(Math.random()*5+15);
      this.goldrop= 120;
     }
    }
    villain() {
     this.villain= "BOSS";
     this.icon= "B";
     this.skill= "Increase Attack";
     this.hp= 2000;
     this.hpmax= this.hp;
     this.mp= 400;
     this.mpcost= 10;
     this.mpmax= this.mp;
     this.batk= 80;
     this.matk= 40;
     this.skilluse= this.batk+5;
     this.armor= 25;
     this.acc= 100;
     this.expdrop= (int)(Math.random()*20+40);
     this.goldrop= 300;
    }
    void setHP(int hp) {this.hp= hp;}
    void setMP(int mp) {this.mp= mp;}
    void setAtk(int atk) {this.batk= atk;}
    void setAcc(int acc) {this.acc= acc;}
    void setArmor(int armor) {this.armor= armor;}
    void setXm1(int x) {this.xm1= x;}
    void setYm1(int y) {this.ym1= y;}
    void setXm2(int x) {this.xm2= x;}
    void setYm2(int y) {this.ym2= y;}
    void setXm3(int x) {this.xm3= x;}
    void setYm3(int y) {this.ym3= y;}
    void setXm4(int x) {this.xm4= x;}
    void setYm4(int y) {this.ym4= y;}
    void setXm5(int x) {this.xm5= x;}
    void setYm5(int y) {this.ym5= y;}
    void setXm6(int x) {this.xm6= x;}
    void setYm6(int y) {this.ym6= y;}
    void setXm7(int x) {this.xm7= x;}
    void setYm7(int y) {this.ym7= y;}
    void setXm8(int x) {this.xm8= x;}
    void setYm8(int y) {this.ym8= y;}
    void setXm9(int x) {this.xm9= x;}
    void setYm9(int y) {this.ym9= y;}
    void setXb(int x) {this.xb= x;}
    void setYb(int y) {this.yb= y;}
    
    String getVillain() {return this.villain;}
    String getIcon() {return this.icon;}
    String getSkill() {return this.skill;}
    int getHP() {return this.hp;}
    int getHPm() {return this.hpmax;}
    int getMP() {return this.mp;}
    int getMPc() {return this.mpcost;}
    int getMPm() {return this.mpmax;}
    int getAtk() {return this.batk;}
    int getMagic() {return this.matk;}
    int getSkilluse() {return this.skilluse;}
    int getArmor() {return this.armor;}
    int getAcc() {return this.acc;}
    int getEXPDrop() {return this.expdrop;}
    int getGoldDrop() {return this.goldrop;}
    int getXm1() {return this.xm1;}
    int getYm1() {return this.ym1;}
    int getXm2() {return this.xm2;}
    int getYm2() {return this.ym2;}
    int getXm3() {return this.xm3;}
    int getYm3() {return this.ym3;}
    int getXm4() {return this.xm4;}
    int getYm4() {return this.ym4;}
    int getXm5() {return this.xm5;}
    int getYm5() {return this.ym5;}
    int getXm6() {return this.xm6;}
    int getYm6() {return this.ym6;}
    int getXm7() {return this.xm7;}
    int getYm7() {return this.ym7;}
    int getXm8() {return this.xm8;}
    int getYm8() {return this.ym8;}
    int getXm9() {return this.xm9;}
    int getYm9() {return this.ym9;}
    int getXb() {return this.xb;}
    int getYb() {return this.yb;}
    
    void statsBattle() {
        System.out.println ("-"+getVillain()+"-");
        System.out.println ("HP Enemy: "+getHP()+"/"+getHPm());
        System.out.println ("MP Enemy: "+getMP()+"/"+getMPm());
    }
    void attackHero(String hero,int atk) {
        setHP(getHP()-(atk-getArmor()));
        System.out.println (hero+" succesfully attack "+getVillain());
    }
    void skillWarrior1(String hero,String skill1,int skilluse1) {
        setHP(getHP()-skilluse1);
        setAtk(getAtk()-(getAtk()*10/100));
        System.out.println (hero+" use "+skill1);
    }
    void skillWarrior2(String hero,String skill2,int skilluse2) {
        setHP(getHP()-skilluse2);
        setArmor(0);
        System.out.println (hero+" use "+skill2);
    }
    void skillMage1(String hero,String skill1,int skilluse1) {
        setHP(getHP()-skilluse1);
        System.out.println (hero+" use "+skill1);
    }
    void bossSkill() {
        setMP(getMP()-getMPc());
        setAtk(getSkilluse());
        System.out.println (getVillain()+" using "+getSkill());
    }
}
