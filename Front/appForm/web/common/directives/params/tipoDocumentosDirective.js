app.directive('dirTipoDocumentos',	function($rootScope){
	return {
		restrict: 'E', 
		templateUrl: 'template/gestionParams/tipoDocumentos.html', 
		scope: {
			tiposDoc: "=docs", 
			tipoDocumentos: "=tipos", 
			obligatorio: "="
		}, 
		link: function(scope, element, attr){
			scope.$watch('tipoDocumentos', function(value){
				$rootScope.$emit('changeTipoDoc', {value});
			})
		}
	};
});