app.directive('dirPerfiles', function(){
	return {
		restrict: 'E', 
		templateUrl: 'template/gestionParams/perfiles.html', 
		scope: {
			profile: "=", 
			perfiles: "="
		}
	};
});