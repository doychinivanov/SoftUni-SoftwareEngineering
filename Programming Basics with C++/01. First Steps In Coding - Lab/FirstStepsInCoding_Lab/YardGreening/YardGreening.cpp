#include <iostream>
using namespace std;

int main()
{
    double totalMetres;
    cin >> totalMetres;

    double discountPercent = 0.18;
    double priceForOneM = 7.61;

    double priceBeforeDiscount = totalMetres * priceForOneM;

    double discount = priceBeforeDiscount * discountPercent;
    double finalPrice = priceBeforeDiscount - discount;

    cout << "The final price is : " << finalPrice << " lv." << endl;
    cout << "The discount is: " << discount << " lv." << endl;

    return 0;
}