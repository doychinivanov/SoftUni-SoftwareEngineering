#include <iostream>
using namespace std;

int main()
{
    double chickenPrice = 10.35;
    double fishPrice = 12.4;
    double vegiterainPrice = 8.15;
    double deliveryPrice = 2.5;

    int chickenCount, fishCount, veggieCount;

    cin >> chickenCount >> fishCount >> veggieCount;

    double sumForChickenMenu = chickenCount * chickenPrice;
    double sumForFishPrice = fishCount * fishPrice;
    double sumForVeggiePrice = veggieCount * vegiterainPrice;

    double sumForAllMenus = sumForChickenMenu + sumForFishPrice + sumForVeggiePrice;
    double desertPrice = sumForAllMenus * 0.2;

    double finalPrice = sumForAllMenus + desertPrice + deliveryPrice;

    cout << finalPrice << endl;

    return 0;
}