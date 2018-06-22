var fs = require('fs');

var msg = fs.readFileSync(__dirname+'/greet.txt','utf8');

console.log(msg);

var msg2 = fs.readFile(__dirname+'/greet.txt','utf8',
function(err,data){
    console.log(data);
});

console.log('Done');

