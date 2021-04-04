#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <windows.h>

using namespace std;

int main ()
{

int lurus=60;
int tinggi=30;
int xplayer,yplayer,xmusuh,ymusuh,xMusuh,yMusuh;
int xbatu1,ybatu1,xbatu2,ybatu2,xbatu3,ybatu3,xbatu4,ybatu4,xbatu5,ybatu5;
char step;
char karakter='v';
char batu= 174;

xplayer= 2;
yplayer= 2;

srand(time(0));
xbatu1=rand()%58+2;
ybatu1=rand()%28+2;
xbatu2=rand()%58+2;
ybatu2=rand()%28+2;
xbatu3=rand()%58+2;
ybatu3=rand()%28+2;
xbatu4=rand()%58+2;
ybatu4=rand()%28+2;
xbatu5=rand()%58+2;
ybatu5=rand()%28+2;

xMusuh=rand()%58+2;
yMusuh=rand()%28+2;
xmusuh=rand()%58+2;
ymusuh=rand()%28+2;

int player,enemy;
int hpplayer=100,hpenemy=100,mp=20;
int damageplayer=0,damageenemy=0;
int attplayer,attenemy,skll;
int attack=1,skill=2,run=3,pilih;

do {
for(int i=1;i<=tinggi;i=i+1)
    {
     for(int j=1;j<=lurus;j=j+1)
        {
         if(xplayer==j && yplayer==i)
            {
            cout<< karakter;
            }
         else if(xMusuh==j && yMusuh==i)
            {
             cout<< "M";
            }
         else if(xmusuh==j && ymusuh==i)
            {
             cout<< "m";
            }
         else if(xbatu1==j && ybatu1==i)
            {
             cout<< batu;
            }
         else if(xbatu2==j && ybatu2==i)
            {
             cout<< batu;
            }
         else if(xbatu3==j && ybatu3==i)
            {
             cout<< batu;
            }
         else if(xbatu4==j && ybatu4==i)
            {
             cout<< batu;
            }
         else if(xbatu5==j && ybatu5==i)
            {
             cout<< batu;
            }
         else if(i==1 || i==tinggi || j==1 || j==lurus)
            {
             cout<< "=";
            }
         else{cout<< " ";}
         }
    cout<< endl;
    }

    cout<< "Input : ";
    cin>> step;
    system("CLS");
    if(step=='w')
        {
         yplayer-=1;
         if(xplayer==xbatu1 && yplayer==ybatu1 || xplayer==xbatu2 && yplayer==ybatu2 || xplayer==xbatu3 && yplayer==ybatu3
             || xplayer==xbatu4 && yplayer==ybatu4 || xplayer==xbatu5 && yplayer==ybatu5)
                {
                 yplayer+=1;
                }
         if(yplayer==1)
            {
             yplayer+=1;
            }
            karakter='^';
        }
    else if(step=='a')
        {
         xplayer-=1;
         if(xplayer==xbatu1 && yplayer==ybatu1 || xplayer==xbatu2 && yplayer==ybatu2 || xplayer==xbatu3 && yplayer==ybatu3
             || xplayer==xbatu4 && yplayer==ybatu4 || xplayer==xbatu5 && yplayer==ybatu5)
                {
                 xplayer+=1;
                }
         if(xplayer==1)
            {
             xplayer+=1;
            }
            karakter='<';
        }
    else if(step=='s')
        {
         yplayer+=1;
         if(xplayer==xbatu1 && yplayer==ybatu1 || xplayer==xbatu2 && yplayer==ybatu2 || xplayer==xbatu3 && yplayer==ybatu3
             || xplayer==xbatu4 && yplayer==ybatu4 || xplayer==xbatu5 && yplayer==ybatu5)
                {
                 yplayer-=1;
                }
         if(yplayer==30)
            {
             yplayer-=1;
            }
             karakter='v';
        }
    else if(step=='d')
        {
         xplayer+=1;
         if(xplayer==xbatu1 && yplayer==ybatu1 || xplayer==xbatu2 && yplayer==ybatu2 || xplayer==xbatu3 && yplayer==ybatu3
             || xplayer==xbatu4 && yplayer==ybatu4 || xplayer==xbatu5 && yplayer==ybatu5)
                {
                 xplayer-=1;
                }
         if(xplayer==60)
            {
             xplayer-=1;
            }
             karakter='>';
        }

    int rx=rand()%3-1;
    int ry=rand()%3-1;
    xMusuh=xMusuh+rx;
    yMusuh=yMusuh+ry;
    xmusuh=xmusuh+rx;
    ymusuh=ymusuh+ry;
    if(xMusuh==xbatu1 && yMusuh==ybatu1 || xMusuh==xbatu2 && yMusuh==ybatu2 || xMusuh==xbatu3 && yMusuh==ybatu3 ||
       xMusuh==xbatu4 && yMusuh==ybatu4 || xMusuh==xbatu5 && yMusuh==ybatu5)
        {
         if(rx==1)
        {
         xMusuh-=1;
        }
         else if(rx==-1)
        {
         xMusuh+=1;
        }
         if(ry==1)
        {
         yMusuh-=1;
        }
         else if(ry=-1)
        {
         yMusuh+=1;
        }
        }

    else if(xmusuh==xbatu1 && ymusuh==ybatu1 || xmusuh==xbatu2 && ymusuh==ybatu2 || xmusuh==xbatu3 && ymusuh==ybatu3 ||
            xmusuh==xbatu4 && ymusuh==ybatu4 || xmusuh==xbatu5 && ymusuh==ybatu5)
        {
         if(rx==1)
        {
         xmusuh-=1;
        }
         else if(rx==-1)
        {
         xmusuh+=1;
        }
         if(ry==1)
        {
         ymusuh-=1;
        }
         else if(ry=-1)
        {
         ymusuh+=1;
        }
        }

    if(xMusuh==1)
        {
         xMusuh+=1;
        }
    if(yMusuh==30)
        {
         yMusuh-=1;
        }

    if(xMusuh==60)
        {
         xMusuh-=1;
        }
    if(yMusuh==1)
        {
         yMusuh+=1;
        }

    if(xmusuh==1)
        {
         xmusuh+=1;
        }
    if(ymusuh==30)
        {
         ymusuh-=1;
        }

    if(xmusuh==60)
        {
         xmusuh-=1;
        }
    if(ymusuh==1)
        {
         ymusuh+=1;
        }

    if(xplayer==xMusuh && yplayer==yMusuh || xplayer==xmusuh && yplayer==ymusuh) {
    srand(time(0));
    cout<<"<<PLAYER>>";                  cout<<"               "<<"ENEMY";
    cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
    cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
    cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
    cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
    cout<< "\n"<<" "<<hpplayer;          cout<< "                      "; cout<< hpenemy;
    cout<< "\n"<<" "<<mp;
    cout<< "\n DAMAGE= "<< damageplayer;
    cout<< "\n PLAYER TURN";

    do{
    cout<<"\n MENU: ";
    cout<< "\n"<<attack<<".    ATTACK";
    cout<< "\n"<<skill<< ".    SKILL";
    cout<< "\n"<<run  << ".    RUN";
    cout<< "\nInput: "; cin>> pilih;
    cout<< "==================================="<<endl;
            if(pilih==attack)
            {
             attplayer= 5+5*(rand()%2*rand()%6)/5;
             hpenemy= hpenemy-attplayer;
             cout<<"\n<<PLAYER>>";                cout<<"               "<<"ENEMY";
             cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
             cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
             cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
             cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
             cout<< "\n"<<" "<<hpplayer;          cout<< "                       "; cout<< hpenemy;
             cout<< "\n"<<" "<<mp;                cout<< "                      "; cout<< "Attacked,Damage= "<<attplayer<<endl;
                                                  cout<< "                         "; cout<< "ENEMY TURN"<<endl;
             int a; cin>>a;
             system("CLS");
             attenemy= 5+(5*rand()%2*rand()%6)/5;
             hpplayer= hpplayer-attenemy;
             cout<<"<<PLAYER>>";                  cout<<"               "<<"ENEMY";
             cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
             cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
             cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
             cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
             cout<< "\n"<<" "<<hpplayer;          cout<< "                        "; cout<< hpenemy;
             cout<< "\n"<<" "<<mp;
             cout<< "\n DAMAGE= "<< attenemy;
             cout<< "\n PLAYER TURN";
            }
            else if (pilih==skill)
            {
             if(mp>=5){
             mp=mp-5;
             skll= 10+10*(rand()%6)/10*(rand()%2*rand()%2);
             hpenemy= hpenemy-skll;
             cout<<"\n<<PLAYER>>";                cout<<"               "<<"ENEMY";
             cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
             cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
             cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
             cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
             cout<< "\n"<<" "<<hpplayer;          cout<< "                       "; cout<< hpenemy;
             cout<< "\n"<<" "<<mp;                cout<< "                      "; cout<< "Attacked,Damage= "<<skll<<endl;
                                                  cout<<"                         "; cout<< "ENEMY TURN"<<endl;

             int a; cin>>a;
             system("CLS");
             attenemy= 5+5*(rand()%2*rand()%6)/5;
             hpplayer= hpplayer-attenemy;
             }
             system("CLS");
             cout<<"<<PLAYER>>";                  cout<<"               "<<"ENEMY";
             cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
             cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
             cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
             cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
             cout<< "\n"<<" "<<hpplayer;          cout<< "                        "; cout<< hpenemy;
             cout<< "\n"<<" "<<mp;
             cout<< "\n DAMAGE= "<< attenemy;
             cout<< "\n PLAYER TURN";
             }

            }while(hpplayer>0 && hpenemy>0 && pilih!=run);
             hpplayer=100,hpenemy=100,mp=20;
             damageplayer=0,damageenemy=0;

             if(xplayer==xMusuh && yplayer==yMusuh)
                {
                  xMusuh=rand()%57+2;
                  yMusuh=rand()%57+2;
                }

             if(xplayer==xmusuh && yplayer==ymusuh)
                    {
                     xmusuh=rand()%57+2;
                     ymusuh=rand()%57+2;
                    }

             if(pilih==run)
             {
                int yy=rand()%4;
                if(yy==0)
                {
                 yplayer=yplayer-3;
                }
                else if(yy==1)
                {
                 yplayer=yplayer+3;
                }
                else if(yy==2)
                {
                 xplayer=xplayer+3;
                }
                else if(yy==3)
                {
                 xplayer=xplayer-3;
                }
             }
    }

            system("CLS");
  }while (step!='0');

return 0;
}

