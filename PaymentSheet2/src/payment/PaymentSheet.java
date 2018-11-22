package payment;

import java.util.*;
import payment.model.*;

public class PaymentSheet {
	private static ArrayList<Employee> employees;
	private static Scanner input;
	
	public static void main(String[] args) {
		employees = new ArrayList<Employee>();
		input = new Scanner(System.in);
		
		while (true) {
			System.out.print(
					"---\n" +
					"0 - sair\n" +
					"1 - adicionar empregado\n" +
					"2 - remover empregado\n" +
					"---\n"
			);
			System.out.print("Escolha uma opção: ");
			int option = input.nextInt(); input.nextLine();
			if (option == 0) break;
			
			switch (option) {
			case 1:
				addEmployee();
				break;
			case 2:
				removeEmployee();
				break;
			default:
				System.err.println("Opção inválida.");
			}
		}
	}
	
	private static void addEmployee() {
		Employee employee = new Employee();
		editInfo(employee);
		employees.add(employee);
		System.out.println("Empregado " + employee.name + " adicionado (id: " + (employees.size() - 1) + ")");
	}
	
	private static void editInfo(Employee employee) {
		System.out.print("Nome: ");
		employee.name = input.nextLine();
		
		System.out.print("Endereço: ");
		employee.address = input.nextLine();
		
		System.out.print("---\nh - horista\nm - mensal\nc - comissionado\n---\n");
		System.out.print("Tipo: ");
		switch (input.nextLine()) {
		case "h":
			employee.type = Employee.Type.HOURLY;
			break;
		case "c":
			employee.type = Employee.Type.COMMISSIONED;
			System.out.print("Comissão: ");
			employee.commission = input.nextDouble();
			input.nextLine();
			break;
		default:
			employee.type = Employee.Type.MONTHLY;
		}
		
		System.out.print("---\nc - cheque por correios\nm - cheque em mãos\nd - depósito em conta\n---\n");
		System.out.print("Método de pagamento: ");
		switch (input.nextLine()) {
		case "c":
			employee.paymentMethod = PaymentMethod.MAIL;
			break;
		case "m":
			employee.paymentMethod = PaymentMethod.HANDS;
			break;
		default:
			employee.paymentMethod = PaymentMethod.DEPOSIT;
		}
		
		System.out.print("Salário: ");
		employee.salary = input.nextDouble(); input.nextLine();
	}
	
	private static void removeEmployee() {
		System.out.print("Id do empregado: ");
		int id = input.nextInt(); input.nextLine();
		
		if (id < 0 || id >= employees.size()) {
			System.err.println("Não encontrado.");
		} else {
			Employee employee = employees.remove(id);
			System.out.println("Empregado " + employee.name + " removido.");
		}
	}
}