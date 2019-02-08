package isoccer.builder;

public interface Builder<T> {
   public T build() throws Exception;
   public String getType();
}