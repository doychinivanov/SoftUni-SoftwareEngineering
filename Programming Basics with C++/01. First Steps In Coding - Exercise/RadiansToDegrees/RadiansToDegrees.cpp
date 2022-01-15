#define _USE_MATH_DEFINES
#include <iostream>
#include <math.h>
using namespace std;

int main()
{
    double radians;
    cin >> radians;

    double degrees = (radians * 180) / M_PI;

    cout << round(degrees) << endl;

    return 0;
}