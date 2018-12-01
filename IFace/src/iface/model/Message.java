package iface.model;

public class Message {
   private String content;
   private User from, to;

   public Message(User from, User to) {
      super();

      this.setContent(null);
      this.from = from;
      this.to = to;
   }

   public String getContent() { return this.content; }

   public void setContent(String content) {
      if (content == null) this.content = "vazio";
      else this.content = content;
   }

   public User getFrom() { return this.from; }

   public User getTo() { return this.to; }
   
   @Override public String toString() {
      return "De: " + this.from.getName() + "\nPara: " +
            this.to.getName() + "\n" + this.content;
   }
}