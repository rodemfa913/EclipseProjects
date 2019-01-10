package manage.model.collaborator;

public class Researcher extends Collaborator {
   public Researcher() {}

   public Researcher(String name) {
      super(name);
   }

   @Override
   public Researcher create(String name) {
      return new Researcher(name);
   }

   @Override
   public String getType() {
      return "pesquisador";
   }
}