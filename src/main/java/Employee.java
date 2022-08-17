import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {
    private String lastName;
    private String firstName;
    private LocalDate dob;
    private static final String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+),\\s*\\{(?<details>.*?)}";
    protected static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    protected Matcher peopleMat;
    protected final NumberFormat nf = NumberFormat.getCurrencyInstance();
    protected final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    protected Employee() {
        lastName = "N/A";
        firstName = "N/A";
    }

    public Employee(String personText) {
        peopleMat = Employee.PEOPLE_PAT.matcher(personText);
        if (peopleMat.find()) {
            lastName = peopleMat.group("lastName");
            firstName = peopleMat.group("firstName");
            dob = LocalDate.from(dtf.parse(peopleMat.group("dob")));
        }

    }
    public abstract int getSalary();


    public static IEmployee createEmployee(String personText) {
        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(personText);
        if (!peopleMat.find()) {
            return () -> 0;
        }

        return switch (peopleMat.group("role")) {
            case "Programmer" -> new Programmer(personText);
            case "Manager" -> new Manager(personText);
            case "Analyst" -> new Analyst(personText);
            case "CEO" -> new CEO(personText);
            default -> () -> 0;
        };

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s - %s", lastName, firstName, nf.format(getSalary()), nf.format(getBonus()));
    }

    private static final class DummyEmployee extends Employee {
        @Override
        public int getSalary() {
            return 0;
        }
    }


}
