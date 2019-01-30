package isoccer.action.builder;

public interface Builder<T> {
   public T build();
   public String getType();
}