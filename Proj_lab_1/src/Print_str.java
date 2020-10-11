public class Print_str {
    public static void main(String[] args) {
        String input = args[0];
        for (char s : input.toCharArray()) {
            System.out.println(s);
        }
    }
}
