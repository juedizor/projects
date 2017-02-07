app.controller('listarSedesCtrl', 
	['$scope', 
	'$rootScope',
	'DataClienteBridge', 
	function($scope, $rootScope, DataClienteBridge){

		var self = this;
		this.cliente = DataClienteBridge.cliente;
		console.log(self.cliente)
		this.nombreCliente = self.cliente.persona.empresa.nombreEmpresa;

	}])