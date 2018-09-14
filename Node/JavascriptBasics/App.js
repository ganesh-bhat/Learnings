/* reg ex for telephone number */

var numbers = ['9008826000','+91 9008826000','080 26369595']

var pattern1 = /^([0-9]{10})$/
var pattern2 = /^(\+[0-9]{2}\s[0-9]{10})$/
var pattern3 = /^\d{3}\s\d{8}$/

var megaPattern = /^(([0-9]{10})|(\+[0-9]{2}\s[0-9]{10})|(\d{3}\s\d{8}))$/

console.log(megaPattern.test('+91 9008826000'));
console.log(megaPattern.test('9008826000'));
console.log(megaPattern.test('080 26369595'));

//swap numbers
var x = 10
var y = 16

x = x^y
y = x^y
x = x^y

console.log('x:'+x+',y:'+y);


x = x+y
y = x-y
x = x-y

console.log('x:'+x+',y:'+y);