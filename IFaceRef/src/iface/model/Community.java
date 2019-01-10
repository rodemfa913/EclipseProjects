package iface.model;

import java.util.*;

public class Community {
   private String description, name;
   private HashMap<String, User> memberRequests, members;
   private User owner;

   public Community(String name, User owner) {
      this.name = name;
      this.memberRequests = new HashMap<>();
      this.members = new HashMap<>();
      this.members.put(owner.getLogin(), owner);
      this.owner = owner;
   }

   public User acceptMember(User member, boolean accept) {
      String login = member.getLogin();
      member = this.memberRequests.remove(login);
      if (member != null && accept)
         return this.members.put(login, member);
      return member;
   }

   public String getDescription() {
      return this.description;
   }

   public ArrayList<User> getMemberRequests() {
      return new ArrayList<>(this.memberRequests.values());
   }

   public ArrayList<User> getMembers() {
      return new ArrayList<>(this.members.values());
   }

   public String getName() {
      return this.name;
   }

   public User getOwner() {
      return this.owner;
   }

   public boolean hasMember(User member) {
      return this.members.containsKey(member.getLogin());
   }

   public User removeMember(User member) {
      return this.members.remove(member.getLogin());
   }

   public User setMemberRequest(User member) {
      return this.memberRequests.put(member.getLogin(), member);
   }

   public void setDescription(String description) {
      if (description == null || description.isEmpty())
         description = "nenhuma";
      this.description = description;
   }

   @Override public String toString() {
      return "Nome: " + this.name + "\nDescrição: " + this.description +
            "\nDono: " + this.owner.getName();
   }
}