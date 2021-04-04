package materim2;

public class Unit 
{
    String job1= "Knight";
    String job2= "Archer";
    String job3= "Mage";
    String enemy= "bot";
    private int hp_hero;
    private int maxatk_hero;
    private int minatk_hero;
    private int acc_hero;
    private int maxhp_hero;
    
    void setHP(int hp) 
    {
     this.hp_hero= hp;
    }
    
    void setMAXHP() 
    {
     this.maxhp_hero= this.hp_hero;
    }
    
    void setMAXATK(int maxatk) 
    {
     this.maxatk_hero= maxatk;
    }
    
    void setMINATK(int minatk) 
    {
     this.minatk_hero= minatk;
    }
    
    void setACC(int acc) 
    {
     this.acc_hero= acc;
    }
    
    int getHP() 
    {
     return this.hp_hero;
    }
    
    int getMAXHP() 
    {
     return this.maxhp_hero;
    }
    
    int getMAXATK() 
    {
     return this.maxatk_hero;
    }
    
    int getMINATK() 
    {
     return this.minatk_hero;
    }
    
    int getACC() 
    {
     return this.acc_hero;
    }
    
    
}
