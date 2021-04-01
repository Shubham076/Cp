import java.util.*;
class lineardiophantineEq{
    public static int gcd(int a, int b){
        while(a % b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return b;
    }

    static int x;
    static int y;
    public static void extendedGCD(int a, int b){
        if(b == 0){
            x = 1;
            y = 0;
            return;
        }
        extendedGCD(b, a % b);
        int cx = y;
        int cy = x - (a / b) * y;
        x = cx;
        y = cy;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the value of a, b, y representing ax + by = c");
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        scn.close();
        int g = gcd(a, b);
        if(c % g != 0){
            System.out.println("No solutions exist");
            return;
        }

        extendedGCD(a, b);
        int ax = x * (c / g);
        int ay = y * (c / g);
        System.out.println("X: " + ax + " , " + "Y: " + ay);

        // for generating the family of soltuions
        System.out.println("Other solutions: ");
        for(int t = 1; t <= 3; t++){
            int ox = ax + (b / g) * t;
            int oy = ay - (a / g) * t;
            System.out.println("X: " + ox + " , " + "Y: " + oy);
        }
    }
}