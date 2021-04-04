#include <iostream>
#include <stdio.h>

using namespace std;

int main ()
{

float harian1,harian2,harian3,uts,uas,na;
    cout<< "Nilai 1 : "; cin>> harian1;
    cout<< "Nilai 2 : "; cin>> harian2;
    cout<< "Nilai 3 : "; cin>> harian3;
    cout<< "UTS : "; cin>> uts;
    cout<< "UAS : "; cin>> uas;

    na= (harian1+harian2+harian3)*0.1+uts*0.3+uas*0.4;
    printf("Nilai akhir : %.3f",na);

    if (na<45)
        {
         cout<< "\nGrade : E" << endl;
         cout<< "Keterangan : Tidak Lulus";
        }
    else if (na>=45 && na<=55.4)
        {
         cout<< "\nGrade : D" << endl;
         cout<< "Keterangan : Tidak Lulus";
        }
    else if (na>=55.5 && na<=55.9)
        {
         cout<< "\nGrade : C Bersyarat" << endl;
         cout<< "Keterangan : Lulus";
        }
    else if (na>=56 && na<=68)
        {
         cout<< "\nGrade : C" << endl;
         cout<< "Keterangan : Lulus";
        }
    else if (na>=69 && na<=79)
        {
         cout<< "\nGrade : B" << endl;
         cout<< "Keterangan : Lulus";
        }
    else if (na>=80 && na<=100)
        {
         cout<< "\nGrade : A" << endl;
         cout<< "Keterangan : Lulus";
        }

return 0;
}
