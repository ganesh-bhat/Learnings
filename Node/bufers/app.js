var buff = new Buffer('Hello');
console.log(buff);

console.log(buff.toString());
console.log(buff.toJSON());


console.log(buff[2]);

buff.write('WO');

console.log(buff.toString());




