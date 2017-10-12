angular.module('accountModule', [])
.controller('accountController', function($scope, $http) {
    $http.get('http://localhost:8080/accounts').
        then(function(response) {
            $scope.accounts = response.data;
        });
});