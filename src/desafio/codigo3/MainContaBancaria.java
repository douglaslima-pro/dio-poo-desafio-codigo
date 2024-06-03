package desafio.codigo3;

import java.util.Locale;
import java.util.Scanner;

public class MainContaBancaria {

	public static void main(String[] args) {

		// muda as configurações de local para o padrão norte-americano
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		
		// lê o saldo inicial da conta
		double saldoInicial = scanner.nextDouble();
		ContaBancaria conta = new ContaBancaria(saldoInicial);
		
		// lê o valor de depósito
		double valorDeposito = scanner.nextDouble();
		conta.depositar(valorDeposito);
		
		// lê o valor de saque
		double valorSaque = scanner.nextDouble();
		conta.sacar(valorSaque);
		
		scanner.close();
	}

}

class ContaBancaria {

	double saldo;

	public ContaBancaria(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	public void depositar(double valorDeposito) {
		this.saldo += valorDeposito;
		System.out.println("Deposito feito.");
		System.out.printf("Saldo atual: %.1f%n", this.saldo);
	}

	public void sacar(double valorSaque) {
		if (valorSaque > this.saldo) {
			System.out.println("Saldo insuficiente. Saque não realizado.");
		} else {
			this.saldo -= valorSaque;
			System.out.println("Saque feito.");
			System.out.printf("Saldo atual: %.1f%n", this.saldo);
		}
	}

}