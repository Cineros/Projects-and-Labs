hasPrecedence(char a, char b){
    if(a == '/' || a == '*'){
        return true;
    }
    if(a == '(' or a == '=' || a == '$'){
        return false;
    }
    return b =='+' || b == '-' || b =='=';
}

struct Value{
    string name;
    Fraction value;
}

bool isDigit(char a){
    if(a >= 48 && a <= 57){
        return true;
    }else{
        return false;
    }
}
void topOp(){
    Value x = numStack.pop();
    Value y = numStack.pop();
    char z = opStack.pop();
    if(z == '*'){
        Fraction temp = x.value * y.value;
    }else if(z == '/'){
        Fraction temp = x.value / y.value;
    }else if(z == '+'){
        Fraction temp = x.value + y.value;
    }else if(z == '-'){
        Fraction temp = x.value - y.value;
    }
    Value newNum;
    newNum.name = "";
    newNum.value = temp;
    numStack.push(newNum);
}

void eval(string s){
    clear numStack
    clear opStack
    opStack.push('$');
    int first = 0;
    Value num;
    while(first < s.length()){
        if(isDigit(s[first])){
            num.name = "";
            num.value = 0;
            while(isDigit(s[first])){
                num.value = num.value*10 + (s[first] - '0');
                first++;
            }
            numStack.push(num);
        }else if(!isDigit(s[first])){
            string temp;
            while(!isDigit(s[first])){
                temp += s[first];
                first++;
            }
            num.name = temp;
            numStack.push(num);
        }else if(s[first] == '('){
            opStack.push('(');
            first++;
        }else if(s[first] == ')'){
            while(opStack.peek() != '('){
                topOp();
            }
        }
    }
}