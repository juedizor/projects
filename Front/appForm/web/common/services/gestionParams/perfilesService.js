var app = angular.module('appForm.perfil', []);


app.factory('PerfilResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest+"gestionParams/perfiles", {}, 
		{
			query: { method: "GET", isArray: true },
            create: { method: "POST"},
            get: { method: "GET"},
            remove: { method: "DELETE"},
            update: { method: "PUT"}
		});

}]);