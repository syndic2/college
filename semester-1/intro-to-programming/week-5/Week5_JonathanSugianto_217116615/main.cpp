#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#include <conio.h>

using namespace std;

int main ()
{
int lebar=15;
int panjang=15;
int xplayer=1;
int yplayer=1;
int xmusuh1,ymusuh1;
int xmusuh2,ymusuh2;
int scoreplayer=0;
int scoremusuh1=-1;
int scoremusuh2=-1;
int gunting=1,batu=2,kertas=3;
int pilihplayer;
int pilihmusuh;
int hpplayer=1,hpmusuh1=1,hpmusuh2=1;
int milidetik=0,detik=0;
char peta[lebar][panjang];

srand(time(0));
xmusuh1=rand()%13+1;
ymusuh1=rand()%13+1;
xmusuh2=rand()%13+1;
ymusuh2=rand()%13+1;

    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             peta[j][i]='.';
            }
        }

    do{
       milidetik++;
       if(milidetik%10==0)
            {
             detik++;
             if(detik%3==0)
                {
                 xmusuh1=rand()%13+1;
                 ymusuh1=rand()%13+1;
                 xmusuh2=rand()%13+1;
                 ymusuh2=rand()%13+1;
                }
             Sleep(53);
            }
    cout<< "Score Player : "<<scoreplayer<<endl;
    cout<< "Score Musuh 1: "<<scoremusuh1<<endl;
    cout<< "Score Musuh 2: "<<scoremusuh2<<endl;
    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             cout<<"|";
             if(xplayer==j && yplayer==i)
                {
                 cout<< "P";
                }
             else if(xmusuh1==j && ymusuh1==i)
                {
                 cout<< "M";
                 if(hpmusuh1==0)
                    {
                     xmusuh1=16;
                     ymusuh1=16;
                    }
                }
             else if(xmusuh2==j && ymusuh2==i)
                {
                 cout<< "M";
                 if(hpmusuh2==0)
                    {
                     xmusuh2=16;
                     ymusuh2=16;
                    }
                }
             else{cout<< peta[j][i];}
            }
            cout<<"|";
         cout<< endl;
        }

    if(GetAsyncKeyState('W'))
        {
         yplayer--;
         if(peta[xplayer][yplayer]=='.')
            {
             peta[xplayer][yplayer]=' ';
             scoreplayer+=1;
            }
         if(yplayer==-1)
            {
             yplayer++;
            }
        }
    else if(GetAsyncKeyState('A'))
        {
         xplayer--;
         if(peta[xplayer][yplayer]=='.')
            {
             peta[xplayer][yplayer]=' ';
             scoreplayer+=1;
            }
         if(xplayer==-1)
            {
             xplayer++;
            }
        }
    else if(GetAsyncKeyState('S'))
        {
         yplayer++;
         if(peta[xplayer][yplayer]=='.')
            {
             peta[xplayer][yplayer]=' ';
             scoreplayer+=1;
            }
         if(yplayer==15)
            {
             yplayer--;
            }
        }
    else if(GetAsyncKeyState('D'))
        {
         xplayer++;
         if(peta[xplayer][yplayer]=='.')
            {
             peta[xplayer][yplayer]=' ';
             scoreplayer+=1;
            }
         if(xplayer==15)
            {
             xplayer--;
            }
        }

    if(peta[xmusuh1][ymusuh1]=='.')
        {
         scoremusuh1+=1;
         peta[xmusuh1][ymusuh1]=' ';
        }

    if(peta[xmusuh2][ymusuh2]=='.')
        {
         scoremusuh2+=1;
         peta[xmusuh2][ymusuh2]=' ';
        }

    if(xplayer==xmusuh1-1 && yplayer==ymusuh1 || xplayer==xmusuh1+1 && yplayer==ymusuh1 ||
       xplayer==xmusuh1 && yplayer==ymusuh1-1 || xplayer==xmusuh1 && yplayer==ymusuh1+1 ||
       xplayer==xmusuh2-1 && yplayer==ymusuh2 || xplayer==xmusuh2+1 && yplayer==ymusuh2 ||
       xplayer==xmusuh2 && yplayer==ymusuh2-1 || xplayer==xmusuh2 && yplayer==ymusuh2+1)
        {
         if(xplayer==xmusuh1-1 && yplayer==ymusuh1 || xplayer==xmusuh1+1 && yplayer==ymusuh1 ||
            xplayer==xmusuh1 && yplayer==ymusuh1-1 || xplayer==xmusuh1 && yplayer==ymusuh1+1)
            {
             do{
             pilihmusuh=rand()%3+1;
             system("CLS");
             cout<< "Pilihan: "<<endl;
             cout<< gunting<<"."<<"Gunting"<<endl;
             cout<< batu<<"."<<"Batu"<<endl;
             cout<< kertas<<"."<<"Kertas"<<endl;
             cout<< "=================="<<endl;
             cout<< "PLAYER"<<endl;
             cout<< "Pilihan player: ";
             cin>> pilihplayer;
             cout<< endl;
             cout<< "=================="<<endl;
             cout<< "MUSUH"<<endl;
             cout<< "Piihan musuh: "<<pilihmusuh;
             getch();
             if(pilihplayer==gunting && pilihmusuh==3)
                {
                 cout<<endl<<"Player Win!"<<endl;
                 hpmusuh1-=1;
                 xmusuh1=16;
                 ymusuh1=16;
                }
             if(pilihplayer==batu && pilihmusuh==1)
                {
                 cout<<endl<<"Player Win!"<<endl;
                 hpmusuh1-=1;
                 xmusuh1=16;
                 ymusuh1=16;
                }
             if(pilihplayer==kertas && pilihmusuh==2)
                {
                 cout<<endl<<"Player Win!"<<endl;
                 hpmusuh1-=1;
                 xmusuh1=16;
                 ymusuh1=16;
                }

             if(pilihplayer==gunting && pilihmusuh==2)
                {
                 cout<<endl<<"Enemey Win !";
                 hpplayer-=1;
                }
             if(pilihplayer==batu && pilihmusuh==3)
                {
                 cout<<endl<<"Enemey Win !";
                 hpplayer-=1;
                }
             if(pilihplayer==kertas && pilihmusuh==1)
                {
                 cout<<endl<<"Enemey Win !";
                 hpplayer-=1;
                }
             if(pilihplayer==pilihmusuh)
                {
                 cout<<endl<<"DRAW!";
                 getch();
                }
             }while(hpplayer!=0 && hpmusuh1!=0);
            }
             if(hpplayer==0)
                {
                 hpplayer=1;
                 hpmusuh1=1;
                 hpmusuh2=1;
                 xplayer=1;
                 yplayer=1;
                 xmusuh1=rand()%13+1;
                 ymusuh1=rand()%13+1;
                 xmusuh2=rand()%13+1;
                 ymusuh2=rand()%13+1;
                 for(int i=0;i<panjang;i++)
                    {
                     for(int j=0;j<lebar;j++)
                        {
                         peta[j][i]='.';
                        }
                    }
                 scoreplayer=0;
                 scoremusuh1=-1;
                 scoremusuh2=-1;
                 detik=0;
                }

         if(xplayer==xmusuh2-1 && yplayer==ymusuh2 || xplayer==xmusuh2+1 && yplayer==ymusuh2 ||
            xplayer==xmusuh2 && yplayer==ymusuh2-1 || xplayer==xmusuh2 && yplayer==ymusuh2+1)
            {
             do{
             pilihmusuh=rand()%3+1;
             system("CLS");
             cout<< "Pilihan: "<<endl;
             cout<< gunting<<"."<<"Gunting"<<endl;
             cout<< batu<<"."<<"Batu"<<endl;
             cout<< kertas<<"."<<"Kertas"<<endl;
             cout<< "=================="<<endl;
             cout<< "PLAYER"<<endl;
             cout<< "Pilihan player: "; cin>> pilihplayer;
             cout<< endl;
             cout<< "=================="<<endl;
             cout<< "MUSUH"<<endl;
             cout<< "Piihan musuh: "<<pilihmusuh;
             if(pilihplayer==gunting && pilihmusuh==3)
                {
                 cout<<endl<<"Player Win!";
                 hpmusuh2-=1;
                 xmusuh2=16;
                 ymusuh2=16;
                }
             if(pilihplayer==batu && pilihmusuh==1)
                {
                 cout<<endl<<"Player Win!"<<endl;
                 hpmusuh2-=1;
                 xmusuh2=16;
                 ymusuh2=16;
                }
             if(pilihplayer==kertas && pilihmusuh==2)
                {
                 cout<<endl<<"Player Win!"<<endl;
                 hpmusuh2-=1;
                 xmusuh2=16;
                 ymusuh2=16;
                }

             if(pilihplayer==gunting && pilihmusuh==2)
                {
                 cout<<endl<<"Enemey Win !";
                 hpplayer-=1;
                }
             if(pilihplayer==batu && pilihmusuh==3)
                {
                 cout<<endl<<"Enemey Win !";
                 hpplayer-=1;
                }
             if(pilihplayer==kertas && pilihmusuh==1)
                {
                 cout<<endl<<"Enemey Win !";
                 hpplayer-=1;
                }
             if(pilihplayer==pilihmusuh)
                {
                 cout<<endl<<"DRAW!";
                 getch();
                }
             }while(hpplayer!=0 && hpmusuh2!=0);
            }
          if(hpplayer==0)
            {
             hpplayer=1;
             hpmusuh1=1;
             hpmusuh2=1;
             xplayer=1;
             yplayer=1;
             xmusuh1=rand()%13+1;
             ymusuh1=rand()%13+1;
             xmusuh2=rand()%13+1;
             ymusuh2=rand()%13+1;
             for(int i=0;i<panjang;i++)
                {
                 for(int j=0;j<lebar;j++)
                    {
                     peta[j][i]='.';
                    }
                }
             scoreplayer=0;
             scoremusuh1=-1;
             scoremusuh2=-1;
             detik=0;
            }
         getch();
        }

     while(xmusuh1==xmusuh2 && ymusuh1==ymusuh2)
        {
         xmusuh1=rand()%13+1;
         ymusuh1=rand()%13+1;
         xmusuh2=rand()%13+1;
         ymusuh2=rand()%13+1;
        }
     system("CLS");
    }while(hpmusuh1!=0 || hpmusuh2!=0);
    cout<< "TERIMA KASIH TELAH BERMAIN! ";

return 0;
}
