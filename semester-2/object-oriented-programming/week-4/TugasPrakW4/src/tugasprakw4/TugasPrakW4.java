package tugasprakw4;
import java.util.*;
public class TugasPrakW4 {
    static int panjang= 33,lebar= 33;
    static String map[][]= new String[panjang][lebar];
    static int xhero= 1,yhero= 1,chero= 0;
    static int xhealing= 16,yhealing= 16;
    static String step;
    static void initMap() {
        for(int i= 0;i<panjang;i++) {
         for(int j= 0;j<lebar;j++) {
          if(i==0 || i==panjang-1 || j==0 || j==lebar-1) {
           map[i][j]= "#";
          }else map[i][j]= " ";
         }
        }
    }
    static void cetakMap() {
        if((xhero>=0 && xhero<=10) && (yhero>=0 && yhero<=10)) {
         System.out.println("Map 1");
         for(int i= 0;i<=10;i++) {
          for(int j= 0;j<=10;j++) {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }else if((xhero>10 && xhero<=21) && (yhero>=0 && yhero<=10)) {
         System.out.println("Map 2");
         for(int i= 0;i<=10;i++) {
          for(int j= 11;j<=21;j++) {
           System.out.print (map[i][j]);
          }  
          System.out.println ();
         }
        }else if((xhero>21 && xhero<lebar) && (yhero>=0 && yhero<=10)) {
         System.out.println("Map 3");
         for(int i= 0;i<=10;i++) {
          for(int j= 22;j<lebar;j++) {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }else if((xhero>=0 && xhero<=10) && (yhero>10 && yhero<=20)) {
         System.out.println("Map 4");
         for(int i=11;i<=20;i++) {
          for(int j= 0;j<=10;j++) {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }else if((xhero>10 && xhero<=21) && (yhero>10 && yhero<=20)) {
         System.out.println("Map 5");
         for(int i= 11;i<=20;i++) {
          for(int j= 11;j<=21;j++) {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }else if((xhero>21 && xhero<lebar) && (yhero>10 && yhero<=20)) {
         System.out.println("Map 6");
         for(int i= 11;i<=20;i++) {
          for(int j= 22;j<lebar;j++) {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }else if((xhero>=0 && xhero<=10) && (yhero>20 && yhero<panjang)) {
         System.out.println("Map 7");
         for(int i= 21;i<panjang;i++) {
          for(int j= 0;j<=10;j++) {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }else if((xhero>10 && xhero<=21) && (yhero>20 && yhero<panjang)) {
         System.out.println("Map 8");
         for(int i= 21;i<panjang;i++) {
          for(int j= 11;j<=21;j++) {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }else if((xhero>21 && xhero<lebar) && (yhero>20 && yhero<panjang)) {
         System.out.println("Map 9");
         for(int i= 21;i<panjang;i++) {
          for(int j= 22;j<lebar;j++) {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }
    }
    static void move() {
        if("w".equals(step) && !"#".equals(map[yhero-1][xhero])) {
         map[yhero][xhero]= " ";
         yhero--;
        }else if("a".equals(step) && !"#".equals(map[yhero][xhero-1])) {
         map[yhero][xhero]= " ";
         xhero--;
        }else if("s".equals(step) && !"#".equals(map[yhero+1][xhero])) {
         map[yhero][xhero]= " ";
         yhero++;
        }else if("d".equals(step) && !"#".equals(map[yhero][xhero+1])) {
         map[yhero][xhero]= " ";
         xhero++;
        } 
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        Scanner string= new Scanner(System.in);
        ArrayList<tier1> tier1= new ArrayList<>();
        ArrayList<mons> momon= new ArrayList<>();
        ArrayList<mons> boss= new ArrayList<>();
        int menu,buy,sp,action,skill,subskill,ctrbuy= 0,gold= 800;
        int turn= 0,ctrevolve= 0,acch,eaction,acce;
        int ctrpb= 0,ctrsent= 0,ctrb= 99,ctrs= 99,ctrempt= 99;
        Random r= new Random();
        do{
        System.out.println("Gold: "+gold+"G");
        System.out.println("1. Start Playing");
        System.out.println("2. Beli Hero ("+ctrbuy+"/12)");
        System.out.println("3. Lihat Hero");
        System.out.println("4. Exit");
        System.out.print("Menu: ");
        menu= input.nextInt();
        if(menu==1) {
         if(ctrbuy>0) {
          //create boss
          for(int i= 0;i<5;i++) {
           boss.add(new mons());
          }
          boss.get(0).setXb(31);
          boss.get(0).setYb(5);
          boss.get(1).setXb(31);
          boss.get(1).setYb(16);
          boss.get(2).setXb(31);
          boss.get(2).setYb(26);
          boss.get(3).setXb(16);
          boss.get(3).setYb(31);
          boss.get(4).setXb(5);
          boss.get(4).setYb(31);
          //create mons
          for(int i= 0;i<5;i++) {
           int typem= r.nextInt(5);
           int elem= r.nextInt(4);
           momon.add(new mons(typem,elem));
          }
          for(int i= 0;i<momon.size();i++) {
           int x= r.nextInt(8)+2;
           int y= r.nextInt(8)+2;
           momon.get(i).setXm(x);
           momon.get(i).setYm(y);
          }
          initMap();
          do{
          map[yhero][xhero]= tier1.get(chero).getIcon();
          map[yhealing][xhealing]= "H";
          for(int i= 0;i<boss.size();i++) {
           map[boss.get(i).getYb()][boss.get(i).getXb()]= boss.get(i).getIcon();
          }
          for(int i= 0;i<momon.size();i++) {
           map[momon.get(i).getYm()][momon.get(i).getXm()]= momon.get(i).getIcon();
          }
          cetakMap();
          System.out.print("Move: ");
          step= string.nextLine();
          move();
          if("e".equals(step) || "E".equals(step)) {
           if(tier1.get(chero).getLv()==10) {
            tier1.get(chero).Evolve(tier1.get(chero).getName());
            ctrevolve++;
           }else System.out.println(tier1.get(chero).getName()+" level tidak cukup untuk evolve!");
          }else if("g".equals(step) || "G".equals(step)) {
           chero++;
           if(chero>=tier1.size()) {
            chero= 0;
           }
          }else if("m".equals(step) || "M".equals(step)) {
           System.out.println ("-Skill Point-");
           System.out.println ("Jumlah SP: "+tier1.get(chero).getSp()+" SP");
           System.out.println ("1. +300 HP");
           System.out.println ("2. +20 MP");
           System.out.println ("3. +20 Attack");
           System.out.println ("4. +1 Armor");
           System.out.println ("5. +3% Evasion");
           System.out.println ("6. +2 Akurasi");
           System.out.print ("Pilih SP: ");
           sp= input.nextInt();
           if(tier1.get(chero).getSp()>0) {
            tier1.get(chero).SkillPoint(sp);
            tier1.get(chero).setSp(tier1.get(chero).getSp()-1);
           }else System.out.println("SP tidak cukup!");
          }else if("x".equals(step) || "X".equals(step)) {
           if("Warrior".equals(tier1.get(chero).getName()) || "Knight".equals(tier1.get(chero).getName())) {
            ctrempt= 0;
            System.out.println("Using Pre-emptive Strike!");
           }else if("Mage".equals(tier1.get(chero).getName()) || "Sorcerer".equals(tier1.get(chero).getName())) {
            ctrempt= 0;
            System.out.println("Using Pre-emptive Strike!");
           }else if("Range".equals(tier1.get(chero).getName()) || "Trooper".equals(tier1.get(chero).getName())) {
            ctrempt= 0;
            System.out.println("Using Pre-emptive Strike!");
           }
          }
          
          //battle mons
          for(int i= chero;i<tier1.size();i++) {
           for(int j= 0;j<momon.size();j++) {
            if(xhero==momon.get(j).getXm() && yhero==momon.get(j).getYm()) {
             do{
             acch= r.nextInt(100);
             acce= r.nextInt(100);
             eaction= r.nextInt(100);
             momon.get(j).statsBattle(momon.get(j).getName());
             System.out.println();
             tier1.get(i).statsBattle();
             System.out.println("1. Attack");
             System.out.println("2. Skill");
             System.out.println("3. Defend");
             System.out.print("Action: ");
             action= input.nextInt();
             if(action==1) { //attack
               if(acch<=tier1.get(i).getAcc()) { //atk
                momon.get(j).attackHero(tier1.get(i).getName(),tier1.get(i).getAtk());
               //momon action
               if(ctrempt<2) {
                System.out.println("Pre-emptive Condition");
                ctrempt++;
               }else if(ctrempt>=2) {
               if(eaction<=75) { //momon atk
                if(ctrb<3) { //cek blind
                 momon.get(j).setAcc(10);
                 tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 ctrb++;
                }else if(ctrb>=3) {
                 momon.get(j).setAcc(100);
                 tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                }
               }else if(eaction>75) { //momon skill
                if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                 if(ctrs<3) { //cek silence
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                  System.out.println(momon.get(j).getName()+" cant use skill!");
                  ctrs++;
                 }else if(ctrs>=3) {
                  momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                  tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                  momon.get(j).getMagic());
                 }
                }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                 tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                }
               }
              }
              }else if(acch>tier1.get(i).getAcc()) { //miss
               System.out.println(tier1.get(i).getName()+" attack miss!");
               if(ctrempt<2) {
                System.out.println("Pre-emptive Condition");
                ctrempt++;
               }else if(ctrempt>=2) {
               //momon action
               if(eaction<=75) { //momon atk
                if(ctrb<3) { //cek blind
                 momon.get(j).setAcc(10);
                 tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 ctrb++;
                }else if(ctrb>=3) {
                 momon.get(j).setAcc(100);
                 tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                }
               }else if(eaction>75) { //momon skill
                if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                 if(ctrs<3) { //cek silence
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                  System.out.println(momon.get(j).getName()+" cant use skill!");
                  ctrs++;
                 }else if(ctrs>=3) {
                  momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                  tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                  momon.get(j).getMagic());
                 }
                }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                 tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                }
               }
              }
              }
              turn++;
             }else if(action==2) { //skill
              if(tier1.get(i).getMpc()<=tier1.get(i).getMp()) {
               tier1.get(i).listSkill();
               System.out.print("Skill: ");
               skill= input.nextInt();
               if("Warrior".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 if(ctrpb<1) {
                  tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                  momon.get(j).powerBreak(tier1.get(i).getName(),tier1.get(i).getAtk(),tier1.get(i).getSname1());
                  //momon action
                  if(ctrempt<2) {
                   System.out.println("Pre-emptive condition");
                   ctrempt++;
                  }else if(ctrempt>=2) {
                  if(eaction<=75) { //momon atk
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }else if(eaction>75) { //momon skill
                   if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp masih ckup 
                    momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                    tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
		    momon.get(j).getMagic());
                   }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                    tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                    if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                     tier1.get(i).setHp(tier1.get(i).getHpm());
                    }
                   }
                  }
                  }
                  ctrpb++;
                 }else System.out.println("No effect!");
                }else if(skill==2) {
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                 momon.get(j).powerBreak(tier1.get(i).getName(),tier1.get(i).getAtk(),tier1.get(i).getSname2());
                 //momon action
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp masih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }else if("Mage".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                 momon.get(j).magicBall(tier1.get(i).getName(),tier1.get(i).getMagic(),tier1.get(i).getSname1());
                 //bos action
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp masih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                 }
                }else if(skill==2) {
                 tier1.get(i).magicBoost();
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //momon action
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp masih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }else if("Range".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 ctrb= 0;
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                 System.out.println(tier1.get(i).getName()+" use "+tier1.get(i).getSname1());
                 //boss action
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp masih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }else if(skill==2) {
                 ctrs= 0;
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                 System.out.println(tier1.get(i).getName()+" use "+tier1.get(i).getSname2());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //momon action
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp masih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }else if("Knight".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc1());
                 momon.get(j).poarmBreak(tier1.get(i).getName(),tier1.get(i).getAtk(),tier1.get(i).getSname1());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //momon action
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  } 
                 }
                }
                }else if(skill==2) {
                 if(ctrsent<1) { //cek sentinel
                  System.out.println(tier1.get(i).getName()+" use "+tier1.get(i).getSname2());
                  tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc2());
                  if(ctrempt<2) {
                   System.out.println("Pre-emptive condition");
                   ctrempt++;
                  }else if(ctrempt>=2) {
                  //momon action
                  if(eaction<=75) { //momon atk
                   tier1.get(i).Sentinel(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }else if(eaction>75) { //momon skill
                   if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                    momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                    tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                    momon.get(j).getMagic());
                   }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                    tier1.get(i).Sentinel(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                    if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                     tier1.get(i).setHp(tier1.get(i).getHpm());
                    }
                   }
                  }
                  ctrsent++;
                 }
                 }else if(ctrsent>=1) {
                  if(ctrempt<2) {
                   System.out.println("Pre-emptive condition");
                   ctrempt++;
                  }else if(ctrempt>=2) {
                  //momon action 
                  if(eaction<=75) { //momon atk
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                 }
                }
               }
               }else if("Sorcerer".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 tier1.get(i).listElement();
                 System.out.print("Element: ");
                 subskill= input.nextInt();
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc1());
                 momon.get(j).elementMons(momon.get(j).getName(),momon.get(j).getElement(),
                 tier1.get(i).getMagic(),subskill,tier1.get(i).getSname1());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //momon action
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }else if(skill==2) {
                 tier1.get(i).heal();
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //momon action
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }else if("Trooper".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 ctrb= 0;
                 ctrs= 0;
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc1());
                 System.out.println(tier1.get(i).getName()+" use "+tier1.get(i).getSname1());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //momon action
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }else if(skill==2) {
                 momon.get(j).setHp(momon.get(j).getHp()-tier1.get(i).getMagic());
                 tier1.get(i).Drain(momon.get(j).getName());
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //momon action
                 if(eaction<=75) { //momon atk
                  tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //momon skill
                  if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                   momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                   tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                   momon.get(j).getMagic());
                  }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                   tier1.get(i).attackEnemy(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }
              }else System.out.println("MP tidak cukup!");
              turn++;
             }else if(action==3) { //defend
              System.out.println(tier1.get(i).getName()+" use defense!");
              //momon action
              if(ctrempt<2) {
               System.out.println("Pre-emptive conidition");
               ctrempt++;
              }else if(ctrempt>=2) {
              if(eaction<=75) { //momon atk
               if(ctrb<3) { //cek blind
                momon.get(j).setAcc(10);
                tier1.get(i).defense(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                 tier1.get(i).setHp(tier1.get(i).getHpm());
                }
                ctrb++;
               }else if(ctrb>=3) {
                momon.get(j).setAcc(100);
                tier1.get(i).defense(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                 tier1.get(i).setHp(tier1.get(i).getHpm());
                }
               }
              }else if(eaction>75) { //momon skill
               if(momon.get(j).getMpc()<=momon.get(j).getMp()) { //momon mp msih ckup
                if(ctrs<3) {
                 tier1.get(i).defense(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 System.out.println(momon.get(j).getName()+" cant use skill!");
                 ctrs++;
                }else if(ctrs>=3) {
                 momon.get(j).setMp(momon.get(j).getMp()-momon.get(j).getMpc());
                 tier1.get(i).momonSkill(momon.get(j).getName(),momon.get(j).getElement(),momon.get(j).getSname(),
                 momon.get(j).getMagic());
                }
               }else if(momon.get(j).getMpc()>momon.get(j).getMp()) { //momon mp tdk ckup
                tier1.get(i).defense(momon.get(j).getName(),momon.get(j).getAtk(),momon.get(j).getAcc(),acce);
                if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                 tier1.get(i).setHp(tier1.get(i).getHpm());
                }
               }
              }
             }
              turn++;
             }
             
             //bonus mp
             if(turn%3==0) {
              tier1.get(i).setMp(tier1.get(i).getMp()+10);
              System.out.println ("Mendapat MP bonus sebanyak 10!");
              if(tier1.get(i).getMp()>tier1.get(i).getMpm()) {
               tier1.get(i).setMp(tier1.get(i).getMpm());
              }
             }
             }while(tier1.get(i).getHp()>0 && momon.get(j).getHp()>0);
             if(momon.get(j).getHp()<=0) { //mons klh
              ctrpb= 0;
              ctrsent= 0;
              ctrb= 99;
              ctrs= 99;
              ctrempt= 99;
              turn= 0;
              System.out.println (momon.get(j).getName()+" was dropped out!");
              tier1.get(i).setExp(tier1.get(i).getExp()+momon.get(j).getExpdrop());
              if(tier1.get(i).getExp()>=tier1.get(i).getExpm()) {
               tier1.get(i).setLv(tier1.get(i).getLv()+1);
               tier1.get(i).setExp(0);
               tier1.get(i).setSp(tier1.get(i).getSp()+1);
               System.out.println (tier1.get(i).getName()+" level up!");
              }
              gold+= momon.get(j).getGolddrop();
              System.out.println ("Got "+momon.get(j).getExpdrop()+"exp.");
              System.out.println ("Got "+momon.get(j).getGolddrop()+"G");
              momon.remove(j);
             }else if(tier1.get(i).getHp()<=0) { //hero klh
              ctrpb= 0;
              ctrsent= 0;
              ctrb= 99;
              ctrs= 99;
              ctrempt= 99;
              turn= 0;
              System.out.println (tier1.get(i).getName()+" was dropped out!");
              ctrbuy-=1;
              tier1.remove(i);
             }
            }
           }
          }
          
          //battle boss
          for(int i= chero;i<tier1.size();i++) {
           for(int j= 0;j<boss.size();j++) {
            if(xhero==boss.get(j).getXb() && yhero==boss.get(j).getYb()) {
             do{
             acch= r.nextInt(100);
             acce= r.nextInt(100);
             eaction= r.nextInt(100);
             boss.get(j).statsBattle(boss.get(j).getName());
             System.out.println();
             tier1.get(i).statsBattle();
             System.out.println("1. Attack");
             System.out.println("2. Skill");
             System.out.println("3. Defend");
             System.out.print("Action: ");
             action= input.nextInt();
             if(action==1) { //attack
              if(acch<=tier1.get(i).getAcc()) { //atk
               boss.get(j).attackHero(tier1.get(i).getName(),tier1.get(i).getAtk());
               //boss action
               if(ctrempt<2) {
                System.out.println("Pre-emptive condition");
                ctrempt++;
               }else if(ctrempt>=2) {
               if(eaction<=75) { //boss atk
                if(ctrb<3) { //cek blind
                 boss.get(j).setAcc(10);
                 tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 ctrb++;
                }else if(ctrb>=3) {
                 boss.get(j).setAcc(100);
                 tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                }
               }else if(eaction>75) { //boss skill
                if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                 if(ctrs<3) { //cek silence
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                  System.out.println(boss.get(j).getName()+" cant use skill!");
                  ctrs++;
                 }else if(ctrs>=3) {
                  boss.get(j).bossSkill();
                 }
                }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                 tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                }
               }
              }
              }else if(acch>tier1.get(i).getAcc()) { //miss
               System.out.println(tier1.get(i).getName()+" attack miss!");
               //boss action
               if(ctrempt<2) {
                System.out.println("Pre-emptive condition");
                ctrempt++;
               }else if(ctrempt>=2) {
               if(eaction<=75) { //boss atk
                if(ctrb<3) { //cek blind
                 boss.get(j).setAcc(10);
                 tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 ctrb++;
                }else if(ctrb>=3) {
                 boss.get(j).setAcc(100);
                 tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                }
               }else if(eaction>75) { //boss skill
                if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                 if(ctrs<3) { //cek silence
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  System.out.println(boss.get(j).getName()+" cant use skill!");
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                  ctrs++;
                 }else if(ctrs>=3) {
                  boss.get(j).bossSkill();
                 }
                }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                 tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                }
               }
              }
              }
              turn++;
             }else if(action==2) { //skill
              if(tier1.get(i).getMpc()<=tier1.get(i).getMp()) {
               tier1.get(i).listSkill();
               System.out.print("Skill: ");
               skill= input.nextInt();
               if("Warrior".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 if(ctrpb<1) {
                  tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                  boss.get(j).powerBreak(tier1.get(i).getName(),tier1.get(i).getAtk(),tier1.get(i).getSname1());
                  ctrpb++;
                  if(ctrempt<2) {
                   System.out.println("Pre-emptive condition");
                   ctrempt++;
                  }else if(ctrempt>=2) {
                  //boss action
                  if(eaction<=75) { //boss atk
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }else if(eaction>75) { //boss skill
                   if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp masih ckup 
                    boss.get(j).bossSkill();
                   }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                    tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                    if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                     tier1.get(i).setHp(tier1.get(i).getHpm());
                    }
                   }
                  }
                 }
                 }else System.out.println("No effect!");
                }else if(skill==2) {
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                 boss.get(j).powerBreak(tier1.get(i).getName(),tier1.get(i).getAtk(),tier1.get(i).getSname2());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp masih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }else if("Mage".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                 boss.get(j).magicBall(tier1.get(i).getName(),tier1.get(i).getMagic(),tier1.get(i).getSname1());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                 }else if(ctrempt>=2) {
                 //bos action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp masih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }else if(skill==2) {
                 tier1.get(i).magicBoost();
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive strike");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp masih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }else if("Range".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 ctrb= 0;
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                 System.out.println(tier1.get(i).getName()+" use "+tier1.get(i).getSname1());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                 }else if(ctrempt>=2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp masih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }else if(skill==2) {
                 ctrs= 0;
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc());
                 System.out.println(tier1.get(i).getName()+" use "+tier1.get(i).getSname2());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp masih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }else if("Knight".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc1());
                 boss.get(j).poarmBreak(tier1.get(i).getName(),tier1.get(i).getAtk(),tier1.get(i).getSname1());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt<2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  } 
                 }
                }
                }else if(skill==2) {
                 if(ctrsent<1) { //cek sentinel
                  System.out.println(tier1.get(i).getName()+" use "+tier1.get(i).getSname2());
                  tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc2());
                  ctrsent++;
                  if(ctrempt<2) {
                   System.out.println("Pre-emptive condition");
                   ctrempt++;
                  }else if(ctrempt>=2) {
                  //boss action
                  if(eaction<=75) { //boss atk
                   tier1.get(i).Sentinel(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }else if(eaction>75) { //boss skill
                   if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                    boss.get(j).bossSkill();
                   }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                    tier1.get(i).Sentinel(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                    if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                     tier1.get(i).setHp(tier1.get(i).getHpm());
                    }
                   }
                  }
                 }
                 }else if(ctrsent>=1) {
                  if(ctrempt<2) {
                   System.out.println("Pre-emptive condition");
                   ctrempt++;
                  }else if(ctrempt>=2) {
                  //boss action 
                  if(eaction<=75) { //boss atk
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                 }
                }
               }
               }else if("Sorcerer".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 tier1.get(i).listElement();
                 System.out.print("Element: ");
                 subskill= input.nextInt();
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc1());
                 boss.get(j).elementBoss(tier1.get(i).getName(),tier1.get(i).getMagic(),subskill,tier1.get(i).getSname1());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }else if(skill==2) {
                 tier1.get(i).heal();
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }else if("Trooper".equals(tier1.get(i).getName())) {
                if(skill==1) {
                 ctrb= 0;
                 ctrs= 0;
                 tier1.get(i).setMp(tier1.get(i).getMp()-tier1.get(i).getMpc1());
                 System.out.println(tier1.get(i).getName()+" use "+tier1.get(i).getSname1());
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt>=2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }else if(skill==2) {
                 boss.get(j).setHp(boss.get(j).getHp()-tier1.get(i).getMagic());
                 tier1.get(i).Drain(boss.get(j).getName());
                 if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                  tier1.get(i).setHp(tier1.get(i).getHpm());
                 }
                 if(ctrempt<2) {
                  System.out.println("Pre-emptive condition");
                  ctrempt++;
                 }else if(ctrempt<2) {
                 //boss action
                 if(eaction<=75) { //boss atk
                  tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                  if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                   tier1.get(i).setHp(tier1.get(i).getHpm());
                  }
                 }else if(eaction>75) { //boss skill
                  if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                   boss.get(j).bossSkill();
                  }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                   tier1.get(i).attackEnemy(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                   if(tier1.get(i).getHp()>tier1.get(i).getHpm()) {
                    tier1.get(i).setHp(tier1.get(i).getHpm());
                   }
                  }
                 }
                }
                }
               }
              }else System.out.println("MP tidak cukup!");
              turn++;
             }else if(action==3) { //defend
              System.out.println(tier1.get(i).getName()+" use defense!");
              //boss action
              if(ctrempt<2) {
               System.out.println("Pre-emptive condition");
              }else if(ctrempt>=2) {
              if(eaction<=75) { //boss atk
               if(ctrb<3) { //cek blind
                boss.get(j).setAcc(10);
                tier1.get(i).defense(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                ctrb++;
               }else if(ctrb>=3) {
                boss.get(j).setAcc(100);
                tier1.get(i).defense(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
               }
              }else if(eaction>75) { //boss skill
               if(boss.get(j).getMpc()<=boss.get(j).getMp()) { //boss mp msih ckup
                if(ctrs<3) {
                 tier1.get(i).defense(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
                 System.out.println(boss.get(j).getName()+" cant use skill!");
                 ctrs++;
                }else if(ctrs>=3) {
                 boss.get(j).bossSkill();
                }
               }else if(boss.get(j).getMpc()>boss.get(j).getMp()) { //boss mp tdk ckup
                tier1.get(i).defense(boss.get(j).getName(),boss.get(j).getAtk(),boss.get(j).getAcc(),acce);
               }
              }
             }
              turn++;
             }
             
             //bonus mp
             if(turn%3==0) {
              tier1.get(i).setMp(tier1.get(i).getMp()+10);
              System.out.println ("Mendapat MP bonus sebanyak 10!");
              if(tier1.get(i).getMp()>tier1.get(i).getMpm()) {
               tier1.get(i).setMp(tier1.get(i).getMpm());
              }
             }
             }while(tier1.get(i).getHp()>0 && boss.get(j).getHp()>0);
             if(boss.get(j).getHp()<=0) { //boss klh
              ctrpb= 0;
              ctrsent= 0;
              ctrb= 99;
              ctrs= 99;
              ctrempt= 99;
              turn= 0;
              System.out.println (boss.get(j).getName()+" was dropped out!");
              tier1.get(i).setExp(tier1.get(i).getExp()+boss.get(j).getExpdrop());
              if(tier1.get(i).getExp()>=tier1.get(i).getExpm()) {
               tier1.get(i).setLv(tier1.get(i).getLv()+1);
               tier1.get(i).setExp(0);
               tier1.get(i).setSp(tier1.get(i).getSp()+1);
               System.out.println (tier1.get(i).getName()+" level up!");
              }
              gold+= boss.get(j).getGolddrop();
              System.out.println ("Got "+boss.get(j).getExpdrop()+"exp.");
              System.out.println ("Got "+boss.get(j).getGolddrop()+"G");
              boss.remove(j);
             }else if(tier1.get(i).getHp()<=0) { //hero klh
              ctrpb= 0;
              ctrsent= 0;
              ctrb= 99;
              ctrs= 99;
              ctrempt= 99;
              turn= 0;
              System.out.println (tier1.get(i).getName()+" was dropped out!");
              ctrbuy-=1;
              tier1.remove(i);
             }
            }
           }
          }
          
          //healing point
          if(xhero==xhealing && yhero==yhealing) {
           System.out.println("-HEAL POINT-");
           tier1.get(chero).HealPoint();
          }
          }while(!tier1.isEmpty() && !boss.isEmpty());
          //win codition
          if(boss.isEmpty()) {
           System.out.println("You WIN!");
          }else if(tier1.isEmpty()) {
           System.out.println("You LOSE!");
          }
         }else System.out.println("Belum memiliki hero!");
        }else if(menu==2) {
         System.out.println("1. Warrior - 200");
         System.out.println("2. Mage - 350");
         System.out.println("3. Range - 180");
         System.out.print("Buy: ");
         buy= input.nextInt();
         if(buy==1) {
          if(gold>=200) {
           gold-=200;
           tier1.add(new tier1("Warrior"));
           ctrbuy++;
          }else System.out.println("Gold tidak cukup!");
         }else if(buy==2) {
          if(gold>=350) {
           gold-=350;
           tier1.add(new tier1("Mage"));
           ctrbuy++;
          }else System.out.println("Gold tidak cukup!");
         }else if(buy==3) {
          if(gold>=180) {
           gold-=180;
           tier1.add(new tier1("Range"));
           ctrbuy++;
          }else System.out.println("Gold tidak cukup!");
         }
        }else if(menu==3) {
         if(ctrbuy>0) {
          for(int i= 0;i<tier1.size();i++) {
           tier1.get(i).Stats(i);
          }
         }else System.out.println("Belum memiliki hero!");
        }
        }while(menu!=4);
        System.out.println("Thank You For Playing!");
    }
}
