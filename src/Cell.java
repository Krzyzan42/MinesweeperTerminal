public class Cell {
    public boolean isHidden = true;
    public boolean isBomb = false;
    public int cellNumber = 0;

    public void draw() {
        if(isHidden) {
            System.out.print("[] ");
            return;
        }

        if(isBomb) 
            System.out.print("B  ");
        else
            System.out.print(cellNumber + "  ");
    }

    public void reveal() {
        isHidden = false;
    }

    public void drawRevealed() {
        if(isBomb) 
            System.out.print("B  ");
        else
            System.out.print(cellNumber + "  ");
    }
}
