#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#include <stdlib.h>
#include <time.h>
#include <conio.h>
#include <windows.h>

using namespace std;

struct card
{

int number;

};

void papan()
{

card kartu[5][14];
int panjang= 6;
int lebar= 15;
int inputx1,inputx2;
int inputy1,inputy2;
int score= 0;
int openkartu[5][14];
char peta[panjang][lebar];
string input;
srand(time(0));

    for(int i=0;i<5;i++)
        {
         for(int j=0;j<14;j++)
            {
             kartu[i][j].number= rand()%13+1;
            }
        }

    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             if(i==0 || i==panjang-1 || j==0 || j==lebar-1)
                {
                 peta[i][j]= '=';
                }
             else
                {
                 switch (kartu[i][j].number)
                    {
                     case 1: peta[i][j]=  'A';
                     break;
                     case 2: peta[i][j]= '2';
                     break;
                     case 3: peta[i][j]= '3';
                     break;
                     case 4: peta[i][j]= '4';
                     break;
                     case 5: peta[i][j]= '5';
                     break;
                     case 6: peta[i][j]= '6';
                     break;
                     case 7: peta[i][j]= '7';
                     break;
                     case 8: peta[i][j]= '8';
                     break;
                     case 9: peta[i][j]= '9';
                     break;
                     case 10: peta [i][j]= '0';
                     break;
                     case 11: peta[i][j]= 'J';
                     break;
                     case 12: peta[i][j]= 'Q';
                     break;
                     case 13: peta[i][j]= 'K';
                     break;
                    }
                }
            }
        }

    do{
    cout<< "Score: "<<score<<endl;
    for(int i=0;i<panjang;i++)
        {
         for(int j=0;j<lebar;j++)
            {
             if(i==0 || i==panjang-1 || j==0 || j==lebar-1)
                {
                 cout<< peta[i][j];
                }
             else
                {
                 if((i==inputy1 && j==inputx1)||(i==inputy2 && j==inputx2))
                    {
                     cout << peta[i][j];
                     for(int k=0;k<5;k++)
                        {
                         for(int l=0;l<14;l++)
                            {
                             openkartu[k][l]= inputy1,inputx1,inputy2,inputx2;
                            }
                        }

                     if(openkartu[i][j]==kartu[i][j].number)
                        {
                         score+=10;
                         cout<< kartu[i][j].number;
                        }
                    }
                else
                    {
                     cout << '#';
                    }
                }
            }
         cout<< endl;
        }
    cout<< "Koordinat X ke-1: ";
    cin>> inputx1;
    cout<< "Koordinat Y ke-1: ";
    cin>> inputy1;
    cout<< "Koordinat X ke-2: ";
    cin>> inputx2;
    cout<< "Koordinat Y ke-2: ";
    cin>> inputy2;
    cout<< "Save/Load/No: ";
    cin>> input;

    if(input=="save")
        {
         ofstream save;
         save.open("Save.txt");
         if(save.is_open())
            {
             save << score<<endl;
             for(int i=0;i<6;i++)
                {
                 for(int j=0;j<15;j++)
                    {
                     save << peta[i][j];
                    }
                 save<<endl;
                }
             save << inputx1 << " " << inputy1 << endl;
             save << inputx2 << " " << inputy2;
             save.close();
            }
         else
            {
             cout<< "Unable to open file...";
            }
        }

     if(input=="load")
        {
         string tampung;
         ifstream load;
         load.open("Save.txt");
         if(load.is_open())
            {
             while(getline(load,tampung))
                {
                 cout<< tampung;
                }
             load.close();
            }
         else
            {
             cout<< "Anda belum pernah men-save"<<endl;
            }
        }
     system("CLS");
    }while(true);

}


int main()
{

    papan();

return 0;
}
