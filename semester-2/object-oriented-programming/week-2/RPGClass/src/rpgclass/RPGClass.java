package rpgclass;
import java.util.*;

public class RPGClass 
{

    public static void main(String[] args) 
    {
        Scanner input= new Scanner (System.in);
        Scanner string= new Scanner (System.in);
        
        int job;
        
        int panjang= 11;
        int lebar= 22;
        
        int xhealing= 1;
        int yhealing= 6;
        
        int xboss= 20;
        int yboss= 9;
        
        int xplayer= 1;
        int yplayer= 1;
        
        String step= "";
        int ctr_step= 0;
        int turn= 0;
        int ctr_wskill= 0;

         
        String[][] map= new String[panjang][lebar];
        
        System.out.println ("Pilih Hero: ");
        System.out.println ("1. Warrior");
        System.out.println ("2. Mage");
        System.out.println ("3. Range");
        System.out.print ("Input: ");
        job= input.nextInt();
        
        //hero
        unit warrior= new unit();
        warrior.setBasic(100);
        warrior.setMagic(20);
        warrior.setEvasion(0);
        warrior.setAcc(90);
        warrior.setHP(520);
        warrior.setMP(30);
        warrior.setHealHP(warrior.getHP());
        warrior.setHealMP(warrior.getMP());
        warrior.setMPUse(8);
        
        unit mage= new unit();
        mage.setBasic(30);
        mage.setMagic(200);
        mage.setEvasion(10);
        mage.setAcc(75);
        mage.setHP(360);
        mage.setMP(120);
        mage.setHealHP(mage.getHP());
        mage.setHealMP(mage.getMP());
        mage.setMPUse(4);
        
        unit range= new unit();
        range.setBasic(70);
        range.setMagic(100);
        range.setEvasion(5);
        range.setAcc(100);
        range.setHP(610);
        range.setMP(40);
        range.setHealHP(range.getHP());
        range.setHealMP(range.getMP());
        range.setMPUse(5);
        
        //musuh
        unit wilddog= new unit();
        wilddog.setBasic(32);
        wilddog.setMagic(10);
        wilddog.setHP(150);
        wilddog.setMP(50);
        wilddog.setHealHP(wilddog.getHP());
        wilddog.setHealMP(wilddog.getMP());
        wilddog.setSkill(wilddog.getMagic());
        wilddog.setMPUse(40);
        
        unit magicmonster= new unit();
        magicmonster.setBasic(7);
        magicmonster.setMagic(70);
        magicmonster.setHP(200);
        magicmonster.setMP(300);
        magicmonster.setHealHP(magicmonster.getHP());
        magicmonster.setHealMP(magicmonster.getMP());
        magicmonster.setSkill(magicmonster.getMagic());
        magicmonster.setMPUse(50);
        
        unit boss= new unit();
        boss.setBasic(50);
        boss.setMagic(20);
        boss.setHP(300);
        boss.setMP(200);
        boss.setMPUse(10);
        
        do{
        int chancemusuh= (int)(Math.random()*10);
        int randmusuh= (int)(Math.random()*2);
        for(int i= 0;i<panjang;i++) 
        {
         for(int j= 0;j<lebar;j++) 
         {
          if(i==0 || i==panjang-1 || j==0 || j==lebar-1)
          {
           map[i][j]= "#";
          }
          else
          {
           map[i][j]= " ";
          }
         }
        }
        
        map[yplayer][xplayer]= "P";
        map[yhealing][xhealing]= "H";
        map[yboss][xboss]= "B";
        
        if(xplayer>=0 && xplayer<=11) 
        {
         System.out.println ("Map 1");
         for(int i= 0;i<panjang;i++) 
         {
          for(int j= 0;j<12;j++) 
           {
            System.out.print (map[i][j]);
           }
           System.out.println ();
         }
        }
        else if(xplayer>11) 
        {
         System.out.println ("Map 2");
         for(int i= 0;i<panjang;i++) 
         {
          for(int j= 12;j<lebar;j++) 
          {
           System.out.print (map[i][j]);
          }
          System.out.println ();
         }
        }
        System.out.print ("Move: ");
        step= string.nextLine();
        
        //move player
        if("w".equals(step) && " ".equals(map[yplayer-1][xplayer])) 
        {
         yplayer--;
         ctr_step++;
        }
        else if("a".equals(step) && " ".equals(map[yplayer][xplayer-1])) 
        {
         xplayer--;
         ctr_step++;
        }
        else if("s".equals(step) && " ".equals(map[yplayer+1][xplayer])) 
        {
         yplayer++;
         ctr_step++;
        }
        else if("d".equals(step) && " ".equals(map[yplayer][xplayer+1])) 
        {
         xplayer++;
         ctr_step++;
        }
        
        //cek healing point
        if(map[yplayer+1][xplayer].equals(map[yhealing][xhealing])) 
        {   
         if(job==1) 
         {
          warrior.setHP(warrior.getHealHP());
          warrior.setMP(warrior.getHealMP());
         }
         else if(job==2) 
         {
          mage.setHP(mage.getHealHP());
          mage.setMP(mage.getHealMP());
         }
         else if(job==3) 
         {
          range.setHP(range.getHealHP());
          range.setMP(range.getMP());
         }
         System.out.println ("HEALING POINT");
        }
        
        //battle boss
        else if(map[yplayer+1][xplayer].equals(map[yboss][xboss])) 
        {
         int chancemusuhatk;
         int play;
         
         //warrior
         if(job==1) 
         {
          do{
          chancemusuhatk= (int)(Math.random()*100);
          int warracc= (int)(Math.random()*100);
          System.out.println ("BOSS");
          System.out.println ("HP: "+boss.getHP()+"/"+"300");
          System.out.println ("MP: "+boss.getMP()+"/"+"200");
          System.out.println ();
          System.out.println ("WARRIOR");
          System.out.println ("HP: "+warrior.getHP()+"/"+"520");
          System.out.println ("MP: "+warrior.getMP()+"/"+"30");
          System.out.println ("1. Attack");
          System.out.println ("2. Skill");
          System.out.println ("3. Defend");
          System.out.print (">>> ");
          play= input.nextInt();
          System.out.println ();
          
          //attack
          if(play==1) 
          {
           if(warracc<=90) 
           {
            boss.setHP(boss.getHP()-warrior.getBasic());
            if(chancemusuhatk<=75) 
            {
             warrior.setHP(warrior.getHP()-boss.getBasic());
            }
            
            else if(chancemusuhatk>75) 
            {
             if(boss.getMP()>=boss.getMPUse()) 
             {
              System.out.println ("Boss use Inreace Attack!");
              boss.setMP(boss.getMP()-boss.getMPUse());
              boss.setBasic(boss.getBasic()+5);
             }
             else if(boss.getMP()<=0) 
             {
              warrior.setHP(warrior.getHP()-boss.getBasic());
             }
            }
           }
           
           else if(warracc>90) 
           {
            System.out.println ("ATTACK MISS!");
            if(chancemusuhatk<=75) 
            {
             warrior.setHP(warrior.getHP()-boss.getBasic());
            }
            
            else if(chancemusuhatk>75) 
            {
             if(boss.getMP()>=boss.getMPUse()) 
             {
              System.out.println ("Boss use Inreace Attack!");
              boss.setMP(boss.getMP()-boss.getMPUse());
              boss.setBasic(boss.getBasic()+5);
             }
             else if(boss.getMP()<=boss.getMPUse()) 
             {
              warrior.setHP(warrior.getHP()-boss.getBasic());
             }
            }
           }
           turn++;
          }
          
          //skill
          else if(play==2) 
          {
           if(warrior.getMP()>warrior.getMPUse()) 
           {
            if(ctr_wskill<1) 
            {
             System.out.println ("Warrior use Power Break!");
             warrior.setMP(warrior.getMP()-warrior.getMPUse());
             boss.setHP(boss.getHP()-warrior.getBasic());
             boss.setBasic(boss.getBasic()-(boss.getBasic()*10/100));
            }
            else if(ctr_wskill>=1) 
            {
             System.out.println ("NO EFFECT!");
            }
            
            if(chancemusuhatk<=75) 
            {
             warrior.setHP(warrior.getHP()-boss.getBasic());
            }
            
            else if(chancemusuhatk>75) 
            {
             if(boss.getMP()>=boss.getMPUse()) 
             {
              System.out.println ("Boss use Increase Attack!");
              boss.setMP(boss.getMP()-boss.getMPUse());
              boss.setBasic(boss.getBasic()+5);
             }
             else if(boss.getMP()<=boss.getMPUse()) 
             {
              warrior.setHP(warrior.getHP()-boss.getBasic());
             }
            }
           }
           
           else if(warrior.getMP()<=warrior.getMPUse()) 
           {
            System.out.println ("MP TIDAK CUKUP");
           }
           ctr_wskill++;
           turn++;
          }
          
          //defend
          else if(play==3) 
          {
           int warrdefend= boss.getBasic()*70/100;
           if(chancemusuhatk<=75) 
           {
            warrior.setHP(warrior.getHP()-(boss.getBasic()-warrdefend));
           }
           
           else if(chancemusuhatk>75) 
           {
            if(boss.getMP()>=boss.getMPUse()) 
            {
             System.out.println ("Boss use Increase Attack!");
             boss.setMP(boss.getMP()-boss.getMPUse());
             boss.setBasic(boss.getBasic()+5);
            }
            else if(boss.getMP()<=boss.getMPUse()) 
            {
             warrior.setHP(warrior.getHP()-(boss.getBasic()-warrdefend));
            }
           }
           turn++;
          }
          
          //bonus mp
          if(turn%3==0) 
          {
           if(warrior.getMP()<30) 
           {
            System.out.println ("Mendapat BONUS MP!");
            warrior.setMP(warrior.getMP()+10);
            if(warrior.getMP()>30) 
            {
             warrior.setMP(30);
            }
           }
          }
          }while(warrior.getHP()>0 && boss.getHP()>0);
          
          if(boss.getHP()<=0) 
          {
           System.out.println ("YOU WIN!");
          }
          
          else if(warrior.getHP()<=0) 
          {
           boss.setHP(0);
           System.out.println ("GAME OVER!");
          }
         }
         
         //mage
         else if(job==2) 
         {
          do{
          chancemusuhatk= (int)(Math.random()*100);
          int mageacc= (int)(Math.random()*100);
          int mageeva= (int)(Math.random()*100);
          System.out.println ("BOSS");
          System.out.println ("HP: "+boss.getHP()+"/"+"300");
          System.out.println ("MP: "+boss.getMP()+"/"+"200");
          System.out.println ();
          System.out.println ("MAGE");
          System.out.println ("HP: "+mage.getHP()+"/"+"360");
          System.out.println ("MP: "+mage.getMP()+"/"+"120");
          System.out.println ("1. Attack");
          System.out.println ("2. Skill");
          System.out.println ("3. Defend");
          System.out.print (">>> ");
          play= input.nextInt();
          System.out.println ();
          
          //attack
          if(play==1) 
          {
           if(mageacc<=75) 
           {
            boss.setHP(boss.getHP()-mage.getBasic());
            if(chancemusuhatk<=75) 
            {
             if(mageeva>10) 
             {
              mage.setHP(mage.getHP()-boss.getBasic());
             }
             else if(mageeva<=10) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
            
            else if(chancemusuhatk>75) 
            {
             if(boss.getMP()>=boss.getMPUse()) 
             {
              System.out.println ("Boss use Increase Attack!");
              boss.setMP(boss.getMP()-boss.getMPUse());
              boss.setBasic(boss.getBasic()+5);
             }
             
             else if(boss.getMP()<=boss.getMPUse()) 
             {
              if(mageeva>10) 
              {
               mage.setHP(mage.getHP()-boss.getBasic());
              }
              else if(mageeva<=10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
            }
           }
           
           else if(mageacc>75) 
           {
            System.out.println ("ATTACK MISS!");
            if(chancemusuhatk<=75) 
            {
             if(mageeva>10) 
             {
              mage.setHP(mage.getHP()-boss.getBasic());
             }
             else if(mageeva<=10) 
             {
              System.out.println ("ENEMY ATTACK MISS");
             }
            }
            
            else if(chancemusuhatk>75) 
            {
             if(boss.getMP()>=boss.getMPUse()) 
             {
              System.out.println ("Boss use Incrase Attack!");
              boss.setMP(boss.getMP()-boss.getMPUse());
              boss.setBasic(boss.getBasic()+5);
             }
             else if(boss.getMP()<=boss.getMPUse()) 
             {
              if(mageeva>10) 
              {
               mage.setHP(mage.getHP()-boss.getBasic());
              }
              else if(mageeva<=10) 
              {
               System.out.println ("ENEMY ATTACK MISS");
              }
             }
            }
           }   
           turn++;
          }
          
          //skill
          else if(play==2) 
          {
           if(mage.getMP()>=mage.getMPUse()) 
           {
            System.out.println ("Mage use Thunder!");
            mage.setMP(mage.getMP()-mage.getMPUse());
            boss.setHP(boss.getHP()-mage.getMagic());
            if(chancemusuhatk<=75) 
            {
             if(mageeva>10)
             {
              mage.setHP(mage.getHP()-boss.getBasic());
             }
             else if(mageeva<=10) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
            
            else if(chancemusuhatk>75) 
            {
             if(boss.getMP()>=boss.getMPUse()) 
             {
              System.out.println ("Boss use Increas Attack!");
              boss.setMP(boss.getMP()-boss.getMPUse());
              boss.setBasic(boss.getBasic()+5);
             } 
             else if(boss.getMP()<=boss.getMPUse()) 
             {
              if(mageeva>10)
              {
               mage.setHP(mage.getHP()-boss.getBasic());
              }
              else if(mageeva<=10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              } 
             }
            }
           }
           else if(mage.getMP()<=mage.getMPUse()) 
           {
            System.out.println ("MP TIDAK CUKUP!");
           }
           turn++;
          }
          
          //defend
          else if(play==3) 
          {
           int magedefend= boss.getBasic()*70/100;
           mage.setHP(mage.getHP()-(boss.getBasic()-magedefend));
           if(chancemusuhatk<=75) 
           {
            if(mageeva>10) 
            {
             mage.setHP(mage.getHP()-(boss.getBasic()-magedefend));
            }
            else if(mageeva<=10) 
            {
             System.out.println ("ENEMY ATTACK MISS!");
            }
           }
           
           else if(chancemusuhatk>75) 
           {
            if(boss.getMP()>=boss.getMPUse()) 
            {
             System.out.println ("Boss use Incrase Attack!");
             boss.setMP(boss.getMP()-boss.getMPUse());
             boss.setBasic(boss.getBasic()+5);
            }
            else if(boss.getMP()<=boss.getMPUse()) 
            {
             if(mageeva>10) 
             {
              mage.setHP(mage.getHP()-(boss.getBasic()-magedefend));
             }
             else if(mageeva<=10) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
           }
           turn++;
          }
          
          //bonus mp
          if(turn%3==0) 
          {
           if(mage.getMP()<120) 
           {
            System.out.println ("Mendapat BONUS MP!");
            mage.setMP(mage.getMP()+10);
            if(mage.getMP()>120) 
            {
             mage.setMP(120);
            }
           }
          }
          }while(mage.getHP()>0 && boss.getHP()>0);
          
          if(boss.getHP()<=0) 
          {
           System.out.println ("YOU WIN!");
          }
          
          else if(mage.getHP()<=0) 
          {
           boss.setHP(0);
           System.out.println ("GAME OVER!");
          }
         }
         
         //range
         else if(job==3) 
         {
          do{
          chancemusuhatk= (int)(Math.random()*100);
          int rangeeva= (int)(Math.random()*100);
          int musuhacc= (int)(Math.random()*100);
          System.out.println ("BOSS");
          System.out.println ("HP: "+boss.getHP()+"/"+"300");
          System.out.println ("MP: "+boss.getMP()+"/"+"200");
          System.out.println ();
          System.out.println ("RANGE");
          System.out.println ("HP: "+range.getHP()+"/"+"610");
          System.out.println ("MP: "+range.getMP()+"/"+"40");
          System.out.println ("1. Attack");
          System.out.println ("2. Skill");
          System.out.println ("3. Defend");
          System.out.print (">>> ");
          play= input.nextInt();
          System.out.println ();
          
          //attack
          if(play==1) 
          {
           boss.setHP(boss.getHP()-range.getBasic());
           if(chancemusuhatk<=75) 
           {
            if(turn<3) 
            {
             if(musuhacc<=10) 
             {
              if(rangeeva>5) 
              {
               range.setHP(range.getHP()-boss.getBasic());
              }
              else if(rangeeva<=5) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             else if(musuhacc>10) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
            
            else if(turn>=3) 
            {
             if(rangeeva>5) 
             {
              range.setHP(range.getHP()-boss.getBasic());
             }
             else if(rangeeva<=5) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
           }
           
           else if(chancemusuhatk>75) 
           {
            if(boss.getMP()>=boss.getMPUse()) 
            {
             System.out.println ("Boss use Incrase Attack!");
             boss.setMP(boss.getMP()-boss.getMPUse());
             boss.setBasic(boss.getBasic()+5);
            }
            else if(boss.getMP()<=boss.getMPUse()) 
            {
             if(turn<3) 
             {
              if(musuhacc<=10) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-boss.getBasic());
               }
               else if(rangeeva<=5) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              else if(musuhacc>10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
            
             else if(turn>=3) 
             {
              if(rangeeva>5) 
              {
               range.setHP(range.getHP()-boss.getBasic());
              }
              else if(rangeeva<=5) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
            }
           }
          }
          
          //skill
          else if(play==2) 
          {
           turn= 0;
           if(range.getMP()>=range.getMPUse()) 
           {
            System.out.println ("Range use Blind Attack!");
            range.setMP(range.getMP()-range.getMPUse());
            if(chancemusuhatk<=75) 
            {
             if(turn<3) 
             {
              if(musuhacc<=10) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-boss.getHP());
               }
               else if(rangeeva<=5) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              else if(musuhacc>10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             
             else if(turn>=3) 
             {
              if(rangeeva>5) 
              {
               range.setHP(range.getHP()-boss.getBasic());
              }
              else if(rangeeva<=5) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
            }
           }
           
           else if(range.getMP()<=range.getMPUse()) 
           {
            System.out.println ("MP TIDAK CUKUP!");
           }
           turn++;
          }
          
          //defend
          else if(play==3) 
          {
           int rangedefend= boss.getBasic()*70/100;
           range.setHP(range.getHP()-(boss.getBasic()-rangedefend));
           if(chancemusuhatk<=75) 
           {
            if(turn<3) 
            {
             if(musuhacc<=10) 
             {
              if(rangeeva>10) 
              {
               range.setHP(range.getHP()-(boss.getBasic()-rangedefend));
              }
              else if(rangeeva<=10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             else if(musuhacc>10) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
            
            else if(turn>=3) 
            {
             if(rangeeva>10) 
             {
              range.setHP(range.getHP()-(boss.getBasic()-rangedefend));
             }
             else if(rangeeva<=10) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
           }
           
           else if(chancemusuhatk>75) 
           {
            if(boss.getMP()>=boss.getMPUse()) 
            {
             System.out.println ("Boss use Increase Attack!");
             boss.setMP(boss.getMP()-boss.getMPUse());
             boss.setBasic(boss.getBasic()+5);
            }
            else if(boss.getMP()<=boss.getMPUse()) 
            {
             if(turn<3) 
             {
              if(musuhacc<=10) 
              {
               if(rangeeva>10) 
               {
                range.setHP(range.getHP()-(boss.getBasic()-rangedefend));
               }
               else if(rangeeva<=10) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              else if(musuhacc>10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             
             else if(turn>=3) 
             {
              if(rangeeva>10) 
              {
               range.setHP(range.getHP()-(boss.getBasic()-rangedefend));
              }
              else if(rangeeva<=10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
            }
           }
           turn++;
          }
         
          //bonus mp
          if(turn%3==0) 
          {
           if(range.getMP()<40) 
           {
            System.out.println ("Mendapatkan BONUS MP!");
            range.setMP(range.getMP()+10);
            if(range.getMP()>40) 
            {
             range.setMP(40);
            }
           }
          }
          
          }while(range.getHP()>0 && boss.getHP()>0);

          if(boss.getHP()<=0) 
          {
           System.out.println ("YOU WIN!");
          }
          
          else if(range.getHP()<=0) 
          {
           boss.setHP(0);
           System.out.println ("GAME OVER!");
          }
         }
        }
        
        //spawn musuh 1 dan 2
        if(ctr_step>5) 
        {
         if(chancemusuh<=5) 
         {
          int play;
          int chancemusuhatk;
          
          //wild dog
          if(randmusuh==0) 
          {
           //warrior
           if(job==1) 
           {
            do{
            chancemusuhatk= (int)(Math.random()*100);
            int warracc= (int)(Math.random()*100);
            System.out.println ("WILD DOG");
            System.out.println ("HP: "+wilddog.getHP()+"/"+"150");
            System.out.println ("MP: "+wilddog.getMP()+"/"+"50");
            System.out.println ();
            System.out.println ("WARRIOR");
            System.out.println ("HP: "+warrior.getHP()+"/"+"520");
            System.out.println ("MP: "+warrior.getMP()+"/"+"30");
            System.out.println ("1. Attack");
            System.out.println ("2. Skill");
            System.out.println ("3. Defend");
            System.out.print (">>> ");
            play= input.nextInt();
            System.out.println ();
            
            //attack
            if(play==1) 
            {
             if(warracc<=90) 
             {
              wilddog.setHP(wilddog.getHP()-warrior.getBasic());
              if(chancemusuhatk<=75) 
              {
               warrior.setHP(warrior.getHP()-wilddog.getBasic());
              }
              
              else if(chancemusuhatk>75)
              {
               if(wilddog.getMP()>=wilddog.getMPUse()) 
               {
                System.out.println ("Wild Dog use Fire Torch!");
                wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
                warrior.setHP(warrior.getHP()-wilddog.getSkill());
               }
               else if(wilddog.getMP()<=wilddog.getMPUse()) 
               {
                warrior.setHP(warrior.getHP()-wilddog.getBasic());
               }
              }
             }
             
             else if(warracc>90) 
             {
              System.out.println ("ATTACK MISS!");
              if(chancemusuhatk<=75) 
              {
               warrior.setHP(warrior.getHP()-wilddog.getBasic());
              }
              
              else if(chancemusuhatk>75)
              {
               if(wilddog.getMP()>=wilddog.getMPUse()) 
               {
                System.out.println ("Wild Dog use Fire Torch!");
                wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
                warrior.setHP(warrior.getHP()-wilddog.getSkill());
               }
               else if(wilddog.getMP()<=wilddog.getMPUse()) 
               {
                warrior.setHP(warrior.getHP()-wilddog.getBasic());
               }
              }
             }
             turn++;
            }
            
            //skill
            else if(play==2) 
            {
             if(warrior.getMP()>=warrior.getMPUse()) 
             {
              if(ctr_wskill<1) 
              {
               System.out.println ("Warrior use Power Break!");
               warrior.setMP(warrior.getMP()-warrior.getMPUse());
               wilddog.setHP(wilddog.getHP()-warrior.getBasic());
               wilddog.setBasic(wilddog.getBasic()-(wilddog.getBasic()*10/100));
              }
              else if(ctr_wskill>=1) 
              {
               System.out.println ("NO EFFECT!");
              }
              
              if(chancemusuhatk<=75) 
              {
               warrior.setHP(warrior.getHP()-wilddog.getBasic());
              }
              
              else if(chancemusuhatk>75)
              {
               if(wilddog.getMP()>=wilddog.getMPUse()) 
               {
                System.out.println ("Wild Dog use Fire Torch!");
                wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
                warrior.setHP(warrior.getHP()-wilddog.getSkill());
               }
               else if(wilddog.getMP()<=wilddog.getMPUse()) 
               {
                warrior.setHP(warrior.getHP()-wilddog.getBasic());
               }
              }
             }
             
             else if(warrior.getMP()<=warrior.getMPUse())
             {
              System.out.println ("MP TIDAK CUKUP!");
             }
             ctr_wskill++;
             turn++;
            }
            
            //defend
            else if(play==3) 
            {
             int warrdefend= wilddog.getBasic()*70/100;
             if(chancemusuhatk<=75) 
             {
              warrior.setHP(warrior.getHP()-(wilddog.getBasic()-warrdefend));
             }
             
             else if(chancemusuhatk>75)
             {
              if(wilddog.getMP()>=wilddog.getMPUse()) 
              {
               System.out.println ("Wild Dog use Fire Torch!");
               wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
               warrior.setHP(warrior.getHP()-wilddog.getSkill());
              }
              else if(wilddog.getMP()<=wilddog.getMPUse()) 
              {
               warrior.setHP(warrior.getHP()-(wilddog.getBasic()-warrdefend));
              }
             }
             turn++;
            }
            
            //bonus mp
            if(turn%3==0) 
            {
             if(warrior.getMP()<30) 
             {
              System.out.println ("Mendapat BONUS MP!");
              warrior.setMP(warrior.getMP()+10);
              if(warrior.getMP()>30) 
              {
               warrior.setMP(30);
              }
             }
            }
            }while(warrior.getHP()>0 && wilddog.getHP()>0);
            if(wilddog.getHP()<=0)
            {
             ctr_wskill= 0;
             ctr_step= 0;
             turn= 0;
             wilddog.setHP(wilddog.getHealHP());
             wilddog.setMP(wilddog.getHealMP());
            }
            else if(warrior.getHP()<=0) 
            {
             boss.setHP(0);
             System.out.println ("GAME OVER!");
            }
           }
           
           //mage
           else if(job==2) 
           {
            do{
            chancemusuhatk= (int)(Math.random()*100);
            int mageacc= (int)(Math.random()*100);
            int mageeva= (int)(Math.random()*100);
            System.out.println ("WILD DOG");
            System.out.println ("HP: "+wilddog.getHP()+"/"+"150");
            System.out.println ("MP: "+wilddog.getMP()+"/"+"50");
            System.out.println ();
            System.out.println ("MAGE");
            System.out.println ("HP: "+mage.getHP()+"/"+"360");
            System.out.println ("MP: "+mage.getMP()+"/"+"120");
            System.out.println ("1. Attack");
            System.out.println ("2. Skill");
            System.out.println ("3. Defend");
            System.out.print (">>> ");
            play= input.nextInt();
            System.out.println ();
            
            //attack
            if(play==1) 
            {
             if(mageacc<=75) 
             {
              wilddog.setHP(wilddog.getHP()-mage.getBasic());
              if(chancemusuhatk<=75) 
              {
               if(mageeva>10) 
               {
                mage.setHP(mage.getHP()-wilddog.getBasic());
               }
               else if(mageeva<=10) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              
              else if(chancemusuhatk>75)
              {
               if(wilddog.getMP()>=wilddog.getMPUse()) 
               {
                System.out.println ("Wild Dog use Fire Torch!");
                wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
                mage.setHP(mage.getHP()-wilddog.getSkill());
               }
               else if(wilddog.getMP()<=wilddog.getMPUse()) 
               {
                if(mageeva>10) 
                {
                 mage.setHP(mage.getHP()-wilddog.getBasic());
                }
                else if(mageeva<=10) 
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
              }
             }
             
             else if(mageacc>75)
             {
              System.out.println ("ATTACK MISS!");
              if(chancemusuhatk<=75) 
              {
               if(mageeva>10) 
               {
                mage.setHP(mage.getHP()-wilddog.getBasic()); 
               }
               else if(mageeva<=10)
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              
              else if(chancemusuhatk>75) 
              {
               if(wilddog.getMP()>=wilddog.getMPUse()) 
               {
                System.out.println ("Wild Dog use Fire Torch!");
                wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
                mage.setHP(mage.getHP()-wilddog.getSkill());
               }
               else if(wilddog.getMP()<=wilddog.getMPUse()) 
               {
                if(mageeva>10) 
                {
                 mage.setHP(mage.getHP()-wilddog.getBasic()); 
                }
                else if(mageeva<=10)
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
              }
             }
             turn++;
            }
            
            //skill
            else if(play==2) 
            {
             if(mage.getMP()>mage.getMPUse()) 
             {
              System.out.println ("Mage use Magic Ball!");
              mage.setMP(mage.getMP()-mage.getMPUse());
              wilddog.setHP(wilddog.getHP()-mage.getMagic());
              
              if(chancemusuhatk<=75) 
              {
               if(mageeva>10) 
               {
                mage.setHP(mage.getHP()-wilddog.getBasic());
               }
               else if(mageeva<=10)
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              
              else if(chancemusuhatk>75)
              {
               if(wilddog.getMP()>=wilddog.getMPUse()) 
               {
                System.out.println ("Wild Dog use fire Torch!");
                wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
                mage.setHP(mage.getHP()-wilddog.getSkill());
               }
               else if(wilddog.getMP()<=wilddog.getMPUse()) 
               {
                if(mageeva>10) 
                {
                 mage.setHP(mage.getHP()-wilddog.getBasic());
                }
                else if(mageeva<=10)
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }  
               }
              }
             }
             
             else if(mage.getMP()<=mage.getMPUse())
             {
              System.out.println ("MP TIDAK CUKUP!");
             }
             turn++;
            }
            
            //defend
            else if(play==3) 
            {
             int magedefend= wilddog.getBasic()*70/100;
             if(chancemusuhatk<=75) 
             {
              if(mageeva>10) 
              {
               mage.setHP(mage.getHP()-(wilddog.getBasic()-magedefend));
              }
              else if(mageeva<=10)
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             
             else if(chancemusuhatk>75)
             {
              if(wilddog.getMP()>=wilddog.getMPUse()) 
              {
               System.out.println ("Wild Dog use Fire Torch!");
               wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
               mage.setHP(mage.getHP()-wilddog.getSkill());
              }
              else if(wilddog.getMP()<=wilddog.getMPUse()) 
              {
               if(mageeva>10) 
               {
                mage.setHP(mage.getHP()-(wilddog.getBasic()-magedefend));
               }
               else if(mageeva<=10)
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
             }
             turn++;
            }
            
            //bonus mp
            if(turn%3==0) 
            {
             if(mage.getMP()<120) 
             {
              System.out.println ("Mendapat BONUS MP!");
              mage.setMP(mage.getMP()+10);
              if(mage.getHP()>120) 
              {
               mage.setHP(120);
              }
             }
            }
            }while(mage.getHP()>0 && wilddog.getHP()>0);
            
            if(wilddog.getHP()<=0) 
            {       
             ctr_step= 0;
             turn= 0;
             wilddog.setHP(wilddog.getHealHP());
             wilddog.setMP(wilddog.getHealMP());
            }
            else if(mage.getHP()<=0) 
            {
             boss.setHP(0);
             System.out.println ("GAME OVER!");
            }
           }
           
           //range
           else if(job==3) 
           {            
            do{
            chancemusuhatk= (int)(Math.random()*100);
            int rangeeva= (int)(Math.random()*100);
            int musuhacc= (int)(Math.random()*100);
            System.out.println ("WILD DOG");
            System.out.println ("HP: "+wilddog.getHP()+"/"+"150");
            System.out.println ("MP: "+wilddog.getMP()+"/"+"50");
            System.out.println ();
            System.out.println ("RANGE");
            System.out.println ("HP: "+range.getHP()+"/"+"610");
            System.out.println ("MP: "+range.getMP()+"/"+"40");
            System.out.println ("1. Attack");
            System.out.println ("2. Skill");
            System.out.println ("3. Defend");
            System.out.print (">>> ");
            play= input.nextInt();
            System.out.println ();
            
            //attack
            if(play==1) 
            {
             wilddog.setHP(wilddog.getHP()-range.getBasic());
             if(chancemusuhatk<=75) 
             {
              if(turn<3) 
              {
               if(musuhacc<=10) 
               {
                if(rangeeva>5) 
                {
                 range.setHP(range.getHP()-wilddog.getBasic());
                }
                else if(rangeeva<=5) 
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
               else if(musuhacc>10) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              
              else if(turn>=3) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-wilddog.getBasic());
               }
                else if(rangeeva<=5) 
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
             }
             
             else if(chancemusuhatk>75) 
             {
              if(wilddog.getMP()>=wilddog.getMPUse()) 
              {
               System.out.println ("Wild Dog Fire Torch!");
               wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
               range.setHP(range.getHP()-wilddog.getSkill());
              }
              else if(wilddog.getMP()<=wilddog.getMPUse()) 
              {
               if(turn<3) 
               {
                if(musuhacc<=10) 
                {
                 if(rangeeva>5) 
                 {
                  range.setHP(range.getHP()-wilddog.getBasic());
                 }
                 else if(rangeeva<=5) 
                 {
                  System.out.println ("ENEMY ATTACK MISS!");
                 }
                }
                else if(musuhacc>10) 
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
               
               else if(turn>=3) 
               {
                if(rangeeva>5) 
                {
                 range.setHP(range.getHP()-wilddog.getBasic());
                }
                else if(rangeeva<=5) 
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
              }
             }
             turn++;
            }
            
            //skill
            else if(play==2) 
            {
             turn= 0;
             if(range.getMP()>=range.getMPUse()) 
             {
              System.out.println ("Range use Blind Attack!");
              range.setMP(range.getMP()-range.getMPUse());
              if(chancemusuhatk<=75) 
              {
               if(turn<3) 
               {
                if(musuhacc<3) 
                {
                 if(rangeeva>5) 
                 {
                  range.setHP(range.getHP()-wilddog.getBasic());
                 }
                 else if(rangeeva<=5) 
                 {
                  System.out.println ("ENEMY ATTACK MISS!");
                 }
                }
                else if(musuhacc>=3) 
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
               
               else if(turn>=3) 
               {
                if(rangeeva>5) 
                 {
                  range.setHP(range.getHP()-wilddog.getBasic());
                 }
                 else if(rangeeva<=5) 
                 {
                  System.out.println ("ENEMY ATTACK MISS!");
                 }
               }
              }
              
              else if(chancemusuhatk>75) 
              {
               if(wilddog.getMP()>=wilddog.getMPUse()) 
               {
                System.out.println ("Wild Dog use Fire Torch!");
                wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
                range.setHP(range.getHP()-wilddog.getSkill());
               }
               else if(wilddog.getMP()<=wilddog.getMPUse()) 
               {
                if(turn<3) 
                {
                 if(musuhacc<=10) 
                 {
                  if(rangeeva>5) 
                  {
                   range.setHP(range.getHP()-wilddog.getBasic());
                  }
                  else if(rangeeva<=5) 
                  {
                   System.out.println ("ENEMY ATTACK MISS!");
                  }
                 }
                 else if(musuhacc>10) 
                 {
                  System.out.println ("ENEMY ATTACK MISS!");
                 }
                }
                
                else if(turn>=3) 
                {
                 if(rangeeva>5) 
                 {
                  range.setHP(range.getHP()-wilddog.getBasic());
                 }
                 else if(rangeeva<=5) 
                 {
                  System.out.println ("ENEMY ATTACK MISS!");
                 }
                }
               }
              }
             }
             
             else if(range.getMP()<=0) 
             {
              System.out.println ("MP TIDAK CUKUP!");
             }
             turn++;
            }
            
            //defend
            else if(play==3) 
            {
             int rangedefend= wilddog.getBasic()*70/100;
             if(chancemusuhatk<=75) 
             {
              if(turn<3) 
              {
               if(musuhacc<=10) 
               {
                if(rangeeva>5) 
                {
                 range.setHP(range.getHP()-(wilddog.getBasic()-rangedefend));
                }
                else if(rangeeva<=5)
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
               else if(musuhacc>10) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              
              else if(turn>=3) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-(wilddog.getBasic()-rangedefend));
               }
                else if(rangeeva<=5)
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
             }
             
             else if(chancemusuhatk>75)
             {
              if(wilddog.getMP()>=wilddog.getMPUse()) 
              {
               System.out.println ("Wild Dog use Fire Torch!");
               wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
               range.setHP(range.getHP()-wilddog.getSkill());
              }
              else if(wilddog.getMP()<=wilddog.getMPUse()) 
              {
               if(turn<3) 
               {
                if(musuhacc<=10) 
                {
                 if(rangeeva>5) 
                 {
                  range.setHP(range.getHP()-(wilddog.getBasic()-rangedefend));
                 }
                 else if(rangeeva<=5)
                 {
                  System.out.println ("ENEMY ATTACK MISS!");
                 }
                }
                else if(musuhacc>10) 
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
               
               else if(turn>=3) 
               {
                if(rangeeva>5) 
                {
                 range.setHP(range.getHP()-(wilddog.getBasic()-rangedefend));
                }
                else if(rangeeva<=5)
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
              }
             }
             turn++;
            }
            
            //bonus mp
            if(turn%3==0) 
            {
             if(range.getMP()<40) 
             {
              System.out.println ("Mendapat BONUS MP!");
              range.setMP(range.getMP()+10);
              if(range.getMP()>40) 
              {
               range.setMP(40);
              }
             }
            }
            }while(range.getHP()>0 && wilddog.getHP()>0);
            
            if(wilddog.getHP()<=0) 
            {       
             ctr_step= 0;
             turn= 0;
             wilddog.setHP(wilddog.getHealHP());
             wilddog.setMP(wilddog.getHealMP());
            }
            else if(range.getHP()<=0) 
            {
             boss.setHP(0);
             System.out.println ("GAME OVER!");
            }
           }
          }
          
          //magicmonster
          else if(randmusuh==1) 
          {
           //warrior
           if(job==1) 
           {
            do{
            chancemusuhatk= (int)(Math.random()*100);
            int warracc= (int)(Math.random()*100);
            System.out.println ("MAGIC MONSTER");
            System.out.println ("HP: "+magicmonster.getHP()+"/"+"200");
            System.out.println ("MP: "+magicmonster.getMP()+"/"+"300");
            System.out.println ();
            System.out.println ("WARRIOR");
            System.out.println ("HP: "+warrior.getHP()+"/"+"520");
            System.out.println ("MP: "+warrior.getMP()+"/"+"30");
            System.out.println ("1. Attack");
            System.out.println ("2. Skill");
            System.out.println ("3. Defend");
            System.out.print (">>> ");
            play= input.nextInt();
            System.out.println ();
            
            //attack
            if(play==1) 
            {
             if(warracc<=90) 
             {
              magicmonster.setHP(magicmonster.getHP()-warrior.getBasic());
              if(chancemusuhatk<=75) 
              {
               warrior.setHP(warrior.getHP()-magicmonster.getBasic());
              }
              
              else if(chancemusuhatk>75)
              {
               if(magicmonster.getMP()>=magicmonster.getMPUse()) 
               {
                System.out.println ("Magic Monster use Thunder!");
                magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
                warrior.setHP(warrior.getHP()-magicmonster.getSkill());
               }
               else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
               {
                warrior.setHP(warrior.getHP()-magicmonster.getBasic());
               }
              }
             }
             
             else if(warracc>90) 
             {
              System.out.println ("ATTACK MISS!");
              if(chancemusuhatk<=75) 
              {
               warrior.setHP(warrior.getHP()-magicmonster.getBasic());
              }
              
              else if(chancemusuhatk>75)
              {
               if(magicmonster.getMP()>magicmonster.getMPUse()) 
               {
                System.out.println ("Magic Monster use Thunder!");
                magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
                warrior.setHP(warrior.getHP()-magicmonster.getSkill());
               }
               else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
               {
                warrior.setHP(warrior.getHP()-magicmonster.getBasic());
               }
              }
             }
             turn++;
            }
            
            //skill
            else if(play==2) 
            {
             if(warrior.getMP()>=warrior.getMPUse()) 
             {
              if(ctr_wskill<1) 
              {
               System.out.println ("Warrior use Power Break!");
               warrior.setMP(warrior.getMP()-warrior.getMPUse());
               magicmonster.setHP(magicmonster.getHP()-warrior.getBasic());
               magicmonster.setBasic(magicmonster.getBasic()-(magicmonster.getBasic()*10/100)); 
              }
              else if(ctr_wskill>=1) 
              {
               System.out.println ("NO EFFECT!");
              }
              
              if(chancemusuhatk<=75) 
              {
               warrior.setHP(warrior.getHP()-magicmonster.getBasic());
              }
              
              else if(chancemusuhatk>75)
              {
               if(magicmonster.getMP()>=magicmonster.getMPUse()) 
               {
                System.out.println ("Magic Monster use Thunder!");
                magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
                warrior.setHP(warrior.getHP()-magicmonster.getSkill());
               }
               else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
               {
                warrior.setHP(warrior.getHP()-magicmonster.getBasic());
               }
              }
             }
             
             else if(warrior.getMP()<=warrior.getMPUse())
             {
              System.out.println ("MP TIDAK CUKUP!");
             }
             ctr_wskill++;
             turn++;
            }
            
            //defend
            else if(play==3) 
            {
             int warrdefend= magicmonster.getBasic()*70/100;
             if(chancemusuhatk<=75) 
             {
              warrior.setHP(warrior.getHP()-(magicmonster.getBasic()-warrdefend));
             }
             
             else if(chancemusuhatk>75)
             {
              if(magicmonster.getMP()>=magicmonster.getMPUse()) 
              {
               System.out.println ("Magic Monster use Thunder!");
               magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
               warrior.setHP(warrior.getHP()-magicmonster.getSkill());
              }
              else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
              {
               warrior.setHP(warrior.getHP()-(magicmonster.getBasic()-warrdefend));
              }
             }
             turn++;
            }
            
            //bonus mp
            if(turn%3==0) 
            {
             if(warrior.getMP()<30) 
             {
              System.out.println ("Mendapat BONUS MP!");
              warrior.setMP(warrior.getMP()+10);
              if(warrior.getMP()>30) 
              {
               warrior.setMP(30);
              }
             }
            }
            }while(warrior.getHP()>0 && magicmonster.getHP()>0);
            
            if(magicmonster.getHP()<=0) 
            {
             ctr_wskill= 0;
             ctr_step= 0;
             turn= 0;
             magicmonster.setHP(magicmonster.getHealHP());
             magicmonster.setMP(magicmonster.getHealMP());
            }
            else if(warrior.getHP()<=0) 
            {
             boss.setHP(0);
             System.out.println ("GAME OVER!");
            }
           }
          }
          
          //mage
          else if(job==2) 
          {
           do{
           chancemusuhatk= (int)(Math.random()*100);
           int mageacc= (int)(Math.random()*100);
           int mageeva= (int)(Math.random()*100);
           System.out.println ("MAGIC MONSTER");
           System.out.println ("HP: "+magicmonster.getHP()+"/"+"200");
           System.out.println ("MP: "+magicmonster.getMP()+"/"+"300");
           System.out.println ();
           System.out.println ("MAGE");
           System.out.println ("HP: "+mage.getHP()+"/"+"360");
           System.out.println ("MP: "+mage.getMP()+"/"+"120");
           System.out.println ("1. Attack");
           System.out.println ("2. Skill");
           System.out.println ("3. Defend");
           System.out.print (">>> ");
           play= input.nextInt();
           System.out.println ();
           
           //attack
           if(play==1) 
           {
            if(mageacc<=75) 
            {
             magicmonster.setHP(magicmonster.getHP()-mage.getBasic());
             if(chancemusuhatk<=75) 
             {
              if(mageeva>10) 
              {
               mage.setHP(mage.getHP()-magicmonster.getBasic());
              }
              else if(mageeva<=10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
              
             else if(chancemusuhatk>75)
             {
              if(magicmonster.getMP()>=magicmonster.getMPUse()) 
              {
               System.out.println ("Magic Monster use Fire Thunder!");
               magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
               mage.setHP(mage.getHP()-magicmonster.getSkill());
              }
              else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
              {
               if(mageeva>10) 
               {
                mage.setHP(mage.getHP()-magicmonster.getBasic());
               }
               else if(mageeva<=10) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
             }
            }
             
            else if(mageacc>75)
            {
             System.out.println ("ATTACK MISS!");
             if(chancemusuhatk<=75) 
             {
              if(mageeva>10) 
              {
               mage.setHP(mage.getHP()-magicmonster.getBasic()); 
              }
              else if(mageeva<=10)
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
              
             else if(chancemusuhatk>75) 
             {
              if(magicmonster.getMP()>=magicmonster.getMPUse()) 
              {
               System.out.println ("Magic Monster use Thunder!");
               wilddog.setMP(wilddog.getMP()-wilddog.getMPUse());
               mage.setHP(mage.getHP()-wilddog.getSkill());
              }
              else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
              {
               if(mageeva>10) 
               {
                mage.setHP(mage.getHP()-magicmonster.getBasic()); 
               }
               else if(mageeva<=10)
               { 
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
             }
            }
            turn++;
           }
            
           //skill
           else if(play==2) 
           {
            if(mage.getMP()>=mage.getMPUse()) 
            {
             System.out.println ("Mage use Magic Ball!");
             mage.setMP(mage.getMP()-mage.getMPUse());
             magicmonster.setHP(magicmonster.getHP()-mage.getMagic());
              
             if(chancemusuhatk<=75) 
             {
              if(mageeva>10) 
              {
               mage.setHP(mage.getHP()-magicmonster.getBasic());
              }
              else if(mageeva<=10)
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
              
             else if(chancemusuhatk>75)
             {
              if(magicmonster.getMP()>=magicmonster.getMPUse()) 
              {
               System.out.println ("Magic Monster use Thunder!");
               magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
               mage.setHP(mage.getHP()-magicmonster.getSkill());
              }
              else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
              {
               if(mageeva>10) 
               {
                mage.setHP(mage.getHP()-magicmonster.getBasic());
               }
               else if(mageeva<=10)
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
             }
            }
             
            else if(mage.getMP()<=mage.getMPUse())
            {
             System.out.println ("MP TIDAK CUKUP!");
            }
            turn++;
           }
            
           //defend
           else if(play==3) 
           {
            int magedefend= magicmonster.getBasic()*70/100;
            if(chancemusuhatk<=75) 
            {
             if(mageeva>10) 
             {
              mage.setHP(mage.getHP()-(magicmonster.getBasic()-magedefend));
             }
             else if(mageeva<=10)
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
             
            else if(chancemusuhatk>75)
            {
             if(magicmonster.getMP()>=magicmonster.getMPUse()) 
             {
              System.out.println ("Magic Monster use Thunder!");
              magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
              mage.setHP(mage.getHP()-magicmonster.getSkill());
             }
             else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
             {
              if(mageeva>10) 
              {
               mage.setHP(mage.getHP()-(magicmonster.getBasic()-magedefend));
              }
              else if(mageeva<=10)
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
            }
            turn++;
           }
            
           //bonus mp
           if(turn%3==0) 
           {
            if(mage.getMP()<120) 
            {
             System.out.println ("Mendapat BONUS MP!");
             mage.setMP(mage.getMP()+10);
             if(mage.getMP()>120) 
             {
              mage.setMP(120);
             }
            }
           }
          }while(mage.getHP()>0 && magicmonster.getHP()>0);
          if(magicmonster.getHP()<=0) 
          {        
           ctr_step= 0;
           turn= 0;
           magicmonster.setHP(magicmonster.getHealHP());
           magicmonster.setMP(magicmonster.getHealMP());
          }
          else if(mage.getHP()<=0) 
          {
           boss.setHP(0);
           System.out.println ("GAME OVER!");
          }
         }
         
         //range
         else if(job==3) 
         {
          do{
          chancemusuhatk= (int)(Math.random()*100);
          int rangeeva= (int)(Math.random()*100);
          int musuhacc= (int)(Math.random()*100);
          System.out.println ("MAGIC MONSTER");
          System.out.println ("HP: "+magicmonster.getHP()+"/"+"200");
          System.out.println ("MP: "+magicmonster.getMP()+"/"+"300");
          System.out.println ();
          System.out.println ("RANGE");
          System.out.println ("HP: "+range.getHP()+"/"+"610");
          System.out.println ("MP: "+range.getMP()+"/"+"40");
          System.out.println ("1. Attack");
          System.out.println ("2. Skill");
          System.out.println ("3. Defend");
          System.out.print (">>> ");
          play= input.nextInt();
          System.out.println ();
            
          //attack
          if(play==1) 
          {
           magicmonster.setHP(magicmonster.getHP()-range.getBasic());
           if(chancemusuhatk<=75) 
           {
            if(turn<3) 
            {
             if(musuhacc<=10) 
             {
              if(rangeeva>5) 
              {
               range.setHP(range.getHP()-magicmonster.getBasic());
              }
              else if(rangeeva<=5) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             else if(musuhacc>10) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
            
            else if(turn>=3) 
            {
             if(rangeeva>5) 
             {
              range.setHP(range.getHP()-magicmonster.getBasic());
             }
             else if(rangeeva<=5) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
           }
             
           else if(chancemusuhatk>75) 
           {
            if(magicmonster.getMP()>=magicmonster.getMPUse()) 
            {
             System.out.println ("Magic Monster use Thunder!");
             magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
             range.setHP(range.getHP()-magicmonster.getSkill());
            }
            else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
            {
             if(turn<3) 
             {
              if(musuhacc<=10) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-magicmonster.getBasic());
               }
               else if(rangeeva<=5) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              else if(musuhacc>10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
              
              else if(turn>=3) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-magicmonster.getBasic());
               }
               else if(rangeeva<=5) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
             }
            }
           }
           turn++;
          }
           
          //skill
          else if(play==2) 
          {
           turn= 0;
           if(range.getMP()>=range.getMPUse()) 
           {
            System.out.println ("Range use Blind Attack!");
            range.setMP(range.getMP()-range.getMPUse());
            if(chancemusuhatk<=75) 
            {
             if(turn<3) 
             {
              if(musuhacc<=10) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-magicmonster.getBasic());
               }
               else if(rangeeva<=5) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              else if(musuhacc>10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             
             else if(turn>=3) 
             {
              if(rangeeva>5) 
              {
               range.setHP(range.getHP()-magicmonster.getBasic());
              }
              else if(rangeeva<=5) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
            }
             
            else if(chancemusuhatk>75) 
            {
             if(magicmonster.getMP()>=magicmonster.getMPUse()) 
             {
              System.out.println ("Magic Monster use Thunder!");
              magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
              range.setHP(range.getHP()-magicmonster.getSkill());
             }
             else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
             {
              if(turn<3) 
              {
               if(musuhacc<=10)
               {
                if(rangeeva>5) 
                {
                 range.setHP(range.getHP()-magicmonster.getBasic());
                }
                else if(rangeeva<=5) 
                {
                 System.out.println ("ENEMY ATTACK MISS!");
                }
               }
               else if(musuhacc>10) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              else if(turn>=3) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-magicmonster.getBasic());
               }
               else if(rangeeva<=5) 
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
             }
            }
           }
            
           else if(range.getMP()<=range.getMPUse()) 
           {
            System.out.println ("MP TIDAK CUKUP!");
           }
           turn++;
          }
           
          //defend
          else if(play==3) 
          {
           int rangedefend= magicmonster.getBasic()*70/100;
           if(chancemusuhatk<=75) 
           {
            if(turn<3) 
            {
             if(musuhacc<=10) 
             {
              if(rangeeva>5) 
              {
               range.setHP(range.getHP()-(magicmonster.getBasic()-rangedefend));
              }
              else if(rangeeva<=5)
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             
             else if(musuhacc>10) 
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
            
            else if(turn>=3) 
            {
             if(rangeeva>5) 
             {
              range.setHP(range.getHP()-(magicmonster.getBasic()-rangedefend));
             }
             else if(rangeeva<=5)
             {
              System.out.println ("ENEMY ATTACK MISS!");
             }
            }
           }
             
           else if(chancemusuhatk>75)
           {
            if(magicmonster.getMP()>=magicmonster.getMPUse()) 
            {
             System.out.println ("Magic Monster use Thunder!");
             magicmonster.setMP(magicmonster.getMP()-magicmonster.getMPUse());
             range.setHP(range.getHP()-magicmonster.getSkill());
            }
            
            else if(magicmonster.getMP()<=magicmonster.getMPUse()) 
            {
             if(turn<3) 
             {
              if(musuhacc<=10) 
              {
               if(rangeeva>5) 
               {
                range.setHP(range.getHP()-(magicmonster.getBasic()-rangedefend));
               }
               else if(rangeeva<=5)
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
              else if(musuhacc>10) 
              {
               System.out.println ("ENEMY ATTACK MISS!");
              }
             }
             
             else if(turn>=3) 
             {
              if(rangeeva>5) 
              {
               range.setHP(range.getHP()-(magicmonster.getBasic()-rangedefend));
              }
               else if(rangeeva<=5)
               {
                System.out.println ("ENEMY ATTACK MISS!");
               }
              }
            }
           }
           turn++;
          }
            
          //bonus mp
          if(turn%3==0) 
          {
           if(range.getMP()<40) 
           {
            System.out.println ("Mendapat BONUS MP!");
            range.setMP(range.getMP()+10);
            if(range.getMP()>40) 
            {
             range.setMP(40);
            }
           }
          }
         }while(range.getHP()>0 && magicmonster.getHP()>0);
           
         if(magicmonster.getHP()<=0) 
          {        
           ctr_step= 0;
           turn= 0;
           magicmonster.setHP(magicmonster.getHealHP());
           magicmonster.setMP(magicmonster.getHealMP());
          }
          else if(range.getHP()<=0) 
          {
           boss.setHP(0);
           System.out.println ("GAME OVER!");
          }
         }          
        }
       }  
      }while(boss.getHP()>0);
      
        
        
    }
    
}

class unit
{
 private int basic_atk;
 private int magic_atk;
 private int evasion;
 private int acc;
 private int hp;
 private int mp;
 private int healhp;
 private int healmp;
 private int skill;
 private int mpuse;
 
 void setBasic(int basic) 
 {
  this.basic_atk= basic;
 }
 
 void setMagic(int magic) 
 {
  this.magic_atk= magic;
 }
 
 void setEvasion(int evasion) 
 {
  this.evasion= evasion;
 }
 
 void setAcc(int scc) 
 {
  this.acc= acc;
 }
 
 void setHP(int hp) 
 {
  this.hp= hp;
 }
 
 void setMP(int mp) 
 {
  this.mp= mp;
 }
 
 void setSkill(int skill) 
 {
 
  this.skill= skill;
 }
 
 void setHealHP(int healhp) 
 {
  this.healhp= healhp;
 }
 
 void setHealMP(int healmp) 
 {
  this.healmp= healmp;
 }
 
 void setMPUse(int mpuse) 
 {
 
  this.mpuse= mpuse;
 }
 
 
 int getBasic() 
 {
  return this.basic_atk;
 }
 
 int getMagic() 
 {
  return this.magic_atk;
 }
 
 int getEvasion() 
 {
  return this.evasion;
 }
 
 int getHP() 
 {
  return this.hp;
 }
 
 int getMP() 
 {
  return this.mp;
 }
 
 int getSkill()
 {
 
  return this.skill;
 }
 
 int getHealHP() 
 {
  return this.healhp;
 }
 
 int getHealMP() 
 {
  return this.healmp;
 }
 
 int getMPUse() 
 {
  return this.mpuse;
 }
 
}
