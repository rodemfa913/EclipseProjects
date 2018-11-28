package iface;

import java.util.*;
import iface.model.*;

public class IFace {
   private enum Action {
      SIGN_UP, SIGN_OUT, EDIT_PROFILE, ADD_FRIEND, SEND_MESSAGE;

      public void doAction() {
         switch (this) {
         case SIGN_OUT:
            signOut();
            break;
         case EDIT_PROFILE:
            editProfile();
            break;
         case ADD_FRIEND:
            addFriend();
            break;
         case SEND_MESSAGE:
            sendMessage();
            break;
         default:
            signUp();
         }
      }

      @Override public String toString() {
         switch (this) {
         case SIGN_OUT:
            return "remover conta";
         case EDIT_PROFILE:
            return "editar perfil";
         case ADD_FRIEND:
            return "adicionar amigo";
         case SEND_MESSAGE:
            return "enviar mensagem";
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
      for (Action action : Action.values()) { actions.add(action); }

      while (true) {
         System.out.println("---\n 0 - sair");
         int a;
         for (a = 1; a <= actions.size(); a++) {
            System.out.printf("%2d - %s\n", a, actions.get(a - 1));
         }
         System.out.print("---\nEscolha uma ação: ");
         a = input.nextInt(); input.nextLine();

         if (a == 0) break;

         if (a == -1) debug();
         else if (a >= 1 && a <= actions.size()) {
            actions.get(a - 1).doAction();
         } else System.out.println("<Erro> Opção inválida.");
      }
   }

   private static void addFriend() {
      User user = signIn();
      if (user == null) return;

      HashMap<String, User> friendRequests = user.getFriendRequests();
      User friend;
      if (!friendRequests.isEmpty()) {
         System.out.println("Solicitações de amizade pendentes:");

         for (String requestLogin : friendRequests.keySet()) {
            friend = friendRequests.get(requestLogin);
            System.out.println("Usuário: " + friend.getName());
            System.out.print("Aceitar? (s/n): ");
            if (input.nextLine().equals("s")) {
               user.getFriends().put(requestLogin, friend);
               friend.getFriends().put(user.getLogin(), user);
            }
         }

         friendRequests.clear();
         return;
      }

      friend = getUser("Login do amigo: ");
      if (friend == null) return;
      friend.getFriendRequests().put(user.getLogin(), user);

      System.out.println(
            "Solicitação de amizade enviada para " + friend.getName() + "."
      );
   }

   private static void debug() {
      System.out.println("Usuários:\n---");
      for (String login : users.keySet()) {
         System.out.println(users.get(login));
         System.out.println("Senha: " + passwords.get(login) + "\n---");
      }
   }

   private static void editProfile() {
      User user = signIn();
      if (user == null) return;

      HashMap<String, String> profile = user.getProfile();
      while (true) {
         System.out.print("Atributo ('-' para encerrar): ");
         String attribute = input.nextLine();
         if (attribute.isEmpty() || attribute.equals("-")) break;

         System.out.print("Valor: ");
         profile.put(attribute, input.nextLine());
      }
   }

   private static User getUser(String prompt) {
      System.out.print(prompt);
      String login = input.nextLine();
      if (!users.containsKey(login)) {
         System.out.println("<Erro> Usuário não encontrado.");
         return null;
      }
      return users.get(login);
   }

   private static void sendMessage() {
      User from = signIn();
      if (from == null) return;

      User to = getUser("Login do destinatário: ");
      if (to == null) return;

      System.out.println("Conteúdo da mensagem ('.' para encerrar):");
      String content = "";
      while (true) {
         String line = input.nextLine();
         if (line.isEmpty() || line.equals(".")) break;
         content += line + "\n";
      }
      
      Message message = new Message(from, to);
      message.setContent(content);
      
      HashMap<String, ArrayList<Message>> sentMessages = from.getSentMessages();
      String toLogin = to.getLogin();
      ArrayList<Message> messages = sentMessages.get(toLogin);
      if (messages == null) {
         messages = new ArrayList<>();
         sentMessages.put(toLogin, messages);
         to.getReceivedMessages().put(from.getLogin(), messages);
      }
      messages.add(message);
   }

   private static User signIn() {
      User user = getUser("Login: ");
      if (user == null) return null;

      System.out.print("Senha: ");
      if (!passwords.get(user.getLogin()).equals(input.nextLine())) {
         System.out.println("<Erro> Senha incorreta.");
         return null;
      }

      return user;
   }

   private static void signOut() {
      User user = signIn();
      if (user == null) return;

      String login = user.getLogin();

      HashMap<String, User> friends = user.getFriends();
      for (String friendLogin : friends.keySet()) {
         User friend = friends.get(friendLogin);
         friend.getFriends().remove(login);
      }

      HashMap<String, ArrayList<Message>> messages = user.getSentMessages();
      for (String toLogin : messages.keySet()) {
         Message message = messages.get(toLogin).get(0);
         User to = message.getTo();
         to.getReceivedMessages().remove(login);
      }

      messages = user.getReceivedMessages();
      for (String fromLogin : messages.keySet()) {
         Message message = messages.get(fromLogin).get(0);
         User from = message.getFrom();
         from.getSentMessages().remove(login);
      }

      users.remove(login);

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