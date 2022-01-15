#include <iostream>
using namespace std;


int main()
{
    string firstName;
    string lastName;
    string age;
    string town;

    cin >> firstName >> lastName >> age >> town;

    string result = "You are " + firstName + " " + lastName + ", a " + age + "-years old person from " + town + ".";

    cout << result;

    return 0;
}