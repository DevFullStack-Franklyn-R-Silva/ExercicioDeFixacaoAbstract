package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.println("Enter the number of tax payers:");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {

			System.out.println("Tax payer #" + i + " data: ");
			System.out.println("Individual or company (i/c)?");
			char ch = sc.next().charAt(0);
			System.out.println("Name:");
			sc.nextLine();
			String name = sc.nextLine();

			if (ch == 'i') {
				System.out.println("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.println("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			} else {
				System.out.println("Anual income: ");
				double anualIncome = sc.nextDouble();
				System.out.println("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		System.out.println();
		System.out.println("TAXES PAID: ");

		for (TaxPayer taxPayer : list) {
			System.out.println(taxPayer.toString());
		}

		System.out.println();
		double sum = 0.0;
		for (TaxPayer taxPayer : list) {
			sum += taxPayer.tax();
		}
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		sc.close();
	}

}
