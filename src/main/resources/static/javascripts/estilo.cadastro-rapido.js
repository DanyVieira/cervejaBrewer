var Brewer = Brewer || {};

Brewer.EstiloCadastroRapido=(function() {
	function EstiloCadastroRapido(){
		
		this.modal = $('#modalCadastroRapidoEstilo');  //Capturo o id do modal
		this.botaoSalvar = this.modal.find('.js-modal-cadastro-estilo-salvar-btn');  //pego a classe do salvar procurando pelo modal
		this.form = this.modal.find('form');  //pelo a div form
		this.url = this.form.attr('action');  //captura a url que defini no controller que é estilos
		this.inputNomeEstilo = $('#nomeEstilo'); //captura o input de nome
		this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo'); //captura a div que mostra a mensagem de erro
		
	}
	
	EstiloCadastroRapido.prototype.iniciar= function(){
		this.form.on('submit', function(event) { event.preventDefault() }); //impede que ao dar enter eu submeta o formulário
		this.modal.on('shown.bs.modal', onModalShow.bind(this)); //chama a função onModalshow ao abrir a tela, coloco o bind this pq a variável foi definida la em cima em outro contexto
		this.modal.on('hide.bs.modal', onModalClose.bind(this)); 
		this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
		
	}
	
	function onModalShow() {
		this.inputNomeEstilo.focus(); //da foco no input ao abrir a tela
	}
	
	function onModalClose() { 
		this.inputNomeEstilo.val(''); //ao fechar a tela retiro o que digitei antes
		this.containerMensagemErro.addClass('hidden'); //esconde a mensaagem de erro
		this.form.find('.form-group').removeClass('has-error'); //remove o erro do input ou seja ele deixa de ficar vermelho
	}
	
	
	function onBotaoSalvarClick() {
		var nomeEstilo = this.inputNomeEstilo.val().trim(); //preenche a variavel com valor digitado e retira espaços em branco
		$.ajax({  // dados que irei passar os dados ao servidor. Preciso passar esses dados:
			url: this.url, //   /estilos
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ nome: nomeEstilo }), //dado que vou enviar em json.Com Json já posso passar o objeto estilo
			error: onErroSalvandoEstilo.bind(this),
			success: onEstiloSalvo.bind(this)
		});
	}
	
	function onErroSalvandoEstilo(obj) {
		var mensagemErro = obj.responseText; // pega o response text que o navegador passa
		this.containerMensagemErro.removeClass('hidden'); //torna a div de erro visivel 
		this.containerMensagemErro.html('<span>' + mensagemErro + '</span>'); //mostra a mensagem de erro na tela
		this.form.find('.form-group').addClass('has-error');// torna o input vermelho pra mostrar erro
	}
	
	function onEstiloSalvo(estilo) {
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome + '</option>'); //adiciona o novo estilo na tela
		comboEstilo.val(estilo.codigo);  // deixa o input preenchido com o novo valor inserido
		this.modal.modal('hide'); //esconde a tela apos salvar com sucesso atraves da função modal.(hide) 
	}
	
	return EstiloCadastroRapido;
}());


$(function() {
	
	var estiloCadastroRapido = new Brewer.EstiloCadastroRapido();
	estiloCadastroRapido.iniciar();
	
});