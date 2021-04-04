package tugasprakw6;
import java.util.*;
public class TugasPrakW6 {
    static int panjang= 13, lebar= 13; 
    static String[][] map= new String[panjang][lebar];
    static String step;
    static void initMap() {
      for(int i= 0;i<panjang;i++) {
       for(int j= 0;j<lebar;j++) {
        if(i==0 || i==panjang-1 || j==0 || j==lebar-1) {
         map[i][j]= "*";
        }else if(i%2==0 && j%2==0) {
         map[i][j]= "*";
        }else map[i][j]= " ";
       }
      }
    }
    static void cetakMap() {
        for(int i= 0;i<panjang;i++) {
         for(int j= 0;j<lebar;j++) {
          System.out.print(map[i][j]);
         }
         System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        Scanner string= new Scanner(System.in);
        player p= new player();
        ArrayList<enemy> m= new ArrayList<>();
        ArrayList<bomb> pb= new ArrayList<>();
        ArrayList<bomb> eb= new ArrayList<>();
        ArrayList<bomb> pup= new ArrayList<>();
        m.add(new enemy());
        int ctreb= 0,ctrpup= 0,ptimer= 99,etimer= 99;
        int ctrup= 1,ctrdown= -1,ctrleft= -1,ctrright= -1;
        int pbom= 1,ebom= 1;
        boolean emove= true,pplant= true,eplant= true;
        boolean hpp= true;
        int randpup;
        Random r= new Random();
        initMap();
        do{
        map[p.getY()][p.getX()]= p.getIcon(); //player
        for(int i= 0;i<m.size();i++) { //enemy
         map[m.get(i).getY()][m.get(i).getX()]= m.get(i).getIcon();
        }
        for(int i= 0;i<pb.size();i++) { //player bomb
         map[pb.get(i).getY()][pb.get(i).getX()]= pb.get(i).getIcon();
        }
        for(int i= 0;i<eb.size();i++) { //enemy bomb
         map[eb.get(i).getY()][eb.get(i).getX()]= eb.get(i).getIcon();
        }
        for(int i= 0;i<pup.size();i++) { //power up
         map[pup.get(i).getY()][pup.get(i).getX()]= pup.get(i).getIcond();
        }
        cetakMap();
        System.out.print("Move: ");
        step= string.nextLine();
        p.move(step,map);
        ctrpup++;
        ptimer++;
        etimer++;
        //player bomb
        if("b".equals(step) || "B".equals(step)) {
         if(pplant==true) {
          if(pbom==1) {
           pb.add(new type1());
          }else if(pbom==2) {
           pb.add(new type2());
          }else if(pbom==3) {
           pb.add(new type3());
          }
          ptimer= 0;
          for(int i= 0;i<pb.size();i++) {
           pb.get(i).plant(p.getX(),p.getY());
          }
          pplant= false;
         }else {System.out.println("Player belum bisa plant bom!");}
        }else if("c".equals(step) || "C".equals(step)) {
         System.out.println("Using Cheat!");
         for(int i= 0;i<m.size();i++) {
          m.get(i).setGerak(false);
          m.get(i).setPlant(false);
         }
        }
        //enemy move1
        if(emove==true) {
         for(int i= 0;i<m.size();i++) {
          if(m.get(i).getGerak()==true) {
           if(ctrup<5) { //atas
            if(!"*".equals(map[m.get(i).getY()-1][m.get(i).getX()])) {
             map[m.get(i).getY()][m.get(i).getX()]= " ";
             m.get(i).setY(m.get(i).getY()-1);
             ctrup++;
            }else {ctrup= 5;}
           }if(ctrup>=5) { //kanan
            if(!"*".equals(map[m.get(i).getY()][m.get(i).getX()+1])) {
             map[m.get(i).getY()][m.get(i).getX()]= " ";
             m.get(i).setX(m.get(i).getX()+1);
             ctrright++;
            }else {ctrright= 5;}
           }if(ctrright>=5) { //bawah
            if(!"*".equals(map[m.get(i).getY()+1][m.get(i).getX()])) {
             map[m.get(i).getY()][m.get(i).getX()]= " ";
             m.get(i).setY(m.get(i).getY()+1);
             ctrdown++;
            }else {ctrdown= 5;}
           }if(ctrdown>=5) { //kiri
            if(!"*".equals(map[m.get(i).getY()][m.get(i).getX()-1])) {
             map[m.get(i).getY()][m.get(i).getX()]= " ";
             m.get(i).setX(m.get(i).getX()-1);
             ctrleft++;
            }else {ctrleft= 5;}
           }if(ctrleft>=5) {
            emove= false;
            ctrup= -1;
            ctrdown= -1;
            ctrright= -1;
            ctrleft= -1;
           }
          }
         }
         ctreb++;
        }
        //enemy move2
        else if(emove==false) {
         for(int i= 0;i<m.size();i++) {
          if(m.get(i).getGerak()==true) {
           if(ctrup<5) { //atas
            if(!"*".equals(map[m.get(i).getY()-1][m.get(i).getX()])) { 
             map[m.get(i).getY()][m.get(i).getX()]= " ";
             m.get(i).setY(m.get(i).getY()-1);
             ctrup++;
            }else {ctrup= 5;}
           }if(ctrup>=5) { //kiri
            if(!"*".equals(map[m.get(i).getY()][m.get(i).getX()-1])) {
             map[m.get(i).getY()][m.get(i).getX()]= " ";
             m.get(i).setX(m.get(i).getX()-1);
             ctrleft++;
            }else {ctrleft= 5;}
           }if(ctrleft>=5) { //bawah
            if(!"*".equals(map[m.get(i).getY()+1][m.get(i).getX()])) {
             map[m.get(i).getY()][m.get(i).getX()]= " ";
             m.get(i).setY(m.get(i).getY()+1);
             ctrdown++;
            }else {ctrdown= 5;}
           }if(ctrleft>=5) { //kanan
            if(!"*".equals(map[m.get(i).getY()][m.get(i).getX()+1])) {
             map[m.get(i).getY()][m.get(i).getX()]= " ";
             m.get(i).setX(m.get(i).getX()+1);
             ctrright++;
            }else {ctrright= 5;}
           }if(ctrright>=5) {
            emove= true;
            ctrup= -1;
            ctrdown= -1;
            ctrright= -1;
            ctrleft= -1;
           }
          }
         }
         ctreb++;
        }
        //enemy bomb
        if(ctreb%6==0) {
         for(int i= 0;i<m.size();i++) {
          if(m.get(i).getPlant()==true) {
           if(eplant==true) {
            etimer= 0;
            if(ebom==1) {
             eb.add(new type1());
            }else if(ebom==2) {
             eb.add(new type2());
            }else if(ebom==3) {
             eb.add(new type3());
            }
            for(int j= 0;j<eb.size();j++) {
             eb.get(j).plant(m.get(i).getX(),m.get(i).getY());
            }
            eplant= false;
           }else {System.out.println("Enemy belum bisa plant bomb!");}
          }
         }
        }
        //player bom explode
        if(ptimer==4) {
         ptimer= 99;
         pplant= true;
         for(int i= 0;i<pb.size();i++) {
          if("4D".equals(pb.get(i).getName())) { //type1
           if((p.getX()==pb.get(i).getX()-1 && p.getY()==pb.get(i).getY()) || 
              (p.getX()==pb.get(i).getX()+1 && p.getY()==pb.get(i).getY()) || 
              (p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY()-1) || 
              (p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY()+1) ||
              (p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY())) { //player 
            pb.get(i).explode(p.getX(),p.getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
            hpp= false;
           }else if((m.get(0).getX()==pb.get(i).getX()-1 && m.get(0).getY()==pb.get(i).getY()) || 
              (m.get(0).getX()==pb.get(i).getX()+1 && m.get(0).getY()==pb.get(i).getY()) || 
              (m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY()-1) || 
              (m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY()+1) ||
              (m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY())) { //enemy
            pb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
            m.remove(0);
           }else {
            pb.get(i).explode(p.getX(),p.getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
           }
          }else if("Horriz".equals(pb.get(i).getName())) { //type2
           if((p.getX()==pb.get(i).getX()-1 && p.getY()==pb.get(i).getY()) ||
              (p.getX()==pb.get(i).getX()-2 && p.getY()==pb.get(i).getY()) ||
              (p.getX()==pb.get(i).getX()+1 && p.getY()==pb.get(i).getY()) ||
              (p.getX()==pb.get(i).getX()+2 && p.getY()==pb.get(i).getY()) ||
              (p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY())) { //player
            pb.get(i).explode(p.getX(),p.getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
            hpp= false;
           }else if((m.get(0).getX()==pb.get(i).getX()-1 && m.get(0).getY()==pb.get(i).getY()) ||
              (m.get(0).getX()==pb.get(i).getX()-2 && m.get(0).getY()==pb.get(i).getY()) ||
              (m.get(0).getX()==pb.get(i).getX()+1 && m.get(0).getY()==pb.get(i).getY()) ||
              (m.get(0).getX()==pb.get(i).getX()+2 && m.get(0).getY()==pb.get(i).getY()) ||
              (m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY())) { //enemy
            pb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
            m.remove(0);
           }else {
            pb.get(i).explode(p.getX(),p.getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
           }
          }else if("Verti".equals(pb.get(i).getName())) { //type3
           if((p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY()-1) || 
              (p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY()-2) ||
              (p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY()+1) ||
              (p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY()+2) || 
              (p.getX()==pb.get(i).getX() && p.getY()==pb.get(i).getY())) { //player
            pb.get(i).explode(p.getX(),p.getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
            hpp= false;
           }else if((m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY()-1) || 
              (m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY()-2) ||
              (m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY()+1) ||
              (m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY()+2) || 
              (m.get(0).getX()==pb.get(i).getX() && m.get(0).getY()==pb.get(i).getY())) { //enemy
            pb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
            m.remove(0);
           }else {
            pb.get(i).explode(p.getX(),p.getY());
            map[pb.get(i).getY()][pb.get(i).getX()]= " ";
            pb.remove(i);
           }
          }
         }
        }
        //enemy bom explode
        if(etimer==4) {
         etimer= 99;
         eplant= true;
         for(int i= 0;i<eb.size();i++) {
          if("4D".equals(eb.get(i).getName())) { //type1
           if((m.get(0).getX()==eb.get(i).getX()-1 && m.get(0).getY()==eb.get(i).getY()) || 
              (m.get(0).getX()==eb.get(i).getX()+1 && m.get(0).getY()==eb.get(i).getY()) ||
              (m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY()-1) ||
              (m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY()+1) ||
              (m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY())) { //enemy
            eb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
            m.remove(0);
           }else if((p.getX()==eb.get(i).getX()-1 && p.getY()==eb.get(i).getY()) || 
              (p.getX()==eb.get(i).getX()+1 && p.getY()==eb.get(i).getY()) ||
              (p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY()-1) ||
              (p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY()+1) ||
              (p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY())) { //player
            eb.get(i).explode(p.getX(),p.getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
            hpp= false;
           }else {
            eb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
           }
          }else if("Horriz".equals(eb.get(i).getName())) { //type2
           if((m.get(0).getX()==eb.get(i).getX()-1 && m.get(0).getY()==eb.get(i).getY()) || 
              (m.get(0).getX()==eb.get(i).getX()-2 && m.get(0).getY()==eb.get(i).getY()) ||
              (m.get(0).getX()==eb.get(i).getX()+1 && m.get(0).getY()==eb.get(i).getY()) ||
              (m.get(0).getX()==eb.get(i).getX()+2 && m.get(0).getY()==eb.get(i).getY()) ||
              (m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY())) { //enemy
            eb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
            m.remove(0);
           }else if((p.getX()==eb.get(i).getX()-1 && p.getY()==eb.get(i).getY()) || 
              (p.getX()==eb.get(i).getX()-2 && p.getY()==eb.get(i).getY()) ||
              (p.getX()==eb.get(i).getX()+1 && p.getY()==eb.get(i).getY()) ||
              (p.getX()==eb.get(i).getX()+2 && p.getY()==eb.get(i).getY()) ||
              (p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY())) { //player
            eb.get(i).explode(p.getX(),p.getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
            hpp= false;
           }else {
            eb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
           }
          }else if("Verti".equals(eb.get(i).getName())) { //type3
           if((m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY()-1) || 
              (m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY()-2) ||
              (m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY()+1) ||
              (m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY()+2) ||
              (m.get(0).getX()==eb.get(i).getX() && m.get(0).getY()==eb.get(i).getY())) { //enemy
            eb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
            m.remove(0);
           }else if((p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY()-1) || 
              (p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY()-2) ||
              (p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY()+1) ||
              (p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY()+2) ||
              (p.getX()==eb.get(i).getX() && p.getY()==eb.get(i).getY())) { //player
            eb.get(i).explode(p.getX(),p.getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
            hpp= false;
           }else {
            eb.get(i).explode(m.get(0).getX(),m.get(0).getY());
            map[eb.get(i).getY()][eb.get(i).getX()]= " ";
            eb.remove(i);
           }
          }
         }
        }
        //power up spawn
        if(ctrpup%5==0) {
         randpup= r.nextInt(3);
         int x= r.nextInt(9)+1;
         int y= r.nextInt(9)+1;
         System.out.println("Power UP dropped!");
         if(randpup==0) { //type1
          pup.add(new type1());
          for(int i= 0;i<pup.size();i++) {
           pup.get(i).setX(x);
           pup.get(i).setY(y);
          }
         }else if(randpup==1) { //type2
          pup.add(new type2());
          for(int i= 0;i<pup.size();i++) {
           pup.get(i).setX(x);
           pup.get(i).setY(y);
          }
         }else if(randpup==2) { //type3
          pup.add(new type3());
          for(int i= 0;i<pup.size();i++) {
           pup.get(i).setX(x);
           pup.get(i).setY(y);
          }
         }
        }
        //get power up
        //player
        for(int i= 0;i<pup.size();i++) {
         if(p.getX()==pup.get(i).getX() && p.getY()==pup.get(i).getY()) { //player
          if("4D".equals(pup.get(i).getName())) { //type1
           pbom= 1;
           System.out.println("Got "+pup.get(i).getName());
          }else if("Horriz".equals(pup.get(i).getName())) { //type2
           pbom= 2;
           System.out.println("Got "+pup.get(i).getName());
          }else if("Verti".equals(pup.get(i).getName())) { //type3
           pbom= 3;
           System.out.println("Got "+pup.get(i).getName());
          }
          pup.remove(i);
         }
        }
        }while(!hpp==false && !m.isEmpty());
        if(hpp==false) { //player klh
         System.out.println("Player mati!");
         System.out.println("You LOSE!");
        }if(m.isEmpty()) { //player menang
         System.out.println("Enemey mati!");
         System.out.println("You WIN!");
        }
    }
}