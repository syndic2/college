#include <iostream>

using namespace std;

int main ()
{
int gmtyangdicari,gmtsekarang,jamsekarang,c;
int jam,hari,bulan,tahun;
int gmtpusat=0;

    cout<< "Input 1 : "; cin>> gmtyangdicari;
    cout<< "Input 2 : "; cin>> jamsekarang>>gmtsekarang;
    cout<< "Input 3 : "; cin>> c;

    hari= c/1000000;
    bulan= c/10000%100;
    tahun= c%10000;

    gmtpusat= 0-gmtsekarang;
    jamsekarang= jamsekarang+gmtpusat;
    jam= jamsekarang+gmtyangdicari;

    if(jam<0)
        {
         jam=24+jam;
         hari=hari-1;
         cout<< "Jam : "<<jam<< endl;
         cout<< "-1"<<endl;
        }
    else if(jam>24)
        {
         jam=jam-24;
         hari=hari+1;
         cout<< "Jam : "<<jam <<endl;
         cout<< "1"<<endl;
        }
    else
        {
         cout<< "0"<<endl;
        }

    if(hari==0)
        {
         bulan=bulan-1;
         if(bulan==0)
            {
             bulan=12;
             tahun=tahun-1;
            }
         if (bulan==1||bulan==3||bulan==5||bulan==7||bulan==8||bulan==10||bulan==12)
            {
             hari=31;
            }
         else if(bulan==4||bulan==6||bulan==9||bulan==11)
            {
             hari=30;
            }
         }
    else if(hari>31)
        {
         if(bulan==1||bulan==3||bulan==5||bulan==7||bulan==8||bulan==10||bulan==12)
            {
             hari=hari-31;
            }
        else if(bulan==4||bulan==6||bulan==9||bulan==11)
            {
             hari=hari-30;
            }
            bulan=bulan+1;
        }
    else if(hari>30)
        {
         if(bulan==4||bulan==6||bulan==9||bulan==1)
            {
             hari=hari-30;
            }
            bulan=bulan+1;
        }

    if(bulan>12)
        {
         tahun=tahun+1;
         bulan=bulan-12;
        }

    if(tahun%4==0)
        {
         if(bulan==2)
            {
             if(hari==0)
                {
                 hari=29;
                }
             else if(hari>29)
                {
                 hari=hari-29;
                 bulan=bulan+1;
                }
            }
        }
    else
    {
     if(bulan==2)
        {
         if(hari==0)
            {
             hari=28;
            }
        else if(hari>28)
            {
             hari=hari-28;
             bulan=bulan+1;
            }
        }
    }
    cout<< hari<<"/"<<bulan<<"/"<<tahun;

return 0;
}
