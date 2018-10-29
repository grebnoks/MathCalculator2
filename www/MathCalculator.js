// var exec = require('cordova/exec');
//
// module.exports.add = function (arg0,success, error)
// {
//     exec(success , error, 'MathCalculator' , 'add' , [arg0]);
// }
//
// module.exports.substract = function (arg0,success, error)
// {
//     exec(success , error, 'MathCalculator' , 'substract' , [arg0]);
// }


var exec = require('cordova/exec');

var PLUGIN_NAME = 'MathCalculator';

var MyCordovaPlugin = {
    add: function(arg0,success, error) {
        exec(success , error, PLUGIN_NAME , 'add' , [arg0]);
    },
    initializeVGD: function (arg0, success, error) {
        exec(success , error, PLUGIN_NAME , 'initializeVGD' , [arg0]);
    },
    substract: function (arg0,success, error) {
        exec(success , error, PLUGIN_NAME , 'substract' , [arg0]);
    }
};

module.exports = MyCordovaPlugin;