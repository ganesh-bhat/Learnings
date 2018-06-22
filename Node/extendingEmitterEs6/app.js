'use strict';
var Greter = require('./greet');

var greter = new Greter();
greter.on('greet', function(data) {
    console.log('Someone greeted me:'+data);
})

console.log('some random work');
greter.greet('Tony');