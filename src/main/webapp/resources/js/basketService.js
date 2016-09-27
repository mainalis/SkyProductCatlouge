/**
 * Created by sushilmainali on 26/09/2016.
 */
app.service('BasketService', function() {
    var productList = [];

    var addProduct = function(newObj) {
        productList.push(newObj);
    };

    var getProducts = function(){
        return productList;
    };

    return {
        addProduct: addProduct,
        getProducts: getProducts
    };

});
