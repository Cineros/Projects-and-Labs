#include <iostream>

using namespace std;

int aux[] = {11,5,2,3,4,6,9,10,8,1}; //Without initialization this didnt work.

void merge(int a[], int l, int m, int h) {
  int k = l;
  int left = l;
  int right = m + 1;
  
  for(int i = l; i <= m; i++){ //copy first half of a to aux.
    aux[i] = a[i];
    //cout << aux[i] << endl; Used these to see how data is copied. 
  }
  for(int j = m+1; j <= h; j++){ //copy back half in reverse.
    aux[j] = a[h-j+m+1];
    //cout << aux[j] << endl; Used these to see how data is copied. 
  }

  while (left <= m && right <= h) { //Generic merge from here on.
    if (a[right] < a[left]) {
      aux[k] = a[right];
      right++;
    } else {
      aux[k] = a[left];
      left++;
    }
    k++;
  }
  while (left <= m) {
    aux[k] = a[left];
    left++;
    k++;
  }
  while (right <= h) {
    aux[k] = a[right];
    right++;
    k++;
  }
}

void mergeSortRec(int a[], int l, int h) {
  if (l < h) {
    int m = (l + h) / 2;

    mergeSortRec(a, l, m);
    mergeSortRec(a, m + 1, h);
    merge(a, l, m, h);
    for (int i = 0; i < 10; i++) { // copy sorted data back to array.
      a[i] = aux[i];
    }
  }
}
void mergeSort(int a[], int n) { 
  mergeSortRec(a, 0, n - 1); 
}

int main() {
  int a[] = {11,5,2,3,4,6,9,10,8,1}; //in the future look to copy the data on the fly rather than this method as it breaks if you don't update everywhere...
  mergeSort(a, 10);
  //could use "sizeof" here to determine length of array more generically but seems to not want to work as it gives a int* not int.
  for (int i = 0; i < 10; i++) {
    cout << a[i] << " ";
  }

  return 0;
}