#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <windows.h>

using namespace std;

void screen()
{
int panjang,lebar;
panjang=30;
lebar=80;
int milisecond=0;
int x,y;
char mapz[panjang][lebar];
char tekan;
char stop=13;
srand(time(0));

    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             if(i==0 || i==29 || j==0 || j==79)
                {
                 mapz[i][j]= '=';
                }
             else
                {
                 mapz[i][j]= ' ';
                }
            }
        }

    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             cout << mapz[i][j];
            }
        cout << endl;
        }

    cout<< "Input: "; cin>> tekan;

    do{
       milisecond++;
       cout<< "Waktu perpindahan bangung: "<<milisecond<<endl;
    x=rand()%75+1;
    y=rand()%25+1;
    if(GetAsyncKeyState('P'))
        {
         system("CLS");
         for(int i=0;i<panjang;i++)
            {
             for(int j=0;j<lebar;j++)
                {
                 if(i==y && j==x)
                    {
                     for(int p=i;p<i+4;p++)
                        {
                         for(int o=j;o<j+4;o++)
                            {
                             int angka= rand()%10;
                             if(angka==0)
                                {
                                  mapz[p][o]='0';
                                }
                             if(angka==1)
                                {
                                  mapz[p][o]='1';
                                }
                             if(angka==2)
                                {
                                  mapz[p][o]='2';
                                }
                             if(angka==3)
                                {
                                  mapz[p][o]='3';
                                }
                             if(angka==4)
                                {
                                  mapz[p][o]='4';
                                }
                             if(angka==5)
                                {
                                  mapz[p][o]='5';
                                }
                             if(angka==6)
                                {
                                  mapz[p][o]='6';
                                }
                             if(angka==7)
                                {
                                  mapz[p][o]='7';
                                }
                             if(angka==8)
                                {
                                  mapz[p][o]='8';
                                }
                             if(angka==9)
                                {
                                  mapz[p][o]='9';
                                }
                            }
                        }
                    }
                }
            }
        }

    x=rand()%75+1;
    y=rand()%25+1;
    if(GetAsyncKeyState('L'))
        {
         system("CLS");
         for(int i=0;i<panjang;i++)
            {
             for(int j=0;j<lebar;j++)
                {
                 if(i==y &&j==x)
                    {
                     for(int p=i;p<i+4;p++)
                        {
                         for(int o=j;o<j+4;o++)
                            {
                             if((j+3)-o <= p-i)
                                {
                                 int angka= rand()%10;
                                 if(angka==0)
                                    {
                                     mapz[p][o]='0';
                                    }
                                 if(angka==1)
                                    {
                                     mapz[p][o]='1';
                                    }
                                 if(angka==2)
                                    {
                                     mapz[p][o]='2';
                                    }
                                 if(angka==3)
                                    {
                                     mapz[p][o]='3';
                                    }
                                 if(angka==4)
                                    {
                                     mapz[p][o]='4';
                                    }
                                 if(angka==5)
                                    {
                                     mapz[p][o]='5';
                                    }
                                 if(angka==6)
                                    {
                                     mapz[p][o]='6';
                                    }
                                 if(angka==7)
                                    {
                                     mapz[p][o]='7';
                                    }
                                 if(angka==8)
                                    {
                                     mapz[p][o]='8';
                                    }
                                 if(angka==9)
                                    {
                                     mapz[p][o]='9';
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    x=rand()%75+1;
    y=rand()%25+1;
    if(GetAsyncKeyState('R'))
        {
         system("CLS");
         for(int i=0;i<panjang;i++)
            {
             for(int j=0;j<lebar;j++)
                {
                 if(i==y && j==x)
                    {
                     for(int p=i;p<i+4;p++)
                        {
                         for(int o=j;o<j+4;o++)
                            {
                             if(o-j <= p-i)
                                {
                                 int angka= rand()%10;
                                 if(angka==0)
                                    {
                                     mapz[p][o]= '0';
                                    }
                                 if(angka==1)
                                    {
                                     mapz[p][o]= '1';
                                    }
                                 if(angka==2)
                                    {
                                     mapz[p][o]= '2';
                                    }
                                 if(angka==3)
                                    {
                                     mapz[p][o]= '3';
                                    }
                                 if(angka==4)
                                    {
                                     mapz[p][o]= '4';
                                    }
                                 if(angka==5)
                                    {
                                     mapz[p][o]= '5';
                                    }
                                 if(angka==6)
                                    {
                                     mapz[p][o]= '6';
                                    }
                                 if(angka==7)
                                    {
                                     mapz[p][o]= '7';
                                    }
                                 if(angka==8)
                                    {
                                     mapz[p][o]= '8';
                                    }
                                 if(angka==9)
                                    {
                                     mapz[p][o]= '9';
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             cout << mapz[i][j];
            }
        cout << endl;
        }
     system("CLS");
    }while(tekan!=0);

}


int main(){


    screen();

return 0;
}
