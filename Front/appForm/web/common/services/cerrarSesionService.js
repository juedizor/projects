var app = angular.module('appForm.cerrarSesion', []);

app.factory('CerrarSesion', function($cookieStore){
	var self = {
		isCerro: false, 
		cerrar: function(){
			$cookieStore.remove("usuario");
			self.isCerro = true;
			return self.isCerro;
		}
	}
return self;

})