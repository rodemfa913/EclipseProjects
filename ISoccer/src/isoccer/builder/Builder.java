package isoccer.builder;

public interface Builder<T> {
   public T build();
   public String getType();
   public T put(T t);
   public void setInfo(T t) throws Exception;
}