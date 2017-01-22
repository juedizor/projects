app.controller('gestionEmpresaModalCtrl', 
	['$scope', 
	'$rootScope', 
	'PersonasResource', 
	'UsuariosResource',
	function($scope, 
		$rootScope, 
		PersonasResource, 
		UsuariosResource){
	

	var self = this;	
	// tipos de documentos cargados con anterioridad en una cookie
	this.tiposDoc = $scope.tiposDoc;
	//perfiles de usuarios cargados anteriormente en una cookie
    this.perfiles = $scope.perfiles;

    this.camposNit = false;
    this.required = true;
    this.persona = new PersonasResource();
    this.usuarioResource = UsuariosResource;
    this.personaResource = PersonasResource;
    this.formEmpresa = {};
    this.contrasena2 = "";
    this.required = true;

    this.guardar = function(){
    	console.log(self.persona)
    }

    $rootScope.$on('changeTipoDoc', function(event, data){
    	if(!angular.isUndefined(data.value)){
	    	if(data.value.codigo == 'NIT'){
	    		self.camposNit = true;
	    		self.required = false;
	    		self.persona.nombre1 = "";
	    		self.persona.nombre2 = "";
	    		self.persona.apellido1 = "";
	    		self.persona.apellido2 = "";
	    	}else{
    			self.camposNit = false;
	    		self.required = true;
	    	}
    	}
    });


}])