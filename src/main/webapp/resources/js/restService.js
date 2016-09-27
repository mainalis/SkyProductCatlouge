/**
 * Created by sushilmainali on 25/09/2016.
 */


'use strict';

app.factory('ProductService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/SkyProductCatlouge/getCatalogue';
    var property = 'First';

    var factory = {

        fetchAllProduct: fetchAllProduct,
        fetchAllUser: fetchAllUser,
        fetchProductByUserId: fetchProductByUserId,
        fetchDefaultProduct: fetchDefaultProduct,
        displayBasket: displayBasket,
        deleteUser:deleteUser,
        getBasket: getBasket,
        setBasket: setBasket
    };

    return factory;

    function fetchAllProduct() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/allProduct")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function fetchAllUser() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/allUser")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function fetchProductByUserId(userId) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/productByUserId/"+userId)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function displayBasket(basket) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + "/basketEntry", basket)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function fetchDefaultProduct() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "/productDefault")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }



    function updateUser(user, id) {

    }

    function deleteUser(id) {

    }


    function getBasket( ) {
        return property;
    }


    function setBasket(item) {
        property = item;
    }

}]);