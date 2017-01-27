app.controller('gestionModalClienteCtrl', 
	['$scope',
	'ClientesResource', 
	'PersonasResource',
	'$rootScope', 
	'$cookieStore',
	function($scope, 
		ClientesResource, 
		PersonasResource, 
		$rootScope, 
		$cookieStore){

	var self = this;	
	// tipos de documentos cargados con anterioridad en una cookie
	this.tiposDoc = $scope.tiposDoc;
	//perfiles de usuarios cargados anteriormente en una cookie
    this.perfiles = $scope.perfiles;
	this.cliente = new ClientesResource();
	this.personaResource = PersonasResource;
	this.formClientes = {};
	this.camposNit = false;
    this.required = true;


	$rootScope.$on('changeTipoDoc', function(event, data){
    	if(!angular.isUndefined(data.value)){
	    	if(data.value.codigo == 'NIT'){
	    		self.camposNit = true;
	    		self.required = false;
	    		self.cliente.persona.nombre1 = "";
	    		self.cliente.persona.nombre2 = "";
	    		self.cliente.persona.apellido1 = "";
	    		self.cliente.persona.apellido2 = "";
	    	}else{
    			self.camposNit = false;
	    		self.required = true;
	    	}
    	}
    });

    /*
		datos que se envia a la vista en caso que sea edicion de datos
	*/
	this.valAccion = ""; // texto en caso que sea edicion o registro
	this.registro = true; // variable en caso que sea edicion o registro


    $rootScope.$on("callGetClientes", function(event, data){
    	// aqui se capturan los datos cuando sea edicion 
    	console.log(data);
    });


	this.guardar = function(){
		
		self.cliente.empresa = {};
		angular.copy(self.userActual.empresa, self.cliente.empresa);
		var response = self.cliente.$save();
		response.$promise.then(
		function(success){
			console.log(success);

		}, 
		function(error){
			console.log(error)

		})

	}



}]);