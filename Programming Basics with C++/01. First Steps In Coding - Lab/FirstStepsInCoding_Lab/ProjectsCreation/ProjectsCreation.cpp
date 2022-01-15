#include <iostream>
using namespace std;


int main()
{
    int timeForOneProject = 3;

    string name;
    int projectsCount;

    cin >> name >> projectsCount;

    int timeNeeded = timeForOneProject * projectsCount;
    
    cout << "The architect " << name << " will need " << timeNeeded << " hours to complete " << projectsCount << " project/s." << endl;
}
