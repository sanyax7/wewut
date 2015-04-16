package wewut.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.function.Function;

public class MockitoExtensions {
  //@SuppressWarnings("unchecked")
  //public static <T> T create(Object methodCall) {
  //  when(methodCall).thenReturn(StubBuilder.current.returnValue);
  //  return (T) StubBuilder.current.mockInstance;
  //}
  //
  //public static <T> StubBuilder<T> stub(Class<T> klass) {
  //  return new StubBuilder<T>(mock(klass));
  //}

  public static <T> T stub(Class<T> klass, Function<T,Object> f, Object returnVal) {
    try {
      T result = mock(klass);
      when(f.apply(result)).thenReturn(returnVal);
      return result;
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static class StubBuilder<T> {
    public static StubBuilder current;
    public final T mockInstance;
    private Object returnValue;

    public StubBuilder(T mockInstance) {
      current = this;
      this.mockInstance = mockInstance;
    }

    public T from() {
      return mockInstance;
    }

    public StubBuilder<T> returning(Object returnValue) {
      this.returnValue = returnValue;
      return this;
    }
  }
}
