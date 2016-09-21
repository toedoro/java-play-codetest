app.controller('customerController', ['$scope', 'fileService', function($scope, fileService){
	$scope.customers = [];
	
	$scope.upload = function(){
		var file = $scope.customerFile;

		console.dir(file);

		var url = 'http://localhost:9000/customers/preview';
		$scope.customers = fileService.submitFile(file, url);
	};

	//$http.get("http://www.w3schools.com/angular/customers.php").then(function (response) {$scope.customers = response.data.records;});
}]);