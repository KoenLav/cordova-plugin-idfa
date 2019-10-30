var exec = require("cordova/exec");
var PLUGIN_NAME = "AdvertisingId";

module.exports = {
    getInfo: function () {
        return new Promise(function (resolve, reject) {
            exec(resolve, reject, PLUGIN_NAME, "getInfo", []);
        });
    }
};
