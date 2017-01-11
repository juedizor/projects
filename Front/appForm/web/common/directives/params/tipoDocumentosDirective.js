app.directive('dirTipoDocumentos',	function(){
	return {
		restrict: 'E', 
		templateUrl: 'template/gestionParams/tipoDocumentos.html', 
		scope: {
			tiposDoc: "=docs", 
			tipoDocumentos: "=tipos"
		}
	};
});