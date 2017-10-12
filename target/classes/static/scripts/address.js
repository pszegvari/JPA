var addressModule = angular.module("addressModule", []);

addressModule.controller('addressController', function($scope, $http) {
	$http.get('http://localhost:8080/addresses').then(function(response) {
		$scope.addresss = response.data;
	});
	$scope.formattedAddress = function(address) {
		var formattedAddress = address.zipCode + " - " +
		address.settlement + ", " + address.publicPlace + " " +
		address.publicPlaceType + " " + address.houseNumber;
		if (address.others) {
			formattedAddress = formattedAddress + " " + address.others;
		}
		return formattedAddress;
	}
});