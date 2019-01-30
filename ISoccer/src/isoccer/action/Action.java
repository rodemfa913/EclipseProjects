package isoccer.action;

import isoccer.model.staff.Member;

public abstract class Action {
   protected static final Exception notFoundException =
         new Exception("Não encontrado.");

   public abstract void doAction() throws Exception;

   protected void setMemberInfo(Member member) throws Exception {}
}