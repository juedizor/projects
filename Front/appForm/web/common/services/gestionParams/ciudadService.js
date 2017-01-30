var app = angular.module('appForm.ciudades', []);

app.factory('CiudadResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest + "gestionParams/ciudades", {}, {
		getCiudades: {
			url: urlRest + "gestionParams/ciudades/:idDepartamento", 
			method: 'GET', 
			params: {idDepartamento: "@idDepartamento"}, 
			isArray: true
		}

	});
}]);