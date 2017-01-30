app.controller('gestionEmpresaModalCtrl', 
	['$scope', 
	'$rootScope', 
	'PersonasResource', 
	'UsuariosResource',
	'$cookieStore', 
	'EmpresasResource', 	
	function($scope, 
		$rootScope, 
		PersonasResource, 
		UsuariosResource, 
		$cookieStore, 
		EmpresasResource){
	

	var self = this;	
	// tipos de documentos cargados con anterioridad en una cookie
	this.tiposDoc = $scope.tiposDoc;
	//perfiles de usuarios cargados anteriormente en una cookie
    this.perfiles = $scope.perfiles;

    this.camposNit = false;
    this.required = true;
    this.empresa = new EmpresasResource();
    this.usuarioResource = UsuariosResource;
    this.personaResource = PersonasResource;
    this.formEmpresa = {};
    this.contrasena2 = "";
    this.required = true;

    this.mostrarMsgTransaccion = false; // muestra el mensaje de finalizacion de la transaccion al momento de guardar
	this.msgTransaccion = ""; // texto del mensaje de la transaccion
	this.classMsgTransaccion = "alert-success-custom"; // clase css a aplicar en el mensaje, en la transaccion

    this.guardar = function(){
		var response = self.empresa.$save();
    	response.then(function(success){
    		self.mostrarMsgTransaccion = true;
			self.msgTransaccion = success.description;
    	}, function(error){
    		self.mostrarMsgTransaccion = true;
			self.msgTransaccion = error.data.description;
			self.classMsgTransaccion = "alert-danger-custom";
    	})
    	self.formEmpresa.$setPristine();
		self.formEmpresa.$setUntouched();
		self.contrasena2 = "";
    }

    $rootScope.$on('limpiarMsg', function(event, data){
    	self.mostrarMsgTransaccion = false;
		self.msgTransaccion = "";
    });

    $rootScope.$on('changeTipoDoc', function(event, data){
    	
    });


}])