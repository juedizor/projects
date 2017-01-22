app.filter('quitarLetra', function(){
	return function(palabra){
		if(palabra !== undefined){
			if(palabra.length > 1){
				return palabra.substr(0);	
			}
		}
	}
});
