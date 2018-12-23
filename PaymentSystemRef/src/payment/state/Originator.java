package payment.state;

import java.util.*;
import payment.model.employee.Employee;

public class Originator extends State {
   public Originator() {
      this.employees = new HashMap<>();
      this.members = new HashMap<>();
      this.services = new HashMap<>();
   }

   public Employee getEmployee(int id) {
      return this.employees.get(id);
   }

   public Collection<Employee> getEmployees() {
      return this.employees.values();
   }

   public Employee getMember(String id) {
      return this.members.get(id);
   }

   public Collection<Employee> getMembers() {
      return this.members.values();
   }

   public HashMap<String, Double> getServices() {
      return new HashMap<>(this.services);
   }

   public boolean hasEmployee(int id) {
      return this.employees.containsKey(id);
   }

   public boolean hasMember(String id) {
      return this.members.containsKey(id);
   }

   public Employee removeEmployee(Employee employee) {
      this.members.remove(employee.syndicateId);
      return this.employees.remove(employee.getId());
   }

   public double removeService(String service) {
      for (Employee member : this.getMembers())
         member.getServices().remove(service);
      return this.services.remove(service);
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

   public Employee setEmployee(Employee employee) {
      if (employee.syndicateId != null)
         this.members.put(employee.syndicateId, employee);
      return this.employees.put(employee.getId(), employee);
   }

   public double setService(String service, double fee) {
      if (fee < 0.0)
         fee = 0.0;
      for (Employee member : this.getMembers())
         if (member.getServices().containsKey(service))
            member.setService(service, fee);
      return this.services.put(service, fee);
   }
}