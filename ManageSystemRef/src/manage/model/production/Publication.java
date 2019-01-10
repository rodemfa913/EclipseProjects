package manage.model.production;

import java.util.*;
import manage.model.collaborator.Collaborator;
import manage.model.Project;

public class Publication extends Production {
   private HashMap<String, Collaborator> authors;
   public String conference, title;
   public Project project;
   private int year;

   public Publication(int year) {
      super();
      this.authors = new HashMap<>();
      this.year = year;
   }
   
   @Override
   public int compareTo(Production other) {
      if (other instanceof Publication) {
         Publication another = (Publication) other;
         if (this.year != another.year)
            return another.year - this.year;
      }
      return super.compareTo(other);
   }

   public ArrayList<Collaborator> getAuthors() {
      return new ArrayList<>(this.authors.values());
   }

   @Override
   public String getType() {
      return "publicação";
   }

   public int getYear() {
      return this.year;
   }

   public Collaborator setAuthor(Collaborator author) {
      return this.authors.put(author.getName(), author);
   }

   @Override
   public String toString() {
      String p = super.toString() + "\nData (ano): " +
            this.year + "\nTítulo: " + this.title + "\nAutores:";
      for (String name : this.authors.keySet())
         p += "\n  " + name;
      return p;
   }
}