var app = angular.module('appForm', [
	'ngRoute',
	'ngCookies',
	'ngResource',
	'appForm.loginService', 
	'appForm.configuracion', 
	'appForm.cerrarSesion', 
	'appForm.usuarios', 
	'appForm.tipoDocumentos', 
	'appForm.perfil', 
	'jcs-autoValidate', 
	'ui.bootstrap', 
	'ui.grid', 
	'ui.grid.resizeColumns', 
	'ui.grid.autoResize', 
	'ui.grid.pagination'
	]);


// variables de rootScope
app.run(['$rootScope', function($rootScope){
	$rootScope.config = {};
	$rootScope.user = {
		valido: false
	};
	$rootScope.usuario = {};
	$rootScope.wrapper = "";
	$rootScope.init = "sidebar-collapse login-page";
	
}]);

// generacion de una constante para la direccion http de los servicios
app.constant("urlRest","http://localhost:8081/");


app.controller('mainCtrl', 
	['$rootScope', 
	'$scope', 
	'LoginService', 
	'Configuracion', 
	'$location',
	'$cookieStore',
	'CerrarSesion',
	'TipoDocumentosResource', 
	'PerfilResource', 
	function(
		$rootScope,
		$scope, 
		LoginService, 
		Configuracion,
		$location, 
		$cookieStore, 
		CerrarSesion, 
		TipoDocumentosResource, 
		PerfilResource){

	// Configuracion - servicio que realizar el cargue de la configuracion inicial de la aplicacion - 
	// como version, nombre, entre otros. 
	// LoginService - Servicio para realizar el inicio de sesion a traves de consumo restFull	
	// BridgeDataUser -  servicio que guarda  las variables de inicio de sesion del aplicaitvo	

	$scope.gUsuarios     = "";
	$scope.gFormularios  = "";



	// cargue inicial de los tiepos de documentos de persoinas
	var tiposDocumentos = $cookieStore.get('tiposDocumentos');
	if(tiposDocumentos !== undefined && tiposDocumentos.length > 0){
		$scope.tiposDoc = tiposDocumentos;
	}else{
		$scope.tiposDoc =  TipoDocumentosResource.query();
		$cookieStore.put('tiposDocumentos', $scope.tiposDoc);
	}

	// cargue inicial de los perfiles de usuarios
	var perfiles = $cookieStore.get('perfiles');
	if(perfiles !== undefined && perfiles.length > 0){
		$scope.perfiles = perfiles;
	}else{
		$scope.perfiles = PerfilResource.query();
		$cookieStore.put('perfiles', $scope.perfiles);
	}
	
	
	// obtiene los datos del usuario almacenado en cookies
	// indica que ya inicio sesion
	var usr = $cookieStore.get('usuario');
	// aqui se hace uso del servicio Configuracion, 
	//usando la promesa creada en el mismo. 
	Configuracion.cargar().then(
		function(value){
			$rootScope.config = value.data;
	})

	
	if(usr == undefined){ // verifica tenga un inicio de sesion
		// en caso de no tenerlo redirecciona a la pagina de login 	
		$location.url("/login");
		$rootScope.usuario = {};
		$rootScope.user.valido = false;
		$rootScope.countIngresoValido = 0;
	}else{
		// si tiene login correcto redirecciona a la pagina principal
		$rootScope.wrapper = "wrapper";
		$rootScope.init = "hold-transition skin-purple sidebar-mini";
		$rootScope.usuario = usr;
		$rootScope.user.valido = true;
	}


	// cierra la sesion de la cookie creada y redireccion a la pagina de inicio
	$scope.salir = function(){
		var cerrar = CerrarSesion.cerrar();
		console.log(cerrar);
		if(cerrar){
			$rootScope.wrapper = "";
			$rootScope.init = "sidebar-collapse login-page";
			$rootScope.usuario = {};
			$rootScope.user.valido = false;
			$location.url("/login");
		}
	}


	// funcion para activar menus y submenus
	$scope.setActive = function(menu, submenu){
		$scope.gUsuarios     = "";
		$scope.gFormularios  = "";

		$scope[menu] = "active";
	}

}]);

;