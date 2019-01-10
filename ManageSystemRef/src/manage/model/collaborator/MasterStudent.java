package manage.model.collaborator;

public class MasterStudent extends Student {
   public MasterStudent() {}

   public MasterStudent(String name) {
      super(name);
   }

   @Override
   public MasterStudent create(String name) {
      return new MasterStudent(name);
   }

   @Override
   public String getType() {
      return super.getType() + "mestrado";
   }
}