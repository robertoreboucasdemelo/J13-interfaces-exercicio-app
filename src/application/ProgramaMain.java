package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ContratoService;
import model.services.PayPalService;

public class ProgramaMain {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		System.out.println("Entre com os Dados de Contrato");
		
		System.out.println("Numero: ");
		Integer numero = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Data (dd/MM/yyyy):");
		Date data = sdf.parse(sc.nextLine());
		
		System.out.println("Valor do Contrato: ");
		Double valorContrato = sc.nextDouble();
		
		System.out.println("Entre com o Numero de Parcelas: ");
		Integer numeroParcelas = sc.nextInt();
		
		Contrato contrato = new Contrato(numero, data, valorContrato);
		
		ContratoService contratoService = new ContratoService(new PayPalService());
		
		contratoService.processarContrato(contrato, numeroParcelas);
		
		System.out.println("Parcelas: ");	
		
		for(Parcela parcela : contrato.getParcelas()) {
			System.out.println(sdf.format(parcela.getDataVencimento()) + " - " + parcela.getValor());		
		}
		
		sc.close();
		
	
	}

}
