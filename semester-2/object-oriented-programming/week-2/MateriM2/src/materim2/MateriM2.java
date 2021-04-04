package materim2;
import java.util.*;

public class MateriM2 
{

    public static void main(String[] args) 
    {
        Scanner input= new Scanner (System.in);
        Scanner string= new Scanner (System.in);
        
        int pilmenu;
        int piljob;
        int pilpup;
        String nama;
        
        int gold= 2000;
                
        System.out.print ("Your name: ");
        nama= string.nextLine();
        
        System.out.println ("Pilih Job: ");
        System.out.println ("1. Knight");
        System.out.println ("2. Archer");
        System.out.println ("3. Mage");
        System.out.print (">>> ");
        piljob= input.nextInt();
        
        Unit h1= new Unit();
        h1.setHP(100);
        h1.setMAXHP();
        h1.setMINATK(10);
        h1.setMAXATK(15);
        h1.setACC(90);
        
        Unit h2= new Unit();
        h2.setHP(120);
        h2.setMAXHP();
        h2.setMINATK(8);
        h2.setMAXATK(12);
        h2.setACC(75);
        
        Unit h3= new Unit();
        h3.setHP(80);
        h3.setMAXHP();
        h3.setMINATK(15);
        h3.setMAXATK(20);
        h3.setACC(80);
        
        Unit e1= new Unit();
        e1.setHP(100);
        e1.setMAXHP();
        e1.setMINATK(10);
        e1.setMAXATK(15);
        e1.setACC(90);
        
        Unit e2= new Unit();
        e2.setHP(120);
        e2.setMAXHP();
        e2.setMINATK(8);
        e2.setMAXATK(12);
        e2.setACC(75);
        
        Unit e3= new Unit();
        e3.setHP(80);
        e3.setMAXHP();
        e3.setMINATK(15);
        e3.setMAXATK(20);
        e3.setACC(80);
        
        do{
        int randenemy= (int)(Math.random()*2);
        System.out.println ("Name: "+nama);
        System.out.println ("Gold: "+gold);
        System.out.println ("1. Battle");
        System.out.println ("2. Power up");
        System.out.println ("3. Lihat status");
        System.out.println ("4. Rest");
        System.out.println ("5. Exit");
        System.out.print (">>> ");
        pilmenu= input.nextInt();
        
        if(pilmenu==1) 
        {
         System.out.println ("-BATTLE RECAP-");
         
         if(piljob==1) //knight
         {
          if(randenemy==0) //knight
          {
           int damageplayer,damageenemy;
           do{
           int atkknight= (int)(Math.random()*16+10);
           System.out.println ("Player "+nama+" - "+h1.job1);
           System.out.println ("HP: "+h1.getHP());
           System.out.println ("Enemy "+e1.enemy+" - "+e1.job1);
           System.out.println ("HP: "+e1.getHP());
           damageplayer= e1.getHP()-atkknight;
           System.out.println ("Player menyerang enemy sebesar "+atkknight);
           e1.setHP(damageplayer);
           damageenemy= h1.getHP()-atkknight;
           h1.setHP(damageenemy);
           System.out.println ("Enemey menyerang player sebesar "+atkknight);
           }while(h1.getHP()>0 && e1.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e1.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h1.getHP()<=0) 
           {
            h1.setHP(h1.getMAXHP());
            System.out.println ("Enemy menang!");
           }
          }
          
          else if(randenemy==1) //archer
          {
           int bonus= (e2.getMINATK()+e2.getMAXATK())/2;
           int damageplayer,damageenemy;
           do{
           int atkknight= (int)(Math.random()*16+10);
           int atkarcher= (int)(Math.random()*13+8);
           System.out.println ("Player "+nama+" - "+h1.job1);
           System.out.println ("HP: "+h1.getHP());
           System.out.println ("Enemy "+e2.enemy+" - "+e2.job2);
           System.out.println ("HP: "+e2.getHP());
           damageplayer= e2.getHP()-atkknight;
           System.out.println ("Player menyerang enemy sebesar "+atkknight);
           e2.setHP(damageplayer);
           int hitungbonus= atkarcher+bonus;
           damageenemy= h1.getHP()-hitungbonus;
           h1.setHP(damageenemy);
           System.out.println ("Enemey menyerang player sebesar "+hitungbonus+
                               "(Bonus Damage)");
           }while(h1.getHP()>0 && e2.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e2.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h1.getHP()<=0) 
           {
            h1.setHP(h1.getMAXHP());
            System.out.println ("Enemey menang!");
           }
          }
          
          else if(randenemy==2) //mage
          {
           int bonus= (h1.getMINATK()+h1.getMAXHP())/2;
           int damageplayer,damageenemy;
           do{
           int atkknight= (int)(Math.random()*16+10);
           int atkmage= (int)(Math.random()*21+15);
           System.out.println ("Player "+nama+" - "+h1.job1);
           System.out.println ("HP: "+h1.getHP());
           System.out.println ("Enemy "+e3.enemy+" - "+e3.job3);
           System.out.println ("HP: "+e3.getHP());
           int hitungbonus= atkknight+bonus;
           damageplayer= e3.getHP()-hitungbonus;
           e3.setHP(damageplayer);
           System.out.println ("Player menyerang enemy sebesar"+hitungbonus+
                               "(Bonus Damage)");
           damageenemy= h1.getHP()-atkmage;
           h1.setHP(damageenemy);
           System.out.println ("Enemy menyerang player sebesar "+atkmage);
           }while(h1.getHP()>0 && e3.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e3.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h1.getHP()<=0) 
           {
            h1.setHP(h1.getMAXHP());
            System.out.println ("Enemy menang!");
           }
          }
         }
         
         else if(piljob==2) //archer
         {
          if(randenemy==0) //knight
          {
           int bonus= (h2.getMINATK()+h2.getMAXATK())/2;
           int damageplayer,damageenemy;
           do{
           int atkarcher= (int)(Math.random()*13+8);
           int atkknight= (int)(Math.random()*16+10);
           System.out.println ("Player "+nama+" - "+h2.job2);
           System.out.println ("HP: "+h2.getHP());
           System.out.println ("Enemy "+e1.enemy+" - "+e1.job1);
           System.out.println ("HP: "+e1.getHP());
           int hitungbonus= atkarcher+bonus;
           damageplayer= e1.getHP()-hitungbonus;
           e1.setHP(damageplayer);
           System.out.println ("Player menyerang enemy sebesar "+hitungbonus+
                               "(Bonus Damage)");
           damageenemy= h2.getHP()-atkknight;
           h2.setHP(damageenemy);
           System.out.println ("Enemy menyerang player sebesar "+atkknight);
           }while(h2.getHP()>0 && e1.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e1.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h2.getHP()<=0) 
           {
            h2.setHP(h2.getMAXHP());
            System.out.println ("Enemy menang!");
           }
          }
          
          else if(randenemy==1) //archer
          {
           int damageplayer,damageenemy;
           do{
           int atkarcher= (int)(Math.random()*13+8);
           System.out.println ("Player "+nama+" - "+h2.job2);
           System.out.println ("HP: "+h2.getHP());
           System.out.println ("Enemy "+e2.enemy+" - "+e2.job2);
           System.out.println ("HP: "+e2.getHP());
           damageplayer= e2.getHP()-atkarcher;
           e2.setHP(damageplayer);
           System.out.println ("Player menyerang enemy sebesar "+atkarcher);
           damageenemy= h2.getHP()-atkarcher;
           h2.setHP(damageenemy);
           System.out.println ("Enemy menyerang player sebesar "+atkarcher);
           }while(h2.getHP()>0 && e2.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e2.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h2.getHP()<=0) 
           {
            h2.setHP(h2.getMAXHP());
            System.out.println ("Enemy menang!");
           }
          }
          
          else if(randenemy==2) //mage
          {
           int bonus= (e3.getMINATK()+e3.getMAXATK())/2;
           int damageplayer,damageenemy;
           do{
           int atkarcher= (int)(Math.random()*13+8);
           int atkmage= (int)(Math.random()*21+15);
           System.out.println ("Player "+nama+" - "+h2.job2);
           System.out.println ("HP: "+h2.getHP());
           System.out.println ("Enemy "+e3.enemy+" - "+e3.job3);
           System.out.println ("HP: "+e3.getHP());
           damageplayer= e3.getHP()-atkarcher;
           e3.setHP(damageplayer);
           System.out.println ("Player menyerang enemy sebesar "+atkarcher);
           int hitungbonus= atkmage+bonus;
           damageenemy= h2.getHP()-hitungbonus;
           h2.setHP(damageenemy);
           System.out.println ("Enemy menyerang player sebesar "+hitungbonus+
                               "(Bonus Damage)");
           }while(h2.getHP()>0 && e3.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e3.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h2.getHP()<=0) 
           {
            h2.setHP(h2.getMAXHP());
            System.out.println ("Enemy menang!");
           }
          }
         }
         
         else if(piljob==3) //mage
         {
          if(randenemy==0) //knight
          {
           int bonus= (e1.getMINATK()+e1.getMAXATK())/2;
           int damageplayer,damageenemy;
           do{
           int atkmage= (int)(Math.random()*21+15);
           int atkknight= (int)(Math.random()*16+10);
           System.out.println ("Player "+nama+" - "+h3.job3);
           System.out.println ("HP: "+h3.getHP());
           System.out.println ("Enemy "+e1.enemy+" - "+e1.job1);
           System.out.println ("HP: "+e1.getHP());
           damageplayer= e1.getHP()-atkmage;
           e1.setHP(damageplayer);
           System.out.println ("Player menyerang enemy sebesar "+atkmage);
           int hitungbonus= atkknight+bonus;
           damageenemy= h3.getHP()-hitungbonus;
           h3.setHP(damageenemy);
           System.out.println ("Enemy menyerang player sebesar "+hitungbonus+
                               "(Bonus Damage)");
           }while(h3.getHP()>0 && e1.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e1.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h3.getHP()<=0) 
           {
            h3.setHP(h3.getMAXHP());
            System.out.println ("Enemy menang!");
           }
          }
          
          else if(randenemy==1) //archer
          {
           int bonus= h3.getMINATK()+h3.getMAXATK();
           int damageplayer,damageenemy;
           do{
           int atkmage= (int)(Math.random()*21+15);
           int atkarcher= (int)(Math.random()*13+8);
           System.out.println ("Player "+nama+" - "+h3.job3);
           System.out.println ("HP: "+h3.getHP());
           System.out.println ("Enemy "+e2.enemy+" - "+e2.job2);
           System.out.println ("HP: "+e2.getHP());
           int hitungbonus= atkmage+bonus;
           damageplayer= e2.getHP()-hitungbonus;
           e2.setHP(damageplayer);
           System.out.println ("Player menyerang musuh sebesar "+hitungbonus+
                           "(Bonus Damage)");
           damageenemy= h3.getHP()-atkarcher;
           h3.setHP(damageenemy);
           System.out.println ("Enemey menyerang player sebesar "+atkarcher);
           }while(h3.getHP()>0 && e2.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e2.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h3.getHP()<=0) 
           {
            h3.setHP(h3.getMAXHP());
            System.out.println ("Enemy menang!");
           }
          }
          
          else if(randenemy==2) //mage
          {
           int damageplayer,damageenemy;
           do{
           int atkmage= (int)(Math.random()*21+15);
           System.out.println ("Player "+nama+" - "+h3.job3);
           System.out.println ("HP: "+h3.getHP());
           System.out.println ("Enemy "+e3.enemy+" - "+e3.job3);
           System.out.println ("HP: "+e3.getHP());
           damageplayer= e3.getHP()-atkmage;
           e3.setHP(damageplayer);
           System.out.println ("Player menyerang musuh sebesar "+atkmage);
           damageenemy= h3.getHP()-atkmage;
           h3.setHP(damageenemy);
           System.out.println ("Enemey menyerang player sebesar "+atkmage);
           }while(h3.getHP()>0  && e3.getHP()>0);
           
           int goldwin= (int)(Math.random()*501+200);
           if(e3.getHP()<=0) 
           {
            gold= gold+goldwin;
            System.out.println ("Player menang!");
           }
           
           else if(h3.getHP()<=0) 
           {
            h3.setHP(h3.getMAXHP());
            System.out.println ("Enemy menang!");
           }
          }
         }
        }
        
        if(pilmenu==2) 
        {
         System.out.println ("1. PowerUp HP");
         System.out.println ("2. PowerUP ATK");
         System.out.print (">>>");
         pilpup= input.nextInt();
         
         if(pilpup==1) 
         {
          gold= gold-250;
          int randuphp= (int)(Math.random()*26+10);  
          if(piljob==1) 
          {
           h1.setHP(h1.getHP()+randuphp);
           System.out.println ("HP POWER UP!");
          }
          
          else if(piljob==2) 
          {
           h2.setHP(h2.getHP()+randuphp);
           System.out.println ("HP POWER UP!");
          }
          
          else if(piljob==3) 
          {
           h3.setHP(h3.getHP()+randuphp);
           System.out.println ("HP POWER UP!");
          }
         }
         
         if(pilpup==2) 
         {
          gold= gold-200;
          int randupatk= (int)(Math.random()*6+3);
          if(piljob==1) 
          {
           h1.setMINATK(h1.getMINATK()+randupatk);
           h1.setMAXATK(h1.getMAXATK()+randupatk);
           System.out.println ("ATK POWER UP!");
          }
          
          else if(piljob==2) 
          {
           h2.setMINATK(h2.getMINATK()+randupatk);
           h2.setMAXATK(h2.getMAXATK()+randupatk);
           System.out.println ("ATK POWER UP!");
          }
          
          else if(piljob==3) 
          {
           h3.setMINATK(h3.getMINATK()+randupatk);
           h3.setMAXATK(h3.getMAXATK()+randupatk);
           System.out.println ("ATK POWER UP!");
          }
         }
        }
        
        if(pilmenu==3) 
        {
         if(piljob==1) 
         {
          System.out.println ("Name: "+nama);
          System.out.println ("Class: "+h1.job1);
          System.out.println ("HP: "+h1.getHP());
          System.out.println ("ATK: "+h1.getMINATK()+"-"+h1.getMAXATK());
          System.out.println ("ACC: "+h1.getACC()+"%");
         }
         
         else if(piljob==2) 
         {
          System.out.println ("Name: "+nama);
          System.out.println ("Class: "+h2.job2);
          System.out.println ("HP: "+h2.getHP());
          System.out.println ("ATK: "+h2.getMINATK()+"-"+h3.getMAXATK());
          System.out.println ("ACC: "+h2.getACC()+"%");
         }
         
         else if(piljob==3) 
         {
          System.out.println ("Name: "+nama);
          System.out.println ("Class: "+h3.job3);
          System.out.println ("HP: "+h3.getHP());
          System.out.println ("ATK: "+h3.getMINATK()+"-"+h3.getMAXATK());
          System.out.println ("ACC: "+h3.getACC()+"%");
         }
        
        }
        
        if(pilmenu==4) 
        {
         if(piljob==1) 
         {
          gold= gold-100;
          h1.setHP(h1.getMAXHP());
          System.out.println ("HEALED !");
         }
         
         else if(piljob==2) 
         {
          gold= gold-100;
          h2.setHP(h2.getMAXHP());
          System.out.println ("HEALED !");
         }
         
         else if(piljob==3) 
         {
          gold= gold-100;
          h3.setHP(h3.getMAXHP());
          System.out.println ("HEALED !");
         }
        }
        
        }while(pilmenu!=5);
        System.out.println ("Thank you for playing!");
        
    }
    
}
