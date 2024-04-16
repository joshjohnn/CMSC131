package system;

import app.DrawingApp;

public class Flag implements Diagram {
    private char[][] board;
    private int animationType;

    public Flag(int size, char color1, char color2, char color3, int animationType) {
        this.animationType = animationType;
        initializeBoard(DrawingApp.getFlag(size, color1, color2, color3));
    }

    private void initializeBoard(String flagString) {
        String[] lines = flagString.split("\n");
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
