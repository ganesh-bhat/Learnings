greetData = require("./greetings.json");

greet = function() {
    console.log(greetData.en);
}

module.exports = greet;