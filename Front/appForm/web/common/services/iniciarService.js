var app = angular.module('appForm.loginService', []);

app.factory('LoginService', ['$http', '$q', function($http, $q){
	// uso de promesas
	var self = {
		login: function(datos){
			//var d = $q.defer();
			return $http.post('http://localhost:8081/inicio/usuario', datos);
			/*.success(function(data){
				self.dataUser = data;
				d.resolve();
			})
			.error(function(error){
				if(error == null){
					self.dataErr = {
						codigo: "-2",
						description: "No se puede conectar al servidor, contacte soporte!!!"
					};
				}else{
					self.dataErr = error;
				}

				console.log(error);
				d.reject();
			})

			return d.promise;*/
		}

	}


	return self;


}]);