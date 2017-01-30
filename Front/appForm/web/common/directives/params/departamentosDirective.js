app.directive('departamentoDirective',['DepartamentosResource', '$rootScope',  
	function(DepartamentosResource, $rootScope){
	return {
		restrict: 'E', 
		templateUrl: "template/gestionParams/departamentos.html", 
		scope: {
			departamento: "=", 
			departamentos: "@", 
			obligatorio: "="
		}, 
		link: function(scope, element, attr){

			$rootScope.$on('changePais', function(event, data){
				console.log(scope.departamento)
				if(!angular.isUndefined(data.value)){
					if(!angular.isUndefined(data.value.idPais)){
						var depart = DepartamentosResource.getDepartamentos({idPais: data.value.idPais});
						depart.$promise.then(function(data){
							scope.departamentos = data;	
						})
					}else{
						scope.departamentos = {};	
					}
				}else{
					scope.departamentos = {};
				}
			});

			scope.$watch('departamento', function(value){
				$rootScope.$emit('changeDepartamento', {value});
				departamento = value;
			});
		}
	}
}])
