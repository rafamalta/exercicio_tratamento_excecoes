package application;

import java.util.Locale;
import java.util.Scanner;

import entidades.Conta;
import excecoes.DominioExcecoes;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Informe os dados da conta: ");
			System.out.print("Numero: ");
			Integer numero = sc.nextInt();
			System.out.print("Titular: ");
			sc.next();
			String titular = sc.nextLine();
			System.out.print("Saldo inicial: ");
			Double saldoInicial = sc.nextDouble();
			System.out.print("Limite de saque: ");
			Double limiteSaque = sc.nextDouble();
			Conta conta = new Conta(numero, titular, saldoInicial, limiteSaque);

			System.out.println();
			System.out.print("Informe o valor do seu saque: ");
			Double valorSaque = sc.nextDouble();

			conta.saque(valorSaque);
			System.out.println("Novo saldo: R$" + String.format("%.2f", conta.getSaldo()));
		}

		catch (DominioExcecoes e) {
			System.out.println("Erro de saque: " + e.getMessage());
		}

		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}

		sc.close();
	}
}
