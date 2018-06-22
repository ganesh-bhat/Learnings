var fs = require('fs');
var zlib = require('zlib');


//reading from streams

var reader = fs.createReadStream(__dirname+'/long_text.txt', {
    encoding:'utf8',
    highWaterMark:16 * 1024
});

var gzip = zlib.createGzip();

var writer = fs.createWriteStream(__dirname+'/long_textcopy.txt');

var compressed = fs.createWriteStream(__dirname+'/long_textcopy.txt.gz');

reader.pipe(writer);

reader.pipe(gzip).pipe(compressed);
