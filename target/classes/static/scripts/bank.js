angular.module('bankModule', [])
.controller('bankController', function($scope, $http) {
    $http.get('http://localhost:8080/banks').
        then(function(response) {
            $scope.banks = response.data;
        });
    $scope.bankName = function(id) {
    	var bankName = $http.get('http://localhost:8080/banks/' + id).then(
    			function(response) {S
    			 $scope.bankName=response.data.name;
    		});
		return bankName;
    }
});