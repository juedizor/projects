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
        msgerror: '='
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
                  scope.form.$invalid = true;
                  scope.form.$valid = false;
  	      			}, 
  	      			function(error){
  	      				angular.element("#"+scope.valueid).removeClass();
  	      				angular.element("#"+scope.valueid).addClass("form-group has-success");
  	      				angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
                  angular.element("#"+scope.idmsgerr).html("");
                  scope.form.$valid = false;
  	      			});
      		}else{
      			angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
            angular.element("#"+scope.idmsgerr).html("");
      		}
    	}) 
      }
    };
});


app.directive('fieldRequired', function(){
    return {
      restrict: 'A', 
      scope: {
        valueid: '=',
        msgerror: '=', 
        form: '=', 
        idmsgerr: '='
      }, 
      link: function(scope, element, attributes) {
        element.bind("blur", function(){
          if(element.val().length <= 0){
              angular.element("#"+scope.valueid).removeClass();
              angular.element("#"+scope.valueid).addClass("form-group has-error");
              angular.element("#"+scope.idmsgerr).removeAttr('style');
              angular.element("#"+scope.idmsgerr).html(scope.msgerror);
              scope.form.$invalid = true;
              scope.form.$valid = false;
          }else{
              angular.element("#"+scope.valueid).removeClass();
              angular.element("#"+scope.valueid).addClass("form-group has-success");
              angular.element("#"+scope.idmsgerr).attr('style', 'display:none');
              angular.element("#"+scope.idmsgerr).html("");
              scope.form.$invalid = false;
              scope.form.$valid = true;
          }
        });
      }
    }
});