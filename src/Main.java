import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker passwordChecker = new PasswordChecker();
        try {
            System.out.print("Введите мин. длину пароля: ");
            String input = scanner.nextLine();
            passwordChecker.setMinLength(Integer.parseInt(input));
            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            input = scanner.nextLine();
            passwordChecker.setMaxRepeats(Integer.parseInt(input));
            while (true) {
                System.out.print("Введите пароль или end: ");
                input = scanner.nextLine();
                if ("end".equals(input)) {
                    break;
                }
                if (passwordChecker.verify(input)) {
                    System.out.println("Подходит!");
                } else {
                    System.out.println("Не подходит!");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}