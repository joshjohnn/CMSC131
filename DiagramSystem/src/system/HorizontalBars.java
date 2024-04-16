package system;

import app.DrawingApp;

public class HorizontalBars implements Diagram {
    private char[][] board;
    private int animationType;

    public HorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3, int animationType) {
        this.animationType = animationType;
        String barsString = DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3);
        initializeBoard(barsString);
    }

    private void initializeBoard(String barsString) {
        String[] lines = barsString.split("\n");
        board = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            board[i] = lines[i].toCharArray();
        }
    }

    @Override
    public char[][] getBoard() {
        return board;
    }

    @Override
    public char[][] nextAnimationStep() {
        if (animationType == 1) {
            TwoDimArrayUtil.rotateTopOneRow(board);
        }
        // No other animation types need to be handled.
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
