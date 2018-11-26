package iface;

import java.util.*;

public class IFace {
	private enum Action {
		SIGN_IN, SIGN_OUT;
		
		public void doAction() {
			System.out.println("Em desenvolvimento...");
		}
		
		@Override public String toString() {
			switch (this) {
			case SIGN_OUT:
				return "desinscrever-se";
			default:
				return "inscrever-se";
			}
		}
	}
	
	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
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
}