public class GameManager {
    Board board;
    Input input;
    
    public GameManager(int width, int height, int bombN){
        board = new Board(width, height, bombN);
        input = new Input(width, height);
    }

    public void Start() {
        boolean win = false;
        boolean gameEnd = false;

        do {
            board.draw();
            input.get();

            gameEnd = showSquare(input.x, input.y);

            if(board.allNumbersRevealed()) {
                gameEnd = true;
                win = true;
            }

        } while (!gameEnd);
        board.draw();
        if(win)
            System.out.println("\n\n You won");
        else
            System.out.println("\n\n You lost");
    }

    private boolean showSquare(int x, int y) {
        ShowResult result = board.showCell(x, y);
        if(result.isBomb) return true;
        if(result.hasBombAround) return false;
        
        int[][] cellsAround = new int[][] {
            {x-1, y-1},
            {x-1, y},
            {x-1, y+1},
            {x, y-1},
            {x, y+1},
            {x+1, y-1},
            {x+1, y},
            {x+1, y+1},
        };
        for (int i = 0; i < 8; i++) {
            int cX = cellsAround[i][0];
            int cY = cellsAround[i][1];

            if(board.isInBounds(cX, cY)) {
                if(board.cells[cX][cY].isHidden)
                    showSquare(cX, cY);
            }
        }
        return false;
    }
}
