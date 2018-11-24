package payment;

import java.util.*;
import payment.model.*;

public class PaymentSheet {
	private enum Action {
		ADD, REMOVE, EDIT, SIGN_IN, SIGN_OUT,
		LAUNCH_CARD, LAUNCH_SALE, LAUNCH_FEE;
		
		public boolean doAction() {
			switch (this) {
			case ADD:
				return addEmployee();
			case EDIT:
				return editEmployee();
			case SIGN_IN:
				return signInSyndicate();
			case SIGN_OUT:
				return signOutSyndicate();
			case LAUNCH_CARD:
				return launchPointCard();
			case LAUNCH_SALE:
				return launchSaleResult();
			case LAUNCH_FEE:
				return launchServiceFee();
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
			case SIGN_IN:
				return "entrar no sindicato";
			case SIGN_OUT:
				return "sair do sindicato";
			case LAUNCH_CARD:
				return "lançar cartão de ponto";
			case LAUNCH_SALE:
				return "lançar resultado de venda";
			case LAUNCH_FEE:
				return "lançar taxa de serviço";
			default:
				return "remover empregado";
			}
		}
	}
	
	private static int employeeCount;
	private static HashMap<Integer, Employee> bkpEmployees, employees;
	private static Scanner input;
	private static Action lastAction;
	private static boolean redo;
	private static Syndicate bkpSyndicate, syndicate;
	
	public static void main(String[] args) {
		employees = new HashMap<>();
		input = new Scanner(System.in);
		syndicate = new Syndicate();
		
		ArrayList<Action> actions = new ArrayList<>();
		for (Action action : Action.values()) {
			actions.add(action);
		}
		
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
			} else System.out.println("<Erro> Opção inválida.");
		}
	}
	
	private static boolean addEmployee() {
		copyData();
		
		Employee employee = new Employee();
		editInfo(employee);
		employee.id = employeeCount;
		employees.put(employeeCount, employee);
		
		System.out.println(
				"Empregado '" + (employeeCount++) +
				": " + employee.name + "' adicionado."
		);
		return true;
	}
	
	private static void copyData() {
		bkpEmployees = new HashMap<>(employees);
		bkpSyndicate = new Syndicate(syndicate);
	}
	
	private static void debug() {
		System.out.println("Empregados:");
		for (int id : employees.keySet()) {
			System.out.println(id + ":");
			System.out.println(employees.get(id));
		}

		System.out.println("Empregados (backup):");
		for (int id : bkpEmployees.keySet()) {
			System.out.println("id " + id + ":");
			System.out.println(bkpEmployees.get(id));
		}
		
		System.out.println("Sindicato:");
		System.out.println(syndicate);
		
		System.out.println("Sindicato (backup):");
		System.out.println(bkpSyndicate);
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
	
	private static int getEmployeeId() {
		System.out.print("Id do empregado: ");
		int id = input.nextInt(); input.nextLine();
		if (!employees.containsKey(id)) {
			System.out.println("<Erro> Não encontrado.");
			return -1;
		}
		return id;
	}
	
	private static String getSyndicateMemberId() {
		System.out.print("Id do membro do sindicato: ");
		String sid = input.nextLine();
		if (!syndicate.hasMember(sid)) {
			System.out.println("<Erro> Não encontrado.");
			return null;
		}
		return sid;
	}
	
	private static boolean launchPointCard() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		Employee employee = employees.get(id);
		if (employee.type != Employee.Type.HOURLY) {
			System.out.println("<Erro> Apenas horistas podem fazer isso.");
			return false;
		}
		
		System.out.print("Horas trabalhadas: ");
		int hours = input.nextInt(); input.nextLine();
		
		copyData();
		employee = new Employee(employee);
		employee.setPointCard(hours);
		employees.put(id, employee);
		
		System.out.println(
				"Cartão de ponto associado a '" + id +
				": " + employee.name + "' lançado."
		);
		return true;
	}
	
	private static boolean launchSaleResult() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		Employee employee = employees.get(id);
		if (employee.type != Employee.Type.COMMISSIONED) {
			System.out.println("<Erro> Apenas comissionados podem fazer isso.");
			return false;
		}
		
		System.out.print("Data (DD MM YYYY): ");
		int day = input.nextInt();
		int month = input.nextInt();
		int year = input.nextInt();
		input.nextLine();
		SimpleDate date = new SimpleDate(year, month, day);
		
		System.out.print("Valor: ");
		double value = input.nextDouble(); input.nextLine();
		
		copyData();
		employee = new Employee(employee);
		employee.setSaleResult(new SaleResult(date, value));
		employees.put(id, employee);
		
		System.out.println(
				"Resultado de venda associado a '" + id +
				": " + employee.name + "' lançado."
		);
		return true;
	}
	
	private static boolean launchServiceFee() {
		String sid = getSyndicateMemberId();
		if (sid == null) return false;
		
		System.out.print("Serviço: ");
		String service = input.nextLine();
		
		copyData();
		Employee member = new Employee(syndicate.getMember(sid));
		member.setService(service);
		
		System.out.print("Taxa: ");
		if (syndicate.hasService(service)) {
			System.out.println(syndicate.getServiceFee(service));
		} else {
			syndicate.setService(service, input.nextDouble());
			input.nextLine();
		}
		
		employees.put(member.id, member);
		syndicate.setMember(sid, member);
		
		System.out.println(
				"Taxa de serviço associada a '" +
				sid + ": " + member + "' lançada."
		);
		return true;
	}
	
	private static boolean removeEmployee() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		copyData();
		Employee employee = employees.remove(id);
		syndicate.removeMember(employee.syndicateId);
		
		System.out.println(
				"Empregado '" + id + ": " +
				employee.name + "' removido.");
		return true;
	}
	
	private static boolean signInSyndicate() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		System.out.print("Id do membro do sindicato: ");
		String sid = input.nextLine();
		if (syndicate.hasMember(sid)) {
			System.out.println("<Erro> Membro já existente.");
			return false;
		}
		
		copyData();
		Employee employee = new Employee(employees.get(id));
		employee.syndicateId = sid;
		
		System.out.print("Taxa sindical: ");
		employee.syndicateFee = input.nextDouble(); input.nextLine();
		
		employees.put(id, employee);
		syndicate.setMember(sid, employee);
		
		System.out.println(
				"Membro '" + sid + ": " + employee.name +
				"' adicionado ao sindicato."
		);
		return true;
	}
	
	private static boolean signOutSyndicate() {
		String sid = getSyndicateMemberId();
		if (sid == null) return false;
		
		copyData();
		Employee member = new Employee(syndicate.removeMember(sid));
		member.syndicateId = null;
		employees.put(member.id, member);
		
		System.out.println(
				"Membro '" + sid + ": " + member.name +
				"' removido do sindicato."
		);
		return true;
	}
	
	private static void undoLastAction() {
		if (lastAction == null) {
			System.out.println("<Erro> Nenhuma ação para desfazer.");
			return;
		}
		
		HashMap<Integer, Employee> empSwap = employees;
		employees = bkpEmployees;
		bkpEmployees = empSwap;
		
		Syndicate syndSwap = syndicate;
		syndicate = bkpSyndicate;
		bkpSyndicate = syndSwap;
		
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