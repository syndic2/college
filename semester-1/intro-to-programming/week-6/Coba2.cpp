#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#include <conio.h>

using namespace std;

void screen()
{
int panjang= 30;
int lebar= 80;
int xkotak,ykotak;
int milisecond=0;
char tekan;
char stop= 13;
string layar[panjang][lebar];
string kotak[4][4];
srand(time(0));

    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             if(j==0 || j==lebar-1 || i==0 || i==panjang-1)
                {
                 layar[i][j]= "=";
                }
             else
                {
                 layar[i][j]= " ";
                }
            }
        }

    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             cout<< layar[i][j];
            }
         cout<< endl;
        }

    cout<< "Input: ";
    cin>> tekan;
    do{
       milisecond++;
       xkotak= rand()%74+1;
       ykotak= rand()%24+1;
    if(tekan=='P' || tekan=='p')
        {
         system("CLS");
         cout<< "Waktu bangun bergerak: "<<milisecond<<endl;
         for(int i=0;i<panjang;i++)
            {
             for(int j=0;j<lebar;j++)
                {
                 if(xkotak==j && ykotak==i)
                    {
                     for(int k=0;k<4;k++)
                        {
                         for(int l=0;l<4;l++)
                            {
                             kotak[k][l]= "#";
                            }
                        }
                    }
                 else if(j==0 || j==lebar-1 || i==0 || i==panjang-1)
                    {
                     layar[i][j]= "=";
                    }
                 else
                    {
                     layar[i][j]= " ";
                    }
                }
            }

        //cout layar
        for(int i=0;i<panjang;i++)
            {
             for(int j=0;j<lebar;j++)
                {
                 if(xkotak==j && ykotak==i)
                    {
                     cout<< kotak[i][j];
                    }
                 else
                    {
                     cout<< layar[i][j];
                    }
                }
             cout<< endl;
            }
        //cout kotak
        for(int k=0;k<4;k++)
            {
             for(int l=0;l<4;l++)
                {
                 cout<< kotak[k][l];
                }
             cout<< endl;
            }
        }
    }while(tekan!=stop);

}

int main ()
{

    screen();

return 0;
}
