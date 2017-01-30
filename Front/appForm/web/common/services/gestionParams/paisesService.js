var app = angular.module('appForm.paises', []);

app.factory('PaisesResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest+"gestionParams/paises", {});
}]);