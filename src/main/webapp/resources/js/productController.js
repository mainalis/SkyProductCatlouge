/**
 * Created by sushilmainali on 25/09/2016.
 */

app.controller('ProductController',['$scope', '$rootScope','BasketService' ,'ProductService', 'myService', function($scope, $rootScope, BasketService ,ProductService, myService){


    $scope.selectedUser = 0;
    // user list
    var defaultUser = {'userId': 0, 'userLocationId':{}, 'userName':"Select User"};
    $scope.userList = [];
    // product list
    $scope.productList = [];

    // Shopping cart content
    $scope.shoppingList = [];

    getAllProduct();


    ProductService.fetchAllUser().then(
        function(success){
            $scope.userList[0] = defaultUser;
            $scope.userList = $scope.userList.concat(success);
        },
        function(faliure){
            console.log("Error in rest call");
        });



    $scope.updateProduct = function() {
        var tt = $scope.selectedUser;
        if($scope.selectedUser > 0) {
            ProductService.fetchProductByUserId($scope.userList[$scope.selectedUser].userId).then(function(success){
                $scope.productList.length = 0;
                $scope.shoppingList.length = 0;
                $scope.productList = success;
                removeItem();
                loadProductToPage();
            },function(){})
        } else {
            $scope.productList.length = 0;
        }
    };


    function getAllProduct() {
        // requesting product
        ProductService.fetchDefaultProduct().then(
            function(success){
                $scope.productList = success;
                loadProductToPage();
            },
            function (fail) {
                console.log("Error in rest call");
            });
    }

    function loadProductToPage() {
        var entertainmentDiv = $('#entCont');
        var music =  $('#musCont');
        var news =  $('#newsCont');
        var sport =  $('#sptCont');

        localStorage.clear();

        angular.forEach($scope.productList, function(value, key){

            switch (value.productType) {
                case "NEWS":
                    news.append('</br><label><input type="checkbox"  id=' + value.productId +"_"+ value.productType + ' value = "'+value.productName+'" ng-click="updateBasket()">' +  value.productName + '</label>');
                    $('#'+value.productId +"_"+ value.productType).on('click',$scope.updateBasket);
                    break;
                case "MUSIC":
                    music.append('</br><label><input type="checkbox"  id=' + value.productId +"_"+ value.productType + ' value = "'+value.productName+'" ng-click="updateBasket()">' +  value.productName + '</label>');
                    $('#'+value.productId +"_"+ value.productType).on('click',$scope.updateBasket);
                    break;
                case "ENTERTAINMENT":
                    entertainmentDiv.append('</br><label><input type="checkbox"  id=' + value.productId +"_"+ value.productType + ' value = "'+value.productName+ '" ng-click="updateBasket()">' +  value.productName + '</label>');
                    $('#'+value.productId +"_"+ value.productType).on('click',$scope.updateBasket);
                    break;
                case "SPORTS":
                    sport.append('</br><label><input type="checkbox"  id=' + value.productId +"_"+ value.productType + ' value = "'+value.productName+ '" ng-click="updateBasket()">' +  value.productName + '</label>');
                    $('#'+value.productId +"_"+ value.productType).on('click',$scope.updateBasket);
                    break;
            }

        });
    }

    function removeItem() {
        $('#entCont').empty();
        $('#musCont').empty();
        $('#newsCont').empty();
        $('#sptCont').empty();
    }

    $scope.updateBasket = function () {

        if($('#'+this.id).is(':checked')) {
            $scope.$apply( $scope.shoppingList.push({"id":this.id, "value":this.value}));
            localStorage.setItem(this.id, this.value);
        } else {

                var index = findIndex(this.id);
                $scope.$apply( $scope.shoppingList.push( $scope.shoppingList.splice(index, 1)));
                localStorage.removeItem(this.id);
        }

    }


    function findIndex(index) {
        var ret = -1;
        for(var i = 0; i < $scope.shoppingList.length;  i++) {
            if($scope.shoppingList[i].id === index) {
                ret = i;
                break;
            }
        }
        return ret;
    }


    $scope.submitShopping = function() {
        myService.set($scope.userList);
        window.location="http://localhost:8080/SkyProductCatlouge/getBasket";

    };

}]);