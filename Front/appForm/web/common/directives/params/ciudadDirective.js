app.directive("ciudadDirective", 
	['$rootScope', 'CiudadResource', 
	function($rootScope, CiudadResource){
		return {
			restrict: 'E', 
			templateUrl: 'template/gestionParams/ciudades.html',
			scope: {
				ciudad: '=', 
				ciudades: '@', 
				obligatorio: '='
			}, 
			link: function(scope, element, attr){
				$rootScope.$on('changeDepartamento', function(event, data){
					if(!angular.isUndefined(data.value)){
						//console.log(data.value);
						if(!angular.isUndefined(data.value.idDepartamento)){
							//console.log(data.value);
							var ciudad = CiudadResource.getCiudades({idDepartamento: data.value.idDepartamento});
							ciudad.$promise.then(function(data){
								scope.ciudades = data;	
							}, 
							function(error){
								scope.ciudades = {};
							})						
						}else{
							scope.ciudades = {};	
						}
					}else{
						scope.ciudades = {};
					}
				})
			}
		}

}])