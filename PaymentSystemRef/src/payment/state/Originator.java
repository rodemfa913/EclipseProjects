package payment.state;

import java.util.HashMap;
import payment.model.employee.Employee;

public class Originator extends State {
   public Originator() {
      this.employees = new HashMap<>();
      this.members = new HashMap<>();
      this.services = new HashMap<>();
   }

   public HashMap<Integer, Employee> getEmployees() {
      return new HashMap<>(this.employees);
   }

   public HashMap<String, Employee> getMembers() {
      return new HashMap<>(this.members);
   }

   public HashMap<String, Double> getServices() {
      return new HashMap<>(this.services);
   }

   public void removeEmployee(Employee employee) {
      this.employees.remove(employee.getId());
      this.members.remove(employee.syndicateId);
   }

   public void removeService(String service) {
      this.services.remove(service);
   }

   public void restore(Memento memento) {
      this.employees = memento.employees;
      this.members = memento.members;
      this.services = memento.services;
   }

   public Memento save() {
      HashMap<Integer, Employee> bkpEmployees = new HashMap<>(this.employees);
      HashMap<String, Employee> bkpMembers = new HashMap<>(this.members);
      HashMap<String, Double> bkpServices = new HashMap<>(this.services);

      for (Employee employee : bkpEmployees.values())
         this.setEmployee(employee.clone());

      return new Memento(bkpEmployees, bkpMembers, bkpServices);
   }

   public void setEmployee(Employee employee) {
      this.employees.put(employee.getId(), employee);
      if (employee.syndicateId != null)
         this.members.put(employee.syndicateId, employee);
   }

   public void setService(String service, double fee) {
      if (fee < 0.0)
         fee = 0.0;
      this.services.put(service, fee);
      for (Employee member : this.members.values())
         if (member.getServices().containsKey(service))
            member.setService(service, fee);
   }
}