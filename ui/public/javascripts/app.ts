/**
 * Created by tk3sy on 16.12.2015.
 */


import greeter = require('./greeter');
import $ = require('jquery');

$(() => {
    $(document.body).html(greeter("Mundo world up there!!!!"));
});