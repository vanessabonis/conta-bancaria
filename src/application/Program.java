package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados da conta");
		System.out.print("Numero da conta > ");
		int conta = sc.nextInt();
		System.out.print("Titular > ");
		//consumir o enter do buffer de entrada do nextInt
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo Inicial > ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de Saque > ");
		double limiteDeSaque = sc.nextDouble();
		
		//instanciar conta
		Account acc = new Account(conta, titular, saldo, limiteDeSaque);
		
		System.out.println();
		System.out.print("Quantia do saque > ");
		double quantia = sc.nextDouble();

		//excep
		try {
			acc.saque(quantia);
			System.out.printf("Novo Saldo: %.2f%n", acc.getSaldo());
		}
		catch (BusinessExceptions e) {
			System.out.println(e.getMessage());	
		}
		
		sc.close();
		
	}
	

}
