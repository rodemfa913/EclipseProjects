package iface;

import java.util.*;
import iface.model.*;

public class IFace {
   private enum Action {
      SIGN_UP, SIGN_OUT, EDIT_PROFILE, ADD_FRIEND, SEND_MESSAGE,
      ADD_COMMUNITY, ENTER_COMMUNITY, ADD_MEMBERS, VIEW_INFO;

      public void doAction() {
         switch (this) {
         case ADD_COMMUNITY:
            addCommunity(); break;
         case ADD_FRIEND:
            addFriend(); break;
         case ADD_MEMBERS:
            addMembers(); break;
         case EDIT_PROFILE:
            editProfile(); break;
         case ENTER_COMMUNITY:
            enterCommunity(); break;
         case SEND_MESSAGE:
            sendMessage(); break;
         case SIGN_OUT:
            signOut(); break;
         case VIEW_INFO:
            viewInfo(); break;
         default:
            signUp();
         }
      }

      @Override public String toString() {
         switch (this) {
         case ADD_COMMUNITY:
            return "criar comunidade";
         case ADD_FRIEND:
            return "adicionar amigo";
         case ADD_MEMBERS:
            return "adicionar membro";
         case EDIT_PROFILE:
            return "editar perfil";
         case ENTER_COMMUNITY:
            return "entrar em comunidade";
         case SEND_MESSAGE:
            return "enviar mensagem";
         case SIGN_OUT:
            return "remover conta";
         case VIEW_INFO:
            return "visualizar informações";
         default:
            return "criar conta";
         }
      }
   }

   private static HashMap<String, Community> communities;
   private static Scanner input;
   private static HashMap<String, String> passwords;
   private static HashMap<String, User> users;

   public static void main(String[] args) {
      communities = new HashMap<>();
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

   private static void addCommunity() {
      User owner = signIn();
      if (owner == null) return;

      System.out.print("Nome da comunidade: ");
      String name = input.nextLine();
      if (name.isEmpty()) name = "0";
      if (communities.containsKey(name)) {
         System.out.println("<Erro> Comunidade já existente.");
         return;
      }

      Community community = new Community(name, owner);
      owner.getOwnCommunities().put(name, community);
      community.getMembers().put(owner.getLogin(), owner);
      owner.getCommunities().put(name, community);

      System.out.print("Descrição: ");
      community.setDescription(input.nextLine());

      communities.put(name, community);
      System.out.println("Comunidade " + name + " criada.");
   }

   private static void addFriend() {
      User user = signIn();
      if (user == null) return;

      HashMap<String, User> friendRequests = user.getFriendRequests();
      User friend;
      if (!friendRequests.isEmpty()) {
         System.out.println("Solicitações de amizade pendentes:");
         for (String login : friendRequests.keySet()) {
            friend = friendRequests.get(login);
            String name = friend.getName();
            System.out.println("Usuário: " + name);
            System.out.print("Aceitar? (s/n): ");
            
            if (input.nextLine().equals("s")) {
               user.getFriends().put(login, friend);
               friend.getFriends().put(user.getLogin(), user);
               System.out.println("Amigo " + name + " adicionado.");
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
   
   private static void addMembers() {
      User owner = signIn();
      if (owner == null) return;

      HashMap<String, Community> communities = owner.getOwnCommunities();
      for (String communityName : communities.keySet()) {
         Community community = communities.get(communityName);
         HashMap<String, User> memberRequests = community.getMemberRequests();
         if (memberRequests.isEmpty()) continue;

         System.out.println(
               "Solicitações de participação pendentes para " +
               communityName + ":"
         );
         for (String login : memberRequests.keySet()) {
            User member = memberRequests.get(login);
            String memberName = member.getName();
            System.out.println("Membro: " + memberName);
            System.out.print("Aceitar? (s/n): ");
            if (input.nextLine().equals("s")) {
               community.getMembers().put(login, member);
               System.out.println("Membro " + memberName + " adicionado.");
            }
         }

         memberRequests.clear();
      }
   }

   private static void debug() {
      System.out.println("Usuários:\n---");
      for (String login : users.keySet()) {
         System.out.println(users.get(login));
         System.out.println("Senha: " + passwords.get(login) + "\n---");
      }

      System.out.println("Comunidades:\n---");
      for (String name : communities.keySet()) {
         System.out.println(communities.get(name));
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
         String value = input.nextLine();

         if (attribute.toLowerCase().equals("nome")) user.setName(value);
         else profile.put(attribute, value);
      }
   }
   
   private static void enterCommunity() {
      User member = signIn();
      if (member == null) return;

      Community community = getCommunity();
      community.getMemberRequests().put(member.getLogin(), member);

      System.out.println(
            "Solicitação de participação enviada para " + community.getName()
      );
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
   
   private static Community getCommunity() {
      System.out.print("Nome da comunidade: ");
      String name = input.nextLine();
      if (!communities.containsKey(name)) {
         System.out.println("<Erro> Comunidade não encontrada.");
         return null;
      }
      return communities.get(name);
   }

   private static void sendMessage() {
      User from = signIn();
      if (from == null) return;

      System.out.println("---\n0 - usuário\n1 - comunidade\n---");
      System.out.print("Enviar mensagem para: ");
      int t = input.nextInt(); input.nextLine();

      HashMap<String, User> toUsers;
      String fromLogin = from.getLogin(), toName;
      if (t == 1) {
         Community to = getCommunity();
         if (to == null) return;
         if (!to.getMembers().containsKey(fromLogin)) {
            System.out.println("<Erro> É necessário ser membro da comunidade.");
         }
         toUsers = to.getMembers();
         toName = to.getName();
      } else {
         User to = getUser("Login do destinatário: ");
         if (to == null) return;
         toUsers = new HashMap<>();
         toUsers.put(to.getLogin(), to);
         toName = to.getName();
      }

      System.out.println("Conteúdo da mensagem ('.' para encerrar):");
      String content = "";
      while (true) {
         String line = input.nextLine();
         if (line.isEmpty() || line.equals(".")) break;
         content += line + "\n";
      }

      for (String toLogin : toUsers.keySet()) {
         if (toLogin == fromLogin) continue;

         User to = toUsers.get(toLogin);
         Message message = new Message(from, to);
         message.setContent(content);

         HashMap<String, ArrayList<Message>> messageLists = from.getMessages();
         ArrayList<Message> messages = messageLists.get(toLogin);
         if (messages == null) {
            messages = new ArrayList<>();
            messageLists.put(toLogin, messages);
            to.getMessages().put(fromLogin, messages);
         }
         messages.add(message);
      }

      System.out.println("Mensagem enviada para " + toName + ".");
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

      HashMap<String, Community> communities = user.getOwnCommunities();
      for (String name : communities.keySet()) {
         Community community = communities.get(name);
         HashMap<String, User> members = community.getMembers();
         for (String memberLogin : members.keySet()) {
            User member = members.get(memberLogin);
            member.getCommunities().remove(name);
         }
      }

      communities = user.getCommunities();
      for (String name : communities.keySet()) {
         Community community = communities.get(name);
         community.getMembers().remove(login);
      }

      HashMap<String, User> friends = user.getFriends();
      for (String friendLogin : friends.keySet()) {
         User friend = friends.get(friendLogin);
         friend.getFriends().remove(login);
      }

      HashMap<String, ArrayList<Message>> messages = user.getMessages();
      for (String fromToLogin : messages.keySet()) {
         User fromTo = users.get(fromToLogin);
         fromTo.getMessages().remove(login);
      }

      users.remove(login);

      System.out.println("Conta de usuário " + user.getName() + " removida.");
   }

   private static void signUp() {
      System.out.print("Login: ");
      String login = input.nextLine();
      if (login.isEmpty()) login = "0";
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

   private static void viewInfo() {
      User user = signIn();
      if (user == null) return;

      System.out.println(
            "0 - perfil\n1 - comunidades\n2 - amigos\n3 - mensagens"
      );
      System.out.print("Informação: ");
      int info = input.nextInt(); input.nextLine();
      switch (info) {
      case 1:
         System.out.println("Comunidades:\n---");
         HashMap<String, Community> communities = user.getCommunities();
         for (String name : communities.keySet()) {
            Community community = communities.get(name);
            System.out.println(community + "\n---");
         }
         break;
      case 2:
         System.out.println("Amigos:\n---");
         HashMap<String, User> friends = user.getFriends();
         for (String friendLogin : friends.keySet()) {
            User friend = friends.get(friendLogin);
            System.out.println(friend + "\n---");
         }
         break;
      case 3:
         HashMap<String, ArrayList<Message>> messages = user.getMessages();
         for (String login : messages.keySet()) {
            User fromTo = users.get(login);
            System.out.println(
                  "Mensagens de/para " + fromTo.getName() + ":\n---"
            );
            for (Message message : messages.get(login)) {
               System.out.println(message + "\n---");
            }
         }
         break;
      default:
         user.printProfile();
      }
   }
}