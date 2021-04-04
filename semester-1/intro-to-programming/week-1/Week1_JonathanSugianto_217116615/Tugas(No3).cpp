#include <iostream>

using namespace std;

int main ()
{
int x,y,x_1,x_2,y_1,z;
int x1,y1;
int x2,y2;
int ya,yb,yc1,yc2;
int xa,xb,xc1,xc2;

    x=1;
    y=1;

    cout<< "X1 : "; cin>> x1;
    cout<< "X2 : "; cin>> x2;
    cout<< "Y1 : "; cin>> y1;
    cout<< "Y2 : "; cin>> y2;

    xb= x2-x1;
    yb= y2-y1;

    xc1= yb*x;
    xc2= yb*(-1*x1);

    yc1= xb*y;
    yc2= xb*(-1*y1);

    x_1= yc2-xc2;
    z  = -1*x_1;
    x= -1*xc1;

    cout<< yc1<<"y"<<"+"<<x<<"x"<<"="<<z;

return 0;
}
