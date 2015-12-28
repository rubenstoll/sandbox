/**
 * Created by tk3sy on 16.12.2015.
 */
var greeter = require('./greeter');
var $ = require('jquery');
$(function () {
    $(document.body).html(greeter("Mundo world up there!!!!"));
});
