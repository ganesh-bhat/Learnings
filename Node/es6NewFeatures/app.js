'use strict';

class Person {
    constructor(firstName,lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    greet() {
        console.log('Hello, '+this.firstName+" "+this.lastName)
    }
}


var name = 'John Doe';

var greet = 'hello' + name;
//template literal
var greet2 = `hello ${name}`;
console.log(greet);
console.log(greet2);

var ganesh = new Person('Ganesh','Bhat');
ganesh.greet();

