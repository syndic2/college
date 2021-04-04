#include <iostream>
#include <windows.h>
#include <conio.h>
#include <time.h>
#include <stdlib.h>

using namespace std;

int main ()
{

int player,enemy;
int hpplayer=100,hpenemy=100,mp=20;
int damageplayer=0,damageenemy=0;
int attplayer,attenemy,skll;
int attack=1,skill=2,run=3,pilih;

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

    while(pilih!=0) {
    cout<<"\n MENU: ";
    cout<< "\n"<<attack<<".    ATTACK";
    cout<< "\n"<<skill<< ".    SKILL";
    cout<< "\n"<<run  << ".    RUN";
    cout<< "\nInput: "; cin>> pilih;
    cout<< "\n========================="<<endl;
            if(pilih==1)
            {
             system("CLS");
             attplayer= 5+5*rand()%2*rand()%6/5;
             hpenemy= hpenemy-attplayer;
             damageenemy= damageenemy+attplayer;
             cout<<"<<PLAYER>>";                  cout<<"               "<<"ENEMY";
             cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
             cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
             cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
             cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
             cout<< "\n"<<" "<<hpplayer;          cout<< "                      "; cout<< hpenemy;
             cout<< "\n"<<" "<<mp;                cout<< "                      "; cout<< "Attacked,Damage= "<<damageenemy<<endl;
                                                  cout<< "                         "; cout<< "ENEMY TURN"<<endl;

             attenemy= 5+5*rand()%2*rand()%6/5;
             hpplayer= hpplayer-attenemy;
             damageplayer= damageplayer+attenemy;
             cout<<"\n<<PLAYER>>";                cout<<"               "<<"ENEMY";
             cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
             cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
             cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
             cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
             cout<< "\n"<<" "<<hpplayer;          cout<< "                       "; cout<< hpenemy;
             cout<< "\n"<<" "<<mp;
             cout<< "\n DAMAGE= "<< damageplayer;
             cout<< "\n PLAYER TURN";
            }
            else{
            if (pilih==2)
            {
             system("CLS");
             mp=mp-5;
             skll= 10+10*rand()%6/10*rand()%2*rand()%2;
             hpenemy= hpenemy-skll;
             damageenemy= damageenemy+skll;
             cout<<"<<PLAYER>>";                  cout<<"               "<<"ENEMY";
             cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
             cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
             cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
             cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
             cout<< "\n"<<" "<<hpplayer;          cout<< "                      "; cout<< hpenemy;
             cout<< "\n"<<" "<<mp;                cout<< "                      "; cout<< "Attacked,Damage= "<<damageenemy<<endl;
                                                  cout<< "                         "; cout<< "ENEMY TURN"<<endl;


             attenemy= 5+5*rand()%2*rand()%6/5;
             hpplayer= hpplayer-attenemy;
             damageplayer= damageplayer+attenemy;
             cout<<"\n<<PLAYER>>";                cout<<"               "<<"ENEMY";
             cout<<endl<<"-----------";           cout<<"              "<<"-----"<<endl;
             cout<< "  0 ";                       cout<< "                     "; cout<< "  0 "<<endl;
             cout<< " /|-+";                      cout<< "                    "; cout<< "+-|\\"<<endl;
             cout<< " / \\";                      cout<< "                     "; cout<< " / \\";
             cout<< "\n"<<" "<<hpplayer;          cout<< "                       "; cout<< hpenemy;
             cout<< "\n"<<" "<<mp;
             cout<< "\n DAMAGE= "<< damageplayer;
             cout<< "\n PLAYER TURN";
            }
            }

    }

    /*while(hpplayer!=0 || pilih!=3);*/


return 0;
}
