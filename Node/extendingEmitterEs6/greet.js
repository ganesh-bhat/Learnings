'use srtict';
var EventEmitter = require('events');

module.exports = class Greter extends EventEmitter {
    constructor() {
        super();
        this.greeting = 'Hello world';
    }

    greet(data) {
        console.log('Hello, greeting is:'+this.greeting);
        this.emit('greet',data);

    }
}