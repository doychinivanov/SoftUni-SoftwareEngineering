#include <iostream>
using namespace std;

int main()
{
    double convertRation = 1.79549;

    double usd;
    cin >> usd;

    double bgn = usd * convertRation;

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << bgn << endl;

    return 0;
}