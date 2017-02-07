app.controller('listarUsuariosCtrl', 
	['$scope', 
	'UsuariosResource', 
	'$location',
	'$rootScope',
	'i18nService',
	'$cookieStore',
	function($scope, 
		UsuariosResource, 
		$location, 
		$rootScope, 
		i18nService, 
		$cookieStore){
	
	var self = this; // se almacena el contexto del controlador

	// se activa el menu de gestion de usuarios
	$scope.setActive('gUsuarios');
	// variable para almacenar todos los usuarios del sistema
	this.user = {
		dataUser: []
	};

	var usr = $cookieStore.get('usuario');

	// ejecucion de la consulta para listar todos los usuarios del sistema
 	UsuariosResource.getUsers({nombreUsuario: usr.nombreUsuario}).$promise.then(
		function(data){
			self.cargarDatosTabla(data);
 	});


 	this.cargarDatosTabla = function(data){
		angular.forEach(data, function(value, key) {
			var user = {};
			user["user"] = value;
			user["TipoDeDocumento"] = value.persona.tipoDocumento.nombre;
			user["NumeroDocumento"] = value.persona.numeroDocumento;
			user["PrimerNombre"] = value.persona.nombre1;
			user["PrimerApellido"] = value.persona.apellido1;
			user["Dirección"] = value.persona.direccion.nombreDireccion;
			user["CorreoElectronico"] = value.persona.email;
			user["Usuario"] = value.nombreUsuario;
			user["Perfil"] = value.perfil.nombrePerfil;
			user["Accion"] = '';
			self.user.dataUser.push(user);
		});
 	}
	
	i18nService.setCurrentLang('es');
 	this.gridOptions = {
 		enableFiltering: true, 
 		enableSorting: true,
 		data: self.user.dataUser, 
 		enableColumnResizing: true,
	    paginationPageSizes: [5, 10, 15],
		paginationPageSize: 10,
 		columnDefs: [
	      { name: 'TipoDeDocumento', enableHiding: false  },
	      { name: 'NumeroDocumento', enableHiding: false },
	      { name: 'PrimerNombre', enableHiding: false  }, 
	      { name: 'PrimerApellido', enableHiding: false  },
	      { name: 'Dirección', enableHiding: false  },
	      { name: 'CorreoElectronico', enableHiding: false },
	      { name: 'Usuario', enableHiding: false  }, 
	      { name: 'Perfil', enableHiding: false  }, 
	      { name: 'data', visible: false },
	      { name: 'Accion', 
	      	displayName:'',  
	      	enableHiding: false, 
	      	cellTemplate: 'template/link/opcionesTableClientes.html',
	      	enableFiltering: false, 
  			enableSorting: false, 
  			enableColumnMenu: false, width: '8%'}
	    ]
 	}

 	this.gridOptions.appScopeProvider  = this;	

    this.abrirModal = function(data){
    	var user = {};
    	if(data !== null){
    		user = data.user;
 		}

    	$("#modal_usuario").modal(); // se instancia la ventana modal de bootstrap
    	/*	se llama metodo de controller gestionUsuariosCtrl, 
    		para poder enviar los datos de una edicion de usuarios
    	*/
    	var valAccion = "Edición de Datos";
    	var registro = false;
    	if(data == null){
    		valAccion = "Registro de Datos";
    		registro = true;
    	}
 		$rootScope.$emit("callGetDataUser", {user, valAccion, registro}); 
    }

    $rootScope.$on("updateUserTable", function(event, user){
    	self.user.dataUser = [];
    	self.cargarDatosTabla(user.success);
    	self.gridOptions.data = [];
		self.gridOptions.data = self.user.dataUser;
    });

}]);
