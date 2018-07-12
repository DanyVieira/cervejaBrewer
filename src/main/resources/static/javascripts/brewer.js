var Brewer = Brewer || {};

Brewer.MaskMoney = (function() {  //função construtora dai nas funções abaixo devo usar o this
	
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}
	
	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
		this.plain.maskMoney({ precision: 0, thousands: '.' });
	}
	
	return MaskMoney;
	
}());

$(function() {
	var maskMoney = new Brewer.MaskMoney();
	maskMoney.enable();
});