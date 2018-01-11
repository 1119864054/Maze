package maze;

import static maze.Build.*;

public class Print {
    void print(){
        for (int i = 0; i <= height + 1; i++)
            for (int j = 0; j <= width + 1; j++) {
                if(state[i][j] == 0)
                    statemap[i][j] = '#';
                if(state[i][j] == 1)
                    statemap[i][j] = '.';
            }

        for (int i = 0; i <= width + 1; i++) {
            statemap[0][i] = statemap[height + 1][i] = '#';
        }
        for (int i = 0; i <= height + 1; i++) {
            statemap[i][0] = statemap[i][width + 1] = '#';
        }

        for (int i = 0; i <= height + 1; i++) {
//                for (int j = 0; j <= width + 1; j++) {
//                    System.out.printf(state[i][j] + " ");
//                }
            for (int j = 0; j <= width + 1; j++) {
                System.out.printf(statemap[i][j] + " ");
            }
            System.out.printf("\n");
        }
    }
}
