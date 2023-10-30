import operation.AddOperation;
import operation.MultiplyOperation;
import operation.SubtractOperation;

import java.util.Objects;

/**
 * Main test program with specific test cases
 */
public class TestingMain {

  public static void main(String[] args) {
    matrixTesting();
  }

  /**
   * Call every tests
   */
  static void matrixTesting() {
    // Test the matrix creation with invalid arguments
    testMatrixWithNegativeRow();
    testMatrixWithNegativeColumn();
    testMatrixWithNegativeModulo();
    testMatrixWithNullModulo();
    testMatrixWithInvalidValues();
    testMatrixWithNullValues();
    testMatrixWithDifferentRowLength();

    // Test the matrix creation with specific matrix AND toString method
    testDefinedMatrix();
    testRandomMatrix();
    testEmptyMatrix();

    // Test matrix operations
    testAddition();
    testSubtraction();
    testMultiplication();
    testOperationWithDifferentSize();
    testOperationWithDifferentModulo();
  }

  static void testMatrixWithNegativeRow() {
    System.out.println("\nTEST : Create a random Matrix with negative row.");
    try {
      Matrix m = new Matrix(-3, 5, 5);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }
  }

  static void testMatrixWithNegativeColumn() {
    System.out.println("\nTEST : Create a random Matrix with negative column.");
    try {
      Matrix m = new Matrix(2, -1, 5);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }
  }

  static void testMatrixWithNegativeModulo() {
    System.out.println("\nTEST : Create a random Matrix with negative modulo.");
    try {
      Matrix m = new Matrix(2, 3, -1);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }

    System.out.println("\nTEST : Create a Matrix with negative modulo.");
    try {
      int[][] values = { { 1, 0 }, { 0, 1 } };
      Matrix m = new Matrix(values, -1);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }
  }

  static void testMatrixWithNullModulo() {
    System.out.println("\nTEST : Create a random Matrix with negative modulo.");
    try {
      Matrix m = new Matrix(2, 3, 0);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }

    System.out.println("\nTEST : Create a Matrix with negative modulo.");
    try {
      int[][] values = { { 1, 0 }, { 0, 1 } };
      Matrix m = new Matrix(values, 0);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }
  }

  static void testMatrixWithInvalidValues() {
    System.out.println("\nTEST : Create a Matrix with values bigger than the modulo.");
    try {
      int[][] values = { { 1, 0 }, { 4, 10 } };
      Matrix m = new Matrix(values, 5);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }

    System.out.println("\nTEST : Create a Matrix with values equal to the modulo.");
    try {
      int[][] values = { { 1, 0 }, { 4, 5 } };
      Matrix m = new Matrix(values, 5);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }

    System.out.println("\nTEST : Create a Matrix with negative values.");
    try {
      int[][] values = { { 1, 0 }, { -4, 1 } };
      Matrix m = new Matrix(values, 5);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }
  }

  static void testMatrixWithDifferentRowLength() {
    System.out.println("\nTEST : Create a Matrix with values with different row length.");
    try {
      int[][] values = { { 1, 4 }, { 1, 4, 3 }, { 1, 2 } };
      Matrix m = new Matrix(values, 5);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }
  }

  static void testMatrixWithNullValues() {
    System.out.println("\nTEST : Create a Matrix with null values.");
    try {
      Matrix m = new Matrix(null, 5);
      System.out.println("Failed : Matrix creation should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }
  }

  static void testDefinedMatrix() {
    System.out.println("\nTEST : Creation of a defined Matrix.");

    try {
      int[][] values = { { 1, 3, 1, 1 }, { 3, 2, 4, 2 }, { 1, 0, 1, 0 } };
      Matrix m = new Matrix(values, 5);

      if (Objects.equals(m.toString(), "1311\n3242\n1010")) {
        System.out.println("Passed.");
      } else {
        System.out.println("Failed : Matrix 'toString' method return the wrong values.");
      }
    } catch (RuntimeException e) {
      System.out.println("Failed : Correctly defined Matrix shouldn't throw an exception.");
    }
  }

  static void testRandomMatrix() {
    System.out.println("\nTEST : Creation of a random Matrix.");

    try {
      Matrix m = new Matrix(3, 4, 5);
      System.out.println("Passed.");
    } catch (RuntimeException e) {
      System.out.println("Failed : Empty Matrix shouldn't throw an exception.");
    }
  }

  static void testEmptyMatrix() {
    System.out.println("\nTEST : Creation of an empty random Matrix.");
    try {
      Matrix m = new Matrix(0, 0, 5);
      if (Objects.equals(m.toString(), "[]")) {
        System.out.println("Passed.");
      } else {
        System.out.println(
            "Failed : Empty Matrix 'toString' method "
                + "should return an empty String.");
      }
    } catch (RuntimeException e) {
      System.out.println("Failed : Empty Matrix shouldn't throw an exception.");
    }

    System.out.println("\nTEST : Creation of an empty Matrix.");
    try {
      int[][] values = {};
      Matrix m = new Matrix(values, 5);
      if (Objects.equals(m.toString(), "[]")) {
        System.out.println("Passed.");
      } else {
        System.out.println(
            "Failed : Empty Matrix 'toString' method "
                + "should return an empty String.");
      }
    } catch (RuntimeException e) {
      System.out.println("Failed : Empty Matrix shouldn't throw an exception.");
    }
  }

  static void testAddition() {
    System.out.println("\nTEST : Addition.");
    int[][] val1 = { { 1, 3, 1, 1 }, { 3, 2, 4, 2 }, { 1, 0, 1, 0 } };
    int[][] val2 = { { 1, 4, 2, 3 }, { 0, 1, 0, 4 }, { 0, 0, 2, 0 } };
    Matrix m1 = new Matrix(val1, 5);
    Matrix m2 = new Matrix(val2, 5);
    try {
      Matrix add = Matrix.applyOperation(m1, new AddOperation(), m2);
      if (Objects.equals(add.toString(), "2234\n3341\n1030")) {
        System.out.println("Passed.");
      } else {
        System.out.println("Failed : Wrong result of the addition.");
      }
    } catch (RuntimeException e) {
      System.out.println(
          "Failed : Operation with same modulo "
              + "shouldn't throw an exception.");
    }
  }

  static void testSubtraction() {
    System.out.println("\nTEST : Subtraction.");
    int[][] val1 = { { 1, 3, 1, 1 }, { 3, 2, 4, 2 }, { 1, 0, 1, 0 } };
    int[][] val2 = { { 1, 4, 2, 3 }, { 0, 1, 0, 4 }, { 0, 0, 2, 0 } };
    Matrix m1 = new Matrix(val1, 5);
    Matrix m2 = new Matrix(val2, 5);
    try {
      Matrix sub = Matrix.applyOperation(m1, new SubtractOperation(), m2);
      if (Objects.equals(sub.toString(), "0443\n3143\n1040")) {
        System.out.println("Passed.");
      } else {
        System.out.println("Failed : Wrong result of the subtraction.");
      }
    } catch (RuntimeException e) {
      System.out.println(
          "Failed : Operation with same modulo "
              + "shouldn't throw an exception.");
    }
  }

  static void testMultiplication() {
    System.out.println("\nTEST : Multiplication.");
    int[][] val1 = { { 1, 3, 1, 1 }, { 3, 2, 4, 2 }, { 1, 0, 1, 0 } };
    int[][] val2 = { { 1, 4, 2, 3 }, { 0, 1, 0, 4 }, { 0, 0, 2, 0 } };
    Matrix m1 = new Matrix(val1, 5);
    Matrix m2 = new Matrix(val2, 5);
    try {
      Matrix multiply = Matrix.applyOperation(m1, new MultiplyOperation(), m2);
      if (Objects.equals(multiply.toString(), "1223\n0203\n0020")) {
        System.out.println("Passed.");
      } else {
        System.out.println("Failed : Wrong result of the multiplication.");
      }
    } catch (RuntimeException e) {
      System.out.println(
          "Failed : Operation with same modulo "
              + "shouldn't throw an exception.");
    }
  }

  static void testOperationWithDifferentSize() {
    int[][] values = { { 1, 3, 1, 1 }, { 3, 2, 4, 2 }, { 1, 0, 1, 0 } };
    Matrix m1 = new Matrix(values, 5);
    Matrix m2 = new Matrix(0, 0, 5);

    System.out.println("\nTEST : Addition with an empty Matrix.");
    try {
      Matrix add = Matrix.applyOperation(m1, new AddOperation(), m2);

      if (Objects.equals(add.toString(), "1311\n3242\n1010")) {
        System.out.println("Passed.");
      } else {
        System.out.println("Failed : Wrong values in the resulting Matrix.");
      }
    } catch (RuntimeException e) {
      System.out.println("Failed : Adding an empty Matrix shouldn't throw an exception.");
    }

    System.out.println("\nTEST : Subtract an empty Matrix.");
    try {
      Matrix sub = Matrix.applyOperation(m1, new SubtractOperation(), m2);

      if (Objects.equals(sub.toString(), "1311\n3242\n1010")) {
        System.out.println("Passed.");
      } else {
        System.out.println("Failed : Wrong values in the resulting Matrix.");
      }
    } catch (RuntimeException e) {
      System.out.println(
          "Failed : Subtracting an empty Matrix "
              + "shouldn't throw an exception.");
    }

    System.out.println("\nTEST : Subtract from an empty Matrix.");
    try {
      Matrix sub = Matrix.applyOperation(m2, new SubtractOperation(), m1);

      if (Objects.equals(sub.toString(), "4244\n2313\n4040")) {
        System.out.println("Passed.");
      } else {
        System.out.println("Failed : Wrong values in the resulting Matrix.");
        System.out.println(sub.toString());
      }
    } catch (RuntimeException e) {
      System.out.println(
          "Failed : Subtracting from an empty Matrix "
              + "shouldn't throw an exception.");
    }

    System.out.println("\nTEST : Multiplication with an empty Matrix.");
    try {
      Matrix multiply = Matrix.applyOperation(m1, new MultiplyOperation(), m2);

      if (Objects.equals(multiply.toString(), "0000\n0000\n0000")) {
        System.out.println("Passed.");
      } else {
        System.out.println("Failed : Resulting matrix should contain only 0.");
      }
    } catch (RuntimeException e) {
      System.out.println(
          "Failed : Multiplying with an empty Matrix "
              + "shouldn't throw an exception.");
    }
  }

  static void testOperationWithDifferentModulo() {
    int[][] val1 = { { 1, 3, 1, 1 }, { 3, 2, 3, 2 }, { 1, 0, 1, 0 } };
    int[][] val2 = { { 1, 4, 2, 3 }, { 0, 1, 0, 4 }, { 0, 0, 2, 0 } };
    Matrix m1 = new Matrix(val1, 4);
    Matrix m2 = new Matrix(val2, 5);

    System.out.println("\nTEST : Addition with matrix of same size but different modulo.");
    try {
      Matrix add = Matrix.applyOperation(m1, new AddOperation(), m2);
      System.out.println(
          "Failed : Operation with different modulo "
              + "should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }

    System.out.println("\nTEST : Subtract with matrix of same size but different modulo.");
    try {
      Matrix sub = Matrix.applyOperation(m1, new SubtractOperation(), m2);
      System.out.println(
          "Failed : Operation with different modulo "
              + "should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }

    System.out.println("\nTEST : Multiply with matrix of same size but different modulo.");
    try {
      Matrix multiply = Matrix.applyOperation(m1, new MultiplyOperation(), m2);
      System.out.println(
          "Failed : Operation with different modulo "
              + "should throw an exception.");
    } catch (RuntimeException e) {
      System.out.println("Passed.");
    }
  }
}
