#define _USE_MATH_DEFINES
#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    string figureType;
    cin >> figureType;
    double area = 0.0;

    if (figureType == "square")
    {
        double a;
        cin >> a;

        area = a * a;
    }
    else if (figureType == "rectangle")
    {
        double a, b;
        cin >> a >> b;

        area = a * b;
    }
    else if (figureType == "circle")
    {
        double a;
        cin >> a;

        area = a * a * M_PI;
    }
    else if (figureType == "triangle")
    {
        double a, b;
        cin >> a >> b;

        area = (a * b) / 2;
    }

    cout.setf(ios::fixed);
    cout.precision(3);

    cout << area << endl;

    return 0;
}