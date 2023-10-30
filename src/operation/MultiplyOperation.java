package operation;

/**
 * Defines a multiplication operation that can be applied against two integers.
 */
public final class MultiplyOperation extends Operation {

  @Override
  public int apply(int a, int b) {
    return a * b;
  }
}
