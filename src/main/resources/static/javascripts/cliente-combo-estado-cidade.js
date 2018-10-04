var Brewer = Brewer || {};

Brewer.ComboEstado = (function() {
	
	function ComboEstado(){
		this.combo = $('#estado');// pega o id estado select
		this.emitter = $({});// objeto
		this.on = this.emitter.on.bind(this.emitter); //lanço eventos a partir do objeto emitter
		
	}
	ComboEstado.prototype.iniciar = function() {
		this.combo.on('change',onEstadoAlterado.bind(this)); //quando mudo estado chamo a função estadoAlterado
	}
	function onEstadoAlterado() {
		this.emitter.trigger('alterado', this.combo.val());// nesse caso ele pega o th:value que eu defini como estado.codigo
		
	}
	
	return ComboEstado;

}());

Brewer.ComboCidade = ( function() {
	

	function ComboCidade(comboEstado){ //coloco o objeto estado dentro do construtor de cidade 
		this.comboEstado = comboEstado ;
		this.combo = $('#cidade');//pego id do select
		this.imgloading = $('.js-img-loading'); //classe que defini na div da imagem 
		
	}
	ComboCidade.prototype.iniciar = function() {
		reset.call(this); //ao iniciar a tela ja desabilita o selecione cidade
		this.comboEstado.on('alterado', onEstadoAlterado.bind(this));
	}
	
	function onEstadoAlterado( evento, codigoEstado) {
		 if(codigoEstado){ //somente se houver um codigo ele envia a requisição ao servidor
			var resposta = $.ajax({
				url: this.combo.data('url'), // essa url defini la no select no clienteController
				method: 'GET',  //metodo
				contentType :'application/json',
				data :{'estado':codigoEstado},  //dados que irei passar, esse codigo veio la da classe controller
				
				beforeSend: iniciarRequisicao.bind(this), //função que chamo antes de enviar a requisição ajax
				complete: finalizarRequisicao.bind(this) //função que chamo depois de enviar a requisição ajax
			});
			resposta.done(onBuscarCidadesFinalizado.bind(this)); //qdp receber a resposta chama a função
		}
		 else{
			reset.call(this); 
		 }
	}
	
	function onBuscarCidadesFinalizado(cidades) {
		var options = [];
		cidades.forEach(function(cidade) {
			options.push('<option value"'+cidade.codigo +'">'+cidade.nome+'</option>');//a cada iteração do for jogo isso dentro do array options que criei
		});
		this.combo.html(options.join(''));//page tudo que esta no array e os separa
		this.combo.removeAttr('disabled');

	}
	
	function reset() {  //desabilita o selecione cidade
		this.combo.html('<option value="">Selecione a Cidade</option>');
		this.combo.val('');//vou selecionar nada
		this.combo.attr('disabled','disabled'); //adiciono o disabled
	}
	
	function iniciarRequisicao() {
		reset.call(this); //quando estiver iniciando a requisição tbm desabilita o selecione cidade
		this.imgloading.show();
	}
	
	function finalizarRequisicao() {
		this.imgloading.hide();
	}
	return ComboCidade;
	
}());

$(function(){ //aqui inicio as functions 
	
	var comboEstado = new Brewer.ComboEstado();
	comboEstado.iniciar();
	
	var comboCidade = new Brewer.ComboCidade(comboEstado) ; // ou seja quando inicializo cidade devo passar as informações de combo estado.
	comboCidade.iniciar();
	
});
