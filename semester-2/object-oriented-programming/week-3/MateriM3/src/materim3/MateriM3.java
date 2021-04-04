package materim3;
import java.util.*;

public class MateriM3 {
    public static void main(String[] args) {
        Scanner input= new Scanner (System.in);
        Scanner string= new Scanner (System.in);
        
        int menu;
        int buyt,buyh;
        int siram= 0,panen;
        int pakan,produksi;
        int gold= 500;
        
        ArrayList<farm> plant= new ArrayList<>();
        ArrayList<farm> animal= new ArrayList<>();
        
        //tanaman
        plant.add(new farm());
        plant.get(0).setJenis("Turnip");
        plant.get(0).setHBeli(120);
        plant.get(0).setHJual(360);
        plant.get(0).setUmur(0);
        plant.add(new farm());
        plant.get(1).setJenis("Eggplant");
        plant.get(1).setHBeli(200);
        plant.get(1).setHJual(550);
        plant.get(1).setUmur(0);
        plant.add(new farm());
        plant.get(2).setJenis("Potato");
        plant.get(2).setHBeli(150);
        plant.get(2).setHJual(480);
        plant.get(2).setUmur(0);
        int ctrp= 0;
        
        //hewan
        animal.add(new farm());
        animal.get(0).setJenis("Ayam");
        animal.get(0).setHBeli(300);
        animal.get(0).setHJual(50);
        animal.get(0).setUmur(0);
        animal.get(0).setCTRPakan(0);
        animal.add(new farm());
        animal.get(1).setJenis("Sapi");
        animal.get(1).setHBeli(500);
        animal.get(1).setHJual(100);
        animal.get(1).setUmur(0);
        animal.get(1).setCTRPakan(0);
        int ctra= 0;
        
        do{
        System.out.println ("Your Gold: "+gold+" Gold");
        System.out.println ("Jumlah tanaman: "+ctrp);
        System.out.println ("Jumlah hewan: "+ctra);
        System.out.println ("1. Ganti hari");
        System.out.println ("2. Beli bibit");
        System.out.println ("3. Siram");
        System.out.println ("4. Panen");
        System.out.println ("5. Beli hewan");
        System.out.println ("6. Beri makan");
        System.out.println ("7. Exit");
        System.out.print ("Pilih: ");
        menu= input.nextInt();
        
        if(menu==1) {
         plant.get(siram-1).setUmur(plant.get(siram-1).getUmur()+1);
         for(int i= 0;i<ctra;i++) {
          System.out.println ((i+1)+". "+animal.get(i).getJenis()+" - "+
                              animal.get(i).getUmur()+" hari");
         }
         System.out.print ("Produksi: ");
         produksi= input.nextInt();
         if(animal.get(produksi-1).getUmur()==2 || animal.get(produksi-1).getUmur()==3) {
          gold= gold+animal.get(produksi-1).getHJual();
         }
         else{
          System.out.println ("Belum cukup hari untuk produksi");
         }
         
        }else if(menu==2) {
        for(int i= 0;i<plant.size();i++) {
         System.out.println ((i+1)+". "+plant.get(i).getJenis()+" - "+plant.get(i).getHBeli());
        }
         System.out.print ("Beli: ");
         buyt= input.nextInt();
         gold= gold-plant.get(buyt-1).getHBeli();
         ctrp++;
        }else if(menu==3) {
         for(int i= 0;i<ctrp;i++) {
          System.out.println ((i+1)+". "+plant.get(i).getJenis()+" - "+plant.get(i).getUmur()+" hari");
         }
         System.out.print ("Siram: ");
         siram= input.nextInt();
        }else if(menu==4) {
         for(int i= 0;i<ctrp;i++) {
          if(plant.get(i).getUmur()==3 || plant.get(i).getUmur()==5 ||
            plant.get(i).getUmur()==6) {
              System.out.println ((i+1)+". "+plant.get(i).getJenis()+" - "+plant.get(i).getUmur());
          }
         }
         System.out.print ("Panen: ");
         panen= input.nextInt();
         plant.remove(panen-1);
         gold= gold+plant.get(panen-1).getHJual();
         
        }else if(menu==5) {
         for(int i= 0;i<animal.size();i++) {
          System.out.println ((i+1)+". "+animal.get(i).getJenis()+" - "+animal.get(i).getHBeli());
         }
         System.out.print ("Beli: ");
         buyh= input.nextInt();
         gold= gold-animal.get(buyh-1).getHBeli();
         ctra++;
        }else if(menu==6) {
         for(int i= 0;i<ctra;i++) {
          System.out.println ((i+1)+". "+animal.get(i).getJenis()+" - "+animal.get(i).getUmur());
         }
         System.out.print ("Pakan: ");
         pakan= input.nextInt();
         if(animal.get(pakan-1).getCTRPakan()<1) {
          animal.get(pakan-1).setUmur(animal.get(pakan-1).getUmur()+1);
          animal.get(pakan-1).setCTRPakan(animal.get(pakan-1).getCTRPakan()+1);
         }
         else{
         System.out.println ("Sudah di beri pakan!");
        }
        }
        
        }while(menu!=7);
    }
}
