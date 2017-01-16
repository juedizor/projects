
// este modulo tambien debe ser inyectado en el modulo principal app.js
var app = angular.module('appForm.configuracion', []);

// creacion de un servicio, este debe ser inyectado dentro del modulo principal
// tener en cuenta que el factory siempre debe hacer un return de algo
app.factory('Configuracion', ['$http', '$q', function($http, $q){

	var self = {
		cargar: function(){
			return $http.get('../web/configuracion.json');
		}
	}

	return self;
}]);