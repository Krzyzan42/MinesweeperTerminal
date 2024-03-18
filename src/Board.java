public class Board {
    Cell[][] cells;
    int width, height;

    Board(int width, int height, int bombs) {
        this.width = width;
        this.height = height;

        cells = new Cell[width][height];
        InitBoard(bombs);
    }

    public ShowResult showCell(int x, int y) {
        cells[x][y].reveal();
        return new ShowResult(cells[x][y].isBomb, cells[x][y].cellNumber != 0);
    }

    public void draw() {
        System.out.print("    ");
        for (int i = 0; i < width; i++) {
            System.out.print(i + "  ");
        }
        System.out.println("\n");

        for (int y = 0; y < height; y++){
            System.out.print(y + "   ");
            for (int x = 0; x < width; x++){
                cells[x][y].draw();
            }
            System.out.println("");
        }
        System.out.println("\n\n\n");
    }

    public void drawRevealed() {
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                cells[x][y].drawRevealed();
            }
            System.out.println("");
        }
        System.out.println("");

    }

    public boolean allNumbersRevealed() {
        
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                if(cells[x][y].isHidden && cells[x][y].isBomb == false) return false;

        return true;
    }

    public boolean isInBounds(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    void InitBoard(int bombN) {
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                cells[x][y] = new Cell();

        int bombsPlaced = 0;
        while(bombsPlaced < bombN) {
            int x = Rand.nextInt(width);
            int y = Rand.nextInt(height);

            if(cells[x][y].isBomb == false) {
                cells[x][y].isBomb = true;
                bombsPlaced++;
            }
        }

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) 
                if(cells[x][y].isBomb == false) 
                    cells[x][y].cellNumber = getBombCountAround(x, y);
    }

    int getBombCountAround(int x, int y) {
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
        int bombCount = 0;
        for (int i = 0; i < 8; i++) {
            int cX = cellsAround[i][0];
            int cY = cellsAround[i][1];

            if(isInBounds(cX, cY)) {
                if(cells[cX][cY].isBomb)
                    bombCount++;
            }
        }
        return bombCount;
    }

}
