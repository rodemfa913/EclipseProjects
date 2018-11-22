package payment;

import java.util.*;
import payment.model.*;
import payment.util.Pair;

public class PaymentSheet {
	private static HashMap<Integer, Employee> bkpEmployees, employees;
	private static int employeeCount;
	private static Scanner input;
	private static Action lastAction;
	private static boolean redo;
	
	public static void main(String[] args) {
		bkpEmployees = new HashMap<Integer, Employee>();
		employees = new HashMap<Integer, Employee>();
		input = new Scanner(System.in);
		
		while (true) {
			System.out.print(
					"---\n" +
					" 0 - sair\n" +
					" 1 - adicionar empregado\n" +
					" 2 - remover empregado\n" +
					" 3 - editar empregado\n" +
					"99 - desfazer/refazer\n" +
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
			case 3:
				editEmployee();
				break;
			case 99:
				undoLastAction();
				break;
			default:
				System.err.println("Opção inválida.");
			}
		}
	}
	
	private static void addEmployee() {
		Employee employee = new Employee();
		
		editInfo(employee);
		employees.put(employeeCount, employee);
		
		lastAction = Action.ADD;
		redo = false;
		
		System.out.println("Empregado " + employee.name + " (id: " + (employeeCount++) + ") adicionado.");
	}
	
	private static void editEmployee() {
		Pair<Integer, Employee> pair = getEmployee();
		if (pair == null) return;
		
		int id = pair.getFirst();
		Employee bkpEmployee = pair.getSecond();
		bkpEmployees.put(id, bkpEmployee);
		Employee employee = new Employee(bkpEmployee);
		editInfo(employee);
		employees.put(id, employee);
		
		lastAction = Action.EDIT;
		redo = false;
		
		System.out.println("Empregado " + employee.name + " (id: " + id + ") editado.");
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
	
	private static Pair<Integer, Employee> getEmployee() {
		System.out.print("Id do empregado: ");
		int id = input.nextInt(); input.nextLine();
		
		if (!employees.containsKey(id)) {
			System.err.println("Não encontrado.");
			return null;
		}
		
		Employee employee = employees.get(id);
		
		return new Pair<Integer, Employee>(id, employee);
	}
	
	private static void removeEmployee() {
		Pair<Integer, Employee> pair = getEmployee();
		if (pair == null) return;
		
		int id = pair.getFirst();
		Employee employee = pair.getSecond();
		employees.remove(id);
		bkpEmployees.put(id, employee);
		
		lastAction = Action.REMOVE;
		redo = false;
		
		System.out.println("Empregado " + employee.name + " removido.");
	}
	
	private static void undoLastAction() {
		if (lastAction == null) {
			System.err.println("Nenhuma ação para desfazer.");
			return;
		}
		
		HashMap<Integer, Employee> swap = employees;
		employees = bkpEmployees;
		bkpEmployees = swap;
		
		System.out.print("Última ação (");
		switch (lastAction) {
		case ADD:
			System.out.print("adicionar empregado");
			break;
		case EDIT:
			System.out.print("editar empregado");
			break;
		case REMOVE:
			System.out.print("remover empregado");
		}
		if (redo) {
			System.out.println(") refeita.");
			redo = false;
		} else {
			System.out.println(") desfeita.");
			redo = true;
		}
	}
}