package manage.model.collaborator;

public abstract class Student extends Collaborator {
   public Student() {}

   public Student(String name) {
      super(name);
   }

   @Override
   public String getType() {
      return "aluno de ";
   }
}