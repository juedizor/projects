var app = angular.module('appForm.usuarios', []);

app.factory('UsuariosResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest + "gestionUsuarios/usuarios/", {}, 
    		{
	            getUser:{
	            	method:'GET',
	              	url:urlRest + "gestionUsuarios/usuarios/usuario/:nombreUsuario",
	              	params:{nombreUsuario:"@nombreUsuario"}
	            }, 
	            getUsers:{
	            	method:'GET',
	              	url:urlRest + "gestionUsuarios/usuarios/:nombreUsuario",
	              	params:{nombreUsuario:"@nombreUsuario"}, 
	              	isArray: true
	            }
    		});

}]);
