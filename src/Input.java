import java.util.Scanner;

public class Input {
    public int x, y;

    private Scanner scanner = new Scanner(System.in);
    private int width, height;

    public Input(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void get() {
        boolean inputCorrect = false;

        while (inputCorrect == false) {
            String input = scanner.nextLine();
            if(input.length() != 2) continue;

            try {
                x = input.charAt(0) - '0';
                y = input.charAt(1) - '0';
            } catch (Exception e) {
                continue;
            }

            if(x < 0 || x >= width || y < 0 || y >= height) continue;
            inputCorrect = true;
        }
    }
}
