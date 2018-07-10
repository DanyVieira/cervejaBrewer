$(function() {
	
	var modal = $('#modalCadastroRapidoEstilo');  //Capturo o id do modal
	var botaoSalvar = modal.find('.js-modal-cadastro-estilo-salvar-btn');  //pego a classe do salvar procurando pelo modal
	var form = modal.find('form');  //pelo a div form
	form.on('submit', function(event) { event.preventDefault() }); //impede que ao dar enter eu submeta o formulário
	var url = form.attr('action');  //captura a url que defini no controller que é estilos
	var inputNomeEstilo = $('#nomeEstilo'); //captura o input de nome
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo'); //captura a div que mostra a mensagem de erro
	
	modal.on('shown.bs.modal', onModalShow); //chama a função onModalshow ao abrir a tela
	modal.on('hide.bs.modal', onModalClose) 
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	function onModalShow() {
		inputNomeEstilo.focus(); //da foco no input ao abrir a tela
	}
	
	function onModalClose() { 
		inputNomeEstilo.val(''); //ao fechar a tela retiro o que digitei antes
		containerMensagemErro.addClass('hidden'); //esconde a mensaagem de erro
		form.find('.form-group').removeClass('has-error'); //remove o erro
	}
	
	function onBotaoSalvarClick() {
		var nomeEstilo = inputNomeEstilo.val().trim(); //preenche a variavel com valor digitado e retira espaços em branco
		$.ajax({  // dados que irei passar ao servidor
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ nome: nomeEstilo }),
			error: onErroSalvandoEstilo,
			success: onEstiloSalvo
		});
	}
	
	function onErroSalvandoEstilo(obj) {
		var mensagemErro = obj.responseText;
		containerMensagemErro.removeClass('hidden'); //torna a div de erro visivel 
		containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');// torna o input vermelho pra mostrar erro
	}
	
	function onEstiloSalvo(estilo) {
		var comboEstilo = $('#estilo');
		comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.nome + '</option>');
		comboEstilo.val(estilo.codigo);
		modal.modal('hide');
	}
	
});