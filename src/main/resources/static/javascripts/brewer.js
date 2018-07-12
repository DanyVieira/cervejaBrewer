/*$(function() {
	var decimal=$('.js-decimal'); //aqui chamo a classe que esta la no cerveja cadastro
	decimal.maskMoney({decimal:',',thousands:'.'});//vou separar decimal com virgula e milhar com ponto
		  
	var plain= $('.js-plain');
	plain.maskMoney({precision:0,thousands:'.'});//neste caso digo que não haverá casa decimal, para estoque
});*/
$(function() {
	var decimal = $('.js-decimal');
	decimal.maskMoney();
	
	var plain = $('.js-plain');
	plain.maskMoney({ precision: 0 });
});