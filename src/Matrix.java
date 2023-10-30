import operation.Operation;

/**
 * Matrix implementation.
 * Arithmetic operations are applied in congruence to the modulo.
 */
public final class Matrix {

  private final int[][] matrix;
  private final int rows;
  private final int columns;
  private final int modulo;

  /**
   * Constructor that allows to generate a matrix using random values
   *
   * @param rows    number of rows
   * @param columns number of columns
   * @param modulo  the modulo to apply
   * @throws IllegalArgumentException if the number of rows or columns is
   *                                  negative, also
   *                                  if the modulo is negative or null
   */
  public Matrix(int rows, int columns, int modulo) {
    if (rows < 0 || columns < 0 || modulo <= 0) {
      throw new IllegalArgumentException();
    }

    this.matrix = new int[rows][columns];
    this.rows = rows;
    this.columns = columns;
    this.modulo = modulo;

    for (int i = 0; i < rows; ++i) {
      for (int j = 0; j < columns; ++j) {
        matrix[i][j] = (int) (Math.random() * modulo);
      }
    }
  }

  /**
   * Constructor that allows to generate a matrix using a given array
   *
   * @param matrix the array to use
   * @param modulo the modulo to apply
   * @throws IllegalArgumentException if the array is empty or if the modulo is
   *                                  negative
   */
  public Matrix(int[][] matrix, int modulo) {
    if (modulo <= 0) {
      throw new IllegalArgumentException("Modulo must be positive");
    }

    this.matrix = new int[matrix.length][];
    this.modulo = modulo;
    rows = matrix.length;
    columns = (0 < matrix.length && null != matrix[0]) ? matrix[0].length : 0;

    for (int i = 0; i < rows; ++i) {
      if (null == matrix[i]) {
        throw new IllegalArgumentException("Row " + i + " is null");
      }

      if (columns != matrix[i].length) {
        throw new IllegalArgumentException(
            "Row " + i + " has " + matrix[i].length + " columns"
                + ", but expected " + columns);
      }

      this.matrix[i] = new int[columns];
      for (int j = 0; j < columns; ++j) {
        if (matrix[i][j] < 0 || matrix[i][j] >= modulo) {
          throw new IllegalArgumentException(
              "Element (" + i + ", " + j + ") is " + matrix[i][j]
                  + ", but expected in range [0, " + modulo + ")");
        }

        this.matrix[i][j] = matrix[i][j];
      }
    }
  }

  /**
   * Apply an operation on two given matrices and return the result as a new
   * matrix.
   * Operations are applied in congruence to the modulo component-by-component,
   * with
   * zero being the default value.
   *
   * @param a         first matrix
   * @param operation the operation to apply
   * @param b         second matrix
   * @return the result of the operation
   * @throws IllegalArgumentException if the matrices have a different modulo
   */
  public static Matrix applyOperation(Matrix a, Operation operation, Matrix b) {
    if (a.modulo != b.modulo) {
      throw new IllegalArgumentException("Matrices must have the same modulo");
    }

    var resultRows = Math.max(a.rows, b.rows);
    var resultColumns = Math.max(a.columns, b.columns);
    var resultModulo = a.modulo;
    int[][] result = new int[resultRows][resultColumns];

    for (int i = 0; i < result.length; ++i) {
      for (int j = 0; j < result[i].length; ++j) {
        var aVal = (i < a.rows && j < a.columns) ? a.matrix[i][j] : 0;
        var bVal = (i < b.rows && j < b.columns) ? b.matrix[i][j] : 0;
        result[i][j] = Math.floorMod(operation.apply(aVal, bVal), resultModulo);
      }
    }

    return new Matrix(result, resultModulo);
  }

  /**
   * Format the matrix as a string, each row on a new line.
   *
   * @return the formatted string
   */
  @Override
  public String toString() {
    if (rows == 0 && columns == 0) {
      return "[]";
    }

    var res = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      if (i > 0) {
        res.append('\n');
      }

      for (int j = 0; j < columns; j++) {
        res.append(matrix[i][j]);
      }
    }
    return res.toString();
  }
}
