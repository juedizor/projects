var app = angular.module('appForm.empresas', []);

app.factory('EmpresasResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest + "gestionEmpresas/empresas", {});
}]);