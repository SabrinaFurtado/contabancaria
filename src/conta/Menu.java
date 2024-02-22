package conta;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		// TESTE CLASSE CONTA
		Conta cont1 = new Conta(1, 8745, 1, "Sabrina", 20000.0f);
		cont1.visualizar();
		cont1.sacar(1500.0f);
		cont1.visualizar();
		cont1.depositar(600f);
		cont1.visualizar();

		// TESTE CLASSE CONTA CORRENTE
		ContaCorrente cc1 = new ContaCorrente(2, 9685, 1, "Nicolas", 6000.0f, 5000.0f);
		cc1.visualizar();
		cc1.sacar(800f);
		cc1.visualizar();
		cc1.depositar(2500.0f);
		cc1.visualizar();

		// TESTE CLASSE CONTA POUPANÇA
		ContaPoupanca cp1 = new ContaPoupanca(6, 7415, 2, "Valentina", 2000.0f, 1);
		cp1.visualizar();
		cp1.sacar(200f);
		cp1.visualizar();
		cp1.depositar(3000.0f);
		cp1.visualizar();

		Scanner leia = new Scanner(System.in);
		int opcao;

		while (true) {
			System.out.println("********************************");
			System.out.println("           BANCO SAH            ");
			System.out.println("********************************");
			System.out.println("       1 - CRIAR CONTA          ");
			System.out.println("       2- SAQUE                 ");
			System.out.println("       3- DEPOSITO              ");
			System.out.println("       4- TRANFERIRÊCIA         ");
			System.out.println("       5 - ATUALIZAR DADOS      ");
			System.out.println("       0 - SAIR                 ");
			System.out.println("********************************");
			System.out.println("      DIGITE A OPÇÃO DESEJADA   ");

			opcao = leia.nextInt();
			

			switch (opcao) {
			case 1:
				System.out.println("Criar conta");
				break;

			case 2:
				System.out.println("Saque");
				break;

			case 3:
				System.out.println("Deposito");
				break;

			case 4:
				System.out.println("Tranferência");
				break;

			case 5:
				System.out.println("Atualizar Dados");
				break;

			case 0:
				System.out.println("***Banco SAH -- ATENDIMENTO FINALIZADO");
				sobre();
				leia.close();
				System.exit(0);
			}
		}
	}

	public static void sobre() {
		System.out.println("*********************");
		System.out.println("projeto desenvolvido por: Sabrina dos Santos Furtado");
		System.out.println("sabrina.s.furtado@gmail.com");
		System.out.println("GITHUB: https://github.com/SabrinaFurtado");
	}
}
