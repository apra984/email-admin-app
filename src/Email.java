import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private int defaultPasswordLength = 8;
    private Departments department;
    private int mailboxCapacity = 200;
    private String alternateEmail;
    private String company = "xyz.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        department = setDepartment();
        password = generatePassword(defaultPasswordLength);
        System.out.println("Password: " + password);

        emailAddress = generateEmail(this.firstName, this.lastName, department);
        System.out.println("Email address: " + emailAddress);
    }

    private Departments setDepartment() {
        System.out.println("DEPARTMENT CODES: \n[1]Sales \n[2]Development \n[3]Accounting \n[0]None \nPlease enter department code: ");
        Scanner scanner = new Scanner(System.in);
        int departmentChoice = scanner.nextInt();

        switch (departmentChoice) {
            case 1:
                return Departments.sales;
            case 2:
                return Departments.development;
            case 3:
                return Departments.accounting;
            default:
                return Departments.none;
        }
    }

    private String generatePassword(int length) {
        String characterSet = "abcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        char[] password = new char[length];

        for (int i = 0; i < password.length; i++) {
            int random = (int) (Math.random() * characterSet.length());
            password[i] = characterSet.charAt(random);
        }
        return new String(password);
    }

    private String generateEmail(String firstName, String lastName, Departments department) {
        if (department == Departments.none) {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + company;
        } else {
            return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + company;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getGeneralInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "MB";
    }
}
