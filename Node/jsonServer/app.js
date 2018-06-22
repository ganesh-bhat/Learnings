var http = require('http');
var fs = require('fs');

http.createServer(function(req,resp){

    resp.writeHead(200,{
        'Content-Type':'application/json'
    });

    var obj = {
        firstName: 'Ganesh',
        lastName: 'Bhat'
    };

    resp.end(JSON.stringify(obj));

}).listen(12311,"127.0.0.1");