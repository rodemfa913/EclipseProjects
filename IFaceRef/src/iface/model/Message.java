package iface.model;

public class Message {
   private String content;
   private User from, to;

   public Message(User from, User to) {
      this.setContent(null);
      this.from = from;
      this.to = to;
   }

   public String getContent() {
      return this.content;
   }

   public User getFrom() {
      return this.from;
   }

   public User getTo() {
      return this.to;
   }

   public void setContent(String content) {
      if (content == null)
         content = "vazio";
      this.content = content;
   }

   @Override public String toString() {
      return "De: " + this.from.getName() + "\nPara: " +
            this.to.getName() + "\n" + this.content;
   }
}