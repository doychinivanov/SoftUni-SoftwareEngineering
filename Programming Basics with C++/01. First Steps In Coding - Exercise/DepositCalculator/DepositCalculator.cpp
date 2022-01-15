#include <iostream>
using namespace std;

int main()
{

    double depositSum, interestRate;
    int months;
    cin >> depositSum >> months >> interestRate;

    double finalSum = depositSum + months * ((depositSum * (interestRate / 100)) / 12);

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << finalSum << endl;

    return 0;
}