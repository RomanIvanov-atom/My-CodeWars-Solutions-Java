package kata.kyu5;

public class TicTacToeChecker {
    public static boolean areEquals(int[] arr) {
        //return Stream.of(arr).distinct().count() == 1;

        // была эта ошибка, которую заметил через часа 4 !
        // в поток брался массив как одно целое, так что тут всегда true

        // это верный вариант, но ката не пропускает
        //return Arrays.stream(arr).distinct().count() == 1;

        int firstElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != firstElement) {
                return false;
            }
        }

        return true;

    }

    public static int isSolved(int[][] board) {

        int[] line1 = new int[3];
        int[] line2 = new int[3];
        int[] line3 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] diag1 = {board[0][0], board[1][1], board[2][2]};
        int[] diag2 = {board[0][2], board[1][1], board[2][0]};

        int winner;

        System.arraycopy(board[0], 0, line1, 0, 3);
        System.arraycopy(board[1], 0, line2, 0, 3);
        System.arraycopy(board[2], 0, line3, 0, 3);

        for (int i = 0; i < 3; i++) {
            col1[i] = board[i][0];
        }
        for (int i = 0; i < 3; i++) {
            col2[i] = board[i][1];
        }
        for (int i = 0; i < 3; i++) {
            col3[i] = board[i][2];
        }


        if ((areEquals(line1) | areEquals(col1) | areEquals(diag1)) & board[0][0] != 0) {
            winner = board[0][0];
            return winner;
        } else if ((areEquals(col3) | areEquals(line2)) & board[1][2] != 0) {
            winner = board[1][2];
            return winner;
        } else if ((areEquals(col2) | areEquals(line3)) & board[2][1] != 0) {
            winner = board[2][1];
            return winner;
        } else if (areEquals(diag2) & board[1][1] != 0) {
            winner = board[1][1];
            return winner;
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return -1;
                }
            }
        }

        return 0;
    }
}
