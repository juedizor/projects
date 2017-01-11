app.controller('gestionUsuariosCtrl', 
	['$scope', 
	'RegistrarUsuariosResource', 
	'$rootScope',
	'ValidarPersonaResource', 
	function($scope, 
		RegistrarUsuariosResource, 
		$rootScope, 
		ValidarPersonaResource){

		var self = this; // se almacena el contexto del controlador dentro de la variable self

		// datos del usuario que esta en la vista
		this.usuario = new RegistrarUsuariosResource();
		// tipos de documentos cargados con anterioridad en una cookie
		this.tiposDoc = $scope.tiposDoc;
		//perfiles de usuarios cargados anteriormente en una cookie
        this.perfiles = $scope.perfiles;
        // tanto los datos de tipos de documentos y perfiles ya estan cargados en el scope
        // desde que inicia la aplicacion, estos se almacenan en cookies

        // datos que se envia a la vista en caso que sea edicion de datos
        // para cargue en el Select
        this.profile = {};
		this.tipoDocumentos = {};


		this.disabledBtnGuardar = true;
		
		// funcion para realizar el proceso de registro de usuarios
		this.guardar = function(){
			self.usuario.$create();
		}

		this.oldUser = {};

		
		// funcion que puede ser llamada para poder cargar los datos de usuario
		$rootScope.$on("callGetDataUser", function(event, user){
			self.oldUser = user;
	        self.getDataUser(user);
        });

		// variable para almacenar el numero de documento inicial al momento de la edicio de 
		// datos
        this.numDocumento = "";

        this.formUser = null;

		// funcion para el cargue de informacion de usuario cuando se realiza un proceso de edicio
		this.getDataUser = function(user) {
			self.usuario = new RegistrarUsuariosResource();
			self.tipoDocumentos = {};
			self.profile = {};
			if(user.user !== null){
				self.usuario = new RegistrarUsuariosResource(user);
				angular.copy(self.usuario.user, self.usuario);
				self.numDocumento = self.usuario.persona.numeroDocumento;
				self.tipoDocumentos = self.usuario.persona.tipoDocumentoDTO;
	            self.profile = self.usuario.perfil;
			}
			self.formUser.$setPristine();
			self.formUser.$setUntouched();
        }

        this.change = function(){
        	if(self.numDocumento == self.usuario.persona.numeroDocumento){
        		return;
        	}
        }

        this.closeModal = function(){
        	console.log("entre")
        	console.log(self.usuario)
        	console.log(self.oldUser)
        	self.usuario =  self.oldUser;
        }

}]);