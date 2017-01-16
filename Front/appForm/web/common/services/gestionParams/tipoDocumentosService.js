var app = angular.module('appForm.tipoDocumentos', []);

app.factory('TipoDocumentosResource', ['$resource', 'urlRest', function($resource, urlRest){
	return $resource(urlRest+"gestionParams/tipoDocumentos", {}, 
		{
            query: { method: "GET", isArray: true },
            create: { method: "POST"},
            get: { method: "GET"},
            remove: { method: "DELETE"},
            update: { method: "PUT"}
        });
}]);