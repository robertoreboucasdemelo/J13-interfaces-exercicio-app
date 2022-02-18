package model.services;

public class PayPalService implements PagamentoService {
	
	public static final Double JUROS = 0.01d;
	public static final Double TAXA  = 0.02d;
	
	public Double calculaParcela(Double valor, Integer quantidadeParcelas) {
		Double valorParcela = calculaJuros(valor, quantidadeParcelas);
		return calculaTaxa(valorParcela);			
	}
	
	private Double calculaJuros(Double valor, Integer parcela) {
		return valor + (valor * JUROS * parcela);
	}
	
	private Double calculaTaxa(Double valor) {
		return valor + (valor * TAXA);
	}
	

}
