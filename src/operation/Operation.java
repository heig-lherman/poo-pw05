package operation;

/**
 * Defines an abstract operation that can be applied against two integers.
 */
public abstract class Operation {

  /**
   * Applies the operation against two integers.
   * 
   * @param a the first integer
   * @param b the second integer
   * @return the result of the operation
   */
  public abstract int apply(int a, int b);
}
