app.controller('formulariosCtrl', 
	['$scope',
	'i18nService',
	 function($scope, i18nService){
	
	// se activa el menu de gestion de formularios
	$scope.setActive('gFormularios');


	i18nService.setCurrentLang('es');
 	this.gridOptions = {
 		enableFiltering: true, 
 		enableSorting: true,
 		data: null, 
 		enableColumnResizing: true,
	    paginationPageSizes: [5, 10, 15],
		paginationPageSize: 10
 	}


 	this.gridOptions.appScopeProvider  = this;

	

	

	
}]);