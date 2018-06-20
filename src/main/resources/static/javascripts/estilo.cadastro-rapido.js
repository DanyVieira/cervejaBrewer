$(function() {
	
	var modal = $('#modalCadastroRapidoEstilo');   //nesse caso pego o id do cadastrorapidoestilo.html
	var botaoSalvar= modal.find('.js-modal-cadastro-estilo-salvar-btn');  //aqui chamo a classe do botao salvar
	var form= modal.find('form');// encontro a tag formulario
	form.on('submit',function(event){event.preventDefault()} ); //submeter o formulario impede q ao dar enter o formulario fecha, isso atraves do preventDefault
	var url = form.attr('action');   //aqui pego a url do input do formulario
	var inputNomeEstilo = $('#nomeEstilo'); //pega o id do input 
	
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
		var nomeEstilo= inputNomeEstilo.val();
		console.log('nome estilo', nomeEstilo);
		
		$.ajax({    //requisição ajax pra salvar no servidor
			
			
			
			
		});
	}
	
});

