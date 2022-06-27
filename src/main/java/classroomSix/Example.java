package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("This is Maven project!");
        Employee employee = new Employee("Jānis", "Bērziņš", 1000.32);
        System.out.println(employee.toString());
        Faker faker = new Faker();
        Employee empoyeeTwo = new Employee(faker.name().firstName(), faker.company().profession(),faker.number().randomDouble(2, 100, 2000));
        System.out.println(empoyeeTwo.toString());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());
        System.out.println("ancient hero: " + faker.ancient().hero());
        System.out.println("frienmds quote: " + faker.friends().quote());
        System.out.println("citats no Hamleta: " + faker.shakespeare().hamletQuote());

        Employee employeeThree = new Employee();
        System.out.println(employeeThree.toString());
        for(int i = 0;i < 100; i++ ){
            Employee employee2 = new Employee();
            System.out.println(employee2);
        }


    }
}
