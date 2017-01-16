var app = angular.module('appForm.usuarios', []);

app.factory('UsuariosResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest + "gestionUsuarios/usuarios", {}, 
    		{
	            getPersona:{
	              	method:'GET',
	              	url:urlRest + "gestionUsuarios/usuarios/:tipoDoc/:numeroDoc",
                	params:{tipoDoc:"@tipoDoc",numeroDoc:"@numeroDoc"}
	            }, 
	            getUser:{
	            	method:'GET',
	              	url:urlRest + "gestionUsuarios/usuarios/:nombreUsuario",
	              	params:{nombreUsuario:"@nombreUsuario"}
	            }
    		});

}]);
