var app = angular.module('appForm.personas', []);

app.factory('PersonasResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest + "gestionPersonal/personas", {}, 
    		{
	            getPersona:{
	              	method:'GET',
	              	url:urlRest + "gestionPersonal/personas/:tipoDoc/:numeroDoc",
                	params:{tipoDoc:"@tipoDoc",numeroDoc:"@numeroDoc"}
	            },
	            getPersonaEmail:{
	            	method: 'GET', 
	            	url: urlRest + "gestionPersonal/personas/:email", 
	            	params: {email: "@email"}, 
	            }
    		});

}]);