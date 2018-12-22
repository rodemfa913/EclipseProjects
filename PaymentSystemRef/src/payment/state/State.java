package payment.state;

import java.util.*;
import payment.model.employee.Employee;

abstract class State {
   protected HashMap<Integer, Employee> employees;
   protected HashMap<String, Employee> members;
   protected HashMap<String, Double> services;

   @Override public String toString() {
      String o = "Empregados:";
      for (Employee employee : this.employees.values())
         o += "\n---\n" + employee;

      o += "\n---\nMembros:";
      for (Employee member : this.members.values())
         o += "\n  " + member.memberInfo();

      o += "\n---\nServiços:";
      for (Map.Entry<String, Double> service : this.services.entrySet())
         o += "\n  " + service.getKey() + ": " + service.getValue();

      return o;
   }
}