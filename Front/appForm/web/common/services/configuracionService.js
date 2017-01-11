
// este modulo tambien debe ser inyectado en el modulo principal app.js
var app = angular.module('appForm.configuracion', []);

// creacion de un servicio, este debe ser inyectado dentro del modulo principal
// tener en cuenta que el factory siempre debe hacer un return de algo
app.factory('Configuracion', ['$http', '$q', function($http, $q){

	// dentro de un objeto self se agregan dos atributos un array y  una funcion
	var self = {
		config: {}, 
		 // funcion encargada de cargar el archivo de configuracion.json  con los atributos principales de la 
		 // aplicacion, hace uso de promesas
		cargar: function(){
			var d = $q.defer();
			$http.get('../web/configuracion.json')
				.success(function(data){
					self.config = data;
					d.resolve();
				})
				.error(function(error){
					d.reject();
					console.log("no se pudo cargar el archivo de configuracion");
				});

			return d.promise;

		}

	}

	return self;
}]);