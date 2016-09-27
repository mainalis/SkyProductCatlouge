/**
 * Created by sushilmainali on 26/09/2016.
 */

app.factory('myService', function() {
    var savedData = {}
    function set(data) {
        savedData = data;
    }
    function get() {
        return savedData;
    }

    return {
        set: set,
        get: get
    }

});
