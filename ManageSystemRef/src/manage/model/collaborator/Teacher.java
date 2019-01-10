package manage.model.collaborator;

import java.util.ArrayList;
import manage.model.production.*;

public class Teacher extends Collaborator {
   private ArrayList<Orientation> orientations;

   public Teacher() {
      this(null);
   }

   public Teacher(String name) {
      super(name);
      this.orientations = new ArrayList<>();
   }

   @Override
   public Teacher create(String name) {
      return new Teacher(name);
   }

   public ArrayList<Orientation> getOrientations() {
      return this.orientations;
   }

   @Override
   public ArrayList<Production> getProductions() {
      ArrayList<Production> production = super.getProductions();
      production.addAll(this.orientations);
      return production;
   }

   @Override
   public String getType() {
      return "professor";
   }
}