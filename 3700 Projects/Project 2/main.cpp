#include <iostream>
#include "dictionary.h"
#include "stack.h"

using namespace std;

struct Value{
    string name;
    Fraction value;
};

Stack<char> opStack;
Stack<Value> numStack;

bool hasPrecedence(char a, char b){
    if(a == '/' || a == '*'){
        return true;
    }
    if(a == '(' or a == '=' || a == '$'){
        return false;
    }
    return b =='+' || b == '-' || b =='=';
}
bool isDigit(char a){
    if(a >= '0' && a<= '9'){
        return true;
    }else{
        return false;
    }
}

bool isLetter(char a){
    if(a >= 'a' && a<='z' || a>= 'A' && a<='Z'){
        return true;
    }else{
        return false;
    }
}

void topOp(){
    Value x = numStack.pop();
    Value y = numStack.pop();
    char z = opStack.pop();
    Fraction temp;
    if(z == '*'){
        temp = x.value * y.value;
    }else if(z == '/'){
        temp = x.value / y.value;
    }else if(z == '+'){
        temp = x.value + y.value;
    }else if(z == '-'){
        temp = x.value - y.value;
    }
    Value newNum;
    newNum.name = "";
    newNum.value = temp;
    numStack.push(newNum);
}

void eval(string s){
    numStack.clear();
    opStack.clear();
    opStack.push('$');
    int count = 0;
    Value num;
    while(count < s.length()){
        if(isDigit(s[count])){
            num.name = "";
            num.value = 0;
            while(isDigit(s[count])){
                num.value = num.value*10 + (s[count] - '0');
                count++;
            }
            numStack.push(num);
        }else if(!isDigit(s[count]) && isLetter(s[count])){
            string temp;
            while(!isDigit(s[count]) && isLetter(s[count])){
                temp += s[count];
                count++;
            }
            num.name = temp;
            numStack.push(num);
        }else if(s[count] == '('){
            opStack.push(s[count]);
            count++;
        }else if(s[count] == ')'){
            while(opStack.peek() != '('){
                topOp();
            }
            numStack.pop();
            count++;
        }else if(s[count] == '+' || s[count] == '*' || s[count] == '-' || s[count] == '/'){
            while(hasPrecedence(opStack.peek(), s[count])){
                topOp();
            }
            opStack.push(s[count]);
            count++;
        }else{
            count++;
        }
    }
    while(opStack.pop() != '$'){
        topOp();
    }
    numStack.pop();
}

int main() {
    string
        input;
    Dictionary
        vars;
    Fraction
        f(2,3);

    try {
        vars.add("foo", f);
    }
    catch (const std::overflow_error &e) {
        std::cout << "Caught an overflow" << std::endl;
        std::cout << "Message: " << e.what() << std::endl;
    }
    catch (const std::domain_error &e) {
        std::cout << "Caught a domain error, which shouldn't happen"
            << std::endl;
    }
    catch (...) {
        std::cout << "Caught some generic exception" << std::endl;
    }

    std::cout << "Hello, World!" << std::endl;
    return 0;


    while(true){
        cout << "Welcome to fraction calculator. Enter # to exit. " << endl;
        getline (cin, input);
        if(input == "#"){
            break;
        }else{
            eval(input);
        }
    }
}