app.controller('clientesCtrl', 
	['$scope', 
	'i18nService',
	'ClientesResource',
	'$cookieStore',
	'$rootScope', 
	function($scope, 
		i18nService, 
		ClientesResource, 
		$cookieStore,
		$rootScope){
	$scope.setActive('gClientes');


	var self = this;
	this.cliente = {
		dataCliente: []
	}

	this.userActual = $cookieStore.get('usuario');
    ClientesResource.getClientes({idEmpresa: self.userActual.empresa.idEmpresa}).$promise.then(function(data){
    	self.cargarDatosTabla(data);
    })


    this.cargarDatosTabla = function(data){
    	console.log(data);
		angular.forEach(data, function(value, key) {
			var cliente = {};
			cliente["cliente"] = value;
			cliente["TipoDeDocumento"] = value.persona.tipoDocumento.nombre;
			cliente["NumeroDocumento"] = value.persona.numeroDocumento;
			cliente["NombreEmpresa"] = value.persona.empresa.nombreEmpresa;
			cliente["Dirección"] = value.persona.direccion.nombreDireccion;
			cliente["CorreoElectronico"] = value.persona.email;
			cliente["Accion"] = '';
			self.cliente.dataCliente.push(cliente);
		});
 	}



	i18nService.setCurrentLang('es');
 	this.gridOptions = {
 		enableFiltering: true, 
 		enableSorting: true,
 		data: self.cliente.dataCliente, 
 		enableColumnResizing: true,
	    paginationPageSizes: [5, 10, 15],
		paginationPageSize: 10, 
		columnDefs: [
	      { name: 'TipoDeDocumento', enableHiding: false  },
	      { name: 'NumeroDocumento', enableHiding: false },
	      { name: 'NombreEmpresa', enableHiding: false  }, 
	      { name: 'Dirección', enableHiding: false  },
	      { name: 'CorreoElectronico', enableHiding: false },
	      { name: 'data', visible: false },
	      { name: 'Accion', 
	      	displayName:'',  
	      	enableHiding: false, 
	      	cellTemplate: 'template/link/editarCliente.html',
	      	enableFiltering: false, 
  			enableSorting: false, 
  			enableColumnMenu: false, width: '4%'}
	    ]
 	}


 	this.gridOptions.appScopeProvider  = this;

 	this.abrirModal = function(data){
 		var cliente = {};
 		if(data != null){
 			cliente = data.cliente;
 		}
 		$rootScope.$emit('callGetClientes', {cliente});
 		$("#moda_clientes").modal();
 	}



}])