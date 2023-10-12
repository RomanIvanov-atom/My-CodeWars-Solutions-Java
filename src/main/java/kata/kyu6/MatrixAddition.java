package kata.kyu6;

public class MatrixAddition {
    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int x = a.length;
        int y = a[0].length;
        int[][] result = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }
}
