package system;

public class CombineLeftRight implements Diagram {
    private char[][] board;
    private int animationType;

    public CombineLeftRight(Diagram left, Diagram right, int animationType) {
        if (left.getNumberRows() != right.getNumberRows()) {
            throw new IllegalArgumentException("Left and right diagrams must have the same number of rows");
        }

        this.board = TwoDimArrayUtil.appendLeftRight(left.getBoard(), right.getBoard());
        this.animationType = animationType;
    }

    @Override
    public char[][] getBoard() {
        return board;
    }

    @Override
    public char[][] nextAnimationStep() {
        if (animationType == 1) {
            TwoDimArrayUtil.rotateLeftOneColumn(board);
        } else if (animationType == 2) {
            TwoDimArrayUtil.rotateTopOneRow(board);
        }

        return board;
    }

    @Override
    public int getNumberRows() {
        return board.length;
    }

    @Override
    public int getNumberCols() {
        return board.length > 0 ? board[0].length : 0;
    }
}
