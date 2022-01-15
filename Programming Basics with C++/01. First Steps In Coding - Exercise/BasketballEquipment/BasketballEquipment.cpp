#include <iostream>
using namespace std;

int main()
{
    int anualTax;
    cin >> anualTax;

    double shoesPrice = anualTax * 0.6;
    double sporstCostumPrice = shoesPrice * 0.8;
    double ballPrice = sporstCostumPrice * 0.25;
    double accessoairs = ballPrice * 0.2;

    double totalEquipmentPrcie = shoesPrice + sporstCostumPrice + ballPrice + accessoairs + anualTax;

    cout << totalEquipmentPrcie << endl;

    return 0;
}