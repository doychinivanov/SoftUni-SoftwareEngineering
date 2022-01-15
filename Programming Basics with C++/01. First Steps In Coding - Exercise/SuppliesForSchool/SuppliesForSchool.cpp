#include <iostream>
using namespace std;

int main()
{
    int pens, markers, cleaningLiquid, discountPercentage;

    cin >> pens >> markers >> cleaningLiquid >> discountPercentage;

    double pensCost = 5.8;
    double markersCost = 7.2;
    double liquidCost = 1.2;

    double totalPenCost = pens * pensCost;
    double totalMarkerCost = markers * markersCost;
    double totalLiquidCost = cleaningLiquid * liquidCost;

    double costBeforeDiscount = totalPenCost + totalMarkerCost + totalLiquidCost;
    double costAfterDiscount = costBeforeDiscount - (costBeforeDiscount * (discountPercentage / 100.0));

    cout << costAfterDiscount << endl;

    return 0;
}