$(function() {
	
	var modal = $('#modalCadastroRapidoEstilo');   //nesse caso pego o id do cadastrorapidoestilo.html
	var botaoSalvar= modal.find('.js-modal-cadastro-estilo-salvar-btn');  //aqui chamo a classe do botao salvar
	var form= modal.find('form');// encontro a tag formulario
	form.on('submit',function(event){event.preventDefault()} ); //submeter o formulario impede q ao dar enter o formulario fecha, isso atraves do preventDefault
	var url = form.attr('action');   //aqui pego a url do input do formulario
	var inputNomeEstilo = $('#nomeEstilo'); //pega o id do input da tela
	var containerMesagemErro = $('.js-mensagem-cadastro-rapido-estilo');
	
	modal.on('shown.bs.modal',onModalShow );  //lança a função onModalShow depois de o modal ser carregado
	modal.on('hide.bs.modal', onModalClose);
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	
	function onModalShow() {
		inputNomeEstilo.focus();  //ao carregar o modal dou focu no input da tela
	}
	
	
	function onModalClose() {
		

		inputNomeEstilo.val(' ');
		
	}
	
	function onBotaoSalvarClick() {
		var nomeEstilo= inputNomeEstilo.val().trim() ;
		console.log('nome estilo', nomeEstilo);
		
		$.ajax({                                //requisição ajax pra salvar no servidor
			url:url,                            // ja pego a url que é : CadastrorapidoEstilo que pego la na action
			method: 'POST',                     // qual metodo que vou usar pra submeter 
			contentType:'application/json' ,    // formato do arquivo que vou mandar ao servidor
			data : JSON.stringify({nome : nomeEstilo}) ,              //qual dado que vou enviar ao servidor, transformo em JSON como objeto, dai la na requisição do controler ja consigo receber um objeto do tipo Estilo
			error: onErroSalvandoEstilo
			success: onEstiloSalvo
		});
	}
	
	function onErroSalvandoEstilo(obj) {
		var mensagemErro = obj.responseText;
		containerMesagemErro.removeClass('hidden'); //nesse caso ele se tornara visivel pois irei retirar a classe que o esconde
		containerMesagemErro.html('<span>'+mensagemErro+'</span>');   //aqui mostro a mensagem de erro dentro de um span
		form.find('.form-group').addClass('has-error');   //no caso de erro a div de input fica vermelha
	}
	
	function onEstiloSalvo() {
		console.log(arguments);
		
		
	}
	
});

