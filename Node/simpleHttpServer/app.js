var http = require('http');
var fs = require('fs');

http.createServer(function(req,resp){

    resp.writeHead(200,{
        'Content-Type':'text/html'
    });

    fs.createReadStream(__dirname+'/index.htm').pipe(resp);

}).listen(12311,"127.0.0.1");