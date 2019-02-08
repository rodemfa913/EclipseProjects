package isoccer.action;

public abstract class Action {
   protected static final Exception notFoundException =
         new Exception("Não encontrado.");

   public abstract void doAction() throws Exception;
}