package iface.model;

import java.util.HashMap;

public class Community {
   private String description, name;
   private HashMap<String, User> memberRequests, members;
   private User owner;

   public Community(String name, User owner) {
      super();

      this.name = name;
      this.memberRequests = new HashMap<>();
      this.members = new HashMap<>();
      this.owner = owner;
   }

   public String getDescription() { return this.description; }

   public void setDescription(String description) {
      if (description == null || description.isEmpty()) {
         this.description = "nenhuma";
      } else this.description = description;
   }

   public HashMap<String, User> getMemberRequests() {
      return this.memberRequests;
   }

   public HashMap<String, User> getMembers() { return this.members; }

   public String getName() { return this.name; }

   public User getOwner() { return this.owner; }

   @Override public String toString() {
      return "Nome: " + this.name + "\nDescrição: " + this.description +
            "\nDono: " + this.owner.getName();
   }
}