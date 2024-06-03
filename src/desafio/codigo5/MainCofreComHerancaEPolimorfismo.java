package desafio.codigo5;

import java.util.Scanner;

public class MainCofreComHerancaEPolimorfismo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// lê o tipo de cofre
		String tipoCofre = scanner.nextLine();
		
		if (tipoCofre.equalsIgnoreCase("FISICO")) {
			CofreFisico cofreFisico = new CofreFisico("Cofre Fisico", "Chave");
			cofreFisico.exibirInformacoes();
		} else if (tipoCofre.equalsIgnoreCase("DIGITAL")) {
			int senha = scanner.nextInt();
			int senhaConfirmacao = scanner.nextInt();
			CofreDigital cofreDigital = new CofreDigital("Cofre Digital", "Senha", senha);
			cofreDigital.exibirInformacoes();
			if (cofreDigital.validarSenha(senhaConfirmacao)) {
				System.out.println("Cofre aberto!");
			} else {
				System.out.println("Senha incorreta!");
			}
		}
		
		scanner.close();
	}

}

abstract class Cofre {
	
	private String tipo;
	private String metodoAbertura;
	
	public Cofre(String tipo, String metodoAbertura) {
		this.tipo = tipo;
		this.metodoAbertura = metodoAbertura;
	}
	
	public void exibirInformacoes() {
		System.out.println("Tipo: " + this.tipo);
		System.out.println("Metodo de abertura: " + this.metodoAbertura);
	}
	
}

class CofreDigital extends Cofre{
	
	private int senha;
	
	public CofreDigital(String tipo, String metodoAbertura, int senha) {
		super(tipo, metodoAbertura);
		this.senha = senha;
	}

	public boolean validarSenha(int senha) {
		return this.senha == senha;
	}
	
}

class CofreFisico extends Cofre {
	
	public CofreFisico(String tipo, String metodoAbertura) {
		super(tipo, metodoAbertura);
	}
}
