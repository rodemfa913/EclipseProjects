package manage.model.production;

import java.util.*;
import manage.model.collaborator.*;

public class Orientation extends Production {
   private HashMap<String, Student> students;
   public Teacher teacher;

   public Orientation() {
      super();
      this.students = new HashMap<>();
   }

   public ArrayList<Student> getStudents() {
      return new ArrayList<>(this.students.values());
   }

   @Override
   public String getType() {
      return "orientação";
   }

   public Student setStudent(Student student) {
      return this.students.put(student.getName(), student);
   }

   @Override
   public String toString() {
      String o = super.toString() + "\nProfessor: " +
            this.teacher.getName() + "\nAlunos:";
      for (String name : this.students.keySet())
         o += "\n  " + name;
      return o;
   }
}