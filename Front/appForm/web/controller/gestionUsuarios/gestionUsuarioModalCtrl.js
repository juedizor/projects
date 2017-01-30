app.controller('gestionUsuariosCtrl', 
	['$scope',  
	'$rootScope',
	'PersonasResource',
	'UsuariosResource', 
	'$cookieStore',
	function($scope, 
		$rootScope, 
		PersonasResource, 
		UsuariosResource, 
		$cookieStore){

		var self = this; // se almacena el contexto del controlador dentro de la variable self

		
		this.usuario = new UsuariosResource(); // datos de la persona que esta en la vista		
		
		/*
			tanto los datos de tipos de documentos y perfiles ya estan cargados en el scope
	        desde que inicia la aplicacion, estos se almacenan en cookies
        */
		this.tiposDoc = []; // tipos de documentos cargados con anterioridad en una cookie
        this.perfiles = $scope.perfiles;//perfiles de usuarios cargados anteriormente en una cookie

        this.cargarTiposDoc = function(data){
        	self.tiposDoc = [];
        	angular.forEach(data, function(value, key) {
        		if(value.codigo !== 'NIT'){
        			self.tiposDoc.push(value);
        		}
        	});
        }

        /*
			datos que se envia a la vista en caso que sea edicion de datos
    	*/
        this.valAccion = ""; // texto en caso que sea edicion o registro
        this.registro = true; // variable en caso que sea edicion o registro

        
        /*
        	para cargue en el cuando es edicion, carga el tipo de documento 
        	y perfil actual del usuario o persona
		*/        	
        this.profile = {};
		this.tipoDocumentos = {};


		this.disabledBtnGuardar = true; // deshabilita el boton guardar
		this.mostrarMsgTransaccion = false; // muestra el mensaje de finalizacion de la transaccion al momento de guardar
		this.msgTransaccion = ""; // texto del mensaje de la transaccion
		this.classMsgTransaccion = "alert-success-custom"; // clase css a aplicar en el mensaje, en la transaccion
		
		// funcion para realizar el proceso de registro de usuarios
		this.guardar = function(){
			var usr = $cookieStore.get('usuario');
			self.usuario.empresa = {};
			angular.copy(usr.empresa, self.usuario.empresa);
			var response = self.usuario.$save();		
			response.then(function(success){
				self.mostrarMsgTransaccion = true;
				self.msgTransaccion = success.description;
				self.classMsgTransaccion = "alert-success-custom";
				var responseUser = [];
				var usr = $cookieStore.get('usuario');
				responseUser = UsuariosResource.getUsers({nombreUsuario: usr.nombreUsuario}).$promise.then(function(success){
					$rootScope.$emit("updateUserTable", {success}); 
				});
				
			}, function(error){
				self.mostrarMsgTransaccion = true;
				self.msgTransaccion = error.data.description;
				self.classMsgTransaccion = "alert-danger-custom";
			});
	        self.formUsuario.$setPristine();
			self.formUsuario.$setUntouched();
			self.password2 = "";
			
		}

		
		// funcion que puede ser llamada para poder cargar los datos de usuario
		$rootScope.$on("callGetDataUser", function(event, user){
			self.valAccion = user.valAccion;
			self.registro = user.registro;
	        self.getDataUser(user);
        });

		// variable para almacenar el numero de documento inicial al momento de la edicio de 
		// datos
        this.numDocumento = "";
        this.nombreUsuario = "";
        this.email = "";
        this.formUsuario = null;


        this.personasResource = PersonasResource;
        this.usuariosResource = UsuariosResource;
        this.styleFormGroup = "form-group has-success";
        this.required = true;
        this.password2 = "";

		// funcion para el cargue de informacion de usuario cuando se realiza un proceso de edicio
		this.getDataUser = function(user) {
			//console.log(user);
			self.cargarTiposDoc($scope.tiposDoc);
			self.mostrarMsgTransaccion = false;
			self.msgTransaccion = "";
			self.usuario = new UsuariosResource();
			self.tipoDocumentos = {};
			self.profile = {};			
			if(!angular.isUndefined(self.formUsuario)){
				self.formUsuario.$setPristine();	
				self.formUsuario.$setUntouched();
			}

			if(!self.registro){
				self.required = false;
				self.usuario = new UsuariosResource(user);
				angular.copy(self.usuario.user, self.usuario);
				self.usuario.persona.pais = {};
				angular.copy(self.usuario.persona.ciudad.departamento.pais, self.usuario.persona.pais);
				self.usuario.persona.departamento = {};
				angular.copy(self.usuario.persona.ciudad.departamento, self.usuario.persona.departamento);
				self.numDocumento = self.usuario.persona.numeroDocumento;
				self.nombreUsuario = self.usuario.nombreUsuario;
				self.email = self.usuario.persona.email;
				angular.element("#numDocError").addClass(self.styleFormGroup);
				angular.element("#fieldEmail").addClass(self.styleFormGroup);
				angular.element("#fieldPerfil").addClass(self.styleFormGroup);
				angular.element("#requiredPass1").addClass(self.styleFormGroup);
				angular.element("#requiredPass2").addClass(self.styleFormGroup);
				angular.element("#userError").addClass(self.styleFormGroup);
				angular.element("#fieldApellido1").addClass(self.styleFormGroup);
				angular.element("#fieldApellido2").addClass(self.styleFormGroup);
				angular.element("#fieldNombre1").addClass(self.styleFormGroup);
				angular.element("#fieldNombre2").addClass(self.styleFormGroup);
				angular.element("#fieldTipoDoc").addClass(self.styleFormGroup);
				angular.element("#direccion").addClass(self.styleFormGroup);
				angular.element("#pais").addClass(self.styleFormGroup);
				angular.element("#departamento").addClass(self.styleFormGroup);
				angular.element("#ciudad").addClass(self.styleFormGroup);
			}else{
				self.required = true;
				self.numDocumento = "";
				self.nombreUsuario = "";
			}
			angular.element("#errorNumDoc").html("");
			angular.element("#errorUser").html("");
			angular.element("#errorPass1").html("");
			angular.element("#errorPass2").html("");
			
        }
}]);