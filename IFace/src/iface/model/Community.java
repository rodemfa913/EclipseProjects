package iface.model;

import java.util.HashMap;

public class Community {
   private String description, name;
   private HashMap<String, User> members;
   private User owner;

   public Community(String name, User owner) {
      super();

      this.name = name;
      this.members = new HashMap<>();
      this.owner = owner;
   }

   public String getDescription() { return this.description; }

   public void setDescription(String description) {
      if (description == null || description.isEmpty()) {
         this.description = "nenhuma";
      } else this.description = description;
   }

   public HashMap<String, User> getMembers() { return this.members; }

   public String getName() { return this.name; }

   public User getOwner() { return this.owner; }
}