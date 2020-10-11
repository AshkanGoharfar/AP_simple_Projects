public class Multiplicate {
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        for (int i = 1; i <= size; i++) {
            System.out.print("\n");
            for (int j = 1; j <= size; j++) {
                System.out.print(i*j+" ");
            }
        }
    }
}
