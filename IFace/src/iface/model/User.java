package iface.model;

import java.util.*;

public class User {
   private HashMap<String, Community> communities, ownCommunities;
   private HashMap<String, User> friendRequests, friends;
   private String login, name;
   private HashMap<String, ArrayList<Message>> messages;
   private HashMap<String, String> profile;

   public User(String login) {
      super();
      
      this.communities = new HashMap<>();
      this.friendRequests = new HashMap<>();
      this.friends = new HashMap<>();
      this.login = login;
      this.messages = new HashMap<>();
      this.ownCommunities = new HashMap<>();
      this.profile = new HashMap<>();
      this.setName(null);
   }

   public HashMap<String, Community> getCommunities() {
      return this.communities;
   }

   public HashMap<String, User> getFriendRequests() {
      return this.friendRequests;
   }

   public HashMap<String, User> getFriends() { return this.friends; }

   public String getLogin() { return this.login; }

   public String getName() { return this.name; }

   public void setName(String name) {
      if (name == null || name.isEmpty()) this.name = "nenhum";
      else this.name = name;
   }

   public HashMap<String, Community> getOwnCommunities() {
      return this.ownCommunities;
   }

   public HashMap<String, String> getProfile() { return this.profile; }

   public HashMap<String, ArrayList<Message>> getMessages() {
      return this.messages;
   }

   public String printProfile() {
      String p = "Nome: " + this.name;
      for (String attribute : this.profile.keySet()) {
         p += "\n" + attribute + ": " + profile.get(attribute);
      }
      return p;
   }

   @Override public String toString() {
      return "Login: " + this.login + "\n" + this.printProfile();
   }
}