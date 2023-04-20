#include <iostream>

using namespace std;

int allocate(int i){
    int *array = new int[i];

    return *array;
}

int main(){
    int temp;
    cout << "How big is the array?" << endl;
    cin >> temp;
    allocate(temp);

    return 0;
}