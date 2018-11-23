package payment;

import java.util.*;
import payment.model.*;

public class PaymentSheet {
	private enum Action {
		ADD, REMOVE, EDIT, LAUNCH_CARD, LAUNCH_SALE;
		
		public boolean doAction() {
			switch (this) {
			case ADD:
				return addEmployee();
			case EDIT:
				return editEmployee();
			case LAUNCH_CARD:
				return launchPointCard();
			case LAUNCH_SALE:
				return launchSaleResult();
			default:
				return removeEmployee();
			}
		}
		
		@Override public String toString() {
			switch (this) {
			case ADD:
				return "adicionar empregado";
			case EDIT:
				return "editar empregado";
			case LAUNCH_CARD:
				return "lançar cartão de ponto";
			case LAUNCH_SALE:
				return "lançar resultado de venda";
			default:
				return "remover empregado";
			}
		}
	}
	
	private static HashMap<Integer, Employee> bkpEmployees, employees;
	private static int employeeCount;
	private static Scanner input;
	private static Action lastAction;
	private static boolean redo;
	
	public static void main(String[] args) {
		ArrayList<Action> actions = new ArrayList<>();
		for (Action action : Action.values()) {
			actions.add(action);
		}
		
		bkpEmployees = new HashMap<>();
		employees = new HashMap<>();
		input = new Scanner(System.in);
		
		while (true) {
			System.out.print("---\n 0 - sair\n");
			for (int a = 1; a <= actions.size(); a++) {
				System.out.printf("%2d - %s\n", a, actions.get(a - 1));
			}
			System.out.print("99 - desfazer/refazer\n---\n");
			System.out.print("Escolha uma ação: ");
			int a = input.nextInt(); input.nextLine();
			if (a == 0) break;
			if (a == -1) debug();
			else if (a == 99) undoLastAction();
			else if (a >= 1 && a <= actions.size()) {
				Action action = actions.get(a - 1);
				if (action.doAction()) {
					lastAction = action;
					redo = false;
				}
			} else System.err.println("Opção inválida.");
		}
	}
	
	private static boolean addEmployee() {
		copyData();
		
		Employee employee = new Employee();
		editInfo(employee);
		employees.put(employeeCount, employee);
		
		System.out.println(
				"Empregado '" + (employeeCount++) +
				": " + employee.name + "' adicionado."
		);
		return true;
	}
	
	private static void copyData() {
		for (int id : employees.keySet()) {
			bkpEmployees.put(id, employees.get(id));
		}
	}
	
	private static boolean editEmployee() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		copyData();
		Employee employee = new Employee(employees.get(id));
		editInfo(employee);
		employees.put(id, employee);
		
		System.out.println(
				"Empregado '" + id + ": " + employee.name + "' editado."
		);
		return true;
	}
	
	private static void editInfo(Employee employee) {
		System.out.print("Nome: ");
		employee.name = input.nextLine();
		
		System.out.print("Endereço: ");
		employee.address = input.nextLine();
		
		ArrayList<Employee.Type> types = new ArrayList<>();
		for (Employee.Type type : Employee.Type.values()) types.add(type);
		
		System.out.println("---");
		for (int t = 0; t < types.size(); t++) {
			System.out.println(t + " - " + types.get(t));
		}
		System.out.println("---");
		System.out.print("Tipo: ");
		int t = input.nextInt(); input.nextLine();
		employee.type = types.get(t);
		
		if (employee.type == Employee.Type.COMMISSIONED) {
			System.out.print("Comissão: ");
			employee.commission = input.nextDouble(); input.nextLine();
		}
		
		ArrayList<PaymentMethod> methods = new ArrayList<>();
		for (PaymentMethod method : PaymentMethod.values()) methods.add(method);
		
		System.out.println("---");
		for (int m = 0; m < methods.size(); m++) {
			System.out.println(m + " - " + methods.get(m));
		}
		System.out.println("---");
		System.out.print("Método de pagamento: ");
		int m = input.nextInt(); input.nextLine();
		employee.paymentMethod = methods.get(m);
		
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
		
		copyData();
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
		
		copyData();
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
		
		copyData();
		Employee employee = employees.remove(id);
		
		System.out.println("Empregado '" + id + ": " + employee.name + "' removido.");
		return true;
	}
	
	private static void undoLastAction() {
		if (lastAction == null) {
			System.err.println("Nenhuma ação para desfazer.");
			return;
		}
		
		HashMap<Integer, Employee> swap = employees;
		employees = bkpEmployees;
		bkpEmployees = swap;
		
		System.out.print("Ação '" + lastAction);
		if (redo) {
			System.out.println("' refeita.");
			redo = false;
		} else {
			System.out.println("' desfeita.");
			redo = true;
		}
	}
}