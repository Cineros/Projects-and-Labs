#include <iostream>

using namespace std;

struct date{
    int day;
    int month;
    int year;
};

string convertM(int m){
    switch(m){
        case 1: 
        return "January";
        case 2: 
        return "Feb";
        case 3: 
        return "March";
        case 4: 
        return "April";
        case 5: 
        return "May";
        case 6: 
        return "June";
        case 7: 
        return "July";
        case 8: 
        return "August";
        case 9: 
        return "Sepetember";
        case 10: 
        return "October";
        case 11: 
        return "November";
        case 12: 
        return "December";
        default:
        return "null";
    }
}

int main(){
    date today;
    while(today.day > 31 || today.month > 12 || today.day < 1 || today.month < 1){
        cout << "Please input the day, month, and year." << endl;
        cin >> today.day >> today.month >> today.year;
        if(today.day > 31 || today.month > 12 || today.day < 1 || today.month < 1){
            cout << "Invalid inputs resetting..." << endl;
        }
    }
    cout << today.day << "/" << today.month << "/" << today.year << endl;
    string month;
    month = convertM(today.month);
    cout << month << " " << today.day << " " << today.year << endl;
    cout << today.day << " " << month << " " << today.year << endl;
 
}