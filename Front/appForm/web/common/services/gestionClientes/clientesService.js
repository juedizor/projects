var app = angular.module('appForm.clientes', []);

app.factory('ClientesResource', ['$resource', 'urlRest',  function($resource, urlRest){
	return $resource(urlRest + "gestionClientes/clientes", {}, 
	{
		getClientes: {
			url: urlRest + "gestionClientes/clientes/:idEmpresa", 
			method: 'GET', 
			params: {idEmpresa: "@idEmpresa"}, 
			isArray: true
		}

	});
}])