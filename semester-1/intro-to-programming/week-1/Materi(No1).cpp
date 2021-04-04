#include <iostream>
#include <stdio.h>

using namespace std;

int main ()
{
int angka,a,b,c,d,e,f,g,h,i;
float genap,ganjil,hasil;
    cin>> angka;

    a= angka%1000000000/100000000;
    b= angka%100000000/10000000;
    c= angka%10000000/1000000;
    d= angka%1000000/100000;
    e= angka%100000/10000;
    f= angka%10000/1000;
    g= angka%1000/100;
    h= angka%100/10;
    i= angka%10;

    genap=  (a%2==0)*a+(b%2==0)*b+(c%2==0)*c+(d%2==0)*d+(e%2==0)*e+(f%2==0)*f+(g%2==0)*g+(h%2==0)*h+(i%2==0)*i;
    cout<< "Bilangan Genap : " << genap<<endl;
    ganjil= (a%2==1)*a+(b%2==1)*b+(c%2==1)*c+(d%2==1)*d+(e%2==1)*e+(f%2==1)*f+(g%2==1)*g+(h%2==1)*h+(i%2==1)*i;
    cout<< "Bilangan Ganjil : " << ganjil<<endl;

    hasil= genap/ganjil;
    printf("Hasil : %.3f",hasil);

return 0;
}
