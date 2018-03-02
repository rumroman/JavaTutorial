package demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeveloperTests {

    Developer developer = new Developer();

    DeveloperLogic logic = new DeveloperLogic();


    // Предустановка значений.
    @Before

    public void setUp(){

        developer.setFirstName("Simple");

        developer.setLastName("Developer");

        developer.setSpeciality("Java");

        developer.setSalary(2000_00);

    }

    /**
     * Проверяет работу методов getters и setters
     */

    @Test

    public void shouldCreateDeveloperInstanceTest(){

        Assert.assertEquals("Simple",developer.getFirstName());

        Assert.assertEquals("Developer", developer.getLastName());

        Assert.assertEquals("Java",developer.getSpeciality());

        Assert.assertEquals(2000_00, developer.getSalary());
    }

    /**
     *
     * Проверяет корректность вычисления годового дохода разработчика
     */

    @Test

    public void shouldCalculateAnnualSalaryTest(){

        Assert.assertEquals(24_000_00, logic.calculateAnnualSalary(developer));
    }

    /**
     * Проверяет правильность вычисления часовой ставки разрабочтика.
     */

    @Test

    public void shouldCalculateHourRateTest(){

        Assert.assertEquals(12_50, logic.calsulateHourRate(developer));
    }
}
