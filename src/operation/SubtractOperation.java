package operation;

/**
 * Defines a subtraction operation that can be applied against two integers.
 */
public final class SubtractOperation extends Operation {

  @Override
  public int apply(int a, int b) {
    return a - b;
  }
}
