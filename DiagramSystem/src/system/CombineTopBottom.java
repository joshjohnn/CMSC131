package system;

public class CombineTopBottom implements Diagram {
    private char[][] board;
    private int animationType;

    public CombineTopBottom(Diagram top, Diagram bottom, int animationType) {
        if (top.getNumberCols() != bottom.getNumberCols()) {
            throw new IllegalArgumentException("Top and bottom diagrams must have the same number of columns");
        }

        this.board = TwoDimArrayUtil.appendTopBottom(top.getBoard(), bottom.getBoard());
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
