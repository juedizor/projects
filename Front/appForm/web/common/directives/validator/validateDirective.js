app.directive('validarCampoResource',function() {
    return {
      restrict: 'A',
      scope: {
        valueinput: '=',
        form: '=', 
        valueid: '=', 
        method: '=', 
        params: '=', 
        idmsgerr: '=', 
        valueant: '=', 
        msgerror: '=', 
        namefield: '='
      },
      link: function(scope, element, attributes) {
      	var valueAnt = "";
        scope.$watch('valueinput', function(value){
      		if(angular.isUndefined(value)){
      			angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
      		}
      	})
      	element.bind("blur", function(){
      		if(!angular.isUndefined(scope.valueinput)){
              if(scope.valueant == element.val()){
                angular.element("#"+scope.valueid).addClass("form-group has-success");
                angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
                angular.element("#"+scope.idmsgerr).html("");
                return;
              }
        			var funcion = scope.method;
  	      		funcion(scope.params).$promise.then(
  	      			function(success){
  	      				angular.element("#"+scope.valueid).removeClass();
  	      				angular.element("#"+scope.valueid).addClass("form-group has-error");
  	      				angular.element("#"+scope.idmsgerr).removeAttr('style');
                  angular.element("#"+scope.idmsgerr).html(scope.msgerror);
                  scope.namefield.$invalid = true;
  	      			}, 
  	      			function(error){
  	      				angular.element("#"+scope.valueid).removeClass();
  	      				angular.element("#"+scope.valueid).addClass("form-group has-success");
  	      				angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
                  angular.element("#"+scope.idmsgerr).html("");
                  scope.namefield.$invalid = false;
  	      			});
      		}else{
      			angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
            angular.element("#"+scope.idmsgerr).html("");
      		}
    	}) 
      }
    };
});