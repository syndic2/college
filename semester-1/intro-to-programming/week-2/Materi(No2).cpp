#include <iostream>

using namespace std;

int main ()
{

int angka,a,b,c;
int d,e,f;
int g,h,i;

    cin>> angka;

    if (angka>99 && angka<1000) {
        a= angka%1000/100;
        b= angka%100/10;
        c= angka%10;
    if (a+b>c && b+c>a && a+c>b)
        {
         cout<< a+b << ">" << c << endl;
         cout<< b+c << ">" << a << endl;
         cout<< a+c << ">" << b << endl;
         cout<< "YES" << endl; }
    else if (a+b<=c || b+c<=a || a+c<=b)
        {
         cout<< a+b << ">" << c << endl;
         cout<< b+c << ">" << a << endl;
         cout<< a+c << ">" << b << endl;
         cout<< "NO" <<endl; } }

    if(angka>99000 && angka<1000000) {
        d= angka%1000000/10000;
        e= angka%10000/100;
        f= angka%100;
    if(d+e>f && e+f>d && d+f>e)
        {
         cout<< d+e << ">" << f << endl;
         cout<< e+f << ">" << d << endl;
         cout<< d+f << ">" << e << endl;
         cout<< "YES"; }
    else if (d+e<=f || e+f<=d || d+f<=e)
        {
         cout<< d+e << ">" << f << endl;
         cout<< e+f << ">" << d << endl;
         cout<< d+f << ">" << e << endl;
         cout<< "NO"; } }

    if (angka>99000000 && angka<1000000000) {
        g= angka/1000000%1000;
        h= angka%1000000/1000;
        i= angka%1000;
    if (g+h>i && h+i>g && g+i>h)
        {
         cout<< g+h << ">" << i << endl;
         cout<< h+i << ">" << g << endl;
         cout<< g+i << ">" << h << endl;
         cout<< "YES"; }
    else if(g+h<=i || h+i<=g || g+i<=h)
        {
         cout<< g+h << ">" << i << endl;
         cout<< h+i << ">" << g << endl;
         cout<< g+i << ">" << h << endl;
         cout<< "NO"; } }

return 0;
}
