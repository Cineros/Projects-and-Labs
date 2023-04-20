#include <iostream>
#include <random>

using namespace std;

void insertionSort(int arr[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++)
    {
        key = arr[i];
        j = i - 1;
        while (j >= 0 && arr[j] > key)
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

int average(int arr[], int n){
    int temp = 0;
    for(int i = 0; i < n; i++){
        temp += arr[i];
    }
    temp = temp / n;
    return temp;
}

int main(){
    time_t current_time = time(NULL);
    srand((unsigned) time(NULL));
    
    int temp;
    cout << "How many scores are there?" << endl;
    cin >> temp;
    int* array = new int[temp];
    for(int i = 0; i < temp; i++){
        int random = rand() % 101;
        array[i] = random;
        cout << random << endl;
    }
    cout << endl;
    insertionSort(array, temp);
    for(int n = 0; n < temp; n++){
        cout << array[n] << endl;
    }
    cout << "Average test score is... " << average(array, temp) << endl;

    int* expel = new int[temp-1];
    for(int x = 1; x < temp; x++){
        expel[x-1] = array[x];
    }
    for(int z = 0; z < temp-1; z++){
        cout << expel[z] << endl;
    }
    cout << "Average test score is... " << average(expel, (temp-1)) << endl;

    delete[] expel;
    delete[] array;
    
    return 0;

}