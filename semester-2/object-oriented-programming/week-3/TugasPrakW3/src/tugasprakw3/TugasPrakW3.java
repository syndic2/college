package tugasprakw3;
import java.util.*;
public class TugasPrakW3 {
    static int ctrbuy= 0;
    public static void main(String[] args) {
        Scanner input= new Scanner (System.in);
        Scanner string= new Scanner (System.in);
        int chero= 0,turn= 0;
        int menu,job,gold= 800,action,sp,skill;
        int panjang= 33,lebar= 33;
        int xhero= 1,yhero= 1;
        int xhealing= 16,yhealing= 16;
        String[][] map= new String[panjang][lebar];
        ArrayList<hero> hero= new ArrayList<>();
        ArrayList<villain> monster1= new ArrayList<>();
        ArrayList<villain> monster2= new ArrayList<>();
        ArrayList<villain> monster3= new ArrayList<>();
        ArrayList<villain> monster4= new ArrayList<>();
        ArrayList<villain> monster5= new ArrayList<>();
        ArrayList<villain> monster6= new ArrayList<>();
        ArrayList<villain> monster7= new ArrayList<>();
        ArrayList<villain> monster8= new ArrayList<>();
        ArrayList<villain> monster9= new ArrayList<>();
        ArrayList<villain> boss= new ArrayList<>();
        String step= "";
        int typem,acch,dmgh,defh;
        int actionv,dmgv,accv;
        int ctrpb= 0,ctrb= 99,ctrs= 99;
        Random r= new Random();
        do{
        System.out.println ("Gold: "+gold+"G");
        System.out.println ("1. Start Playing");
        System.out.println ("2. Beli Hero ("+ctrbuy+"/12)");
        System.out.println ("3. Lihat Hero");
        System.out.println ("4. Exit");
        System.out.print ("Menu: ");
        menu= input.nextInt();    
        if(menu==1) {
         if(ctrbuy>0) {
          //monster
          for(int i= 0;i<5;i++) {
           typem= (int)(Math.random()*4); 
           monster1.add(new villain(typem));
           monster2.add(new villain(typem));
           monster3.add(new villain(typem));
           monster4.add(new villain(typem));
           monster5.add(new villain(typem));
           monster6.add(new villain(typem));
           monster7.add(new villain(typem));
           monster8.add(new villain(typem));
           monster9.add(new villain(typem));
          }
          //koordinat monster
          //map 1
          for(int i= 0;i<monster1.size();i++) {
           int x= r.nextInt(8)+2;
           int y= r.nextInt(8)+2;
           monster1.get(i).setXm1(x);
           monster1.get(i).setYm1(y);
          }
          //map 2
          for(int i= 0;i<monster2.size();i++) {
           int x= r.nextInt(8)+12;
           int y= r.nextInt(8)+2;
           monster2.get(i).setXm2(x);
           monster2.get(i).setYm2(y);
          }
          //map 3
          for(int i= 0;i<monster3.size();i++) {
           int x= r.nextInt(8)+23;
           int y= r.nextInt(8)+2;
           monster3.get(i).setXm3(x);
           monster3.get(i).setYm3(y);
          }
          //map 4
          for(int i= 0;i<monster4.size();i++) {
           int x= r.nextInt(8)+2; 
           int y= r.nextInt(7)+12;    
           monster4.get(i).setXm4(x);
           monster4.get(i).setYm4(y);
          }
          //map 5
          for(int i= 0;i<monster5.size();i++) {
           int x= r.nextInt(8)+12;
           int y= r.nextInt(7)+12; 
           monster5.get(i).setXm5(x);
           monster5.get(i).setYm5(y);
          }
          //map 6
          for(int i= 0;i<monster6.size();i++) {
           int x= r.nextInt(8)+23;
           int y= r.nextInt(7)+12; 
           monster6.get(i).setXm6(x);
           monster6.get(i).setYm6(y);
          }
          //map 7
          for(int i= 0;i<monster7.size();i++) {
           int x= r.nextInt(8)+2;
           int y= r.nextInt(9)+22;
           monster7.get(i).setXm7(x);
           monster7.get(i).setYm7(y);
          }
          //map 8
          for(int i= 0;i<monster8.size();i++) {
           int x= r.nextInt(8)+12;
           int y= r.nextInt(9)+22;
           monster8.get(i).setXm8(x);
           monster8.get(i).setYm8(y);
          }
          //map 9
          for(int i= 0;i<monster9.size();i++) {
           int x= r.nextInt(8)+23;
           int y= r.nextInt(9)+22; 
           monster9.get(i).setXm9(x);
           monster9.get(i).setYm9(y);           
          }
          //boss
          for(int i= 0;i<5;i++) {
           boss.add(new villain());
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
          //init map
          for(int i= 0;i<panjang;i++) {
           for(int j= 0;j<lebar;j++) {
            if(i==0 || i==panjang-1 || j==0 || j==lebar-1) map[i][j]= "#";
            else map[i][j]= " ";
           }
          }
          do{
          //pindah map
          map[yhealing][xhealing]= "H";
          map[yhero][xhero]= hero.get(chero).getIcon();
          for(int i= 0;i<boss.size();i++) {
           map[boss.get(i).getYb()][boss.get(i).getXb()]= boss.get(i).getIcon();
          }
          if((xhero>=0 && xhero<=10) && (yhero>=0 && yhero<=10)) {
           System.out.println ("Map 1");
           //rand mons2
           for(int i= 0;i<monster2.size();i++) {
            map[monster2.get(i).getYm2()][monster2.get(i).getXm2()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(8)+2;
            monster2.get(i).setXm2(x);
            monster2.get(i).setYm2(y);
           }
           //rand mons4
           for(int i= 0;i<monster4.size();i++) {
            map[monster4.get(i).getYm4()][monster4.get(i).getXm4()]= " ";
            int x= r.nextInt(8)+2; 
            int y= r.nextInt(7)+12;    
            monster4.get(i).setXm4(x);
            monster4.get(i).setYm4(y);
           }
           for(int i= 0;i<monster1.size();i++) {
            map[monster1.get(i).getYm1()][monster1.get(i).getXm1()]= monster1.get(i).getIcon();
           }
           for(int i= 0;i<=10;i++) {
            for(int j= 0;j<=10;j++) {
             System.out.print (map[i][j]);
            }
            System.out.println ();
           }
          }
          else if((xhero>10 && xhero<=21) && (yhero>=0 && yhero<=10)) {
           System.out.println ("Map 2");
           //rand mons1
           for(int i= 0;i<monster1.size();i++) {
            map[monster1.get(i).getYm1()][monster1.get(i).getXm1()]= " ";
            int x= r.nextInt(8)+2;
            int y= r.nextInt(8)+2;
            monster1.get(i).setXm1(x);
            monster1.get(i).setYm1(y);
           }
           //rand mons3
           for(int i= 0;i<monster3.size();i++) {
            map[monster3.get(i).getYm3()][monster3.get(i).getXm3()]= " ";
            int x= r.nextInt(8)+23;
            int y= r.nextInt(8)+2;
            monster3.get(i).setXm3(x);
            monster3.get(i).setYm3(y);
           }
           //rand mons5
           for(int i= 0;i<monster5.size();i++) {
            map[monster5.get(i).getYm5()][monster5.get(i).getXm5()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(7)+12; 
            monster5.get(i).setXm5(x);
            monster5.get(i).setYm5(y);
           }
           for(int i= 0;i<monster2.size();i++) {
            map[monster2.get(i).getYm2()][monster2.get(i).getXm2()]= monster2.get(i).getIcon();
           }
           for(int i= 0;i<=10;i++) {
            for(int j= 11;j<=21;j++) {
             System.out.print (map[i][j]);
            }  
            System.out.println ();
           }
          }
          else if((xhero>21 && xhero<lebar) && (yhero>=0 && yhero<=10)) {
           System.out.println ("Map 3");
           //rand mons2
           for(int i= 0;i<monster2.size();i++) {
            map[monster2.get(i).getYm2()][monster2.get(i).getXm2()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(8)+2;
            monster2.get(i).setXm2(x);
            monster2.get(i).setYm2(y);
           }
           //rand mons6
           for(int i= 0;i<monster6.size();i++) {
            map[monster6.get(i).getYm6()][monster6.get(i).getXm6()]= " ";
            int x= r.nextInt(8)+23;
            int y= r.nextInt(7)+12; 
            monster6.get(i).setXm6(x);
            monster6.get(i).setYm6(y);
           }
           for(int i= 0;i<monster3.size();i++) {
            map[monster3.get(i).getYm3()][monster3.get(i).getXm3()]= monster3.get(i).getIcon();
           }
           for(int i= 0;i<=10;i++) {
            for(int j= 22;j<lebar;j++) {
             System.out.print (map[i][j]);
            }
            System.out.println ();
           }
          }
          else if((xhero>=0 && xhero<=10) && (yhero>10 && yhero<=20)) {
           System.out.println ("Map 4");
           //rand mons1
           for(int i= 0;i<monster1.size();i++) {
            map[monster1.get(i).getYm1()][monster1.get(i).getXm1()]= " ";
            int x= r.nextInt(8)+2;
            int y= r.nextInt(8)+2;
            monster1.get(i).setXm1(x);
            monster1.get(i).setYm1(y);
           }
           //rand mons5
           for(int i= 0;i<monster5.size();i++) {
            map[monster5.get(i).getYm5()][monster5.get(i).getXm5()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(7)+12; 
            monster5.get(i).setXm5(x);
            monster5.get(i).setYm5(y);
           }
           //rand mons7
           for(int i= 0;i<monster7.size();i++) {
            map[monster7.get(i).getYm7()][monster7.get(i).getXm7()]= " ";
            int x= r.nextInt(8)+2;
            int y= r.nextInt(9)+22;
            monster7.get(i).setXm7(x);
            monster7.get(i).setYm7(y);
           }
           for(int i= 0;i<monster4.size();i++) {
            map[monster4.get(i).getYm4()][monster4.get(i).getXm4()]= monster4.get(i).getIcon();
           }
           for(int i=11;i<=20;i++) {
            for(int j= 0;j<=10;j++) {
             System.out.print (map[i][j]);
            }
            System.out.println ();
           }
          } 
          else if((xhero>10 && xhero<=21) && (yhero>10 && yhero<=20)) {
           System.out.println ("Map 5");
           //rand mons2
           for(int i= 0;i<monster2.size();i++) {
            map[monster2.get(i).getYm2()][monster2.get(i).getXm2()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(8)+2;
            monster2.get(i).setXm2(x);
            monster2.get(i).setYm2(y);
           }
           //rand mons4
           for(int i= 0;i<monster4.size();i++) {
            map[monster4.get(i).getYm4()][monster4.get(i).getXm4()]= " ";
            int x= r.nextInt(8)+2; 
            int y= r.nextInt(7)+12;    
            monster4.get(i).setXm4(x);
            monster4.get(i).setYm4(y);
           }
           //rand mon6
           for(int i= 0;i<monster6.size();i++) {
            map[monster6.get(i).getYm6()][monster6.get(i).getXm6()]= " ";
            int x= r.nextInt(8)+23;
            int y= r.nextInt(7)+12; 
            monster6.get(i).setXm6(x);
            monster6.get(i).setYm6(y);
           }
           //rand mons8
           for(int i= 0;i<monster8.size();i++) {
            map[monster8.get(i).getYm8()][monster8.get(i).getXm8()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(9)+22;
            monster8.get(i).setXm8(x);
            monster8.get(i).setYm8(y);
           }
           for(int i= 0;i<monster5.size();i++) {
            map[monster5.get(i).getYm5()][monster5.get(i).getXm5()]= monster5.get(i).getIcon();
           }
           for(int i= 11;i<=20;i++) {
            for(int j= 11;j<=21;j++) {
             System.out.print (map[i][j]);
            }
            System.out.println ();
           }
          }
          else if((xhero>21 && xhero<lebar) && (yhero>10 && yhero<=20)) {
           System.out.println ("Map 6");
           //rand mons3
           for(int i= 0;i<monster3.size();i++) {
            map[monster3.get(i).getYm3()][monster3.get(i).getXm3()]= " ";
            int x= r.nextInt(8)+23;
            int y= r.nextInt(8)+2;
            monster3.get(i).setXm3(x);
            monster3.get(i).setYm3(y);
           }
           //rand mons5 
           for(int i= 0;i<monster5.size();i++) {
            map[monster5.get(i).getYm5()][monster5.get(i).getXm5()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(7)+12; 
            monster5.get(i).setXm5(x);
            monster5.get(i).setYm5(y);
           }
           //rand mons9
           for(int i= 0;i<monster9.size();i++) {
            map[monster9.get(i).getYm9()][monster9.get(i).getXm9()]= " ";
            int x= r.nextInt(8)+23;
            int y= r.nextInt(9)+22; 
            monster9.get(i).setXm9(x);
            monster9.get(i).setYm9(y);           
           }
           for(int i= 0;i<monster6.size();i++) {
            map[monster6.get(i).getYm6()][monster6.get(i).getXm6()]= monster6.get(i).getIcon();
           }
           for(int i= 11;i<=20;i++) {
            for(int j= 22;j<lebar;j++) {
             System.out.print (map[i][j]);
            }
            System.out.println ();
           }
          }
          else if((xhero>=0 && xhero<=10) && (yhero>20 && yhero<panjang)) {
           System.out.println ("Map 7");
           //rand mons4
           for(int i= 0;i<monster4.size();i++) {
            map[monster4.get(i).getYm4()][monster4.get(i).getXm4()]= " ";
            int x= r.nextInt(8)+2; 
            int y= r.nextInt(7)+12;    
            monster4.get(i).setXm4(x);
            monster4.get(i).setYm4(y);
           }
           //rand mons8
           for(int i= 0;i<monster8.size();i++) {
            map[monster8.get(i).getYm8()][monster8.get(i).getXm8()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(9)+22;
            monster8.get(i).setXm8(x);
            monster8.get(i).setYm8(y);
           }
           for(int i= 0;i<monster7.size();i++) {
            map[monster7.get(i).getYm7()][monster7.get(i).getXm7()]= monster7.get(i).getIcon();
           }
           for(int i= 21;i<panjang;i++) {
            for(int j= 0;j<=10;j++) {
             System.out.print (map[i][j]);
            }
            System.out.println ();
           }
          }
          else if((xhero>10 && xhero<=21) && (yhero>20 && yhero<panjang)) {
           System.out.println ("Map 8");
           //rand mons5 
           for(int i= 0;i<monster5.size();i++) {
            map[monster5.get(i).getYm5()][monster5.get(i).getXm5()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(7)+12; 
            monster5.get(i).setXm5(x);
            monster5.get(i).setYm5(y);
           }
           //rand mons7
           for(int i= 0;i<monster7.size();i++) {
            map[monster7.get(i).getYm7()][monster7.get(i).getXm7()]= " ";
            int x= r.nextInt(8)+2;
            int y= r.nextInt(9)+22;
            monster7.get(i).setXm7(x);
            monster7.get(i).setYm7(y);
           }
           //rand mons9
           for(int i= 0;i<monster9.size();i++) {
            map[monster9.get(i).getYm9()][monster9.get(i).getXm9()]= " ";
            int x= r.nextInt(8)+23;
            int y= r.nextInt(9)+22; 
            monster9.get(i).setXm9(x);
            monster9.get(i).setYm9(y);           
           }
           for(int i= 0;i<monster8.size();i++) {
            map[monster8.get(i).getYm8()][monster8.get(i).getXm8()]= monster8.get(i).getIcon();
           }
           for(int i= 21;i<panjang;i++) {
            for(int j= 11;j<=21;j++) {
             System.out.print (map[i][j]);
            }
            System.out.println ();
           }
          }
          else if((xhero>21 && xhero<lebar) && (yhero>20 && yhero<panjang)) {
           System.out.println ("Map 9");
           //rand mon6
           for(int i= 0;i<monster6.size();i++) {
            map[monster6.get(i).getYm6()][monster6.get(i).getXm6()]= " ";
            int x= r.nextInt(8)+23;
            int y= r.nextInt(7)+12; 
            monster6.get(i).setXm6(x);
            monster6.get(i).setYm6(y);
           }
           //rand mons8
           for(int i= 0;i<monster8.size();i++) {
            map[monster8.get(i).getYm8()][monster8.get(i).getXm8()]= " ";
            int x= r.nextInt(8)+12;
            int y= r.nextInt(9)+22;
            monster8.get(i).setXm8(x);
            monster8.get(i).setYm8(y);
           }
           for(int i= 0;i<monster9.size();i++) {
            map[monster9.get(i).getYm9()][monster9.get(i).getXm9()]= monster9.get(i).getIcon();
           }
           for(int i= 21;i<panjang;i++) {
            for(int j= 22;j<lebar;j++) {
             System.out.print (map[i][j]);
            }
            System.out.println ();
           }
          }
          //move hero
          int ctrsearch= 0;
          System.out.print ("Move: ");
          step= string.nextLine();
          if("w".equals(step) && !"#".equals(map[yhero-1][xhero])) {
           map[yhero][xhero]= " ";
           yhero--;
          }
          else if("a".equals(step) && !"#".equals(map[yhero][xhero-1])) {
           map[yhero][xhero]= " ";
           xhero--;
          }
          else if("s".equals(step) && !"#".equals(map[yhero+1][xhero])) {
           map[yhero][xhero]= " ";
           yhero++;
          }
          else if("d".equals(step) && !"#".equals(map[yhero][xhero+1])) {
           map[yhero][xhero]= " ";
           xhero++;
          }
          else if("g".equals(step) || "G".equals(step)) {
           if("Warrior".equals(hero.get(chero).getHero())) {
            do{
            if("Warrior".equals(hero.get(chero).getHero())&&"Mage".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            }
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
            do{
            if("Warrior".equals(hero.get(chero).getHero())&&"Range".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            } 
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
            do{
            if("Warrior".equals(hero.get(chero).getHero())&&"Warrior".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            }
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
           }
           else if("Mage".equals(hero.get(chero).getHero())) {
            do{
            if("Mage".equals(hero.get(chero).getHero())&&"Range".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            }
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
            do{
            if("Mage".equals(hero.get(chero).getHero())&&"Warrior".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            } 
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
            do{
            if("Mage".equals(hero.get(chero).getHero())&&"Mage".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            }
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
           }
           else if("Range".equals(hero.get(chero).getHero())) {
            do{
            if("Range".equals(hero.get(chero).getHero())&&"Warrior".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            }
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
            do{
            if("Range".equals(hero.get(chero).getHero())&&"Mage".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            } 
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
            do{
            if("Mage".equals(hero.get(chero).getHero())&&"Range".equals(hero.get(ctrsearch).getHero())) {
             chero= ctrsearch;
             map[yhero][xhero]= hero.get(chero).getIcon();
            }
            ctrsearch++;
            }while(ctrsearch<hero.size());
            ctrsearch= 0;
           }
         }
         else if("m".equals(step) || "M".equals(step)) {
          System.out.println ("-Skill Point-");
          System.out.println ("Jumlah SP: "+hero.get(chero).getSP()+" SP");
          System.out.println ("1. +300 HP");
          System.out.println ("2. +20 MP");
          System.out.println ("3. +20 Attack");
          System.out.println ("4. +1 Armor");
          System.out.println ("5. +3% Evasion");
          System.out.println ("6. +2 Akurasi");
          System.out.print ("Pilih SP: ");
          sp= input.nextInt();
          if(hero.get(chero).getSP()>0) {
           hero.get(chero).SkillPoint(sp);
           hero.get(chero).setSP(hero.get(chero).getSP()-1);
          }
          else System.out.println ("SP tidak cukup!"); 
         }
          //vs monster 1
          for(int i= chero;i<hero.size();i++) {
           for(int j= 0;j<monster1.size();j++) {
            if(xhero==monster1.get(j).getXm1()&&yhero==monster1.get(j).getYm1()) {
             do{
             acch= (int)(Math.random()*100);
             actionv= (int)(Math.random()*100);
             accv= (int)(Math.random()*100);
             monster1.get(j).statsBattle();
             System.out.println ("===================");
             hero.get(i).statsBattle();
             System.out.print ("Action: ");
             action= input.nextInt();
             //action atk
             if(action==1) {
              if(acch<=hero.get(i).getAcc()) {
               monster1.get(j).attackHero(hero.get(i).getHero(),hero.get(i).getAtk());
               //mons atk
               if(actionv<=75) {
                //cek blind
                if(ctrb<3) {
                 //cek blind
                 if(accv<=10) {
                  hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                 }
                 else if(accv>10) {
                  System.out.println (monster1.get(j).getVillain()+" attack miss!");
                 }
                }
                else if(ctrb>=3) {
                 hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                }
               }
               //mons skill
               else if(actionv>75) {
                if(monster1.get(j).getMPc()<=monster1.get(j).getMP()) {
                 //cek silence
                 if(ctrs<3) {
                  hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  System.out.println (monster1.get(j).getVillain()+" cant use skill!");
                 }
                 else if(ctrs>=3) {
                  monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
                  hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
                  monster1.get(j).getSkilluse());
                 }
                }
                else if(monster1.get(j).getMPc()>monster1.get(j).getMP()) {
                 if(ctrb<3) {
                  //cek blind
                  if(accv<=10) {
                   hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  }
                  else if(accv>10) {
                   System.out.println (monster1.get(j).getVillain()+" attack miss!");
                  }
                 }
                 else if(ctrb>=3) {
                  hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                 }
                }
               }
              }
              else if(acch>hero.get(i).getAcc()) {
               System.out.println (hero.get(i).getHero()+" attack miss!");
               //monster atk
               if(actionv<=75) {
                //cek blind
                if(ctrb<3) {
                 if(accv<=10) {
                  hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                 }
                 else if(accv>10) {
                  System.out.println (monster1.get(j).getVillain()+" attack miss!");
                 }
                }
                else if(ctrb>=3) {
                 hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                }
               }
               //monster skill
               else if(actionv>75) {
                if(monster1.get(j).getMPc()<=monster1.get(j).getMP()) {
                 //cek silence
                 if(ctrs<3) {
                  hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  System.out.println (monster1.get(j).getVillain()+" cant use skill!");
                 }
                 else if(ctrs>=3) {
                  monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
                  hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
                  monster1.get(j).getSkilluse());
                 }
                }
                else if(monster1.get(j).getMPc()>monster1.get(j).getMP()) {
                 //cek blind
                 if(ctrb<3) {
                  if(accv<=10) {
                   hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  }
                  else if(accv>10) {
                   System.out.println (monster1.get(j).getVillain()+" attack miss!");
                  }
                 }
                 else if(ctrb>=3) {
                  hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                 }
                }
               }
              }
              ctrb++;
              ctrs++;
              turn++;
             }
             //action skill
             else if(action==2) {	  
              hero.get(i).Skill();
              System.out.print ("Skill: ");
              skill= input.nextInt();
              if(hero.get(i).getMPc()<=hero.get(i).getMP()) {
               hero.get(i).setMP(hero.get(i).getMP()-hero.get(i).getMPc());
               if("Warrior".equals(hero.get(i).getHero())) {
                //skill 1
                if(skill==1) {
                 if(ctrpb<1) {
                  monster1.get(j).skillWarrior1(hero.get(i).getHero(),hero.get(i).getSkill1(),
                  hero.get(i).getSkilluse1());
                  //monster atk
                  if(actionv<=75) {
                   //cek blind
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (monster1.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                  }
                  //monster skill
                  else if(actionv>75) {
                   if(monster1.get(j).getMPc()<=monster1.get(j).getMP()) {
                    //cek silence
                    if(ctrs<3) {
                     hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                     System.out.println (monster1.get(j).getVillain()+" cant use skill!");
                    }
                    else if(ctrs>=3) {
                     monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
		     hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
		     monster1.get(j).getSkilluse());
                    }
                   }
                   else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                    //cek blind
                    if(ctrb<3) {
                     if(accv<=10) {
                      hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                     }
                     else if(accv>10) {
                      System.out.println (monster1.get(j).getVillain()+" attack miss!");
                     }
                    }
                    else if(ctrb>=3) {
                     hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    }
                   }
                  }
                 }
                 else if(ctrpb>=1) {
                  System.out.println (hero.get(i).getSkill1()+" no effect!");
                 }
                 ctrpb++;
                }
                //skill 2
                else if(skill==2) {
                 monster1.get(j).skillWarrior2(hero.get(i).getHero(),hero.get(i).getSkill2(),
                 hero.get(i).getSkilluse2());
                 //monster atk
                 if(actionv<=75) {
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (monster1.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  }
                 }
                 //monster skill
                 else if(actionv>75) {
                  if(monster1.get(j).getMPc()<=monster1.get(j).getMP()) {
                   if(ctrs<3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    System.out.println (monster1.get(j).getVillain()+" cant use skill!"); 
                   }
                   else if(ctrs>=3) {
                    monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
		    hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
		    monster1.get(j).getSkilluse());
                   }
                  }
                  else if(monster1.get(j).getMPc()>monster1.get(j).getMP()) {
	          //cek blind
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (monster1.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                  }
                 }
                }
               }
               else if("Mage".equals(hero.get(i).getHero())) {
                //skill 1
                if(skill==1) {
                 monster1.get(j).skillMage1(hero.get(i).getHero(),hero.get(i).getSkill1(),
                 hero.get(i).getSkilluse1());
                 //monster atk
                 if(actionv<=75) {
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (monster1.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  }
                 }
                 //monster skill
                 else if(actionv>75) {
                  if(monster1.get(j).getMPc()<=monster1.get(j).getMP()) {
                   if(ctrs<3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    System.out.println (monster1.get(j).getVillain()+" cant use skill!");
                   }
                   else if(ctrs>=3) {
                    monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
		    hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
		    monster1.get(j).getSkilluse());
                   }
                  }
                  else if(monster1.get(j).getMPc()>monster1.get(j).getMP()) {
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (monster1.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                  }
                 }
                }
                //skill 2
                else if(skill==2) {
                 hero.get(i).mageSkill2();
                 //monster atk
                 if(actionv<=75) {
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (monster1.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  }
                 }
                 //boss skill
                 else if(actionv>75) {
                  if(monster1.get(j).getMPc()<=monster1.get(j).getMP()) {
                   if(ctrs<3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    System.out.println (boss.get(j).getVillain()+" cant use skill!");
                   }
                   else if(ctrs>=3) {
                    monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
		    hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
                    monster1.get(j).getSkilluse());
                   }
                  }
                  else if(monster1.get(j).getMPc()>monster1.get(j).getMP()) {
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (monster1.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                  }
                 }
                }
               }
               else if("Range".equals(hero.get(i).getHero())) {
                ctrb= 0;
                ctrs= 0;
                if(skill==1) {
                 hero.get(i).rangeSkill1();
                 //monster atk
                 if(actionv<=75) {
	         //cek blind
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (monster1.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  }
                 }
                 //monster skill
                 else if(actionv>75) {
                  if(monster1.get(j).getMPc()<=monster1.get(j).getMP()) {
	          //cek silence
                   if(ctrs<3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    System.out.println (monster1.get(j).getVillain()+" cant use skill!");
                   }
                    monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
		    hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
		    monster1.get(j).getSkilluse());
                   }
                  }
                  else if(monster1.get(j).getMPc()>monster1.get(j).getMP()) {
		   //cek blind
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (monster1.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),boss.get(j).getAtk());
                   }
                  }
                 }
                }
                else if(skill==2) {
                 hero.get(i).rangeSkill2();
                 //monster atk
                 if(actionv<=75) {
	         //cek blind 
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (monster1.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                  }
                 }
                 //monster skill
                 else if(actionv>75) {
                  if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
		  //cek silence 
                   if(ctrs<3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    System.out.println (monster1.get(j).getVillain()+" cant use skill!");
                   }
                   else if(ctrs>=3) {
                    monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
		    hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
		    monster1.get(j).getSkilluse());
                   }
                  }
                  else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
		   //cek blind 
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (monster1.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(monster1.get(j).getVillain(),monster1.get(j).getAtk());
                   }
                  }
                 }
                }
               }
               else if(hero.get(i).getMPc()>hero.get(i).getMP()) {
                System.out.println (hero.get(i).getHero()+ " MP tidak cukup!");
               }
               ctrb++;
               ctrs++;
               turn++;
             }
             //action def
             else if(action==3) {
              defh= monster1.get(j).getAtk()-(monster1.get(j).getAtk()*70/100);
              System.out.println (hero.get(i).getHero()+" use defense!");
              //monster atk
              if(actionv<=75) {
               //cek blind
               if(ctrb<3) {
                if(accv<=10) {
                 hero.get(i).defHero(monster1.get(j).getVillain(),defh);
                }
                else if(accv>10) {
                 System.out.println (monster1.get(j).getVillain()+" attack miss!");
                }
               }
               else if(ctrb>=3) {
                hero.get(i).defHero(monster1.get(j).getVillain(),defh);
               }
              }
              //monster skill
              else if(actionv>75) {
               if(monster1.get(j).getMPc()<=monster1.get(j).getMP()) {
	        //cek silence
                if(ctrs<3) {
                 hero.get(i).defHero(monster1.get(j).getVillain(),defh);
                 System.out.println (monster1.get(j).getVillain()+" cant use skill!");
                }
                else if(ctrs>=3) {
                 monster1.get(j).setMP(monster1.get(j).getMP()-monster1.get(j).getMPc());
                 hero.get(i).monsSkill(monster1.get(j).getVillain(),monster1.get(j).getSkill(),
                 monster1.get(j).getSkilluse());
                }
               }
               else if(monster1.get(j).getMPc()>monster1.get(j).getMP()) {
	        //cek blind 
                if(ctrb<3) {
                 if(accv<=10) {
                  hero.get(i).defHero(monster1.get(j).getVillain(),defh);
                 }
                 else if(accv>10) {
                  System.out.println (monster1.get(j).getVillain()+" attack miss!");
                 }
                }
                else if(ctrb>=3) {
                 hero.get(i).defHero(monster1.get(j).getVillain(),defh);
                }
               }
              }
              ctrb++;
              ctrs++;
              turn++;
             }
             //bonus mp
             if(turn%3==0) {
              hero.get(i).setMP(hero.get(i).getMP()+10);
              System.out.println ("Mendapat MP bonus sebanyak 10!");
              if(hero.get(i).getMP()>hero.get(i).getMPm()) {
               hero.get(i).setMP(hero.get(i).getMPm());
              }
             }
             }while(hero.get(i).getHP()>0&&monster1.get(j).getHP()>0);
             //mnnster klh
             if(monster1.get(j).getHP()<=0) {
              ctrpb= 0;
              ctrb= 99;
              ctrs= 99;
              turn= 0;
              System.out.println (monster1.get(j).getVillain()+" was dropped out!");
              hero.get(i).setEXP(hero.get(i).getEXP()+monster1.get(j).getEXPDrop());
              if(hero.get(i).getEXP()>=hero.get(i).getEXMPm()) {
               hero.get(i).setLv(hero.get(i).getLv()+1);
               hero.get(i).setEXP(0);
               hero.get(i).setSP(hero.get(i).getSP()+1);
               System.out.println (hero.get(i).getHero()+" level up!");
              }
              gold+=monster1.get(j).getGoldDrop();
              System.out.println ("Got "+monster1.get(j).getEXPDrop()+"exp.");
              System.out.println ("Got "+monster1.get(j).getGoldDrop()+"G");
              monster1.remove(j);
             }
             //hero klh
             else if(hero.get(i).getHP()<=0) {
              ctrpb= 0;
              ctrb= 99;
              ctrs= 99;
              turn= 0;
              System.out.println (hero.get(i).getHero()+" was dropped out!");
              ctrbuy-=1;
              hero.remove(i);
             }
            }
           }
          }
          //vs boss
          for(int i= chero;i<hero.size();i++) {
           for(int j= 0;j<boss.size();j++) {
            if(xhero==boss.get(j).getXb()&&yhero==boss.get(j).getYb()) {
             do{
             acch= (int)(Math.random()*100);
             actionv= (int)(Math.random()*100);
             accv= (int)(Math.random()*100);
             boss.get(j).statsBattle();
             System.out.println ("===================");
             hero.get(i).statsBattle();
             System.out.print ("Action: ");
             action= input.nextInt();
             //action atk
             if(action==1) {
              if(acch<=hero.get(i).getAcc()) {
               boss.get(j).attackHero(hero.get(i).getHero(),hero.get(i).getAtk());
               //boss atk
               if(actionv<=75) {
                //cek blind
                if(ctrb<3) {
                 if(accv<=10) {
                  hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                 }
                 else if(accv>10) {
                  System.out.println (boss.get(j).getVillain()+" attack miss!");
                 }
                }
                else if(ctrb>=3) {
                 hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                }
               }
               //boss skill
               else if(actionv>75) {
                if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                 //cek silence
                 if(ctrs<3) {
                  hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  System.out.println (boss.get(j).getVillain()+" cant use skill!");
                 }
                 else if(ctrs>=3) {
                  boss.get(j).bossSkill();
                 }
                }
                else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                 //cek blind
                 if(ctrb<3) {
                  if(accv<=10) {
                   hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  }
                  else if(accv>10) {
                   System.out.println (boss.get(j).getVillain()+" attack miss!");
                  }
                 }
                 else if(ctrb>=3) {
                  hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                 }
                }
               }
              }
              else if(acch>hero.get(i).getAcc()) {
               System.out.println (hero.get(i).getHero()+" attack miss!");
               //boss atk
               if(actionv<=75) {
                //cek blind 
                if(ctrb<3) {
                 if(accv<=10) {
                   hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  }
                  else if(accv>10) {
                   System.out.println (boss.get(j).getVillain()+" attack miss!");
                  }
                 }
                else if(ctrb>=3) {
                 hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                }
               }
               //boss skill
               else if(actionv>75) {
                if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                //cek silence
                 if(ctrs<3) {
                  hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  System.out.println (boss.get(j).getVillain()+" cant use skill!");
                 }
                 else if(ctrs>=3) {
                  boss.get(j).bossSkill();
                 }
                }
                else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                 //cek blind
                 if(ctrb<3) {
                  if(accv<=10) {
                   hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  }
                  else if(accv>10) {
                   System.out.println (boss.get(j).getVillain()+" attack miss!");
                  }
                 }
                 else if(ctrb>=3) {
                  hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                 }
                }
               }
              }
              ctrb++;
              ctrs++;
              turn++;
             }
             //action skill
             else if(action==2) {
              hero.get(i).Skill();
              System.out.print ("Skill: ");
              skill= input.nextInt();
              if(hero.get(i).getMPc()<=hero.get(i).getMP()) {
               hero.get(i).setMP(hero.get(i).getMP()-hero.get(i).getMPc());
               if("Warrior".equals(hero.get(i).getHero())) {
                //skill 1
                if(skill==1) {
                 if(ctrpb<1) {
                  boss.get(j).skillWarrior1(hero.get(i).getHero(),hero.get(i).getSkill1(),
                  hero.get(i).getSkilluse1());
                  //boss atk
                  if(actionv<=75) {
                   //cek blind
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (boss.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                  }
                  //boss skill
                  else if(actionv>75) {
                   if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                    //cek silence
                    if(ctrs<3) {
                     hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                     System.out.println (boss.get(j).getVillain()+" cant use skill!");
                    }
                    else if(ctrs>=3) {
                     boss.get(j).bossSkill();
                    }
                   }
                   else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                    //cek blind
                    if(ctrb<3) {
                     if(accv<=10) {
                      hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                     }
                     else if(accv>10) {
                      System.out.println (boss.get(j).getVillain()+" attack miss!");
                     }
                    }
                    else if(ctrb>=3) {
                     hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    }
                   }
                  }
                 }
                 else if(ctrpb>=1) {
                  System.out.println (hero.get(i).getSkill1()+" no effect!");
                 }
                 ctrpb++;
                }
                //skill 2
                else if(skill==2) {
                 boss.get(j).skillWarrior2(hero.get(i).getHero(),hero.get(i).getSkill2(),
                 hero.get(i).getSkilluse2());
                 //boss atk
                 if(actionv<=75) {
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (boss.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  }
                 }
                 //boss skill
                 else if(actionv>75) {
                  if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                   if(ctrs<3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    System.out.println (boss.get(j).getVillain()+" cant use skill!"); 
                   }
                   else if(ctrs>=3) {
                    boss.get(j).bossSkill();
                   }
                  }
                  else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (boss.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                  }
                 }
                }
               }
               else if("Mage".equals(hero.get(i).getHero())) {
                //skill 1
                if(skill==1) {
                 boss.get(j).skillMage1(hero.get(i).getHero(),hero.get(i).getSkill1(),
                 hero.get(i).getSkilluse1());
                 //boss atk
                 if(actionv<=75) {
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (boss.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  }
                 }
                 //boss skill
                 else if(actionv>75) {
                  if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                   if(ctrs<3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    System.out.println (boss.get(j).getVillain()+" cant use skill!");
                   }
                   else if(ctrs>=3) {
                    boss.get(j).bossSkill();
                   }
                  }
                  else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (boss.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                  }
                 }
                }
                //skill 2
                else if(skill==2) {
                 hero.get(i).mageSkill2();
                 //boss atk
                 if(actionv<=75) {
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (boss.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  }
                 }
                 //boss skill
                 else if(actionv>75) {
                  if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                   if(ctrs<3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    System.out.println (boss.get(j).getVillain()+" cant use skill!");
                   }
                   else if(ctrs>=3) {
                    boss.get(j).bossSkill();
                   }
                  }
                  else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (boss.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                  }
                 }
                }
               }
               else if("Range".equals(hero.get(i).getHero())) {
                ctrb= 0;
                ctrs= 0;
                if(skill==1) {
                 hero.get(i).rangeSkill1();
                 //boss atk
                 if(actionv<=75) {
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (boss.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  }
                 }
                 //boss skill
                 else if(actionv>75) {
                  if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                   if(ctrs<3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    System.out.println (boss.get(j).getVillain()+" cant use skill!");
                   }
                   else if(ctrs>=3) {
                    boss.get(j).bossSkill();
                   }
                  }
                  else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (boss.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                  }
                 }
                }
                else if(skill==2) {
                 hero.get(i).rangeSkill2();
                 //boss atk
                 if(actionv<=75) {
                  if(ctrb<3) {
                   if(accv<=10) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                   else if(accv>10) {
                    System.out.println (boss.get(j).getVillain()+" attack miss!");
                   }
                  }
                  else if(ctrb>=3) {
                   hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                  }
                 }
                 //boss skill
                 else if(actionv>75) {
                  if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                   if(ctrs<3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    System.out.println (boss.get(j).getVillain()+" cant use skill!");
                   }
                   else if(ctrs>=3) {
                    boss.get(j).bossSkill();
                   }
                  }
                  else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                   if(ctrb<3) {
                    if(accv<=10) {
                     hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                    }
                    else if(accv>10) {
                     System.out.println (boss.get(j).getVillain()+" attack miss!");
                    }
                   }
                   else if(ctrb>=3) {
                    hero.get(i).villainAttack(boss.get(j).getVillain(),boss.get(j).getAtk());
                   }
                  }
                 }
                }
               }
              }
              else if(hero.get(i).getMPc()>hero.get(i).getMP()) {
               System.out.println (hero.get(i).getHero()+ " MP tidak cukup!");
              }
              ctrb++;
              ctrs++;
              turn++;
             }
             //action def
             else if(action==3) {
              defh= boss.get(j).getAtk()-(boss.get(j).getAtk()*70/100);
              System.out.println (hero.get(i).getHero()+" use defense!");
              //boss atk
              if(actionv<=75) {
               if(ctrb<3) {
                if(accv<=10) {
                 hero.get(i).defHero(boss.get(j).getVillain(),defh);
                }
                else if(accv>10) {
                 System.out.println (boss.get(j).getVillain()+" attack miss!");
                }
               }
               else if(ctrb>=3) {
                hero.get(i).defHero(boss.get(j).getVillain(),defh);
               }
              }
              //boss skill
              else if(actionv>75) {
               if(boss.get(j).getMPc()<=boss.get(j).getMP()) {
                if(ctrs<3) {
                 hero.get(i).defHero(boss.get(j).getVillain(),defh);
                 System.out.println (boss.get(j).getVillain()+" cant use skill!");
                }
                else if(ctrs>=3) {
                 boss.get(j).bossSkill();
                }
               }
               else if(boss.get(j).getMPc()>boss.get(j).getMP()) {
                if(ctrb<3) {
                 if(accv<=10) {
                  hero.get(i).defHero(boss.get(j).getVillain(),defh);
                 }
                 else if(accv>10) {
                  System.out.println (boss.get(j).getVillain()+" attack miss!");
                 }
                }
                else if(ctrb>=3) {
                 hero.get(i).defHero(boss.get(j).getVillain(),defh);
                }
               }
              }
              ctrb++;
              ctrs++;
              turn++;
             }
             //bonus mp
             if(turn%3==0) {
              hero.get(i).setMP(hero.get(i).getMP()+10);
              System.out.println ("Mendapat MP bonus sebanyak 10!");
              if(hero.get(i).getMP()>hero.get(i).getMPm()) {
               hero.get(i).setMP(hero.get(i).getMPm());
              }
             }
             }while(hero.get(i).getHP()>0&&boss.get(j).getHP()>0);
             //boss klh
             if(boss.get(j).getHP()<=0) {
              ctrpb= 0;
              ctrb= 99;
              ctrs= 99;
              turn= 0;
              System.out.println (boss.get(j).getVillain()+" was dropped out!");
              hero.get(i).setEXP(hero.get(i).getEXP()+boss.get(j).getEXPDrop());
              if(hero.get(i).getEXP()>=hero.get(i).getEXMPm()) {
               hero.get(i).setLv(hero.get(i).getLv()+1);
               hero.get(i).setEXP(0);
               hero.get(i).setSP(hero.get(i).getSP()+1);
               System.out.println (hero.get(i).getHero()+" level up!");
              }
              gold+= boss.get(j).getGoldDrop();
              System.out.println ("Got "+boss.get(j).getEXPDrop()+"exp.");
              System.out.println ("Got "+boss.get(j).getGoldDrop()+"G");
              boss.remove(j);
             }
             //hero klh
             else if(hero.get(i).getHP()<=0) {
              ctrpb= 0;
              ctrb= 99;
              ctrs= 99;
              turn= 0;
              System.out.println (hero.get(i).getHero()+" was dropped out!");
              ctrbuy-=1;
              hero.remove(i);
             }
            }
           }
          }
          //healing point
          for(int i= chero;i<hero.size();i++) {
           if(xhero==xhealing && yhero==yhealing) {
            System.out.println ("-HEALING POINT-");
            hero.get(i).setHP(hero.get(i).getHPm());
            hero.get(i).setMP(hero.get(i).getMPm());
           }
          }
          }while(hero.size()!=0 && boss.size()!=0);
          if(boss.isEmpty()) {
           System.out.println ("You WIN!");
          }
          else if(hero.isEmpty()) {
           System.out.println ("You LOSE!");
          }
         }
         else System.out.println ("Belum memiliki hero!");
        }
        
        else if(menu==2) {
         System.out.println ("1. Warrior - 200");
         System.out.println ("2. Mage - 350");
         System.out.println ("3. Range - 180");
         System.out.print ("Choose your hero: ");
         job= input.nextInt();
         if(ctrbuy<12) {
          if(job==1) {
           if(gold>=200) {
            gold-=200;
            hero.add(new hero(job));
            ctrbuy++;
           }
           else System.out.println ("Gold tidak cukup!");
          }
          else if(job==2) {
           if(gold>=350) {
            gold-=350;
            hero.add(new hero(job));
            ctrbuy++;
           }
           else System.out.println ("Gold tidak cukup!"); 
          }
          else if(job==3) {
           if(gold>=180) {
            gold-=180;
            hero.add(new hero(job));
            ctrbuy++;
           }
           else System.out.println ("Gold tidak cukup!");
          }
         }
         else System.out.println ("Slot hero tidak cukup!");
        }
        
        else if(menu==3) {
         if(ctrbuy>0) {
          for(int i= 0;i<hero.size();i++) {
           hero.get(i).cetakStats(i);
          }
         }
         else System.out.println ("Belum memiliki hero!");
        }
        }while(menu!=4);
        System.out.println ("-THANK YOU FOR PLAYING-");
    }
}
