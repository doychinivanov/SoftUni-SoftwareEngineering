#include <iostream>
using namespace std;

int main()
{
    double priceForDogFood = 2.5;
    int priceForCatFood = 4;

    int dogFoodAmount, catFoodAmount;

    cin >> dogFoodAmount >> catFoodAmount;

    double totalDogPrice = priceForDogFood * dogFoodAmount;
    int totalCatPrice = priceForCatFood * catFoodAmount;

    double totalPrice = totalDogPrice + totalCatPrice;

    cout.setf(ios::fixed);
    cout.precision(1);

    cout << totalPrice << " lv." << endl;

    return 0;
}
