// controlador para el manejo del login de la aplicación
app.controller('inicioCtrl', 
	['$scope', 
	'LoginService', 
	'$rootScope', 
	'$location', 
	'$cookieStore',
	function($scope, 
		LoginService, 
		$rootScope, 
		$location, 
		$cookieStore){

	var self = this;

	/*INICIO DE SESION, EN EL CONTROLADOR PRINCIPAL */

	this.invalido = false;
	this.cargando = false;
	this.mensaje = "";

	this.dataUser = {};
	this.dataErr = {};
	this.redirecTo = "/gestion"

	this.ingresar = function( datos )	{
		if(datos.usuario.length < 3){
			self.invalido = true;
			self.mensaje = "Ingrese su usuario"; 
			return 
		}else{
			if(datos.contrasena.length < 3){
				self.invalido = true;
				self.mensaje = "Ingrese su contraseña"; 
				return;	
			}
		}

		self.invalido = false;
		self.cargando = true;
		// se utliza el servicio inyectado
		// se usa la promesa creada en el mismo para poder realizar el consumo del inicio de login
		LoginService.login(datos).then(
			function(){ // funcion cuando la promesa es exitosa
				self.cargando = false;
			    $cookieStore.put('estaConectado', true);
			    $cookieStore.put('usuario', LoginService.dataUser);
				$rootScope.user.valido = true;
				$rootScope.wrapper = "wrapper";
				$rootScope.init = "hold-transition skin-purple sidebar-mini";
				$location.url(self.redirecTo);
			}, 
			function(){ // funcion cuando la promesa genero error
				self.cargando = false;
				self.invalido = true;
				self.dataErr = LoginService.dataErr;
				self.mensaje = self.dataErr.description;
			});

	}

}]);
