package typershark;
import java.util.*;

public class TyperShark 
{
    public static void main(String[] args) 
    {
        Scanner input= new Scanner(System.in);
        Scanner string= new Scanner(System.in);
        
        int panjang= 10;
        int lebar= 20;
        
        String insert;
        String jawab;
        int hpplayer= 100;
        int scoreplayer= 0;
        int play= 0;
        int wrong= 0;
        
        String[][] map= new String[panjang][lebar];
        
        ArrayList<String> kata= new ArrayList<>();
        ArrayList<Integer> xkata= new ArrayList<>();
        ArrayList<Integer> ykata= new ArrayList<>();
        ArrayList<String> listpotong= new ArrayList<>();
        ArrayList<String> answer= new ArrayList<>();
        
        int xkoor= 0;
        int randy= (int) (Math.random()*8+1);
        
        do{
        System.out.print ("Masukkan kata: ");
        insert= string.nextLine();
        
        if("-".equals(insert)) {}
        else
        {
         kata.add(insert);
        }     
        }while(!"-".equals(insert));
        
        /*//index kata
        for(int i= 0;i<kata.size();i++) 
        {
         System.out.println (i+". "+kata.get(i));
        }*/
        
        for(int i= 0;i<kata.size();i++) 
        {
         String[] split= kata.get(i).split("");
         for(int j= 0;j<split.length;j++) 
         {
          listpotong.add(split[j]);
          xkoor= 18-kata.get(i).length();
          xkata.add(xkoor);
          ykata.add(randy);
         }
        }
        
        for(int x1= 0;x1<xkata.size();x1++) 
        {
         for(int x2= x1;x2<xkata.size();x2++) 
         {
          xkata.set(x2, xkata.get(x1)+1);
         }
        }
        
        /*//list potong
        for(int i= 0;i<listpotong.size();i++) 
        {
         System.out.print (i+". "+listpotong.get(i)+" ");
        }
        
        //cetak koor trace
        System.out.println ();
        for(int i= 0;i<xkata.size();i++) 
        {
         System.out.println (i+". X: "+xkata.get(i));
        }
        
        for(int i= 0;i<ykata.size();i++) 
        {
         System.out.println (i+". Y: "+ykata.get(i));
        }*/
        
        do{
        //isi map
        for(int i= 0;i<panjang;i++) 
        {
         for(int j= 0;j<lebar;j++) 
         {
          for(int i2= 0;i2<ykata.size();i2++) 
          {
           for(int j2= 0;j2<xkata.size();j2++)
           {
            for(int grt= 0;grt<listpotong.size();grt++) 
            {
             if(i==0 || i==panjang-1 || j==0 || j==lebar-1) 
             {
              map[i][j]= "#";
             }
             else if(xkata.get(j2)==j && ykata.get(i2)==i) 
             {
              map[i][17-grt]= listpotong.get(grt);
             }
             else
             {
              map[i][j]= " ";
             }
            }
           }
          }
         }
        }
        
        for(int i= 0;i<panjang;i++) 
        {
         for(int j= 0;j<lebar;j++) 
         {
          System.out.print (map[i][j]);
         }
         System.out.println ();
        }
        System.out.println ("Score: "+scoreplayer); 
        System.out.println ("HP: "+hpplayer);
        System.out.print ("Input: ");
        jawab= string.nextLine();
        answer.add(jawab);
        play++;
        
        //cek jawab
        for(int a= 0;a<answer.size();a++) 
        {
         for(int s= 0;s<kata.size();s++) 
         {
          if(answer.get(a).equals(kata.get(s))) 
          {
           scoreplayer+=2;
           for(int p= 0;p<listpotong.size();p++) 
           {
            xkata.set(p, -1);
            ykata.set(p, -1);
           }
           a= answer.size();
           s= kata.size();
          }
         }
        }
        
        }while(hpplayer>0);
        
    }
    
}
