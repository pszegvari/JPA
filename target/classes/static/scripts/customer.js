var customerModule = angular.module("customerModule", []);

customerModule.controller('customerController', function($scope, $http) {
	$http.get('http://localhost:8080/cCustomers.htmlustomers').then(function(response) {
		$scope.customers = response.data;
	});
	$scope.formattedAddress = function(address) {
		var formattedAddress = address.country + " - " + address.zipCode + " - " +
		address.city + ", " + address.publicPlace + " " +
		address.publicPlaceType + " " + address.houseNumber;
		if (address.others) {
			formattedAddress = formattedAddress + " " + address.others;
		}
		return formattedAddress;
	}
});