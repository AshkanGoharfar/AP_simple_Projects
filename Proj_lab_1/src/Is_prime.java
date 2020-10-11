public class Is_prime {
    public static void main(String[] args) {
        int number_1 = Integer.parseInt(args[0]);
        int number_2 = Integer.parseInt(args[1]);
        int i;
        if (number_1 > number_2)
            i = number_1;
        else
            i = number_1;

        while ((number_1 % i != 0) || (number_2 % i != 0)) {
            i--;
        }
        System.out.println(i);
        if (i != 1)
            System.out.println("not prime together !");
        else
            System.out.println("is prime ");
    }
}
