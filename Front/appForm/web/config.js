app.config(['$routeProvider', function($routeProvider){

	$routeProvider
		.when('/', {
			templateUrl: 'dashboard/dashboard.html'
		})
		.otherwise({
			redirecTo: '/'
		})

}]);