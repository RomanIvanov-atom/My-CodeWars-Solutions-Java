package kata.kyu5;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class TicTacToeCheckerTest {

    @Test
    public void notFinished() {
        assertEquals("[0, 0, 1]\n[0, 1, 2]\n[2, 1, 0]", -1, TicTacToeChecker.isSolved(new int[][]{
                {0, 0, 1},
                {0, 1, 2},
                {2, 1, 0}
        }));
    }

    @Test
    public void winnerX() {
        assertEquals("[1, 1, 1]\n[0, 2, 2]\n[0, 0, 0]", 1, TicTacToeChecker.isSolved(new int[][]{
                {1, 1, 1},
                {0, 2, 2},
                {0, 0, 0}
        }));
    }

    @Test
    public void winnerO() {
        assertEquals("[1, 1, 2]\n[0, 2, 0]\n[2, 1, 1]", 2, TicTacToeChecker.isSolved(new int[][]{
                {1, 1, 2},
                {0, 2, 0},
                {2, 1, 1}
        }));
    }

    @Test
    public void draw() {
        assertEquals("[1, 2, 1]\n[1, 1, 2]\n[2, 1, 2]", 0, TicTacToeChecker.isSolved(new int[][]{
                {1, 2, 1},
                {1, 1, 2},
                {2, 1, 2}
        }));
    }

    @Test
    public void fixedTests() {
        assertEquals(1, TicTacToeChecker.isSolved(new int[][]{
                {1, 1, 1},
                {0, 2, 2},
                {0, 0, 0}
        }));
        assertEquals(1, TicTacToeChecker.isSolved(new int[][]{
                {1, 2, 0},
                {0, 1, 2},
                {0, 0, 1}
        }));
        assertEquals(2, TicTacToeChecker.isSolved(new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {2, 2, 2}
        }));
        assertEquals(2, TicTacToeChecker.isSolved(new int[][]{
                {2, 2, 2},
                {0, 1, 1},
                {1, 0, 0}
        }));
        assertEquals(0, TicTacToeChecker.isSolved(new int[][]{
                {2, 1, 2},
                {2, 1, 1},
                {1, 2, 1}
        }));
        assertEquals(0, TicTacToeChecker.isSolved(new int[][]{
                {1, 2, 1},
                {1, 1, 2},
                {2, 1, 2}
        }));
        assertEquals(-1, TicTacToeChecker.isSolved(new int[][]{
                {2, 0, 2},
                {2, 1, 1},
                {1, 2, 1}
        }));
        assertEquals(-1, TicTacToeChecker.isSolved(new int[][]{
                {0, 0, 2},
                {0, 0, 0},
                {1, 0, 1}
        }));
        assertEquals(-1, TicTacToeChecker.isSolved(new int[][]{
                {1, 2, 1},
                {1, 1, 2},
                {2, 2, 0}
        }));
        assertEquals(-1, TicTacToeChecker.isSolved(new int[][]{
                {0, 2, 2},
                {2, 1, 1},
                {0, 0, 1}
        }));
        assertEquals(-1, TicTacToeChecker.isSolved(new int[][]{
                {0, 1, 1},
                {2, 0, 2},
                {2, 1, 0}
        }));
    }

    @Test
    public void testRandomBoards() {
        var random = ThreadLocalRandom.current();
        for (int i = 0; i < 10_000; i++) {
            int[][] board = new int[3][3];
            int turns = 9 - random.nextInt(4) * random.nextInt(4);
            boolean x = random.nextBoolean();
            int expectedResult = -1;
            int turn = 0;
            while (expectedResult < 0 && turn < turns) {
                int row = random.nextInt(3);
                int col = random.nextInt(3);
                if (board[row][col] > 0)
                    continue;
                int val = x ? 1 : 2;
                board[row][col] = val;
                if (board[row][0] == val && board[row][1] == val && board[row][2] == val)
                    expectedResult = val;
                else if (board[0][col] == val && board[1][col] == val && board[2][col] == val)
                    expectedResult = val;
                else if (board[0][2] == val && board[1][1] == val && board[2][0] == val)
                    expectedResult = val;
                else if (board[0][0] == val && board[1][1] == val && board[2][2] == val)
                    expectedResult = val;
                x = !x;
                turn++;
            }
            if (expectedResult < 0 && turns == 9)
                expectedResult = 0;
            assertEquals(expectedResult, TicTacToeChecker.isSolved(board));
        }
    }

}