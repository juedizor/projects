var app = angular.module('appForm.usuarios', []);

app.factory('UsuariosResource', ['$resource', 'urlRest',  function($resource, urlRest){
	return $resource(urlRest+"gestionUsuarios/usuarios/all", {}, 
	     {
          query: { method: "GET", isArray: true }
       });
}]);


app.factory('RegistrarUsuariosResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest + "gestionUsuarios/usuarios", {}, 
    		{
		        query: { method: "GET", isArray: true },
            create: { method: "POST"},
            get: { method: "GET"},
            remove: { method: "DELETE"},
            update: { method: "PUT"}
    		});

}]);

app.factory('ValidarPersonaResource', ['$resource', 'urlRest', function($resource, urlRest){
    return $resource(urlRest + "gestionUsuarios/usuarios", {}, 
      {
        query: { method: "GET", isArray: true }
      });
}]);
