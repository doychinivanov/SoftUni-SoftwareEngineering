#include <iostream>
using namespace std;

int main()
{
    string realPass = "s3cr3t!P@ssw0rd";

    string userInput;
    cin >> userInput;


    if (userInput == realPass)
    {
        cout << "Welcome" << endl;
    }
    else
    {
        cout << "Wrong password!" << endl;
    }


    return 0;
}