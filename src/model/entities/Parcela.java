package model.entities;

import java.util.Date;

public class Parcela {
	
	private Date dataVencimento;
	private Double valor;
	
	public Parcela() {
	}
	
	public Parcela(Date dataVencimento, Double valor) {
		this.dataVencimento = dataVencimento;
		this.valor = valor;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	

}
