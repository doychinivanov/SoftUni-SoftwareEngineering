#include <iostream>
using namespace std;

int main()
{
    int pagesCount, pagesReadFoOneHour, days;

    cin >> pagesCount >> pagesReadFoOneHour >> days;

    int hoursNeedToReedBook = pagesCount / pagesReadFoOneHour;
    int daysNeedToReadBook = hoursNeedToReedBook / days;

    cout << daysNeedToReadBook << endl;

    return 0;
}