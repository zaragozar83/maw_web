var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl1', function($scope, $http){
    $scope.refreshCart = function(cartId){
        $http.get('maw/rest/cart/' + $scope.cartId)
            .success(function(data){
                $scope.cart = data;
            });
    };

    $scope.clearCart = function(){
        $http.delete('maw/rest/dart/' + $scope.cartId)
            .success(function(data){
                $scope.refreshCart($scope.cartId);
            });
    };

    $scope.initCartId = function(cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function(productId) {
        $http.put('/maw/rest/cart/add/' + productId)
            .success(function(data) {
                alert("Product Successfully added to the Cart!");
            });
    };
    $scope.removeFromCart = function(productId) {
        $http.put('/maw/rest/cart/remove/' + productId)
            .success(function(data) {
                $scope.refreshCart($scope.cartId);
            });
    };
});