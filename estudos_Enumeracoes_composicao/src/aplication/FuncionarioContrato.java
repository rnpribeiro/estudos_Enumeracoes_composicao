package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelDeTrabalho;

public class FuncionarioContrato {

    public static void main(String[] args) throws ParseException {

	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

	System.out.print("Entre o nome do departamento: ");
	String nomeDepartamento = sc.nextLine();
	System.out.println("Entre os dados do trabalhador:");

	System.out.print("Nome: ");
	String nomeTrabalhador = sc.nextLine();

	System.out.print("Nivel do Trabalhador: ");
	String nivelTrabalhador = sc.nextLine();

	System.out.print("Salario Base: ");
	Double salarioBase = sc.nextDouble();

	Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDeTrabalho.valueOf(nivelTrabalhador),
		salarioBase, new Departamento(nomeDepartamento));

	System.out.print("Quantos contratos esse trabalhador terá? ");
	Integer NumContratos = sc.nextInt();

	int i;
	for (i = 1; i <= NumContratos; i++) {
	    System.out.printf("Entre os dados para o contrato #%d%n", i);
	    System.out.print("Data (DD/MM/YYYY): ");
	    Date dataContrato = sdf.parse(sc.next());
	    System.out.print("Valor por hora: ");
            Double valorHora = sc.nextDouble();
	    System.out.print("Duracao (Horas): ");
	    Integer horasContrato = sc.nextInt() ; 
            ContratoHora contrato = new ContratoHora(dataContrato, valorHora, horasContrato);
            trabalhador.addContrato(contrato);
	}
	sc.nextLine();
        System.out.print("Entre mes e ano (MM/YYYY) para calcular o salario: ");
        String mesAno = sc.nextLine();
        int mes = Integer.parseInt(mesAno.substring(0, 2));       
        int ano = Integer.parseInt(mesAno.substring(3));       
        
        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome()  );
        System.out.println("Salario para " +  mesAno + ": " + String.format("%.2f", trabalhador.rendimento(ano, mes)) );
	sc.close();
    }

}
