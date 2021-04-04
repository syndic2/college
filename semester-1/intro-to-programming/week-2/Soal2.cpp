#include <iostream>

using namespace std;

int main ()
{

int a,b,c;
    cout<< "Input 1 : "; cin>> a;
    cout<< "Input 2 : "; cin>> b;
    cout<< "Input 3 : "; cin>> c;

    if (a==b && a==c && b==c)
        {
         cout<< "Segitiga sama sisi";
        }
    else if (a==b && b==a || a==c && c==a || b==c && c==b)
        {
         cout<< "Segitiga sama kaki";
        }
    else if (a*a+b*b==c*c || b*b+a*a==c*c || a*a+c*c==b*b || b*b+c*c==a*a)
        {
         cout<< "Segitiga siku-siku";
        }
    else if (a!=b && b!=c && c!=a)
        {
         cout<< "Segitiga sembarang";
        }

return 0;
}
