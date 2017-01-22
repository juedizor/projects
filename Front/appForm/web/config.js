app.config(['$routeProvider', function($routeProvider){

	$routeProvider
		.when('/login', {
			templateUrl: 'template/login.html',
			controller: 'inicioCtrl', 
			controllerAs: 'inicio'
		})
		.when('/gestion', {
			templateUrl: 'template/inicio/main.html',	
			controller: 'principalCtrl', 
			controllerAs: 'principal'
			
		})
		.when('/usuarios', {
			templateUrl: 'template/gestionUsuarios/usuarios.html', 
			controller: 'listarUsuariosCtrl', 
			controllerAs: 'listarUsuariosCtrl'
			
		})
		.when('/formularios', {
			templateUrl: 'template/gestionFormularios/formularios.html', 
			controller: 'formulariosCtrl', 
			controllerAs: 'formulariosCtrl'
			
		})
		.when('/clientes', {
			templateUrl: 'template/gestionClientes/clientes.html', 
			controller: 'clientesCtrl', 
			controllerAs: 'clientesCtrl'
			
		})
		.otherwise({
			redirecTo: '/'
		})

}]);