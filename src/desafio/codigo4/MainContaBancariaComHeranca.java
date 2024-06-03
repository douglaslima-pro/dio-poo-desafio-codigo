package desafio.codigo4;

import java.util.Locale;
import java.util.Scanner;

public class MainContaBancariaComHeranca {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		// lê a entrada do usuário
		String nomeTitular = scanner.nextLine();
		int numero = scanner.nextInt();
		double saldo = scanner.nextDouble();
		double taxaJuros = scanner.nextDouble();
		
		// cria uma conta bancária do tipo poupança
		ContaPoupanca contaPoupanca = new ContaPoupanca(nomeTitular, saldo, numero, taxaJuros);

		// exibe as informações da conta
		System.out.println("Conta Poupanca:");
		System.out.println(contaPoupanca.getNomeTitular());
		System.out.println(contaPoupanca.getNumero());
		System.out.printf("Saldo: R$ %.1f%n", contaPoupanca.getSaldo());
		System.out.printf("Taxa de juros: %.1f%%", contaPoupanca.getTaxaJuros());
		
		scanner.close();
	}

}

abstract class ContaBancaria {

	private String nomeTitular;
	private double saldo;
	private int numero;

	public ContaBancaria(String nomeTitular, double saldo, int numero) {
		this.nomeTitular = nomeTitular;
		this.saldo = saldo;
		this.numero = numero;
	}
	
	public String getNomeTitular() {
		return this.nomeTitular;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
}

class ContaPoupanca extends ContaBancaria {

	private double taxaJuros;

	public ContaPoupanca(String nomeTitular, double saldo, int numero, double taxaJuros) {
		super(nomeTitular, saldo, numero);
		this.taxaJuros = taxaJuros;
	}
	
	public double getTaxaJuros() {
		return this.taxaJuros;
	}
}