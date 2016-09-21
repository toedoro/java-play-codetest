app.service('fileService', ['$http', function ($http) {
	this.submitFile = function(file, uploadUrl){
		var data = new FormData();
		data.append('file', file);

		$http.post(uploadUrl, data, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).success(function(response){
			return response.data;
		}).error(function(err){
			alert(err);
		});
	}
}]);