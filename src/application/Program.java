package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String dep_name = sc.nextLine();
		
		System.out.println("Digite dados do trabalhador:");
		System.out.print("Nome: ");
		String work_name = sc.nextLine();
		System.out.print("Level: ");
		String work_level = sc.nextLine();
		System.out.print("Salario base: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(work_name, WorkerLevel.valueOf(work_level), baseSalary, new Departament(dep_name));
		
		System.out.print("Quantos contratos tem esse trabalhador: ");
		int n = sc.nextInt();
		
		int contcontr = 1;
		for(int i=0; i<n; i++) {
			System.out.println("Digite os dados do contrato #" + contcontr + ":");
			System.out.print("Data (DD/MM/AAAA): ");
			Date contratodata = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duracao (horas): ");
			Integer hours = sc.nextInt();
			HourContract contract = new HourContract(contratodata, valuePerHour, hours);
			worker.addContract(contract);

			contcontr++;
		}
		System.out.println();
		System.out.print("Digite o mes e o ano da renda (MM/AAAA): ");
		String meseano = sc.next();
		int month = Integer.parseInt(meseano.substring(0, 2));
		int year = Integer.parseInt(meseano.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartament().getName());
		System.out.println("Renda em " + meseano + ": " + String.format("%.2f", worker.income(year, month)));

	}

}
