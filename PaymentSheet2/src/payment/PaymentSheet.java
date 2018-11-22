package payment;

import java.util.*;
import payment.model.*;

public class PaymentSheet {
	private static HashMap<Integer, String> actions;
	private static HashMap<Integer, Employee> bkpEmployees, employees;
	private static int employeeCount;
	private static Scanner input;
	private static int lastAction;
	private static boolean redo;
	
	public static void main(String[] args) {
		actions = new HashMap<>();
		actions.put(1, "adicionar empregado");
		actions.put(2, "remover empregado");
		actions.put(3, "editar empregado");
		actions.put(6, "lançar cartão de ponto");
		actions.put(7, "lançar resultado de venda");
		
		bkpEmployees = new HashMap<>();
		employees = new HashMap<>();
		input = new Scanner(System.in);
		
		while (true) {
			System.out.print("---\n 0 - sair\n");
			for (int action : actions.keySet()) {
				System.out.printf("%2d - %s\n", action, actions.get(action));
			}
			System.out.print("99 - desfazer/refazer\n---\n");
			System.out.print("Escolha uma ação: ");
			int action = input.nextInt(); input.nextLine();
			if (action == 0) break;
			
			boolean ok = false;
			switch (action) {
			case -1:
				debug();
				break;
			case 1:
				ok = addEmployee();
				break;
			case 2:
				ok = removeEmployee();
				break;
			case 3:
				ok = editEmployee();
				break;
			case 6:
				ok = launchPointCard();
				break;
			case 7:
				ok = launchSaleResult();
			case 99:
				undoLastAction();
				break;
			default:
				System.err.println("Opção inválida.");
			}
			if (ok) {
				lastAction = action;
				redo = false;
			}
		}
	}
	
	private static boolean addEmployee() {
		backUpData();
		
		Employee employee = new Employee();
		editInfo(employee);
		employees.put(employeeCount, employee);
		
		System.out.println("Empregado '" + (employeeCount++) + ": " + employee.name + "' adicionado.");
		return true;
	}
	
	private static void backUpData() {
		for (int id : employees.keySet()) {
			bkpEmployees.put(id, employees.get(id));
		}
	}
	
	private static boolean editEmployee() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		backUpData();
		Employee employee = new Employee(employees.get(id));
		editInfo(employee);
		employees.put(id, employee);
		
		System.out.println("Empregado '" + id + ": " + employee.name + "' editado.");
		return true;
	}
	
	private static void editInfo(Employee employee) {
		System.out.print("Nome: ");
		employee.name = input.nextLine();
		
		System.out.print("Endereço: ");
		employee.address = input.nextLine();
		
		System.out.print("---\nh - horista\na - assalariado\nc - comissionado\n---\n");
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
			employee.type = Employee.Type.SALARIED;
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
	
	private static void debug() {
		System.out.println("Empregados:");
		for (int id : employees.keySet()) {
			System.out.println("  " + id + ": " + employees.get(id));
		}

		System.out.println("Empregados (backup):");
		for (int id : bkpEmployees.keySet()) {
			System.out.println("  " + id + ": " + bkpEmployees.get(id));
		}
	}
	
	private static int getEmployeeId() {
		System.out.print("Id do empregado: ");
		int id = input.nextInt(); input.nextLine();
		if (!employees.containsKey(id)) {
			System.err.println("Não encontrado.");
			return -1;
		}
		return id;
	}
	
	private static boolean launchPointCard() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		Employee employee = new Employee(employees.get(id));
		if (employee.type != Employee.Type.HOURLY) {
			System.err.println("Apenas horistas podem fazer isso.");
			return false;
		}
		
		backUpData();
		System.out.print("Horas trabalhadas: ");
		int hours = input.nextInt(); input.nextLine();
		employee.setPointCard(hours);
		employees.put(id, employee);
		
		System.out.println("Cartão de ponto associado a '" + id + ": " + employee.name + "' lançado.");
		return true;
	}
	
	private static boolean launchSaleResult() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		Employee employee = new Employee(employees.get(id));
		if (employee.type != Employee.Type.COMMISSIONED) {
			System.err.println("Apenas comissionados podem fazer isso.");
			return false;
		}
		
		backUpData();
		SaleResult sale = new SaleResult();
		
		System.out.print("Data (DD MM YYYY): ");
		int day = input.nextInt();
		int month = input.nextInt();
		int year = input.nextInt();
		input.nextLine();
		sale.date = new SimpleDate(year, month, day);
		
		System.out.print("Valor: ");
		sale.value = input.nextDouble(); input.nextLine();
		
		employee.setSaleResult(sale);
		employees.put(id, employee);
		
		System.out.println("Resultado de venda associado a '" + id + ": " + employee.name + "' lançado.");
		return true;
	}
	
	private static boolean removeEmployee() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		backUpData();
		Employee employee = employees.remove(id);
		
		System.out.println("Empregado '" + id + ": " + employee.name + "' removido.");
		return true;
	}
	
	private static void undoLastAction() {
		if (lastAction == 0) {
			System.err.println("Nenhuma ação para desfazer.");
			return;
		}
		
		HashMap<Integer, Employee> swap = employees;
		employees = bkpEmployees;
		bkpEmployees = swap;
		
		System.out.print("Ação '" + actions.get(lastAction));
		if (redo) {
			System.out.println("' refeita.");
			redo = false;
		} else {
			System.out.println("' desfeita.");
			redo = true;
		}
	}
}