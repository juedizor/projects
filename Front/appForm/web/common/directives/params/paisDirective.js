app.directive('paisDirective',['PaisesResource', '$rootScope',  
	function(PaisesResource, $rootScope){
	return {
		restrict: 'E', 
		templateUrl: 'template/gestionParams/paises.html', 
		scope: {
			pais: '=', 
			paises: '@',
			obligatorio: '='
		}, 
		link: function(scope, element, attr){
			var pais = PaisesResource.query();
			pais.$promise.then(function(data){
				scope.paises = data;	
			})			
			scope.$watch('pais', function(value){
				$rootScope.$emit("changePais", {value});
				pais = value;
			})
		}

	}

}])