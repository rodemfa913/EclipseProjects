package isoccer.builder;

public abstract class Builder<T> {
   public abstract T build() throws Exception;
   public abstract String getType();
}