package tugasprakw5;
import java.util.*;
public class TugasPrakW5 {
    static int panjang= 10,lebar= 10;
    static String[][] map= new String[panjang][lebar];
    static void initMap() {
        for(int i= 0;i<panjang;i++) {
         for(int j= 0;j<lebar;j++) {
          map[i][j]= " ";
         }
        }
    }
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        Scanner string= new Scanner(System.in);       
        String musim[]= new String[2];
        musim[0]= "Spring";
        musim[1]= "Summer";
        int ctricon= 0,ctrmusim= 0,ctrhari= 1,tmenu;
        int ctrg= 0,ctrsiramg= 0,ctrsiramt= 0,ctrsiramc= 0;
        int ctrsiramp= 0,ctrsiramtom= 0,ctrsiramco= 0,ctrsiramon= 0;
        int xplayer= 0,yplayer= 0;
        String icon= "V",step;
        ArrayList<tanaman> turnip1= new ArrayList<>();
        ArrayList<tanaman> potato1= new ArrayList<>();
        ArrayList<tanaman> cucumber1= new ArrayList<>();
        ArrayList<tanaman> tomato1= new ArrayList<>();
        ArrayList<tanaman> corn1= new ArrayList<>();
        ArrayList<tanaman> onion1= new ArrayList<>();
        ArrayList<tanaman> grass= new ArrayList<>();
        initMap();
        do{
        for(int i= 0;i<panjang;i++) {
         System.out.print("|");
         for(int j= 0;j<lebar;j++) {
          if(j==xplayer && i==yplayer) {
           System.out.print(icon);
          }else System.out.print(map[i][j]);
          System.out.print("|");
         }
         System.out.println();
        }
        System.out.println("Musim: "+musim[ctrmusim]);
        System.out.println("Hari: "+ctrhari);
        System.out.print("Move: ");
        step= input.nextLine();
        if("w".equals(step)){ //w
         icon= "^";
         yplayer--;
         if(yplayer==-1) {
          icon= "V";
          yplayer+=1;
         }
         for(int i= 0;i<grass.size();i++) { //cek grass
          if(xplayer==grass.get(i).getXt() && yplayer==grass.get(i).getYt()) {
           yplayer+=1;
          }
         }
        }else if("a".equals(step)) { //a
         icon= "<";
         xplayer--;
         if(xplayer==-1) {
          icon= ">";
          xplayer+=1;
         }
         for(int i= 0;i<grass.size();i++) { //cek grass
          if(xplayer==grass.get(i).getXt() && yplayer==grass.get(i).getYt()) {
           xplayer+=1;
          }
         }
        }else if("s".equals(step)) { //s
         yplayer++;
         icon= "V";
         if(yplayer==10) {
          icon= "^";
          yplayer-=1;
         }
         for(int i= 0;i<grass.size();i++) { //cek grass
          if(xplayer==grass.get(i).getXt() && yplayer==grass.get(i).getYt()) {
           yplayer-=1;
          }
         }
        }else if("d".equals(step)) { //d
         icon= ">";
         xplayer++;
         if(xplayer==10) {
          icon= "<";
          xplayer-=1;
         }
         for(int i= 0;i<grass.size();i++) { //cek grass
          if(xplayer==grass.get(i).getXt() && yplayer==grass.get(i).getYt()) {
           xplayer-=1;
          }
         }
        }
        else if("t".equals(step) || "T".equals(step)) { //tanam
         System.out.println("1. Turnip");
         System.out.println("2. Potato");
         System.out.println("3. Cucumber");
         System.out.println("4. Tomato");
         System.out.println("5. Corn");
         System.out.println("6. Onion");
         System.out.print("Pilih tanaman: ");
         tmenu= input.nextInt();
         if(tmenu==1) { //turnip
          for(int i= 0;i<9;i++) {
           turnip1.add(new turnip1());
          }
          turnip1.get(0).setXt(xplayer-1);
          turnip1.get(0).setYt(yplayer-1);
          turnip1.get(1).setXt(xplayer);
          turnip1.get(1).setYt(yplayer-1);
          turnip1.get(2).setXt(xplayer+1);
          turnip1.get(2).setYt(yplayer-1);
          turnip1.get(3).setXt(xplayer-1);
          turnip1.get(3).setYt(yplayer);
          turnip1.get(4).setXt(xplayer);
          turnip1.get(4).setYt(yplayer);
          turnip1.get(5).setXt(xplayer+1);
          turnip1.get(5).setYt(yplayer);
          turnip1.get(6).setXt(xplayer-1);
          turnip1.get(6).setYt(yplayer+1);
          turnip1.get(7).setXt(xplayer);
          turnip1.get(7).setYt(yplayer+1);
          turnip1.get(8).setXt(xplayer+1);
          turnip1.get(8).setYt(yplayer+1);
          for(int i= yplayer-1;i<=yplayer+1;i++) {
           for(int j= xplayer-1;j<=xplayer+1;j++) {
            for(int k= 0;k<turnip1.size();k++) {
             if(turnip1.get(k).getMusim().equals(musim[ctrmusim])) {
              map[i][j]= turnip1.get(k).getSymbol();
             }else map[i][j]= turnip1.get(k).getDead();
            }
           }
          }
         }else if(tmenu==2) { //potato
          for(int i= 0;i<9;i++) {
           potato1.add(new potato1());
          }
          potato1.get(0).setXt(xplayer-1);
          potato1.get(0).setYt(yplayer-1);
          potato1.get(1).setXt(xplayer);
          potato1.get(1).setYt(yplayer-1);
          potato1.get(2).setXt(xplayer+1);
          potato1.get(2).setYt(yplayer-1);
          potato1.get(3).setXt(xplayer-1);
          potato1.get(3).setYt(yplayer);
          potato1.get(4).setXt(xplayer);
          potato1.get(4).setYt(yplayer);
          potato1.get(5).setXt(xplayer+1);
          potato1.get(5).setYt(yplayer);
          potato1.get(6).setXt(xplayer-1);
          potato1.get(6).setYt(yplayer+1);
          potato1.get(7).setXt(xplayer);
          potato1.get(7).setYt(yplayer+1);
          potato1.get(8).setXt(xplayer+1);
          potato1.get(8).setYt(yplayer+1);
          for(int i= yplayer-1;i<=yplayer+1;i++) {
           for(int j= xplayer-1;j<=xplayer+1;j++) {
            for(int k= 0;k<potato1.size();k++) {
             if(potato1.get(k).getMusim().equals(musim[ctrmusim])) {
              map[i][j]= potato1.get(k).getSymbol();
             }else map[i][j]= potato1.get(k).getDead();
            }
           }
          }
         }else if(tmenu==3) { //cucumber
          for(int i= 0;i<9;i++) {
           cucumber1.add(new cucumber1());
          }
          cucumber1.get(0).setXt(xplayer-1);
          cucumber1.get(0).setYt(yplayer-1);
          cucumber1.get(1).setXt(xplayer);
          cucumber1.get(1).setYt(yplayer-1);
          cucumber1.get(2).setXt(xplayer+1);
          cucumber1.get(2).setYt(yplayer-1);
          cucumber1.get(3).setXt(xplayer-1);
          cucumber1.get(3).setYt(yplayer);
          cucumber1.get(4).setXt(xplayer);
          cucumber1.get(4).setYt(yplayer);
          cucumber1.get(5).setXt(xplayer+1);
          cucumber1.get(5).setYt(yplayer);
          cucumber1.get(6).setXt(xplayer-1);
          cucumber1.get(6).setYt(yplayer+1);
          cucumber1.get(7).setXt(xplayer);
          cucumber1.get(7).setYt(yplayer+1);
          cucumber1.get(8).setXt(xplayer+1);
          cucumber1.get(8).setYt(yplayer+1);
          for(int i= yplayer-1;i<=yplayer+1;i++) {
           for(int j= xplayer-1;j<=xplayer+1;j++) {
            for(int k= 0;k<cucumber1.size();k++) {
             if(cucumber1.get(k).getMusim().equals(musim[ctrmusim])) {
              map[i][j]= cucumber1.get(k).getSymbol();
             }else map[i][j]= cucumber1.get(k).getDead();
            }
           }
          }
         }else if(tmenu==4) { //tomato
          for(int i= 0;i<9;i++) {
           tomato1.add(new tomato1());
          }
          tomato1.get(0).setXt(xplayer-1);
          tomato1.get(0).setYt(yplayer-1);
          tomato1.get(1).setXt(xplayer);
          tomato1.get(1).setYt(yplayer-1);
          tomato1.get(2).setXt(xplayer+1);
          tomato1.get(2).setYt(yplayer-1);
          tomato1.get(3).setXt(xplayer-1);
          tomato1.get(3).setYt(yplayer);
          tomato1.get(4).setXt(xplayer);
          tomato1.get(4).setYt(yplayer);
          tomato1.get(5).setXt(xplayer+1);
          tomato1.get(5).setYt(yplayer);
          tomato1.get(6).setXt(xplayer-1);
          tomato1.get(6).setYt(yplayer+1);
          tomato1.get(7).setXt(xplayer);
          tomato1.get(7).setYt(yplayer+1);
          tomato1.get(8).setXt(xplayer+1);
          tomato1.get(8).setYt(yplayer+1);
          for(int i= yplayer-1;i<=yplayer+1;i++) {
           for(int j= xplayer-1;j<=xplayer+1;j++) {
            for(int k= 0;k<tomato1.size();k++) {
             if(tomato1.get(k).getMusim().equals(musim[ctrmusim])) {
              map[i][j]= tomato1.get(k).getSymbol();
             }else map[i][j]= tomato1.get(k).getDead();
            }
           }
          }
         }else if(tmenu==5) { //corn
          for(int i= 0;i<9;i++) {
           corn1.add(new corn1());
          }
          corn1.get(0).setXt(xplayer-1);
          corn1.get(0).setYt(yplayer-1);
          corn1.get(1).setXt(xplayer);
          corn1.get(1).setYt(yplayer-1);
          corn1.get(2).setXt(xplayer+1);
          corn1.get(2).setYt(yplayer-1);
          corn1.get(3).setXt(xplayer-1);
          corn1.get(3).setYt(yplayer);
          corn1.get(4).setXt(xplayer);
          corn1.get(4).setYt(yplayer);
          corn1.get(5).setXt(xplayer+1);
          corn1.get(5).setYt(yplayer);
          corn1.get(6).setXt(xplayer-1);
          corn1.get(6).setYt(yplayer+1);
          corn1.get(7).setXt(xplayer);
          corn1.get(7).setYt(yplayer+1);
          corn1.get(8).setXt(xplayer+1);
          corn1.get(8).setYt(yplayer+1);
          for(int i= yplayer-1;i<=yplayer+1;i++) {
           for(int j= xplayer-1;j<=xplayer+1;j++) {
            for(int k= 0;k<corn1.size();k++) {
             if(corn1.get(k).getMusim().equals(musim[ctrmusim])) {
              map[i][j]= corn1.get(k).getSymbol();
             }else map[i][j]= corn1.get(k).getDead();
            }
           }
          }
         }else if(tmenu==6) { //onion
          for(int i= 0;i<9;i++) {
           onion1.add(new onion1());
          }
          onion1.get(0).setXt(xplayer-1);
          onion1.get(0).setYt(yplayer-1);
          onion1.get(1).setXt(xplayer);
          onion1.get(1).setYt(yplayer-1);
          onion1.get(2).setXt(xplayer+1);
          onion1.get(2).setYt(yplayer-1);
          onion1.get(3).setXt(xplayer-1);
          onion1.get(3).setYt(yplayer);
          onion1.get(4).setXt(xplayer);
          onion1.get(4).setYt(yplayer);
          onion1.get(5).setXt(xplayer+1);
          onion1.get(5).setYt(yplayer);
          onion1.get(6).setXt(xplayer-1);
          onion1.get(6).setYt(yplayer+1);
          onion1.get(7).setXt(xplayer);
          onion1.get(7).setYt(yplayer+1);
          onion1.get(8).setXt(xplayer+1);
          onion1.get(8).setYt(yplayer+1);
          for(int i= yplayer-1;i<=yplayer+1;i++) {
           for(int j= xplayer-1;j<=xplayer+1;j++) {
            for(int k= 0;k<onion1.size();k++) {
             if(onion1.get(k).getMusim().equals(musim[ctrmusim])) {
              map[i][j]= onion1.get(k).getSymbol();
             }else map[i][j]= onion1.get(k).getDead();
            }
           }
          }
         }
        }else if("si".equals(step) || "Si".equals(step)) { //siram
         if(">".equals(icon)) {
          if(" ".equals(map[yplayer][xplayer+1])) { //tanah
           System.out.println("Tersiram!");
           ctrsiramg++;
          }else if("t".equals(map[yplayer][xplayer+1])) { //turnip
           System.out.println("Tersiram!");
           ctrsiramt++;
          }else if("p".equals(map[yplayer][xplayer+1])) { //potato
           System.out.println("Tersiram!");
           ctrsiramp++;
          }else if("c".equals(map[yplayer][xplayer+1])) { //cucumber
           System.out.println("Tersiram!");
           ctrsiramc++;
          }else if("m".equals(map[yplayer][xplayer+1])) { //tomato
           System.out.println("Tersiram!");
           ctrsiramtom++;
          }else if("j".equals(map[yplayer][xplayer+1])) { //corn
           System.out.println("Tersiram!");
           ctrsiramco++;
          }else if("o".equals(map[yplayer][xplayer+1])) { //onion
           System.out.println("Tersiram!");
           ctrsiramon++;
          }
         }else if("<".equals(icon)) {
          if(" ".equals(map[yplayer][xplayer-1])) { //tanah
           System.out.println("Tersiram!"); 
           ctrsiramg++;
          }else if("t".equals(map[yplayer][xplayer-1])) { //turnip
           System.out.println("Tersiram!");
           ctrsiramt++;
          }else if("p".equals(map[yplayer][xplayer-1])) { //potato
           System.out.println("Tersiram!");
           ctrsiramp++;
          }else if("c".equals(map[yplayer][xplayer-1])) { //cucumber
           System.out.println("Tersiram!");
           ctrsiramc++;
          }else if("m".equals(map[yplayer][xplayer-1])) { //tomato
           System.out.println("Tersiram!");
           ctrsiramtom++;
          }else if("j".equals(map[yplayer][xplayer-1])) { //corn
           System.out.println("Tersiram!");
           ctrsiramco++;
          }else if("o".equals(map[yplayer][xplayer-1])) { //onion
           System.out.println("Tersiram!");
           ctrsiramon++;
          }
         }else if("^".equals(icon)) {
          if(" ".equals(map[yplayer-1][xplayer])) { //tanah
           System.out.println("Tersiram!"); 
           ctrsiramg++;
          }else if("t".equals(map[yplayer-1][xplayer])) { //turnip
           System.out.println("Tersiram!");
           ctrsiramt++;
          }else if("p".equals(map[yplayer-1][xplayer])) { //potato
           System.out.println("Tersiram!");
           ctrsiramp++;
          }else if("c".equals(map[yplayer-1][xplayer])) { //cucumber
           System.out.println("Tersiram!");
           ctrsiramc++;
          }else if("m".equals(map[yplayer-1][xplayer])) { //tomato
           System.out.println("Tersiram!");
           ctrsiramtom++;
          }else if("j".equals(map[yplayer-1][xplayer])) { //corn
           System.out.println("Tersiram!");
           ctrsiramco++;
          }else if("o".equals(map[yplayer-1][xplayer])) { //onion
           System.out.println("Tersiram!");
           ctrsiramon++;
          }
         }else if("V".equals(icon)) {
          if(" ".equals(map[yplayer+1][xplayer])) { //tanah
           System.out.println("Tersiram!"); 
           ctrsiramg++;
          }else if("t".equals(map[yplayer+1][xplayer])) { //turnip
           System.out.println("Tersiram!");
           ctrsiramt++;
          }else if("p".equals(map[yplayer+1][xplayer])) { //potato
           System.out.println("Tersiram!");
           ctrsiramp++;
          }else if("c".equals(map[yplayer+1][xplayer])) { //cucumber
           System.out.println("Tersiram!");
           ctrsiramc++;
          }else if("m".equals(map[yplayer+1][xplayer])) { //tomato
           System.out.println("Tersiram!");
           ctrsiramtom++;
          }else if("j".equals(map[yplayer+1][xplayer])) { //corn
           System.out.println("Tersiram!");
           ctrsiramco++;
          }else if("o".equals(map[yplayer+1][xplayer])) { //onion
           System.out.println("Tersiram!");
           ctrsiramon++;
          }
         }
        }else if("g".equals(step) ||"G".equals(step)) { //ganti hari
         ctrhari++;
         if(ctrhari%25==0) {
          ctrmusim++;
          if(ctrmusim>=musim.length) {
           ctrmusim= 0;
          }
         }
         for(int i= 0;i<turnip1.size();i++) { //turnip
          if(!turnip1.get(i).getMusim().equals(musim[ctrmusim])) {
           map[turnip1.get(i).getYt()][turnip1.get(i).getXt()]= turnip1.get(i).getDead();
          }
         }
         for(int i= 0;i<potato1.size();i++) { //potato
          if(!potato1.get(i).getMusim().equals(musim[ctrmusim])) {
           map[potato1.get(i).getYt()][potato1.get(i).getXt()]= potato1.get(i).getDead();
          }
         }
         for(int i= 0;i<cucumber1.size();i++) { //cucumber
          if(!cucumber1.get(i).getMusim().equals(musim[ctrmusim])) {
           map[cucumber1.get(i).getYt()][cucumber1.get(i).getXt()]= cucumber1.get(i).getDead();
          }
         }
         for(int i= 0;i<tomato1.size();i++) { //tomato
          if(!tomato1.get(i).getMusim().equals(musim[ctrmusim])) {
           map[tomato1.get(i).getYt()][tomato1.get(i).getXt()]= tomato1.get(i).getDead();
          }
         }
         for(int i= 0;i<corn1.size();i++) { //corn
          if(!corn1.get(i).getMusim().equals(musim[ctrmusim])) {
           map[corn1.get(i).getYt()][corn1.get(i).getXt()]= corn1.get(i).getDead();
          }
         }
         for(int i= 0;i<onion1.size();i++) { //onion
          if(!corn1.get(i).getMusim().equals(musim[ctrmusim])) {
           map[onion1.get(i).getYt()][onion1.get(i).getXt()]= onion1.get(i).getDead();
          }
         }
         if(ctrsiramg>=1) { //grow tanah
          if(">".equals(icon)) {
           grass.add(new grass());
           grass.get(ctrg).setXt(xplayer+1);
           grass.get(ctrg).setYt(yplayer); 
           map[yplayer][xplayer+1]= grass.get(ctrg).getSymbol();
           ctrg++;
          }else if("<".equals(icon)) {
           grass.add(new grass());
           grass.get(ctrg).setXt(xplayer-1);
           grass.get(ctrg).setYt(yplayer);
           map[yplayer][xplayer-1]= grass.get(ctrg).getSymbol();
           ctrg++;
          }else if("^".equals(icon)) {
           grass.add(new grass());
           grass.get(ctrg).setXt(xplayer);
           grass.get(ctrg).setYt(yplayer-1);
           map[yplayer-1][xplayer]= grass.get(ctrg).getSymbol();
           ctrg++;
          }else if("V".equals(icon)) {
           grass.add(new grass());
           grass.get(ctrg).setXt(xplayer);
           grass.get(ctrg).setYt(yplayer+1);
           map[yplayer+1][xplayer]= grass.get(ctrg).getSymbol();
           ctrg++;
          }
          ctrsiramg= 0;
         }
         if(ctrsiramt>=1) { //grow turnip
          if(">".equals(icon)) {
           turnip1.get(0).setUmur(turnip1.get(0).getUmur()+1);
           if(turnip1.get(0).getUmur()>=turnip1.get(0).getGrow()) {
            if(turnip1.get(0).getMusim().equals(musim[ctrmusim])) {
             turnip1.set(0, new turnip2());
             map[yplayer][xplayer+1]= turnip1.get(0).getSymbol();
            }else {
             map[yplayer][xplayer+1]= turnip1.get(0).getDead();
            }
           }
          }else if("<".equals(icon)) {
           turnip1.get(2).setUmur(turnip1.get(2).getUmur()+1);
           if(turnip1.get(2).getUmur()>=turnip1.get(2).getGrow()) {
            if(turnip1.get(2).getMusim().equals(musim[ctrmusim])) {
             turnip1.set(2, new turnip2());
             map[yplayer][xplayer-1]= turnip1.get(2).getSymbol();
            }else {
             map[yplayer][xplayer-1]= turnip1.get(2).getDead();
            }
           }
          }else if("^".equals(icon)) {
           turnip1.get(7).setUmur(turnip1.get(7).getUmur()+1);
           if(turnip1.get(7).getUmur()>=turnip1.get(7).getGrow()) {
            if(turnip1.get(7).getMusim().equals(musim[ctrmusim])) {
             turnip1.set(7, new turnip2());
             map[yplayer-1][xplayer]= turnip1.get(7).getSymbol();
            }else {
             map[yplayer-1][xplayer]= turnip1.get(7).getDead();
            }
           }
          }else if("V".equals(icon)) {
           turnip1.get(1).setUmur(turnip1.get(1).getUmur()+1);
           if(turnip1.get(1).getUmur()>=turnip1.get(1).getGrow()) {
            if(turnip1.get(1).getMusim().equals(musim[ctrmusim])) {
             turnip1.set(1, new turnip2());
             map[yplayer+1][xplayer]= turnip1.get(1).getSymbol();
            }else {;
             map[yplayer+1][xplayer]= turnip1.get(1).getDead();
            }
           }
          }
         }
         if(ctrsiramp>=1) { //grow potato
          if(">".equals(icon)) {
           potato1.get(0).setUmur(potato1.get(0).getUmur()+1);
           if(potato1.get(0).getUmur()>=potato1.get(0).getGrow()) {
            if(potato1.get(0).getMusim().equals(musim[ctrmusim])) {
             potato1.set(0, new potato2());
             map[yplayer][xplayer+1]= potato1.get(0).getSymbol();
            }else {
             map[yplayer][xplayer+1]= potato1.get(0).getDead();
            }
           }
          }else if("<".equals(icon)) {
           potato1.get(2).setUmur(potato1.get(2).getUmur()+1);
           if(potato1.get(2).getUmur()>=potato1.get(2).getGrow()) {
            if(potato1.get(2).getMusim().equals(musim[ctrmusim])) {
             potato1.set(2, new potato2());
             map[yplayer][xplayer-1]= potato1.get(2).getSymbol();
            }else {
             map[yplayer][xplayer-1]= potato1.get(2).getDead();
            }
           }
          }else if("^".equals(icon)) {
           potato1.get(7).setUmur(potato1.get(7).getUmur()+1);
           if(potato1.get(7).getUmur()>=potato1.get(7).getGrow()) {
            if(potato1.get(7).getMusim().equals(musim[ctrmusim])) {
             potato1.set(7, new potato2());
             map[yplayer-1][xplayer]= potato1.get(7).getSymbol();
            }else {
             map[yplayer-1][xplayer]= potato1.get(7).getDead();
            }
           }
          }else if("V".equals(icon)) {
           potato1.get(1).setUmur(potato1.get(1).getUmur()+1);
           if(potato1.get(1).getUmur()>=potato1.get(1).getGrow()) {
            if(potato1.get(1).getMusim().equals(musim[ctrmusim])) {
             potato1.set(1, new potato2());
             map[yplayer+1][xplayer]= potato1.get(1).getSymbol();
            }else {;
             map[yplayer+1][xplayer]= potato1.get(1).getDead();
            }
           }
          }
         }
         if(ctrsiramc>=1) { //grow cucumber
          if(">".equals(icon)) {
           cucumber1.get(0).setUmur(cucumber1.get(0).getUmur()+1);
           if(cucumber1.get(0).getUmur()>=cucumber1.get(0).getGrow()) {
            if(cucumber1.get(0).getMusim().equals(musim[ctrmusim])) {
             cucumber1.set(0, new cucumber2());
             map[yplayer][xplayer+1]= cucumber1.get(0).getSymbol();
            }else {
             map[yplayer][xplayer+1]= cucumber1.get(0).getDead();
            }
           }
          }else if("<".equals(icon)) {
           cucumber1.get(2).setUmur(cucumber1.get(2).getUmur()+1);
           if(cucumber1.get(2).getUmur()>=cucumber1.get(2).getGrow()) {
            if(cucumber1.get(2).getMusim().equals(musim[ctrmusim])) {
             cucumber1.set(2, new cucumber2());
             map[yplayer][xplayer-1]= cucumber1.get(2).getSymbol();
            }else {
             map[yplayer][xplayer-1]= cucumber1.get(2).getDead();
            }
           }
          }else if("^".equals(icon)) {
           cucumber1.get(7).setUmur(cucumber1.get(7).getUmur()+1);
           if(cucumber1.get(7).getUmur()>=cucumber1.get(7).getGrow()) {
            if(cucumber1.get(7).getMusim().equals(musim[ctrmusim])) {
             cucumber1.set(7, new cucumber2());
             map[yplayer-1][xplayer]= cucumber1.get(7).getSymbol();
            }else {
             map[yplayer-1][xplayer]= cucumber1.get(7).getDead();
            }
           }
          }else if("V".equals(icon)) {
           cucumber1.get(1).setUmur(cucumber1.get(1).getUmur()+1);
           if(cucumber1.get(1).getUmur()>=cucumber1.get(1).getGrow()) {
            if(cucumber1.get(1).getMusim().equals(musim[ctrmusim])) {
             cucumber1.set(1, new cucumber2());
             map[yplayer+1][xplayer]= cucumber1.get(1).getSymbol();
            }else {
             map[yplayer+1][xplayer]= cucumber1.get(1).getDead();
            }
           }
          }
         }
         if(ctrsiramtom>=1) { //grow tomato
          if(">".equals(icon)) {
           tomato1.get(0).setUmur(tomato1.get(0).getUmur()+1);
           if(tomato1.get(0).getUmur()>=tomato1.get(0).getGrow()) {
            if(tomato1.get(0).getMusim().equals(musim[ctrmusim])) {
             tomato1.set(0, new tomato2());
             map[yplayer][xplayer+1]= tomato1.get(0).getSymbol();
            }else {
             map[yplayer][xplayer+1]= tomato1.get(0).getDead();
            }
           }
          }else if("<".equals(icon)) {
           tomato1.get(2).setUmur(tomato1.get(2).getUmur()+1);
           if(tomato1.get(2).getUmur()>=tomato1.get(2).getGrow()) {
            if(tomato1.get(2).getMusim().equals(musim[ctrmusim])) {
             tomato1.set(2, new tomato2());
             map[yplayer][xplayer-1]= tomato1.get(2).getSymbol();
            }else {
             map[yplayer][xplayer-1]= tomato1.get(2).getDead();
            }
           }
          }else if("^".equals(icon)) {
           tomato1.get(7).setUmur(tomato1.get(7).getUmur()+1);
           if(tomato1.get(7).getUmur()>=tomato1.get(7).getGrow()) {
            if(tomato1.get(7).getMusim().equals(musim[ctrmusim])) {
             tomato1.set(7, new tomato2());
             map[yplayer-1][xplayer]= tomato1.get(7).getSymbol();
            }else {
             map[yplayer-1][xplayer]= tomato1.get(7).getDead();
            }
           }
          }else if("V".equals(icon)) {
           tomato1.get(1).setUmur(tomato1.get(1).getUmur()+1);
           if(tomato1.get(1).getUmur()>=tomato1.get(1).getGrow()) {
            if(tomato1.get(1).getMusim().equals(musim[ctrmusim])) {
             tomato1.set(1, new tomato2());
             map[yplayer+1][xplayer]= tomato1.get(1).getSymbol();
            }else {;
             map[yplayer+1][xplayer]= tomato1.get(1).getDead();
            }
           }
          }
         }
         if(ctrsiramco>=1) { //grow corn
          if(">".equals(icon)) {
           corn1.get(0).setUmur(corn1.get(0).getUmur()+1);
           if(corn1.get(0).getUmur()>=corn1.get(0).getGrow()) {
            if(corn1.get(0).getMusim().equals(musim[ctrmusim])) {
             corn1.set(0, new corn2());
             map[yplayer][xplayer+1]= corn1.get(0).getSymbol();
            }else {
             map[yplayer][xplayer+1]= corn1.get(0).getDead();
            }
           }
          }else if("<".equals(icon)) {
           corn1.get(2).setUmur(corn1.get(2).getUmur()+1);
           if(corn1.get(2).getUmur()>=corn1.get(2).getGrow()) {
            if(corn1.get(2).getMusim().equals(musim[ctrmusim])) {
             corn1.set(2, new corn2());
             map[yplayer][xplayer-1]= corn1.get(2).getSymbol();
            }else {
             map[yplayer][xplayer-1]= corn1.get(2).getDead();
            }
           }
          }else if("^".equals(icon)) {
           corn1.get(7).setUmur(corn1.get(7).getUmur()+1);
           if(corn1.get(7).getUmur()>=corn1.get(7).getGrow()) {
            if(corn1.get(7).getMusim().equals(musim[ctrmusim])) {
             corn1.set(7, new corn2());
             map[yplayer-1][xplayer]= corn1.get(7).getSymbol();
            }else {
             map[yplayer-1][xplayer]= corn1.get(7).getDead();
            }
           }
          }else if("V".equals(icon)) {
           corn1.get(1).setUmur(corn1.get(1).getUmur()+1);
           if(corn1.get(1).getUmur()>=corn1.get(1).getGrow()) {
            if(corn1.get(1).getMusim().equals(musim[ctrmusim])) {
             corn1.set(1, new corn2());
             map[yplayer+1][xplayer]= corn1.get(1).getSymbol();
            }else {;
             map[yplayer+1][xplayer]= corn1.get(1).getDead();
            }
           }
          }
         }
         if(ctrsiramon>=1) { //grow onion
          if(">".equals(icon)) {
           onion1.get(0).setUmur(onion1.get(0).getUmur()+1);
           if(onion1.get(0).getUmur()>=onion1.get(0).getGrow()) {
            if(onion1.get(0).getMusim().equals(musim[ctrmusim])) {
             onion1.set(0, new onion2());
             map[yplayer][xplayer+1]= onion1.get(0).getSymbol();
            }else {
             map[yplayer][xplayer+1]= onion1.get(0).getDead();
            }
           }
          }else if("<".equals(icon)) {
           onion1.get(2).setUmur(onion1.get(2).getUmur()+1);
           if(onion1.get(2).getUmur()>=onion1.get(2).getGrow()) {
            if(onion1.get(2).getMusim().equals(musim[ctrmusim])) {
             onion1.set(2, new onion2());
             map[yplayer][xplayer-1]= onion1.get(2).getSymbol();
            }else {
             map[yplayer][xplayer-1]= onion1.get(2).getDead();
            }
           }
          }else if("^".equals(icon)) {
           onion1.get(7).setUmur(onion1.get(7).getUmur()+1);
           if(onion1.get(7).getUmur()>=onion1.get(7).getGrow()) {
            if(onion1.get(7).getMusim().equals(musim[ctrmusim])) {
             onion1.set(7, new onion2());
             map[yplayer-1][xplayer]= onion1.get(7).getSymbol();
            }else {
             map[yplayer-1][xplayer]= onion1.get(7).getDead();
            }
           }
          }else if("V".equals(icon)) {
           onion1.get(1).setUmur(onion1.get(1).getUmur()+1);
           if(onion1.get(1).getUmur()>=onion1.get(1).getGrow()) {
            if(onion1.get(1).getMusim().equals(musim[ctrmusim])) {
             onion1.set(1, new onion2());
             map[yplayer+1][xplayer]= onion1.get(1).getSymbol();
            }else {;
             map[yplayer+1][xplayer]= onion1.get(1).getDead();
            }
           }
          }
         }
        }else if("p".equals(step) || "P".equals(step)) { //panen
         if(">".equals(icon)) {
          if("T".equals(map[yplayer][xplayer+1])) { //turnip
           map[yplayer][xplayer+1]= " ";
           turnip1.remove(0);
          }else if("P".equals(map[yplayer][xplayer+1])) { //potato
           map[yplayer][xplayer+1]= " ";
           potato1.remove(0);
          }else if("C".equals(map[yplayer][xplayer+1])) { //cucumber
           cucumber1.set(0, new cucumber1());
           map[yplayer][xplayer+1]= cucumber1.get(0).getSymbol();
          }else if("M".equals(map[yplayer][xplayer+1])) { //tomato
           tomato1.set(0, new tomato1());
           map[yplayer][xplayer+1]= tomato1.get(0).getSymbol();
          }else if("J".equals(map[yplayer][xplayer+1])) { //corn
           corn1.set(0, new corn1());
           map[yplayer][xplayer+1]= corn1.get(0).getSymbol();
          }else if("O".equals(map[yplayer][xplayer+1])) { //onion
           map[yplayer][xplayer+1]= " ";
           onion1.remove(0);
          }
         }else if("<".equals(icon)) {
          if("T".equals(map[yplayer][xplayer-1])) { //turnip
           map[yplayer][xplayer-1]= " ";
           turnip1.remove(2);
          }else if("P".equals(map[yplayer][xplayer-1])) { //potato
           map[yplayer][xplayer-1]= " ";
           potato1.remove(2);
          }else if("C".equals(map[yplayer][xplayer-1])) { //cucumber
           cucumber1.set(2, new cucumber1());
           map[yplayer][xplayer-1]= cucumber1.get(2).getSymbol();
          }else if("M".equals(map[yplayer][xplayer-1])) { //tomato
           tomato1.set(2, new tomato1());
           map[yplayer][xplayer-1]= tomato1.get(2).getSymbol();
          }else if("J".equals(map[yplayer][xplayer-1])) { //corn
           corn1.set(2, new corn1());
           map[yplayer][xplayer-1]= corn1.get(2).getSymbol();
          }else if("O".equals(map[yplayer][xplayer-1])) { //onion
           map[yplayer][xplayer-1]= " ";
           onion1.remove(2);
          }
         }else if("^".equals(icon)) {
          if("T".equals(map[yplayer-1][xplayer])) { //turnip
           map[yplayer-1][xplayer]= " ";
           turnip1.remove(7);
          }else if("P".equals(map[yplayer-1][xplayer])) { //potato
           map[yplayer-1][xplayer]= " ";
           potato1.remove(7);
          }else if("C".equals(map[yplayer-1][xplayer])) { //cucumber
           cucumber1.set(7, new cucumber1());
           map[yplayer-1][xplayer]= cucumber1.get(7).getSymbol();
          }else if("M".equals(map[yplayer-1][xplayer])) { //tomato
           tomato1.set(7, new tomato1());
           map[yplayer-1][xplayer]= tomato1.get(7).getSymbol();
          }else if("J".equals(map[yplayer-1][xplayer])) { //corn
           corn1.set(7, new corn1());
           map[yplayer-1][xplayer]= cucumber1.get(7).getSymbol();
          }else if("O".equals(map[yplayer-1][xplayer])) { //onion
           map[yplayer-1][xplayer]= " ";
           onion1.remove(7);
          }
         }else if("V".equals(icon)) {
          if("T".equals(map[yplayer+1][xplayer])) { //turnip
           map[yplayer+1][xplayer]= " ";
           turnip1.remove(1);
          }else if("P".equals(map[yplayer+1][xplayer])) { //potato
           map[yplayer+1][xplayer]= " ";
           potato1.remove(1);
          }else if("C".equals(map[yplayer+1][xplayer])) { //cucumber
           cucumber1.set(1, new cucumber1());
           map[yplayer+1][xplayer]= cucumber1.get(1).getSymbol();
          }else if("M".equals(map[yplayer+1][xplayer])) { //tomato
           tomato1.set(1, new tomato1());
           map[yplayer+1][xplayer]= tomato1.get(1).getSymbol();
          }else if("J".equals(map[yplayer+1][xplayer])) { //corn
           corn1.set(1, new corn1());
           map[yplayer+1][xplayer]= corn1.get(1).getSymbol();
          }else if("O".equals(map[yplayer+1][xplayer])) { //onion
           map[yplayer+1][xplayer]= " ";
           onion1.remove(1);
          }
         }
        }
        }while(true);  
    }
}
