#include <iostream>
using namespace std;

int main()
{
    int plasticAmount, paintAmount, chemicalAmount, workingHours;

    cin >> plasticAmount >> paintAmount >> chemicalAmount >> workingHours;

    double plasticPrice = 1.5;
    double paintPrice = 14.5;
    double chemicalPrice = 5.0;
    double plasticBagPrice = 0.4;

    int aditionalPlastic = plasticAmount + 2;
    double totalPlasticPrice = aditionalPlastic * plasticPrice;
    double totalPaintPrice = (paintAmount * 1.1) * paintPrice;
    double totalChemicalPrice = chemicalAmount * chemicalPrice;

    double sumForAllMaterial = totalPlasticPrice + totalPaintPrice + totalChemicalPrice + plasticBagPrice;
    double sumForWorkers = (sumForAllMaterial * 0.3) * workingHours;

    double finalCosts = sumForAllMaterial + sumForWorkers;

    cout << finalCosts << endl;

    return 0;
}