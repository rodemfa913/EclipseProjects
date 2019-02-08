package isoccer.manager;

public abstract class Manager<T> {
   public abstract T build() throws Exception;
   public abstract String getType();
   protected abstract T put(T t);
   protected abstract void setInfo(T t) throws Exception;
}