var Emitter = require('events');

var emtr = new Emitter();

emtr.on('test',function(){

    console.log("my test event fired");
});

emtr.on('test',function(){

    console.log("someone somewere  fired my event");
});

console.log('started app');

emtr.emit('test');




