//Process an operator



Value a,b;

char op = opStack.pop();
a = numStack.pop();
b = numStack.pop();

if(op == '='){
	vars.add(a.name,b.value);
	numStack.push(b);
}