#include <iostream>
using namespace std;


int main()
{
    int x, y;
    cin >> x >> y;

    int biggerNum = max(x, y);

    cout << biggerNum << endl;

    return 0;
}