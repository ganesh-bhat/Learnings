var Emitter = require('events');
var util = require('util');

function Greeter() {
    this.greeting = 'hello world';

}


util.inherits(Greeter,Emitter);

Greeter.prototype.greet = function() {
    console.log('someone greeted');
    //passing arguments in the event emitter pattern
    this.emit('greet','Tony');

}



var grter = new Greeter();

grter.on('greet',function(data){
    console.log('greet event received :'+data);
});

grter.greet();