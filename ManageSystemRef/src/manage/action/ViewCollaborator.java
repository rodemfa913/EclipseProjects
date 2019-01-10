package manage.action;

public class ViewCollaborator extends Action {
   @Override
   public void doAction() throws Exception {
      System.out.println(this.getCollaborator("Nome do colaborador"));
   }

   @Override
   public String toString() {
      return "consultar colaborador";
   }
}