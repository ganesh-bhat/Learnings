var obj = {
    greet: function() {
        console.log("hello!");
    },
    message:'Hi Ganesh'

}

obj.greet();
console.log(obj.message);
console.log(obj['message']);

var arr = [];

arr.push(function(){
    console.log("hello world 1");
});
arr.push(function(){
    console.log("hello world 2");
});
arr.push(function(){
    console.log("hello world 3");
});

arr.forEach(function(item){
    item();
});