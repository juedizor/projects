app.controller('listarUsuariosCtrl', 
	['$scope', 
	'UsuariosResource', 
	'DTOptionsBuilder',
	'$location',
	'$rootScope', 
	function($scope, 
		UsuariosResource, 
		DTOptionsBuilder, 
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
	this.users.dataUser = UsuariosResource.query();

	// cambio de idioma al table usado para mostrar todos los usuarios
	this.dtOptions = DTOptionsBuilder.newOptions()
        .withLanguageSource('angular-datatables-master/Spanish.json');

    this.abrirModal = function(user){
    	$("#modal_usuario").modal(); // se instancia la ventana modal de bootstrap
    	/*	se llama metodo de controller gestionUsuariosCtrl, 
    		para poder enviar los datos de una edicion de usuarios
    	*/
 		$rootScope.$emit("callGetDataUser", {user}); 
 		

    	
    }

}]);
