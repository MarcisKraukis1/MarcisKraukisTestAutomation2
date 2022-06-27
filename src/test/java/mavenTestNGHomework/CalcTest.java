package mavenTestNGHomework;

import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalcTest {
    private Calculator kalkulators;

    @Test
public void sumParbaude(){
    Assert.assertEquals(kalkulators.saskaitisana(5,10),15);

    }
    @Test
    public void subParbaude(){
        Assert.assertEquals(kalkulators.atnemsana(13,4),9);
    }

    @Test
    public void mulParbaude(){
        Assert.assertEquals(kalkulators.reizinasana(3,3),9);
    }

    @Test
    public void divParbaude(){
        Assert.assertEquals(kalkulators.dalisana(7,3.5),2);
    }


    @BeforeClass
    public void beforeClass() {
        this.kalkulators = new Calculator();
    }

    @BeforeMethod
    public void pirmsMetode(){
        System.out.println("Tests ir sācies!");
    }
}
