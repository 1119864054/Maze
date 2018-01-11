package maze;

import java.util.Stack;

public class Build {

    public static int height = 21;
    public static int width = 21;
    public static int[][] state = new int[height + 2][width + 2];
    public static char[][] statemap = new char[height + 2][width + 2];
    public static boolean up = false, down = false, right = false, left = false;

    public static void setDirFalse() {
        up = false;
        down = false;
        right = false;
        left = false;
    }

    public static void main(String[] args) {


        Stack<Point> stack = new Stack<>();

        for (int i = 0; i <= height + 1; i++)
            for (int j = 0; j <= width + 1; j++) {
                state[i][j] = 0;
            }

        int row = 1, col = 1;
        state[row][col] = 1;

        Point temp = new Point();
        Point pmet = new Point();
        temp.row = row;
        temp.col = col;
        temp.state = 1;

        while (true) {
            temp.row = row;
            temp.col = col;
            java.util.Random r = new java.util.Random();
            int randNum = Math.abs(r.nextInt()) % 4;
            switch (randNum) {
                case 0://上
                    if (!up && row > 2 && state[row - 2][col] == 0) {
                        Point t = new Point();
                        t.row = temp.row;
                        t.col = temp.col;
                        t.state = temp.state;
                        stack.push(t);
                        state[row - 2][col] = 1;
                        state[row - 1][col] = 1;
                        row = row - 2;
                        setDirFalse();
                    } else
                        up = true;
                    break;
                case 1://下
                    if (!down && row < height - 1 && state[row + 2][col] == 0) {
                        Point t = new Point();
                        t.row = temp.row;
                        t.col = temp.col;
                        t.state = temp.state;
                        stack.push(t);
                        state[row + 2][col] = 1;
                        state[row + 1][col] = 1;
                        row = row + 2;

                        setDirFalse();
                    } else
                        down = true;
                    break;
                case 2://左
                    if (!left && col > 2 && state[row][col - 2] == 0) {
                        Point t = new Point();
                        t.row = temp.row;
                        t.col = temp.col;
                        t.state = temp.state;
                        stack.push(t);
                        state[row][col - 2] = 1;
                        state[row][col - 1] = 1;
                        col = col - 2;
                        setDirFalse();
                    } else
                        left = true;
                    break;
                case 3://右
                    if (!right && col < width - 1 && state[row][col + 2] == 0) {
                        Point t = new Point();
                        t.row = temp.row;
                        t.col = temp.col;
                        t.state = temp.state;
                        stack.push(t);
                        state[row][col + 2] = 1;
                        state[row][col + 1] = 1;
                        col = col + 2;
                        setDirFalse();
                    } else
                        right = true;
                    break;
            }
            if (up && down && right && left) {
                if (!stack.empty()) {
                    row = stack.peek().row;
                    col = stack.peek().col;
                    stack.pop();
                    setDirFalse();
                } else {
                    Print p = new Print();
                    p.print();
                    return;
                }
            }
        }
    }
}
