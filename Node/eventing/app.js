var Emitter = require('./emitter');

var emtr = new Emitter();

emtr.on('greet',function() {
    console.log('someone greeted me');
});

emtr.on('greet',function() {
    console.log('someone somewhere greeted me');
});

console.log('hello');

emtr.emit('greet');



