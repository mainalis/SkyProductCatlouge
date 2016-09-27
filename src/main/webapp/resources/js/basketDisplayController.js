/**
 * Created by sushilmainali on 26/09/2016.
 */

app.controller('BasketController',['$scope','BasketService','myService', function($scope,BasketService, myService) {


    $scope.productList = [];

    //for(var i = 0; i < localStorage.length; i++) {
    //    $scope.productList.push(localStorage[i]);
    //}

    $.each(localStorage, function(index, value){
        $scope.productList.push(value);
    })


}]);