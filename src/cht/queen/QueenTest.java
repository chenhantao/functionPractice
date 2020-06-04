package cht.queen;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2019/5/29
 */
public class QueenTest {
    public static void main(String[] args) {
        Queen queen = new Queen(8);
        queen.settleQueen(0);
        queen.printChessBoard();
    }
}
