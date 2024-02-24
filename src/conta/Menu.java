package conta;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;

public class Menu {
	public static Scanner leia = new Scanner(System.in);
	private static float valor;
	private static int numeroDestino;
	public static void main(String[] args) {

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo = 0, limite;
		Scanner leia = new Scanner(System.in);

		
		contas.listarTodas();
		
		while (true) {
			System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT);
			System.out.println("  *******************************************");
			System.out.println("  *           BANCO SAH                     *");
			System.out.println("  *******************************************");
			System.out.println("  *    1 - CRIAR CONTA                      *");
			System.out.println("  *    2 - LISTAR TODAS AS CONTAS           *");
			System.out.println("  *    3 - BUSCAR CONTAS POR NÚMERO         *");
			System.out.println("  *    4 - ATUALIZAR DADOS DA CONTA         *");
			System.out.println("  *    5 - APAGAR CONTA                     *");
			System.out.println("  *    6 - SACAR                            *");
			System.out.println("  *    7 - DEPOSITAR                        *");
			System.out.println("  *    8 - TRANFERIR VALORES ENTRE CONTAS   *");
			System.out.println("  *    0 - SAIR                             *");
			System.out.println("  *******************************************");
			System.out.println("  *      DIGITE A OPÇÃO DESEJADA            *");
			System.out.println("  *******************************************");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Criar conta");
				
				System.out.println("Digite o número da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o tipo de Conta(1- Conta Corrente ou 2- Conta Poupança: ");
					tipo = leia.nextInt();
				} while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o saldo da conta: ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta: ");
					aniversario = leia.nextInt();		
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;

			case 2:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Listar todas as contas");
				contas.listarTodas();
				
				keyPress();
				break;

			case 3:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Buscar contas por número");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;

			case 4:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Atualizar dados da conta");
				
				System.out.println("Digite o número da conta");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
				
					System.out.println("Digitte o número da agência: ");
					agencia= leia.nextInt();
					System.out.println("Digite o nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de crédito (R$): ");
						limite = leia.nextFloat();
						
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválida!");
					}
					}
				}else {
					System.out.println("A conta não foi encontrada!");
				}
				
				keyPress();
				break;

			case 5:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Apagar conta");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				keyPress();
				break;

			case 6:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Sacar");
				
				System.out.println("Digite o número da Conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				}while (valor <= 0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;

			case 7:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Depositar");
				
				System.out.println("Digite o numero da Conta: ");
				numero = leia.nextInt();
				
				do {
					System.out.println("Digite o valor de depósito (R$): ");
					valor = leia.nextFloat();
				} while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;

			case 8:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Transferir");
				
				System.out.println("Digite o número da conta de origem: ");
				numero = leia.nextInt();
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt();
				
				do {
					System.out.println("Digite o valor da tranferência (R$): ");
					valor = leia.nextInt();
				} while (valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				keyPress();
				break;
				
			case 0:
				System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "***Banco SAH -- ATENDIMENTO FINALIZADO");
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

	public static void keyPress() {
		
		try {
			
			System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "Pressione enter para continuar..." );
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionoua uma tecla diferente de enter!");
		}
		
	}
}
