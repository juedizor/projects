var app = angular.module('appForm.personas', []);

app.factory('PersonasResource', ['$resource', 'urlRest', function($resource, urlRest){
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
	            }, 
	            getPersonaEmail:{
	            	method: 'GET', 
	            	url: urlRest + "gestionUsuarios/usuarios/persona/:email", 
	            	params: {email: "@email"}
	            }
    		});

}]);
