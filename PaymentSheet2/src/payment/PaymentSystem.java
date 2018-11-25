package payment;

import java.util.*;
import payment.model.*;

public class PaymentSystem {
	private enum Action {
		ADD, REMOVE, EDIT, SIGN_IN, SIGN_OUT,
		LAUNCH_CARD, LAUNCH_SALE, LAUNCH_FEE, ROLL;
		
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
			case ROLL:
				return rollPayment();
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
			case ROLL:
				return "rodar folha de pagamento";
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
		
		Employee employee = new Employee(employeeCount++);
		editInfo(employee);
		setEmployee(employee);
		
		System.out.println(
				"Empregado " + employee.employeeInfo() + " adicionado."
		);
		return true;
	}
	
	private static void copyData() {
		bkpEmployees = new HashMap<>(employees);
		bkpSyndicate = new Syndicate(syndicate);
	}
	
	private static void debug() {
		System.out.println("Empregados:");
		for (int id : employees.keySet()) System.out.println(employees.get(id));

		System.out.println("Empregados (backup):");
		for (int id : bkpEmployees.keySet()) {
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
		setEmployee(employee);
		
		System.out.println(
				"Empregado " + employee.employeeInfo() + " editado."
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
			employee.setCommission(input.nextDouble()); input.nextLine();
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
	
	private static SimpleDate getDate() {
		System.out.print("Data (DD MM YYYY): ");
		int day = input.nextInt();
		int month = input.nextInt();
		int year = input.nextInt(); input.nextLine();
		
		return new SimpleDate(year, month, day);
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
		
		SimpleDate date = getDate();
		
		System.out.print("Horas trabalhadas: ");
		int hours = input.nextInt(); input.nextLine();
		
		copyData();
		employee = new Employee(employee);
		employee.getPointCards().add(new PointCard(date, hours));
		setEmployee(employee);
		
		System.out.println(
				"Cartão de ponto associado a " +
				employee.employeeInfo() + " lançado."
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
		
		SimpleDate date = getDate();
		
		System.out.print("Valor: ");
		double value = input.nextDouble(); input.nextLine();
		
		copyData();
		employee = new Employee(employee);
		employee.getSaleResults().add(new SaleResult(date, value));
		setEmployee(employee);
		
		System.out.println(
				"Resultado de venda associado a " +
				employee.employeeInfo() + " lançado."
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
		
		setEmployee(member);
		
		System.out.println(
				"Taxa de serviço associada a " +
				member.memberInfo() + " lançada."
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
				"Empregado " + employee.employeeInfo() + " removido."
		);
		return true;
	}
	
	private static boolean rollPayment() {
		SimpleDate date = getDate();
		ArrayList<Payment> payments = new ArrayList<>();
		copyData();
		for (int id : employees.keySet()) {
			Employee employee = employees.get(id);
			double value = 0.0;
			switch (employee.type) {
			case HOURLY:
				if (date.getDayOfWeek() != SimpleDate.DayOfWeek.FRIDAY) break;
				employee = new Employee(employee);
				ArrayList<PointCard> cards = employee.getPointCards();
				for (PointCard card : cards) {
					int hours = card.getHours();
					value += employee.salary + hours;
					if (hours > 8) value += 0.5 * (hours - 8);
				}
				cards.clear();
				setEmployee(employee);
				break;
			case COMMISSIONED:
				if (
						date.getDayOfWeek() != SimpleDate.DayOfWeek.FRIDAY ||
						date.getWeekOfMonth() % 2 != 0
				) break;
				employee = new Employee(employee);
				value = employee.salary / 2;
				ArrayList<SaleResult> sales = employee.getSaleResults();
				for (SaleResult sale : sales) {
					value += employee.getCommission() * sale.getValue();
				}
				sales.clear();
				setEmployee(employee);
				break;
			default:
				if (date.isLastBusinessDay()) value = employee.salary;
			}
			if (value > 0.0) payments.add(new Payment(employee, value));
		}
		System.out.println("Folha de pagamento para " + date + ":");
		for (Payment payment : payments) {
			System.out.println(payment);
		}
		return true;
	}
	
	private static void setEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
		if (employee.syndicateId != null) {
			syndicate.setMember(employee.syndicateId, employee);
		}
	}
	
	private static boolean signInSyndicate() {
		int id = getEmployeeId();
		if (id < 0) return false;
		
		Employee member = employees.get(id);
		if (member.syndicateId != null) {
			System.out.println("<Erro> Empregado já é membro do sindicato.");
			return false;
		}
		
		System.out.print("Id do membro do sindicato: ");
		String sid = input.nextLine();
		if (syndicate.hasMember(sid)) {
			System.out.println("<Erro> Id já existente.");
			return false;
		}
		
		copyData();
		member = new Employee(member);
		member.syndicateId = sid;
		
		System.out.print("Taxa sindical: ");
		member.syndicateFee = input.nextDouble(); input.nextLine();
		
		setEmployee(member);
		
		System.out.println(
				"Membro " + member.memberInfo() + " adicionado ao sindicato."
		);
		return true;
	}
	
	private static boolean signOutSyndicate() {
		String sid = getSyndicateMemberId();
		if (sid == null) return false;
		
		copyData();
		Employee member = new Employee(syndicate.removeMember(sid));
		member.syndicateId = null;
		setEmployee(member);
		
		System.out.println(
				"Membro " + member.memberInfo() + " removido do sindicato."
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