app.config(['$routeProvider', function($routeProvider){

	$routeProvider
		.when('/login', {
			templateUrl: 'template/login.html',
			controller: 'inicioCtrl', 
			controllerAs: 'inicio'
		})
		.when('/gestion', {
			templateUrl: 'dashboard/dashboard.html'
			
		})
		.when('/usuarios', {
			templateUrl: 'template/gestionUsuarios/usuarios.html', 
			controller: 'listarUsuariosCtrl', 
			controllerAs: 'listarUsuariosCtrl'
			
		})
		.otherwise({
			redirecTo: '/'
		})

}]);