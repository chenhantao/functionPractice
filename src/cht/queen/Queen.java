package cht.queen;

/**
 * 八皇后
 *
 * @author chenhantao
 * @since 2019/5/29
 */
public class Queen {

    private int[][] chessBoard;
    private int MAX_SIZE;

    /**
     * 八皇后初始设置
     * @param size 棋盘的大小
     */
    public Queen(int size) {
        this.chessBoard = new int[size][size];
        this.MAX_SIZE = size;
    }

    /**
     * 定义一个方法来检查新落入的皇后是否符合要求
     * @param x x
     * @param y y
     * @return true or false
     */
    private boolean check(int x, int y) {
        for (int i = 0; i < y; i++) {
            // 检查纵向
            if (chessBoard[x][i] == 1) {
                return false;
            }
            // 检查左侧斜向
            if (x - 1 - i >= 0 && chessBoard[x - 1 - i][y - 1 - i] == 1) {
                return false;
            }
            // 检查右侧斜向
            if (x + 1 + i < MAX_SIZE && chessBoard[x + 1 + i][y - 1 - i] == 1) {
                return false;
            }

        }
        return true;
    }

    public boolean settleQueen(int y) {
        // 行数超过最大，说明已经找到答案
        if (y == MAX_SIZE) {
            return true;
        }
        // 遍历当前行，逐一格子验证
        for (int i = 0; i < MAX_SIZE; i++) {
            // 为当前行清零，以免在回溯的时候出现脏数据
            for (int x = 0; x < MAX_SIZE; x++) {
                chessBoard[x][y] = 0;
            }
            // 检查是否符合规则，如果符合，更改元素值并进一步递归
            if (check(i, y)) {
                chessBoard[i][y] = 1;
                // 递归如果返回true，说明下层已找到解法，无需继续循环
                if (settleQueen(y + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printChessBoard() {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++){
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
