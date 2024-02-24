package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscaNaColletion(numero);

		if (conta != null)
			((Conta) conta).visualizar();
		else
			System.out.println("A conta número " + numero + " não foi encontrada!");
	}

	private Object buscaNaColletion(int numero2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("Conta número " + conta.getNumero() + "foi criada com sucesso!");

	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscaNaColletion(conta.getNumero());

		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println(" Conta Número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println(" A Conta número: " + conta.getNumero() + "não foi encontrada!");

	}

	@Override
	public void deletar(int numero) {
		var conta = buscaNaColletion(numero);

		if (conta != null) {
			System.out.println("A conta número: " + numero + " foi deletada com sucesso!");
		} else
			System.out.println("A conta número: " + numero + " não foi encontrada");

	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {

			if (conta.sacar(valor) == true)
				System.out.println("Saque na conta número: " + numero + " foi efetuado com sucesso!");

		} else
			System.out.println("A conta núemro: " + numero + "não foi enontrada!");

	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscaNaColletion(numero);

		if (conta != null) {
			((Conta) conta).depositar(valor);
			System.out.println("Deposito na conta número: " + numero + " foi efetuado com sucesso!");
		} else
			System.out.println("Conta número: " + numero + " não foi encontrada!");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null) {
		
		if (contaOrigem.sacar(valor) == true) {
			contaDestino.depositar(valor);
			System.out.println("Tansferência foi efetuada com sucesso!");
		} 
	} else System.out.println("A conta de origem e/ou destino não foram encontradas!");

}
	public int gerarNumero() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}
