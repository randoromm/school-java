package sortballs;


public class ColorSort {

    enum Color {red, green, blue}

    public static void main(String[] param) {

    }

    public static void reorder(Color[] balls) {
        int redCount = 0;
        int blueCount = balls.length - 1;

        for(int i=0; i<=blueCount; i++){
            if(redCount < blueCount){
                if(balls[i] == Color.red){
                    Color tmp = balls[i];
                    balls[i] = balls[redCount];
                    balls[redCount] = tmp;
                    redCount++;
                }
                else if(balls[i] == Color.blue){
                    Color tmp = balls[i];
                    balls[i] = balls[blueCount];
                    balls[blueCount] = tmp;
                    blueCount--;
                    i--;
                }
            }
        }
    }
}
