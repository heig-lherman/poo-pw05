package operation;

/**
 * Defines an addition operation that can be applied against two integers.
 */
public final class AddOperation extends Operation {

  @Override
  public int apply(int a, int b) {
    return a + b;
  }
}
