package iface.model;

import java.util.*;

public class User {
   private HashMap<String, User> friendRequests, friends;
   private String login;
   private String name;
   private HashMap<String, String> profile;
   private HashMap<String, ArrayList<Message>> receivedMessages, sentMessages;

   public User(String login) {
      super();
      
      this.friendRequests = new HashMap<>();
      this.friends = new HashMap<>();
      this.login = login;
      this.profile = new HashMap<>();
      this.receivedMessages = new HashMap<>();
      this.sentMessages = new HashMap<>();
      this.setName(null);
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

   public HashMap<String, String> getProfile() { return this.profile; }

   public HashMap<String, ArrayList<Message>> getReceivedMessages() {
      return this.receivedMessages;
   }

   public HashMap<String, ArrayList<Message>> getSentMessages() {
      return this.sentMessages;
   }

   @Override public String toString() {
      String s = "Login: " + this.login + "\nNome: " + this.name;
      for (String attribute : profile.keySet()) {
         s += "\n" + attribute + ": " + profile.get(attribute);
      }
      return s;
   }
}