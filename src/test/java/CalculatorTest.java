import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;
    @Test
    public void testSum(){
        System.out.println("Test saskaitišana");
      //  Calculator calculator = new Calculator();
        int actualResult = calculator.saskaitisana(5,3);
        int expectedResult = 8;
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(calculator.saskaitisana(-5,3),-2);
        Assert.assertEquals(calculator.saskaitisana(-5,-3),-8);
        Assert.assertEquals(calculator.saskaitisana(0,-3),-3);
        Assert.assertEquals(calculator.saskaitisana(2,0),2);
        Assert.assertEquals(calculator.saskaitisana(0,0),0);

        System.out.println("This is my first test ever!!!");
    }
    @Test
    public void dalisanasTests(){
        System.out.println("Dalīšanas tests");
     //   Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.dalisana(8,2),4);
        Assert.assertEquals(calculator.dalisana(8.2,2.0),4.1);

    }

    @BeforeClass
    public void beforeClass(){
        this.calculator = new Calculator();
        System.out.println("Izpildās 'Before Class'");
    }
    @BeforeMethod
    public void izpilditPirmsKatraTesta(){
        System.out.println("Izpildās pirms katras testa metodes!");
    }
}
