package isoccer.model.staff.player;

import isoccer.model.staff.Member;

public abstract class Player extends Member {
   public boolean unable;

   protected Player(int id) {
      super(id);
   }
}