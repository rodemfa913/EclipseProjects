package payment.state;

import java.util.HashMap;
import payment.model.employee.Employee;

public class Memento extends State {
   public Memento(HashMap<Integer, Employee> employees,
         HashMap<String, Employee> members, HashMap<String, Double> services) {
      this.employees = employees;
      this.members = members;
      this.services = services;
   }
}