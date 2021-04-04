#include <iostream>

using namespace std;

int main ()
{

int m1,m2,m3,m4,m5,m6,m7,mTA;
int na;
    cout<< "Minggu 1 : "; cin>> m1;
    cout<< "Minggu 2 : "; cin>> m2;
    cout<< "Minggu 3 : "; cin>> m3;
    cout<< "Minggu 4 : "; cin>> m4;
    cout<< "Minggu 5 : "; cin>> m5;
    cout<< "Minggu 6 : "; cin>> m6;
    cout<< "Minggu 7 : "; cin>> m7;
    cout<< "Minggu TA : "; cin>> mTA;

    na= (m1+m2+m3+m4+m5+m6+m7)/10+mTA/10*3;

    cout<< "Nilai akhir : "<<"("<<m1<<"+"<<m2<<"+"<<m3<<"+"<<m4<<"+"<<m5<<"+"<<m6<<"+"
    <<m7<<")"<<"/"<<10<<" + "<<100<<"/"<<10<<"*"<<3<<" = "<< na;

return 0;
}
