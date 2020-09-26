



angular.module("NeoApp", [])
	.value('urlBase', 'http://localhost:8080/projetoNeomind/rest/')
	.directive('uiFormat', function(){
	
	return{
		require: "ngModel",
		link: function(scope, element, attrs, ctrl){
			
			var _formatCNPJ = function(cnpj){
				
				cnpj = cnpj.replace(/[^0-9]+/g, "");
				
				if(cnpj.length > 2){
				
				cnpj = cnpj.substring(0,2)+"." + cnpj.substring(2);
				}
				
				if(cnpj.length > 6){
				
				cnpj = cnpj.substring(0,6)+"." + cnpj.substring(6);
				}
				
				if(cnpj.length > 10){
				
				cnpj = cnpj.substring(0,10)+"/" + cnpj.substring(10);
				}
				
				if(cnpj.length > 15){
				
				cnpj = cnpj.substring(0,15)+"-" + cnpj.substring(15);
				}
				
				if(cnpj.length > 18){
				
				cnpj = cnpj.substring(18);
				}
				
				return cnpj;
			}
			
			element.bind("keyup", function() {
			ctrl.$setViewValue(_formatCNPJ(ctrl.$viewValue));
			ctrl.$render();
				
			})
		
		
		}
		
	}
	
	})
	.controller("fornecedorController", function($scope, $http, urlBase) {
		
		var self = this;
		self.fornecedores = [];
		self.fornecedor = undefined;
		
		
		self.salvar = function(){
			var metodo = "POST";
			if(self.fornecedor.id){
			metodo = "PUT";
			}
			
			
			
			$http({	method: metodo,	url: urlBase + "fornecedores/", data: self.fornecedor})
					.then(function successCallback(){self.atualizarTabela();},
						  function errorCallback()	{self.ocorreuErro();});
		};
		
		$scope.reset = function(){
			
				$scope.data.name = "";
  				$scope.data.email = "";
  				$scope.data.cnpj = "";
  				$scope.data.comment = "";
  				$scope.formFornecedor.$setPristine();
		}
			
		self.novo = function(){		
			
			$scope.data = {
			"name": "",
			"email": "",
			"cnpj": "",
			"comment": ""
			
			};
			
			
			
			$scope.reset();
			
			self.fornecedor = {};
		
		};
		
		self.alterar = function(fornecedor){
			self.fornecedor = fornecedor;
		
		};
		
		self.deletar = function(fornecedor){
		
			self.fornecedor = fornecedor;
			
			$http({method: "DELETE", url: urlBase + "fornecedores/" + self.fornecedor.id + "/"})
						.then(function successCallback (response) {self.atualizarTabela()},
							  function errorCallback   (response) {self.ocorreuErro()	 });
		
		};
		
		
		self.ocorreuErro = function (){
		
		alert("Ocorreu um erro inesperado!");
		
		};
		
		self.atualizarTabela = function(){
		
			$http({method: "GET", url: urlBase + "fornecedores/"})
						.then(function successCallback (response) {self.fornecedores = response.data; self.fornecedor = undefined},
							  function errorCallback   (response) {self.ocorreuErro()});		
		}
	
		
			

		self.activate = function (){
			self.atualizarTabela();
		}
		
		self.activate();
	});