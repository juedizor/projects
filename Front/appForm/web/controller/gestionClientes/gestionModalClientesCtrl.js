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
    this.userActual = $cookieStore.get('usuario');

    this.mostrarMsgTransaccion = false; // muestra el mensaje de finalizacion de la transaccion al momento de guardar
	this.msgTransaccion = ""; // texto del mensaje de la transaccion
	this.classMsgTransaccion = "alert-success-custom"; // clase css a aplicar en el mensaje, en la transaccion


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
    	//console.log(data);
    	self.getDataClient(data);
    });

    this.getDataClient = function(data){
    	if(!angular.isUndefined(self.formClientes)){
    		self.formClientes.$setPristine();
    		self.formClientes.$setUntouched();
    	}

    	self.valAccion = "Edición";
    	if(data.registro){
    		self.valAccion = "Registro";
    		self.cliente = new ClientesResource();
    	}else{
    		self.cliente = new ClientesResource(data.cliente)

    	}


    	console.log(data)
    }



	this.guardar = function(){
		
		self.cliente.empresa = {};
		angular.copy(self.userActual.empresa, self.cliente.empresa);
		var response = self.cliente.$save();
		response.then(
		function(success){
			self.mostrarMsgTransaccion = true;
			self.msgTransaccion = success.description;
			self.formClientes.$setPristine();
			self.formClientes.$setUntouched();
			ClientesResource.getClientes({idEmpresa: self.userActual.empresa.idEmpresa}).$promise.then(function(data){
		    	$rootScope.$emit("updateCliente", {data});
		    })

		}, 
		function(error){
			self.mostrarMsgTransaccion = true;
			self.msgTransaccion = error.data.description;
			self.classMsgTransaccion = "alert-danger-custom";
		})

	}



}]);