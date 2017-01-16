app.directive('isExisteUsuario',['UsuariosResource',function(UsuariosResource) {
    return {
      restrict: 'A',
      require: 'ngModel',
      scope: {
        valueinput: '=',
        form: '=', 
        valueid: '=', 
        method: '=', 
        params: '=', 
        idmsgerr: '='
      },
      link: function(scope, element, attributes, ngModel) {
      	scope.$watch('valueinput', function(value){
      		if(angular.isUndefined(value)){
      			angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
      		}
      	})
      	element.bind("blur", function(){
      		if(!angular.isUndefined(scope.valueinput)){
      			var funcion = scope.method;
	      		funcion(scope.params).$promise.then(
	      			function(success){
	      				angular.element("#"+scope.valueid).removeClass();
	      				angular.element("#"+scope.valueid).addClass("form-group has-error");
	      				angular.element("#"+scope.idmsgerr).removeAttr('style');
			      		scope.form.nombreUsuario.$valid = false;
			      		scope.form.nombreUsuario.$invalid = true;
	      			}, 
	      			function(error){
	      				angular.element("#"+scope.valueid).removeClass();
	      				angular.element("#"+scope.valueid).addClass("form-group has-success");
	      				angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
			      		scope.form.nombreUsuario.$valid = true;
			      		scope.form.nombreUsuario.$invalid = false;
	      			});
      		}else{
      			angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
	      		scope.$apply()
      		}
    	}) 
      }
    };
}]);