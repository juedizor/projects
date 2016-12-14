var app = angular.module('appForm', [
	'ngRoute', 
	'appForm.configuracion' // inyeccion del servicio creado para cargar la confiuguracion inicial
	]);

// en nuestro controlador principal
app.controller('mainCtrl', ['$scope', 'Configuracion', function($scope, Configuracion){
		
	$scope.config = {};
	$scope.usuario = {
		nombreUsuario: "nameUser"
	}

	// aqui se hace uso del servicio Configuracion, usando la promesa creada en el mismo. 
	Configuracion.cargar().then(
		function(){
			$scope.config = Configuracion.config;
		})


}]);