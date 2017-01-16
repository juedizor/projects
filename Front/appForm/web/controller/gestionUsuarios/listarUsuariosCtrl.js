app.controller('listarUsuariosCtrl', 
	['$scope', 
	'UsuariosResource', 
	'$location',
	'$rootScope', 
	function($scope, 
		UsuariosResource, 
		$location, 
		$rootScope){
	
	var self = this; // se almacena el contexto del controlador

	// se activa el menu de gestion de usuarios
	$scope.setActive('gUsuarios');
	
	// variable para almacenar todos los usuarios del sistema
	this.users = {
		dataUser: {}
	};

	// ejecucion de la consulta para listar todos los usuarios del sistema
 	UsuariosResource.query().$promise.then(
		function(data){
			self.users.dataUser = data;
 	});

  
 	// se usa para la inicializacion el datatable de jquery 
 	this.bTooltipsterExists = false;
	$scope.$watch(
		function(){
		    if(angular.element('.tooltipster').length){
		        self.bTooltipsterExists = true;
		        return true;
		    }
		    
		    return false;
		},
		function(){
		    if(self.bTooltipsterExists){
		        $('#example2').DataTable({
					"paging": true,
					"lengthChange": true,
					"searching": true,
					"ordering": true,
					"info": true,
					"autoWidth": false, 
					"language": {
			            "lengthMenu": "Mostrar _MENU_ registros por pagina",
			            "zeroRecords": "No hay Resultados",
			            "info": "Mostrando _START_ de _END_ de _TOTAL_ registros",
			            "infoEmpty": "No hay Resultados",
			            "infoFiltered": "(Filtrando de _MAX_ registros)", 
			            "search":"Buscar:",
			        }
				});
		    }
		});


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

}]);
