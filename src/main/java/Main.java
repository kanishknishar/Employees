import java.text.NumberFormat;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        String peopleText = """
            Flinstone, Fred, 01/01/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 01/01/1900, Programmerzzz, {locpd=2000,yoe=10,iq=140}
            Flinstone2, Fred, 01/01/1900, Programmer, {locpd=1300,yoe=14,iq=100}
            Flinstone3, Fred, 01/01/1900, Programmer, {locpd=2300,yoe=8,iq=105}
            Flinstone4, Fred, 01/01/1900, Programmer, {locpd=1630,yoe=3,iq=115}
            Flinstone5, Fred, 01/01/1900, Programmer, {locpd=5,yoe=10,iq=100}
            Rubble, Barney, 02/02/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney, 02/02/1905, Manager, {orgSize=100,dr=4}
            Rubble3, Barney, 02/02/1905, Manager, {orgSize=200,dr=2}
            Rubble4, Barney, 02/02/1905, Manager, {orgSize=500,dr=8}
            Rubble5, Barney, 02/02/1905, Manager, {orgSize=175,dr=20}
            Flinstone, Wilma, 03/03/1910, Analyst, {projectCount=3}
            Flinstone2, Wilma, 03/03/1910, Analyst, {projectCount=4}
            Flinstone3, Wilma, 03/03/1910, Analyst, {projectCount=5}
            Flinstone4, Wilma, 03/03/1910, Analyst, {projectCount=6}
            Flinstone5, Wilma, 03/03/1910, Analyst, {projectCount=9}
            Rubble, Betty, 04/04/1915, CEO, {avgStockPrice=300}
            """;

        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(peopleText);

        int totalSalaries = 0;

        while (peopleMat.find()) {
            IEmployee employee = Employee.createEmployee(peopleMat.group());
            switch(employee) {
                case Programmer prog -> System.out.println(prog.getIq());
                case Manager man -> System.out.println(man.getDirectReports());
                default -> System.out.println(employee.getSalary());
            }

            totalSalaries += employee.getBonus();
        }

        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        System.out.printf("%nThe total payout should be %s%n", currencyInstance.format(totalSalaries));




    }

}