package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		int opcao;

		while (true) {
			System.out.println("********************************");
			System.out.println("           BANCO SAH            ");
			System.out.println("********************************");
			System.out.println("       1 - CRIAR CONTA          ");
			System.out.println("       2- SAQUE                ");
			System.out.println("       3- DEPOSITO             ");
			System.out.println("       4- TRANFERIRÊCIA             ");
			System.out.println("       5 - ATUALIZAR DADOS      ");
			System.out.println("       0 - SAIR         ");
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