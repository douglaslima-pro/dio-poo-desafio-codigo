package desafio.codigo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RegistroTransacoesBancarias {

	public static void main(String[] args) {

		// define as configurações de local para o padrão norte-americano
		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		// informa o saldo inicial da conta
		double saldo = scanner.nextDouble();

		// informa a quantidade total de transações
		int quantidadeTransacoes = scanner.nextInt();

		// armazena o histórico de transações
		List<String> transacoes = new ArrayList<>();

		// realiza as transações pela quantidade de vezes que o usuário informou
		for (int i = 0; i < quantidadeTransacoes; i++) {
			char tipoTransacao = scanner.next().charAt(0);
			double valorTransacao = scanner.nextDouble();
			if (tipoTransacao == 'd' || tipoTransacao == 'D') {
				saldo += valorTransacao;
				transacoes.add(String.format("%d. %s de %.1f", i + 1, "Deposito", valorTransacao));
			} else if (tipoTransacao == 's' || tipoTransacao == 'S') {
				saldo -= valorTransacao;
				transacoes.add(String.format("%d. %s de %.1f", i + 1, "Saque", valorTransacao));
			}
		}

		// exibe o saldo final
		System.out.printf("Saldo: %.1f%n", saldo);

		// exibe a lista de transações
		System.out.println("Transacoes:");
		transacoes.forEach(System.out::println);

		scanner.close();
	}

}
