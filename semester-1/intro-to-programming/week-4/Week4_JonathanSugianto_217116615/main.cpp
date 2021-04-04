#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#include <conio.h>

using namespace std;

int main ()
{
int tinggi=25;
int lebar=60;
int xmusuh1,ymusuh1,xmusuh2,ymusuh2,xmusuh3,ymusuh3,xmusuh4,ymusuh4,xmusuh5,ymusuh5;
int xchpinggir1,ychpinggir1;
int xchpinggir2,ychpinggir2;
int xchatas,ychatas;
int xchbawah,ychbawah;
int xchtengah,ychtengah;
int score=0;
int detik= 0,milidetik=0;
char stop=13;

xchtengah=6;
ychtengah=6;
xchatas=6;
ychatas=5;
xchpinggir1=5;
ychpinggir1=6;
xchpinggir2=7;
ychpinggir2=6;
xchbawah=6;
ychbawah=7;

xmusuh1=rand()%58+2;
ymusuh1=rand()%23+2;
xmusuh2=rand()%58+2;
ymusuh2=rand()%23+2;
xmusuh3=rand()%58+2;
ymusuh3=rand()%23+2;
xmusuh4=rand()%58+2;
ymusuh4=rand()%23+2;
xmusuh5=rand()%58+2;
ymusuh5=rand()%23+2;

    do{
       milidetik++;
       if(milidetik%10==0)
            {
             detik++;
             if(detik%10==0)
                {
                 xmusuh1=rand()%58+2;
                 ymusuh1=rand()%23+2;
                 xmusuh2=rand()%58+2;
                 ymusuh2=rand()%23+2;
                 xmusuh3=rand()%58+2;
                 ymusuh3=rand()%23+2;
                 xmusuh4=rand()%58+2;
                 ymusuh4=rand()%23+2;
                 xmusuh5=rand()%58+2;
                 ymusuh5=rand()%23+2;
                }
            }
    cout<< "Score : " <<score<<endl;
    cout<< "Waktu bermain : " <<detik<<" Detik"<<endl;
    for(int i=1;i<=tinggi;i=i+1)
        {
         for(int j=1;j<=lebar;j=j+1)
            {
             if (xchatas==j && ychatas==i)
                {
                 cout<< "|";
                }
             else if(xchtengah==j && ychtengah==i)
                {
                 cout<< "+";
                }
             else if(xchpinggir1==j && ychpinggir1==i)
                {
                 cout<< "-";
                }
             else if(xchpinggir2==j && ychpinggir2==i)
                {
                 cout<< "-";
                }
             else if(xchbawah==j && ychbawah==i)
                {
                 cout<< "|";
                }
             else if(xmusuh1==j && ymusuh1==i)
                {
                 cout<< "m";
                }
             else if(xmusuh2==j && ymusuh2==i)
                {
                 cout<< "m";
                }
             else if(xmusuh3==j && ymusuh3==i)
                {
                 cout<< "m";
                }
             else if(xmusuh4==j && ymusuh4==i)
                {
                 cout<< "m";
                }
             else if(xmusuh5==j && ymusuh5==i)
                {
                 cout<< "m";
                }
             else if(i==1 || i==tinggi || j==1 || j==lebar)
                {
                cout<< "=";
                }
             else
                {
                 cout<< " ";
                }
            }
         cout<< endl;
        }

        if(xchtengah==xmusuh1 && ychtengah==ymusuh1 || xchtengah==xmusuh2 && ychtengah==ymusuh2 ||
            xchtengah==xmusuh3 && ychtengah==ymusuh3 || xchtengah==xmusuh4 && ychtengah==ymusuh4 ||
            xchtengah==xmusuh5 && ychtengah==ymusuh5)
            {
             cout<< "Ada Musuh !!"<<endl;
                if(GetAsyncKeyState(' '))
                    {
                     if(xchtengah==xmusuh1 && ychtengah==ymusuh1)
                            {
                             xmusuh1=0;
                             ymusuh1=0;
                             score=score+10;
                            }
                     if(xchtengah==xmusuh2 && ychtengah==ymusuh2)
                            {
                             xmusuh2=0;
                             ymusuh2=0;
                             score=score+10;
                            }
                     if(xchtengah==xmusuh3 && ychtengah==ymusuh3)
                            {
                             xmusuh3=0;
                             ymusuh3=0;
                             score=score+10;
                            }
                     if(xchtengah==xmusuh4 && ychtengah==ymusuh4)
                            {
                             xmusuh4=0;
                             ymusuh4=0;
                             score=score+10;
                            }
                     if(xchtengah==xmusuh5 && ychtengah==ymusuh5)
                            {
                             xmusuh5=0;
                             ymusuh5=0;
                             score=score+10;
                            }
                    }
             cout<< "Koordinat X Crosshair: "<<xchtengah<<endl;
             cout<< "Koordinat Y Crosshair: "<<ychtengah;
            }
         else
            {
             cout<< "Tidak Ada Musuh !!"<<endl;
            }

         if(GetAsyncKeyState('W'))
            {
             ychatas-=1;
             ychpinggir1-=1;
             ychpinggir2-=1;
             ychtengah-=1;
             ychbawah-=1;
             if(ychtengah==1)
                {
                 ychatas+=1;
                 ychpinggir1+=1;
                 ychpinggir2+=1;
                 ychtengah+=1;
                 ychbawah+=1;
                }
            }
         if(GetAsyncKeyState('S'))
            {
             ychatas+=1;
             ychpinggir1+=1;
             ychpinggir2+=1;
             ychtengah+=1;
             ychbawah+=1;
             if(ychtengah==25)
                {
                 ychatas-=1;
                 ychpinggir1-=1;
                 ychpinggir2-=1;
                 ychtengah-=1;
                 ychbawah-=1;
                }
            }
         if(GetAsyncKeyState('A'))
            {
             xchatas-=1;
             xchpinggir1-=1;
             xchpinggir2-=1;
             xchtengah-=1;
             xchbawah-=1;
             if(xchtengah==1)
                {
                 xchatas+=1;
                 xchpinggir1+=1;
                 xchpinggir2+=1;
                 xchtengah+=1;
                 xchbawah+=1;
                }
            }
         if(GetAsyncKeyState('D'))
            {
             xchatas+=1;
             xchpinggir1+=1;
             xchpinggir2+=1;
             xchtengah+=1;
             xchbawah+=1;
             if(xchtengah==60)
                {
                 xchatas-=1;
                 xchpinggir1-=1;
                 xchpinggir2-=1;
                 xchtengah-=1;
                 xchbawah-=1;
                }
            }
         system("CLS");
        }while(!GetAsyncKeyState(stop));

return 0;
}
