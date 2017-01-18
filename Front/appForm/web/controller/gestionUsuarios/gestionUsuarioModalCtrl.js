app.controller('gestionUsuariosCtrl', 
	['$scope',  
	'$rootScope',
	'UsuariosResource', 
	function($scope, 
		$rootScope, 
		UsuariosResource){

		var self = this; // se almacena el contexto del controlador dentro de la variable self

		// datos del usuario que esta en la vista
		this.usuario = new UsuariosResource();
		// tipos de documentos cargados con anterioridad en una cookie
		this.tiposDoc = $scope.tiposDoc;
		//perfiles de usuarios cargados anteriormente en una cookie
        this.perfiles = $scope.perfiles;
        // tanto los datos de tipos de documentos y perfiles ya estan cargados en el scope
        // desde que inicia la aplicacion, estos se almacenan en cookies

        this.valAccion = ""; // texto en caso que sea edicion o registro
        this.registro = true; // variable en caso que sea edicion o registro

        // datos que se envia a la vista en caso que sea edicion de datos
        // para cargue en el Select
        this.profile = {};
		this.tipoDocumentos = {};


		this.disabledBtnGuardar = true;
		
		// funcion para realizar el proceso de registro de usuarios
		this.guardar = function(){
			var response = self.usuario.$save();		
			response.then(function(success){
				var responseUser = [];
				responseUser = UsuariosResource.query().$promise.then(function(success){
					$rootScope.$emit("updateUserTable", {success}); 
				});
				
			});
	        self.formUser.$setPristine();
			self.formUser.$setUntouched();
			
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
        this.formUser = {};


        this.usuarioResource = UsuariosResource;
        this.styleFormGroup = "form-group has-success";
        this.required = true;

		// funcion para el cargue de informacion de usuario cuando se realiza un proceso de edicio
		this.getDataUser = function(user) {
			self.usuario = new UsuariosResource();
			self.tipoDocumentos = {};
			self.profile = {};
			if(!angular.isUndefined(self.formUser)){
				self.formUser.$setPristine();	
				self.formUser.$setUntouched();
			}
			if(!self.registro){
				self.required = false;
				self.usuario = new UsuariosResource(user);
				angular.copy(self.usuario.user, self.usuario);
				self.numDocumento = self.usuario.persona.numeroDocumento;
				self.nombreUsuario = self.usuario.nombreUsuario;

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