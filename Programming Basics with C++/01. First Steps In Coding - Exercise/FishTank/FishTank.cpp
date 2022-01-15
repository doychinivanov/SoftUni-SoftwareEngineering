#include <iostream>
using namespace std;

int main()
{
    int length, width, height;
    double takenSpace;
    cin >> length >> width >> height >> takenSpace;

    int volume = length * height * width;
    double totalLitres = volume * 0.001;

    double percentageOfFreeSpace = 1 - takenSpace / 100;
    double neededWater = totalLitres * percentageOfFreeSpace;

    cout << neededWater << endl;

    return 0;
}