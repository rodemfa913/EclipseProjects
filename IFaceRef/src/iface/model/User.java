package iface.model;

import java.util.*;

public class User {
   private HashMap<String, Community> communities, ownCommunities;
   private HashMap<String, User> friendRequests, friends;
   private String login, name;
   private HashMap<String, ArrayList<Message>> messageLists;
   private HashMap<String, String> profile;

   public User(String login) {
      this.communities = new HashMap<>();
      this.friendRequests = new HashMap<>();
      this.friends = new HashMap<>();
      this.login = login;
      this.messageLists = new HashMap<>();
      this.ownCommunities = new HashMap<>();
      this.profile = new HashMap<>();
      this.setName(null);
   }

   public User acceptFriend(User friend, boolean accept) {
      String login = friend.getLogin();
      friend = this.friendRequests.remove(login);
      if (friend != null && accept)
         return this.friends.put(login, friend);
      return friend;
   }

   public ArrayList<Community> getCommunities() {
      return new ArrayList<>(this.communities.values());
   }

   public ArrayList<User> getFriendRequests() {
      return new ArrayList<>(this.friendRequests.values());
   }

   public ArrayList<User> getFriends() {
      return new ArrayList<>(this.friends.values());
   }

   public String getLogin() {
      return this.login;
   }

   public ArrayList<Message> getMessages() {
      ArrayList<Message> messages = new ArrayList<>();
      for (ArrayList<Message> messageList : this.messageLists.values())
         messages.addAll(messageList);
      return messages;
   }

   public ArrayList<Message> getMessages(User fromTo) {
      return this.messageLists.get(fromTo.getLogin());
   }

   public String getName() {
      return this.name;
   }

   public ArrayList<Community> getOwnCommunities() {
      return new ArrayList<>(this.ownCommunities.values());
   }

   public HashMap<String, String> getProfile() {
      return this.profile;
   }

   public String getProfileAsString() {
      String p = "Nome: " + this.name;
      for (Map.Entry<String, String> attribute : this.profile.entrySet())
         p += "\n" + attribute.getKey() + ": " + attribute.getValue();
      return p;
   }

   public Community removeCommunity(Community community) {
      String name = community.getName();
      this.ownCommunities.remove(name);
      return this.communities.remove(name);
   }

   public User removeFriend(User friend) {
      return this.friends.remove(friend.getLogin());
   }

   public ArrayList<Message> removeMessages(User fromTo) {
      return this.messageLists.remove(fromTo.getLogin());
   }

   public Community setCommunity(Community community) {
      String name = community.getName();
      if (community.getOwner().equals(this))
         this.ownCommunities.put(name, community);
      return this.communities.put(name, community);
   }

   public User setFriendRequest(User friend) {
      return this.friendRequests.put(friend.getLogin(), friend);
   }

   public ArrayList<Message> setMessages(
         User fromTo, ArrayList<Message> messages) {
      return this.messageLists.put(fromTo.getLogin(), messages);
   }

   public void setName(String name) {
      if (name == null || name.isEmpty())
         name = "nenhum";
      this.name = name;
   }

   @Override public String toString() {
      return "Login: " + this.login + "\n" + this.getProfileAsString();
   }
}