import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        long out; // long has bigger value than int, to maximize level
        int tingkat;
        Scanner in = new Scanner(System.in);

        while (true) {
            int KELIPATAN_SPASI = 5; // whitespace that will be filled between pascal numbers

            do {
                System.out.print("Input pascal level (max is 62): ");
                tingkat = in.nextInt();
            } while (!(tingkat > 0 && tingkat <= 62));

            if (tingkat >= 33) KELIPATAN_SPASI += 1;
            if (tingkat >= 40) KELIPATAN_SPASI += 2;
            if (tingkat >= 54) KELIPATAN_SPASI += 2;

            System.out.println("Using " + KELIPATAN_SPASI + " spaces ");
            for (int row = 0; row < tingkat; row++) {
                System.out.printf("%2d", row + 1);
                // arrange whitepace on the left side
                for (int i = 0; i < (tingkat - row) * KELIPATAN_SPASI; i++) System.out.print("_");
                // System.out.printf("%" + (tingkat - row) * KELIPATAN_SPASI + "s", ""); // other method but whitespaces

                out = 1; // kombinasi awal
                for (int col = 0; col <= row; col++) {
                    // fill each formatted whitespace with pascal number
                    System.out.printf("%" + (KELIPATAN_SPASI * 2) + "d", out);

                    out = out * (row - col) / (col + 1);
                }
                System.out.println();
            }
            System.out.print("\nEnter 'q' to exit the program: ");
            char exit = in.next().charAt(0);
            if (exit == 'q') break;
            System.out.println();
        }
    }
}
