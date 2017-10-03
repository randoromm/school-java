package algorithmscourse.sortballs;


import java.util.Random;

public class ColorSort {

    enum Color {red, green, blue}

    public static void main(String[] param) {
        Color[] examp = genRandomRow(20);
        printRow(examp);
        reorder(examp);
        printRow(examp);

    }

    public static void reorder(Color[] balls) {
        int redCount = 0;
        int blueCount = balls.length - 1;

        for(int i = 0; i <= blueCount; i++){
            if(redCount < blueCount){  // Everything is already sorted if that happens
                if(balls[i] == Color.red){
                    Color temp = balls[i];
                    balls[i] = balls[redCount];
                    balls[redCount] = temp;
                    redCount++;  // No i--, because the replaced ball can't be blue anyways
                }
                else if(balls[i] == Color.blue){
                    Color temp = balls[i];
                    balls[i] = balls[blueCount];
                    balls[blueCount] = temp;
                    blueCount--;
                    i--;  // Because the replaced ball may be red
                }
            }
        }
    }

    public static Color[] genRandomRow(int len) {
        Color[] res = new Color[len];
        for (int i = 0; i < len; i++) {
            int r = new Random().nextInt(2 + 1);
            if (r == 0) {
                res[i] = Color.red;
            } else if (r == 1) {
                res[i] = Color.green;
            } else if (r == 2) {
                res[i] = Color.blue;
            }

        }
        return res;
    }

    public static void printRow(Color[] row) {
        for (Color c : row) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
