package desafio.codigo2;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegistroTransacoesComStream {

	public static void main(String[] args) {
		
		// muda as configurações de local para o padrão norte-americano
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		
		// lê o saldo inicial
		double saldo = scanner.nextDouble();
		
		// lê a quantidade de transações a serem feitas
		int quantidadeTransacoes = scanner.nextInt();

		// cria uma lista a partir de uma stream
		// usando um supplier como argumento no método generate(cria uma fonte de dados a partir da entrada do usuário)
		// coleta os dados da stream usando a classe Collectors
		List<Transacao> historicoTransacoes =
				Stream
				.generate(() -> {
					char tipoTransacao = scanner.next().charAt(0);
					double valorTransacao = scanner.nextDouble();
					if ("d".equalsIgnoreCase(String.valueOf(tipoTransacao)) || "s".equalsIgnoreCase(String.valueOf(tipoTransacao))) {
						return new Transacao(tipoTransacao, valorTransacao);
					} else {
						return null;
					}
				})
				.limit(quantidadeTransacoes)
				.collect(Collectors.toList());
		
		// calcula as transações de depósito
		saldo += historicoTransacoes
				.stream()
				.filter(transacao -> transacao.getTipo() == 'd')
				.mapToDouble(transacao -> transacao.getValor())
				.sum();
		
		// calcula as transações de saque
		saldo -= historicoTransacoes
				.stream()
				.filter(transacao -> transacao.getTipo() == 's')
				.mapToDouble(transacao -> transacao.getValor())
				.sum();

		// output
		System.out.printf("Saldo: %.1f%n", saldo);
		System.out.println("Transacoes:");
		// exibe a lista de transações
		// passa como argumento um Consumer no método forEach
		historicoTransacoes.forEach(transacao -> {
			System.out.printf("%s de %.1f%n", (transacao.getTipo() == 'd' ? "Deposito" : "Saque" ), transacao.getValor());
		});
	}

}

class Transacao {
	
	private char tipo;
	private double valor;
	
	public Transacao(char tipo, double valor) {
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public char getTipo() {
		return this.tipo;
	}
	
	public double getValor() {
		return this.valor;
	}
	
}