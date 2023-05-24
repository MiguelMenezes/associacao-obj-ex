package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HoraContrato;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Informe o nome do departamento: ");
		String nomeDepto = sc.nextLine();

		System.out.println("DADOS DO TRABALHADOR:");
		System.out.print("NOME: ");
		String nomeTrabalhador = sc.nextLine();

		System.out.print("NÍVEL: ");
		String nivelTrabalhador = sc.nextLine();

		System.out.print("SALÁRIO BASE R$: ");
		double salarioBase = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador),
				salarioBase, new Departamento(nomeDepto));

		System.out.println("_______________________________________________________________________________________");
		System.out.print("Informe a quantidade de contratos do trabalhador: ");
		int qteContratos = sc.nextInt();

		for (int i = 1; i <= qteContratos; i++) {

			System.out.println("DADOS DO CONTRATO #" + i + ":");
			System.out.print("Data do contrato(dd/mm/yyyy): ");
			Date dataContrato = formatador.parse(sc.next());
			
			System.out.print("Valor por hora R$: ");
			double valorPorHora = sc.nextDouble();
			
			System.out.print("Duração do contrato (horas): ");
			int horas = sc.nextInt();
			
			HoraContrato contrato = new HoraContrato(dataContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
			System.out.println("CONTRATO ADICIONADO COM SUCESSO!");
			System.out.println("-----------------------------------------------------------------------------------");

		}
		System.out.println();
		System.out.print("Informe o período que deseja filtrar o valor total que o trabalhador recebeu(mm/yyyy): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("NOME: " + trabalhador.getNome());
		System.out.println("DEPARTAMENTO: " + trabalhador.getDepartamento().getNome());
		System.out.println("TOTAL RECEBIDO EM " + mesAno + ", foi de R$: " + trabalhador.totalValor(ano, mes));
		

		sc.close();

	}

}
