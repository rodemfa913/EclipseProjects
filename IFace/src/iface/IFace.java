package iface;

import java.util.*;
import iface.model.User;

public class IFace {
	private enum Action {
		SIGN_UP, SIGN_OUT;
		
		public void doAction() {
			switch (this) {
			case SIGN_OUT:
				signOut();
				break;
			default:
				signUp();
			}
		}
		
		@Override public String toString() {
			switch (this) {
			case SIGN_OUT:
				return "remover conta";
			default:
				return "criar conta";
			}
		}
	}
	
	private static Scanner input;
	private static HashMap<String, String> passwords;
	private static HashMap<String, User> users;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		passwords = new HashMap<>();
		users = new HashMap<>();
		
		ArrayList<Action> actions = new ArrayList<>();
		for (Action action : Action.values()) {
			actions.add(action);
		}
		
		while (true) {
			System.out.print("---\n 0 - sair\n");
			int a;
			for (a = 1; a <= actions.size(); a++) {
				System.out.printf("%2d - %s\n", a, actions.get(a - 1));
			}
			System.out.print("---\nEscolha uma ação: ");
			a = input.nextInt(); input.nextLine();
			
			if (a == 0) break;
			if (a >= 1 && a <= actions.size()) actions.get(a - 1).doAction();
			else System.out.println("<Erro> Opção inválida.");
		}
	}
	
	private static User signIn() {
		System.out.print("Login: ");
		String login = input.nextLine();
		if (!users.containsKey(login)) {
			System.out.println("<Erro> Login não encontrado.");
			return null;
		}
		
		System.out.print("Senha: ");
		if (!passwords.get(login).equals(input.nextLine())) {
			System.out.println("<Erro> Senha incorreta.");
			return null;
		}
		
		return users.get(login);
	}
	
	private static void signOut() {
		User user = signIn();
		if (user == null) return;
		
		users.remove(user.getLogin());
		System.out.println("Conta de usuário " + user.getName() + " removida.");
	}
	
	private static void signUp() {
		System.out.print("Login: ");
		String login = input.nextLine();
		if (users.containsKey(login)) {
			System.out.println("<Erro> Login já existente.");
			return;
		}
		User user = new User(login);
		
		System.out.print("Senha: ");
		passwords.put(login, input.nextLine());
		
		System.out.print("Nome de usuário: ");
		user.setName(input.nextLine());
		
		users.put(login, user);
		System.out.println("Conta de usuário " + user.getName() + " criada.");
	}
}