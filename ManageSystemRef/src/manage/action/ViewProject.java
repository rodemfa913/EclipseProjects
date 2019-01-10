package manage.action;

public class ViewProject extends Action {
   @Override
   public void doAction() throws Exception {
      System.out.println(this.getProject(null));
   }

   @Override
   public String toString() {
      return "consultar projeto";
   }
}