package tugasprakw3;
public class hero{
    private String hero,icon;
    private int hp,hpmax;
    private int mp,mpmax,mpcost;
    private int batk,matk;
    private int acc,eva,armor;
    private int lv,exp,exmpmax;
    private int sp,ctrblind,ctrsilence,ctrpb;
    private String skill1,skill2;
    private int skilluse1,skilluse2;
    static int jumlahHero= 0 ;
    hero(int job) {
     if(job==1) {
      this.hero= "Warrior";
      this.icon= "W";
      this.hp= 520;
      this.hpmax= this.hp;
      this.mp= 30;
      this.mpcost= 8;
      this.mpmax= this.mp;
      this.batk= 520;
      this.matk= 20;
      this.skill1= "Power Break";
      this.skilluse1= this.batk;
      this.skill2= "Armor Break";
      this.skilluse2= this.batk;
      this.acc= 90;
      this.eva= 0;
      this.armor= 8;
      this.sp= 0;
      this.lv= 1;
      this.exp= 0;
      this.exmpmax= 100;
      jumlahHero++;
     }
     else if(job==2) {
      this.hero= "Mage";
      this.icon= "M";
      this.hp= 360;
      this.hpmax= this.hp;
      this.mp = 120;
      this.mpcost= 4;
      this.mpmax= this.mp;
      this.batk= 30;
      this.matk= 200;
      this.skill1= "Magic Ball";
      this.skilluse1= this.matk;
      this.skill2= "Magic Boost";
      this.skilluse2= this.matk+(this.matk*50/100);
      this.acc= 75;
      this.eva= 10;
      this.armor= 2;
      this.sp= 0;
      this.lv= 1;
      this.exp= 0;
      this.exmpmax= 100;
      jumlahHero++;
     }
     else if(job==3) {
      this.hero= "Range";
      this.icon= "R";
      this.hp= 610;
      this.hpmax= 610;
      this.mp= 40;
      this.mpcost= 5;
      this.mpmax= this.mp;
      this.batk= 70;
      this.matk= 100;
      this.skill1= "Blind Attack";
      this.skill2= "Silence Attack";
      this.acc= 100;
      this.eva= 5;
      this.armor= 4;
      this.sp= 0;
      this.lv= 1;
      this.exp= 0;
      this.exmpmax= 100;
      this.sp= 0;
      jumlahHero++;
     } 
   }
    void setIcon(String icon) {this.icon= icon;}
    void setHP(int hp) {this.hp= hp;}
    void setMP(int mp) {this.mp= mp;}
    void setAtk(int atk) {this.batk= atk;}
    void setMagic(int magic) {this.matk= magic;}
    void setAcc(int acc) {this.acc= acc;}
    void setEva(int eva) {this.eva= eva;}
    void setArmor(int armor) {this.armor= armor;}
    void setSP(int sp) {this.sp= sp;}
    void setLv(int lv) {this.lv= lv;}
    void setEXP(int exp) {this.exp= exp;}
    void setCTRpb(int pb) {this.ctrpb= pb;}
    void setCTRb(int blind) {this.ctrblind= blind;}
    
    String getHero() {return this.hero;}
    String getIcon() {return this.icon;}
    int getHP() {return this.hp;}
    int getHPm() {return this.hpmax;}
    int getMP() {return this.mp;}
    int getMPc() {return this.mpcost;}
    int getMPm() {return this.mpmax;}
    int getSP() {return this.sp;}
    int getAtk() {return this.batk;}
    int getMagic() {return this.matk;}
    String getSkill1() {return this.skill1;}
    String getSkill2() {return this.skill2;}
    int getSkilluse1() {return this.skilluse1;}
    int getSkilluse2() {return this.skilluse2;}
    int getAcc() {return this.acc;}
    int getEva() {return this.eva;}
    int getArmor() {return this.armor;}
    int getLv() {return this.lv;}
    int getEXP() {return this.exp;}
    int getEXMPm() {return this.exmpmax;}
    int getCTRpb() {return this.ctrpb;}
    int getCTRb() {return this.ctrblind;}
    int getCTRs() {return this.ctrsilence;}
    
    void cetakStats(int idxhero) {
        System.out.println ((idxhero+1)+". Hero: "+getHero());
        System.out.println ("Level: "+getLv());
        System.out.println ("EXP: "+getEXP());
        System.out.println ("HP: "+getHP());
        System.out.println ("MP: "+getMP());
        System.out.println ("ATK: "+getAtk());
        System.out.println ("ARMOR: "+getArmor());
        System.out.println ("EVA: "+getEva());
        System.out.println ("ACC: "+getAcc());
        System.out.println ("==================");
    }
    void SkillPoint(int sp) {
        if(sp==1) {setHP(getHPm()+300);}
        else if(sp==2) {setMP(getMPm()+20);}
        else if(sp==3) {setAtk(getAtk()+20);}
        else if(sp==4) {setArmor(getArmor()+1);}
        else if(sp==5) {setEva(getEva()+3);}
        else if(sp==6) {setAcc(getAcc()+2);}
    }
    void statsBattle() {
        System.out.println ("-"+getHero()+"-");
        System.out.println ("HP Player: "+getHP()+"/"+getHPm());
        System.out.println ("MP Player: "+getMP()+"/"+getMPm());
        System.out.println ("1. Attack");
        System.out.println ("2. Skill");
        System.out.println ("3. Defend");  
    }
    void Skill() {
        System.out.println ("SKILL: ");
        System.out.println ("1. "+getSkill1());
        System.out.println ("2. "+getSkill2());
    }
    void mageSkill2() {
        setMagic(getMagic()+(getMagic()*10/100));
        System.out.println (getHero()+" use "+getSkill2());
    }
    void rangeSkill1() {
        System.out.println (getHero()+" use "+getSkill1());
    }
    void rangeSkill2() {
        System.out.println (getHero()+" use "+getSkill2());
    }
    void defHero(String villain,int defhero) {
        setHP(getHP()-(defhero-getArmor()));
        if(getHP()>getHPm()) {
         setHP(getHPm());
        }
        System.out.println (villain+" succesfully attack "+getHero());
    }
    void villainAttack(String villain,int atk) {
        int evah= (int)(Math.random()*100);
        if(evah>getEva()) {
         setHP(getHP()-(atk-getArmor()));
         if(getHP()>getHPm()) {
         setHP(getHPm());
         }
         System.out.println (villain+" succesfully attack "+getHero());
        }
        else if(evah<=getEva()) {
         System.out.println (villain+" attack miss!");
        } 
    }
    void monsSkill(String villain,String skill,int skilluse) {
        setHP(getHP()-skilluse);
        System.out.println (villain+" using "+skill);
    }
}
    