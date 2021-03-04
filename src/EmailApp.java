import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        System.out.println("Please enter employee's first name: ");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        System.out.println("Please enter employee's last name: ");
        String lastName = scanner.next();
        Email email = new Email(firstName, lastName);
        System.out.println(email.getGeneralInfo());
        System.out.println("------------------------------------");
        System.out.println("Employee registered.");
    }
}
