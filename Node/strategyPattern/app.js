function add(a,b){
    return a+b;
}

function minus(a,b) {
    return a-b;
}

var operations =  {
    '+': add,
    '-':minus
}

function calculate(a,b,operator) {
    return operations[operator](a,b);
}

var out = calculate(5,6,'+');
console.log(out);


out = calculate(5,3,'-');
console.log(out);