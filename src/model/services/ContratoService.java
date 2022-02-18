package model.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;

public class ContratoService {
	
	private PagamentoService pagamentoService;
	
	public ContratoService() {
	}
	
	public ContratoService(PagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}

	public PagamentoService getPagamentoService() {
		return pagamentoService;
	}

	public void setPagamentoService(PagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}

	public void processarContrato(Contrato contrato, Integer quantidadeParcelas) {
		
		Double valorParcela = divideParcela(contrato.getValorTotal(), quantidadeParcelas);
		
		for (int i = 1; i <= quantidadeParcelas; i++) {
			
			Date data = calculaDataVencimento(contrato.getData(), i);
			Double valor = pagamentoService.calculaParcela(valorParcela, i);
			
			Parcela parcela = new Parcela(data,valor);		
			
			contrato.getParcelas().add(parcela);		
			
		}		
	}

	
	private Double divideParcela(Double valor, Integer quantidadeParcelas) {
		return (valor/quantidadeParcelas);
	}
	
	
	private Date calculaDataVencimento(Date data, Integer parcela) {	
		LocalDate dataVencimento = converterDataParaLocal(data);	
		return converterLocalParaData((dataVencimento.plusMonths(parcela)));
	}
	
	private LocalDate converterDataParaLocal(Date data) {
	    return data.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	private Date converterLocalParaData(LocalDate data) {
	    return java.util.Date.from(data.atStartOfDay()
	      .atZone(ZoneId.systemDefault())
	      .toInstant());
	}

}
