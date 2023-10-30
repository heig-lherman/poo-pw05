import operation.AddOperation;
import operation.MultiplyOperation;
import operation.SubtractOperation;

import java.util.Objects;

/**
 * Main test program
 */
public class Main {

  public static void main(String[] args) {
    if (args.length < 5) {
      throw new IllegalArgumentException("Not enough arguments");
    }

    var n1 = Integer.parseInt(args[0]);
    var m1 = Integer.parseInt(args[1]);
    var n2 = Integer.parseInt(args[2]);
    var m2 = Integer.parseInt(args[3]);
    var module = Integer.parseInt(args[4]);

    var mat1 = new Matrix(n1, m1, module);
    var mat2 = new Matrix(n2, m2, module);

    System.out.println("The modulus is " + module);
    System.out.println("\none\n" + mat1);
    System.out.println("\ntwo\n" + mat2);

    System.out.println("\none + two\n" + Matrix.applyOperation(
        mat1, new AddOperation(), mat2));
    System.out.println("\none - two\n" + Matrix.applyOperation(
        mat1, new SubtractOperation(), mat2));
    System.out.println("\none * two\n" + Matrix.applyOperation(
        mat1, new MultiplyOperation(), mat2));
  }
}
