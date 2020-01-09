var exec = require('cordova/exec');

module.exports.networkCheck = function (arg0, success, error) {
    exec(success, error, 'CustomAlert', 'network', []);
};