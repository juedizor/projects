var app = angular.module('appForm.departamentos', []);

app.factory('DepartamentosResource', ['$resource', 'urlRest',  function($resource, urlRest){
	return $resource(urlRest + "gestionParams/departamentos", {}, {
		getDepartamentos: {
			url: urlRest + "gestionParams/departamentos/:idPais", 
			method: 'GET', 
			params: {idPais: "@idPais"}, 
			isArray: true
		}

	})
}])