app.controller('listarUsuariosCtrl', 
	['$scope', 
	'UsuariosResource', 
	'$location',
	'$rootScope',
	'i18nService', 
	function($scope, 
		UsuariosResource, 
		$location, 
		$rootScope, 
		i18nService){
	
	var self = this; // se almacena el contexto del controlador

	// se activa el menu de gestion de usuarios
	$scope.setActive('gUsuarios');
	// variable para almacenar todos los usuarios del sistema
	this.users = {
		dataUser: []
	};

	// ejecucion de la consulta para listar todos los usuarios del sistema
 	UsuariosResource.query().$promise.then(
		function(data){
			self.cargarDatosTabla(data);
 	});

 	this.cargarDatosTabla = function(data){
 		var dataUser = [];
		angular.forEach(data, function(value, key) {
			var user = {};
			user["TipoDeDocumento"] = value.persona.tipoDocumento.nombre;
			user["NumeroDocumento"] = value.persona.numeroDocumento;
			user["PrimerNombre"] = value.persona.nombre1;
			user["PrimerApellido"] = value.persona.apellido1;
			user["CorreoElectronico"] = value.persona.email;
			user["Usuario"] = value.nombreUsuario;
			user["Perfil"] = value.perfil.nombrePerfil;
			self.users.dataUser.push(user);
		});
 	}
	
	i18nService.setCurrentLang('es');
 	this.gridOptions = {
 		enableFiltering: true, 
 		enableSorting: true,
 		data: self.users.dataUser, 
 		enableColumnResizing: true,
	    paginationPageSizes: [5, 10, 15],
		paginationPageSize: 5,
 		columnDefs: [
	      { name: 'TipoDeDocumento', enableHiding: false  },
	      { name: 'NumeroDocumento', enableHiding: false },
	      { name: 'PrimerNombre', enableHiding: false  }, 
	      { name: 'PrimerApellido', enableHiding: false  },
	      { name: 'CorreoElectronico', enableHiding: false },
	      { name: 'Usuario', enableHiding: false  }, 
	      { name: 'Perfil', enableHiding: false  }
	    ]
 	}

    this.abrirModal = function(user){
    	$("#modal_usuario").modal(); // se instancia la ventana modal de bootstrap
    	/*	se llama metodo de controller gestionUsuariosCtrl, 
    		para poder enviar los datos de una edicion de usuarios
    	*/
    	var valAccion = "Edición de Datos";
    	var registro = false;
    	if(user == null){
    		valAccion = "Registro de Datos";
    		registro = true;
    	}
 		$rootScope.$emit("callGetDataUser", {user, valAccion, registro}); 
    }

    $rootScope.$on("updateUserTable", function(event, user){
    	self.users.dataUser = user.success;
    	//self.cargarDatosTabla(self.users.dataUser);
    });

}]);
