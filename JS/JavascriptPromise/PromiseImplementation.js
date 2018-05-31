var Promise = (function (){
		
		var promisesObject = {};
		
		function reject(){
		
		}
		
		function resolve(data){
			for(var i=0;i<promisesObject.successFn.length;i++){
				promisesObject.successFn[i](data);
			}
		}
		
		function promise(){
			return this;
		}
		
		function then( successFn, rejectFn, progressFn){
				promisesObject.successFn = promisesObject.successFn || [];
				promisesObject.successFn.push(successFn);
				
				promisesObject.rejectFn = promisesObject.rejectFn || [];
				promisesObject.rejectFn.push( rejectFn );
				
				promisesObject.progressFn = promisesObject.progressFn || [];
				promisesObject.progressFn.push( progressFn );
				return this;
		}
		
		return {
			promise:promise,
			resolve: resolve,
			reject: reject,
			then: then
		}
})();

//Simple ajax call to accept the request object and success and failure functions

var Promise1 = (function (){
	
	function makeAJAX(requestObject,successFn,rejectFn){
		var xhrobj = new XMLHttpRequest();
		xhrobj.open("GET","url",true);
		xhrobj.onreadystatechange = function(){
			if ( this.readyState ==4 && this.status ==200){
				successFn(this.responseText);
			}
		}
	}
	
	return{
		makeAJAX:makeAJAX
	}
})();